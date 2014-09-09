/*
 * myCAN.c
 *
 *  Created on: 2014-9-4
 *      Author: liudanghao
 */

#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)
#include "myGlobe.h"
#include <string.h>

#define MAXLINE 16	//must be 4,8,16,32,64....

typedef struct{
	CAN001_MessageHandleType buf[MAXLINE];
	uint8_t WritePos;
	uint8_t SendPos;
}my_CAN_BUF;


//CAN0RX=======================================================
my_CAN_BUF can0rx;
osSemaphoreId can0rx_semaphore_id;
osSemaphoreDef(can0rx_semaphore);

//CAN1RX=======================================================
my_CAN_BUF can1rx;
osSemaphoreId can1rx_semaphore_id;
osSemaphoreDef(can1rx_semaphore);


CAN001_MessageHandleType test;

void myCANinit()
{
	can0rx_semaphore_id = osSemaphoreCreate(osSemaphore(can0rx_semaphore), 1);
	memset(&can0rx,0,sizeof(my_CAN_BUF));

	can1rx_semaphore_id = osSemaphoreCreate(osSemaphore(can1rx_semaphore), 1);
	memset(&can1rx,0,sizeof(my_CAN_BUF));
}


CAN001_MessageHandleType* myCAN0_Get()
{
	CAN001_MessageHandleType* pmsg;
	if(can0rx.SendPos==can0rx.SendPos) osSemaphoreWait(can0rx_semaphore_id,osWaitForever);
	pmsg=&can0rx.buf[can0rx.SendPos];
	can0rx.SendPos++;
	can0rx.SendPos&=(MAXLINE-1);
	return pmsg;
}


CAN001_MessageHandleType* myCAN1_Get()
{
	CAN001_MessageHandleType* pmsg;
	if(can1rx.SendPos==can1rx.SendPos) osSemaphoreWait(can1rx_semaphore_id,osWaitForever);
	pmsg=&can1rx.buf[can1rx.SendPos];
	can1rx.SendPos++;
	can1rx.SendPos&=(MAXLINE-1);
	return pmsg;
}

//if multi thread call this function, must think...
void myCAN0_Send(uint8_t msgbox,uint8_t* buf,uint8_t len)
{
	CAN001_UpdateMODataRegisters(&CAN001_Handle0,msgbox,len,buf);
	CAN001_SendDataFrame(&CAN001_Handle0,msgbox);
}

//if multi thread call this function, must think...
void myCAN1_Send(uint8_t msgbox,uint8_t* buf,uint8_t len)
{
	CAN001_UpdateMODataRegisters(&CAN001_Handle1,msgbox,len,buf);
	CAN001_SendDataFrame(&CAN001_Handle1,msgbox);
}

void EventHandlerCAN0()
{
/*
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,1,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,1,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,2,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,2,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,3,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,3,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,4,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,4,TRANSMIT_PENDING);
	  }
*/


	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,5,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,5,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle0,&can0rx.buf[can0rx.WritePos],5);
	    can0rx.WritePos++;
	    can0rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can0rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,6,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,6,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle0,&can0rx.buf[can0rx.WritePos],6);
	    can0rx.WritePos++;
	    can0rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can0rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,7,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,7,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle0,&can0rx.buf[can0rx.WritePos],7);
	    can0rx.WritePos++;
	    can0rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can0rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,8,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,8,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle0,&can0rx.buf[can0rx.WritePos],8);
	    can0rx.WritePos++;
	    can0rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can0rx_semaphore_id);
	  }


	  if(CAN001_GetNodeFlagStatus(&CAN001_Handle0,CAN001_ALERT_STATUS) == CAN_SET)
	  {
	    CAN001_ClearNodeFlagStatus(&CAN001_Handle0,CAN001_ALERT_STATUS);
	  }

}

void EventHandlerCAN1()
{
/*
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,1,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,1,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,2,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,2,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,3,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,3,TRANSMIT_PENDING);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,4,TRANSMIT_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,4,TRANSMIT_PENDING);
	  }
*/



	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,5,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,5,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle1,&can1rx.buf[can1rx.WritePos],5);
	    can1rx.WritePos++;
	    can1rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can1rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,6,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,6,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle1,&can1rx.buf[can1rx.WritePos],6);
	    can1rx.WritePos++;
	    can1rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can1rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,7,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,7,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle1,&can1rx.buf[can1rx.WritePos],7);
	    can1rx.WritePos++;
	    can1rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can1rx_semaphore_id);
	  }
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle1,8,RECEIVE_PENDING) == CAN_SET)
	  {
	    CAN001_ClearMOFlagStatus(&CAN001_Handle1,8,RECEIVE_PENDING);
	    CAN001_ReadMsgObj(&CAN001_Handle1,&can1rx.buf[can1rx.WritePos],8);
	    can1rx.WritePos++;
	    can1rx.WritePos&=(MAXLINE-1);
	    osSemaphoreRelease(can1rx_semaphore_id);
	  }









	  if(CAN001_GetNodeFlagStatus(&CAN001_Handle1,CAN001_ALERT_STATUS) == CAN_SET)
	  {
	    CAN001_ClearNodeFlagStatus(&CAN001_Handle1,CAN001_ALERT_STATUS);
	  }
}
