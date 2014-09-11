/*
 * myQEP.c
 *
 *  Created on: 2014-9-10
 *      Author: liudanghao
 */

#include <DAVE3.h>
#include "myGlobe.h"



uint32_t depth=0;

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
	}
	Status = POSQE001_GetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH,&EvtStatus);
	if(EvtStatus == (uint8_t) SET)
	{
		depth--;
		IO004_TogglePin(LED1);
		Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH);
	}
}

void myQEPinit()
{
	status_t Status;
	Status=POSQE001_SetPeriodCounterPM(&POSQE001_Handle0, 1280);
	Status=POSQE001_SetPeriodCounterCM(&POSQE001_Handle0, 1280/2);
	if(Status!=DAVEApp_SUCCESS) depth=100;
	Status=POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_UP_COMPARE_MATCH);
	if(Status!=DAVEApp_SUCCESS) depth+=50;
	Status=POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,POSQE001_POSITION_COUNTER,POSQE001_CCU_DOWN_COMPARE_MATCH);
	if(Status!=DAVEApp_SUCCESS) depth+=25;
	//POSQE001_Start(&POSQE001_Handle0);
}
