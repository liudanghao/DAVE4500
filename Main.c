/*
 * Main.c
 *
 *
 *  Created on: 2014-8-20
 *      Author: liudanghao
 */

#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)
#include <string.h>
#include "myGlobe.h"
#include "myUART.h"


typedef struct{
	uint8_t buf[6];
	uint8_t cnt;
	uint8_t st;
}myFrameDef;
myFrameDef uartRx0Frame;
myFrameDef uartRx1Frame;
myFrameDef uartRx2Frame;



//thread_idle define
void thread_idle (void const *argument);
osThreadId thread_idle_id;
osThreadDef(thread_idle, osPriorityNormal, 1, 0);

//thread_uart0_rx define
void thread_uart0_rx (void const *argument);
osThreadId thread_uart0_rx_id;
osThreadDef(thread_uart0_rx, osPriorityNormal, 1, 0);

//thread_uart1_rx define
void thread_uart1_rx (void const *argument);
osThreadId thread_uart1_rx_id;
osThreadDef(thread_uart1_rx, osPriorityNormal, 1, 0);

//thread_uart2_rx define
void thread_uart2_rx (void const *argument);
osThreadId thread_uart2_rx_id;
osThreadDef(thread_uart2_rx, osPriorityNormal, 1, 0);


uint8_t* MakeFrame(uint8_t* buf,uint8_t len,myFrameDef* pFrame)
{
	uint8_t* retp=NULL;
	int i;
	uint8_t ch;
	for(i=0;i<len;i++)
	{
		ch=buf[i];
		if(pFrame->st==0)
		{
			if(ch==0xff)
			{
				pFrame->st=1;
				pFrame->cnt=0;
			}
		}
		else
		{
			pFrame->buf[pFrame->cnt]=ch;
			pFrame->cnt++;
			if(pFrame->cnt>=3)
			{
				retp=pFrame->buf;
				pFrame->st=0;
			}
		}
	}
	return retp;
}



void thread_uart0_rx(void const *argument)
{
	uint8_t* pRxLine;
	uint8_t* pFrame;
	int len;
	while(1)
	{
		len=GetUart0RxLine(&pRxLine);
		if(len>0)
		{
			pFrame=MakeFrame(pRxLine,len,&uartRx0Frame);
			if(pFrame!=NULL)
			{
				//IO004_TogglePin(LED1);
			}
		}
    }
}

void thread_uart1_rx(void const *argument)
{
	uint8_t* pRxLine;
	uint8_t* pFrame;
	int len;
	while(1)
	{
		len=GetUart1RxLine(&pRxLine);
		if(len>0)
		{
			pFrame=MakeFrame(pRxLine,len,&uartRx1Frame);
			if(pFrame!=NULL)
			{
				IO004_TogglePin(LED1);
			}
		}
    }
}

void thread_uart2_rx(void const *argument)
{
	uint8_t* pRxLine;
	uint8_t* pFrame;
	int len;
	while(1)
	{
		len=GetUart2RxLine(&pRxLine);
		if(len>0)
		{
			pFrame=MakeFrame(pRxLine,len,&uartRx2Frame);
			if(pFrame!=NULL)
			{
				//IO004_TogglePin(LED1);
			}
		}
    }
}

void thread_idle(void const *argument)
{
	uint8_t buf[16]={0xff,0,0,0,0,0,0,0};
	while(1)
	{
		osDelay(10);
		IO004_TogglePin(LED0);
		myUART0_Send(buf,8);
		myUART1_Send(buf,8);
		myUART2_Send(buf,8);
    }
}


























int main(void)
{
	memset(&uartRx0Frame,0,sizeof(myFrameDef));
	memset(&uartRx1Frame,0,sizeof(myFrameDef));
	memset(&uartRx2Frame,0,sizeof(myFrameDef));
	myUARTinit();


//	status_t status;		// Declaration of return variable for DAVE3 APIs (toggle comment if required)
	DAVE_Init();			// Initialization of DAVE Apps


	thread_idle_id = osThreadCreate(osThread(thread_idle), NULL);
	thread_uart0_rx_id = osThreadCreate(osThread(thread_uart0_rx), NULL);
	thread_uart1_rx_id = osThreadCreate(osThread(thread_uart1_rx), NULL);
	thread_uart2_rx_id = osThreadCreate(osThread(thread_uart2_rx), NULL);
	osKernelStart();

	//if something error!!!
	while(1)
	{
		osDelay(1000);
	}
	return 0;
}
