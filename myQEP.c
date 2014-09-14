/*
 * myQEP.c
 *
 *  Created on: 2014-9-10
 *      Author: liudanghao
 */

#include <DAVE3.h>
#include "myGlobe.h"

osSemaphoreId depth_semaphore_id;
osSemaphoreDef(depth_semaphore);

osSemaphoreId speed_semaphore_id;
osSemaphoreDef(speed_semaphore);

int32_t depth=0;
uint16_t speed=0;

void QEP_Compare_Event_Handler()
{
	status_t Status;
	uint8_t EvtStatus;
	Status = POSQE001_GetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_UP_COMPARE_MATCH,&EvtStatus);
	if(EvtStatus == (uint8_t) SET)
	{
		depth++;
		IO004_TogglePin(LED1);
		Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_UP_COMPARE_MATCH);
		osSemaphoreRelease(depth_semaphore_id);
	}
	Status = POSQE001_GetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH,&EvtStatus);
	if(EvtStatus == (uint8_t) SET)
	{
		depth--;
		IO004_TogglePin(LED1);
		Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH);
		osSemaphoreRelease(depth_semaphore_id);
	}
}

void QEP_Speed_Event_Handler()
{
	status_t Status;
	uint8_t EvtStatus;
	Status = POSQE001_GetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_VELOCITY_TIMER0,POSQE001_CCU_PERIOD_MATCH,&EvtStatus);
	if(EvtStatus == (uint8_t) SET)
	{
		IO004_TogglePin(LED1);
		POSQE001_GetVelocityRAW(&POSQE001_Handle0, &speed);
		Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_VELOCITY_TIMER0,POSQE001_CCU_PERIOD_MATCH);
		osSemaphoreRelease(speed_semaphore_id);
	}
}
int32_t GetDepth()
{
	osSemaphoreWait(depth_semaphore_id,3000);
	return depth;
}

uint16_t GetSpeed()
{
	osSemaphoreWait(speed_semaphore_id,osWaitForever);
	return speed;
}

void myQEPinit()
{
	status_t Status;
	depth_semaphore_id = osSemaphoreCreate(osSemaphore(depth_semaphore), 1);
	speed_semaphore_id = osSemaphoreCreate(osSemaphore(speed_semaphore), 1);

	Status=POSQE001_SetPeriodCounterPM(&POSQE001_Handle0, 32);
	Status=POSQE001_SetPeriodCounterCM(&POSQE001_Handle0, 32/2);
	if(Status!=DAVEApp_SUCCESS) depth=100;
	Status=POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_UP_COMPARE_MATCH);
	if(Status!=DAVEApp_SUCCESS) depth+=50;
	Status=POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH);
	Status=POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_VELOCITY_TIMER0,POSQE001_CCU_PERIOD_MATCH);
	if(Status!=DAVEApp_SUCCESS) depth+=25;
	//POSQE001_Start(&POSQE001_Handle0);
}
