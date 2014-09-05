/*
 * myCAN.c
 *
 *  Created on: 2014-9-4
 *      Author: liudanghao
 */

#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)
#include "myGlobe.h"
#include <string.h>

#define MAXLINE 8	//must be 4,8,16,32,64....

typedef struct{
	uint8_t ArrayBuf[MAXLINE][8];
	uint8_t ArrayLen[MAXLINE];
	uint32_t msgid[MAXLINE];
	uint8_t WritePos;
	uint8_t SendPos;
	uint8_t Sending;
}my_CAN_BUF;

my_CAN_BUF can0tx;
my_CAN_BUF can1tx;
my_CAN_BUF can0rx;
my_CAN_BUF can1rx;

osSemaphoreId can0rx_semaphore_id;
osSemaphoreDef(can0rx_semaphore);

osSemaphoreId can1rx_semaphore_id;
osSemaphoreDef(can1rx_semaphore);


osMutexId can0tx_mutex_id;
osMutexDef(can0tx_mutex);

osMutexId can1tx_mutex_id;
osMutexDef(can1tx_mutex);


CAN001_MessageHandleType CanRecMsgObj;

void myCANinit()
{
	can0rx_semaphore_id = osSemaphoreCreate(osSemaphore(can0rx_semaphore), 1);
	can1rx_semaphore_id = osSemaphoreCreate(osSemaphore(can1rx_semaphore), 1);
	can0tx_mutex_id = osMutexCreate(osMutex(can0tx_mutex));
	can1tx_mutex_id = osMutexCreate(osMutex(can1tx_mutex));
	memset(&can0tx,0,sizeof(my_CAN_BUF));
	memset(&can1tx,0,sizeof(my_CAN_BUF));
}



void myCAN0_Send(uint32_t msgid,uint8_t* buf,uint8_t len)
{
	osMutexWait(can0tx_mutex_id,osWaitForever);
	//if(can0tx.Sending==0)
	{
		CAN001_UpdateMODataRegisters(&CAN001_Handle0,1,len,buf);
		CAN001_SendDataFrame(&CAN001_Handle0,1);
		//can0tx.Sending=1;
	}
	osMutexRelease(can0tx_mutex_id);
}

void EventHandlerCAN0()
{

	  /* Check transmit pending status in LMO1 */
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,1,TRANSMIT_PENDING) == CAN_SET)
	  {
	    /* Clear the flag */
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,1,TRANSMIT_PENDING);
	    can0tx.Sending=0;
	   IO004_TogglePin(LED0);
	  }
	  /* Check receive pending status in LMO2 */
	  if(CAN001_GetMOFlagStatus(&CAN001_Handle0,2,RECEIVE_PENDING) == CAN_SET)
	  {
	    /* Clear the flag */
	    CAN001_ClearMOFlagStatus(&CAN001_Handle0,2,RECEIVE_PENDING);
	    /* Read the received Message object and stores in variable CanRecMsgObj */
	    CAN001_ReadMsgObj(&CAN001_Handle0,&CanRecMsgObj,2);
	    /* Switch on LED Pin 5.2  to indicate that the requested message is received*/
	    IO004_TogglePin(LED1);
	  }
	  /* Check for Node error */
	  if(CAN001_GetNodeFlagStatus(&CAN001_Handle0,CAN001_ALERT_STATUS) == CAN_SET)
	  {
	    /* Clear the flag */
	    CAN001_ClearNodeFlagStatus(&CAN001_Handle0,CAN001_ALERT_STATUS);
	    IO004_TogglePin(LED1);
	  }

}

void EventHandlerCAN1()
{

}
