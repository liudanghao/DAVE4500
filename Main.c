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
#include "myCAN.h"


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

//thread_idle2 define
void thread_idle2 (void const *argument);
osThreadId thread_idle2_id;
osThreadDef(thread_idle2, osPriorityNormal, 1, 0);

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




void thread_uart0_rx(void const *argument)
{
	uint8_t* pRxLine;
	int len;
	uint8_t ch;
	int i;
	while(1)
	{
		len=GetUart0RxLine(&pRxLine);
		if(len>0)
		{
			for(i=0;i<len;i++)
			{
				ch=pRxLine[i];
				if(uartRx0Frame.st==0)
				{
					if(ch==0xff)
					{
						uartRx0Frame.st=1;
						uartRx0Frame.cnt=0;
					}
				}
				else
				{
					uartRx0Frame.buf[uartRx0Frame.cnt]=ch;
					uartRx0Frame.cnt++;
					if(uartRx0Frame.cnt>=7)
					{
						//==================process frame here=====================
						//==================process frame end======================
						uartRx0Frame.st=0;
					}
				}
			}
		}
    }
}


void thread_uart1_rx(void const *argument)
{
	uint8_t* pRxLine;
	int len;
	while(1)
	{
		len=GetUart1RxLine(&pRxLine);
		if(len>0)
		{
		}
    }
}

void thread_uart2_rx(void const *argument)
{
	uint8_t* pRxLine;
	int len;
	while(1)
	{
		len=GetUart2RxLine(&pRxLine);
		if(len>0)
		{
		}
    }
}

void thread_idle(void const *argument)
{
	uint8_t buf[16]={0xff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	while(1)
	{
		osDelay(50);
		myUART0_Send(buf,8);
		myUART0_Send(buf,8);
		myCAN0_Send(0,buf,8);
		myCAN1_Send(0,buf,8);

    }
}


void thread_idle2(void const *argument)
{
	uint8_t buf[16]={0xff,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	while(1)
	{
		osDelay(100);
		myUART0_Send(buf,8);
		myUART0_Send(buf,8);
    }
}



















int main(void)
{
	memset(&uartRx0Frame,0,sizeof(myFrameDef));
	memset(&uartRx1Frame,0,sizeof(myFrameDef));
	memset(&uartRx2Frame,0,sizeof(myFrameDef));
	myUARTinit();
	myCANinit();


//	status_t status;		// Declaration of return variable for DAVE3 APIs (toggle comment if required)
	DAVE_Init();			// Initialization of DAVE Apps


	thread_idle_id = osThreadCreate(osThread(thread_idle), NULL);
	thread_idle2_id = osThreadCreate(osThread(thread_idle2), NULL);
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
