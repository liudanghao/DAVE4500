/*
 * myUART.c
 *
 *  Created on: 2014-9-2
 *      Author: liudanghao
 */
#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)
#include "myGlobe.h"
#include <string.h>

#define MAXCHAR 16 //WARNING!!! this must be less or equels to the TX FIFO size
#define MAXLINE 8	//must be 4,8,16,32,64....

typedef struct{
	uint8_t ArrayBuf[MAXLINE][MAXCHAR];
	uint8_t ArrayLen[MAXLINE];
	uint8_t WritePos;
	uint8_t SendPos;
	uint8_t Sending;
}my_UART_BUF;


my_UART_BUF uart0tx;
my_UART_BUF uart1tx;
my_UART_BUF uart2tx;
my_UART_BUF uart0rx;
my_UART_BUF uart1rx;
my_UART_BUF uart2rx;

osSemaphoreId uart0semaphore;
osSemaphoreDef(uart0semaphore);

osSemaphoreId uart1semaphore;
osSemaphoreDef(uart1semaphore);

osSemaphoreId uart2semaphore;
osSemaphoreDef(uart2semaphore);

uint8_t GetUart0RxLine(uint8_t** buf)
{
	uint8_t len;
	if(uart0rx.WritePos == uart0rx.SendPos)
	{
		osSemaphoreWait(uart0semaphore,osWaitForever);
		//return 0;
	}
	*buf=uart0rx.ArrayBuf[uart0rx.SendPos];
	len=uart0rx.ArrayLen[uart0rx.SendPos];
	uart0rx.SendPos++;
	uart0rx.SendPos&=(MAXLINE-1);
	return len;
}

uint8_t GetUart1RxLine(uint8_t** buf)
{
	uint8_t len;
	if(uart1rx.WritePos == uart1rx.SendPos)
	{
		osSemaphoreWait(uart1semaphore,osWaitForever);
		//return 0;
	}
	*buf=uart1rx.ArrayBuf[uart1rx.SendPos];
	len=uart1rx.ArrayLen[uart1rx.SendPos];
	uart1rx.SendPos++;
	uart1rx.SendPos&=(MAXLINE-1);
	return len;
}


uint8_t GetUart2RxLine(uint8_t** buf)
{
	uint8_t len;
	if(uart2rx.WritePos == uart2rx.SendPos)
	{
		osSemaphoreWait(uart2semaphore,osWaitForever);
		//return 0;
	}
	*buf=uart2rx.ArrayBuf[uart2rx.SendPos];
	len=uart2rx.ArrayLen[uart2rx.SendPos];
	uart2rx.SendPos++;
	uart2rx.SendPos&=(MAXLINE-1);
	return len;
}


void myUARTinit()
{
	uart0semaphore = osSemaphoreCreate(osSemaphore(uart0semaphore), 1);
	uart1semaphore = osSemaphoreCreate(osSemaphore(uart1semaphore), 1);
	uart2semaphore = osSemaphoreCreate(osSemaphore(uart2semaphore), 1);
	memset(&uart0tx,0,sizeof(my_UART_BUF));
	memset(&uart1tx,0,sizeof(my_UART_BUF));
	memset(&uart2tx,0,sizeof(my_UART_BUF));
}



void myUART0_Send(uint8_t* buf,uint8_t len)
{
	if(len>MAXCHAR) len=MAXCHAR;
	if(uart0tx.Sending==0)
	{
		UART001_WriteDataBytes(&UART001_Handle0,buf,len);
		uart0tx.Sending=1;
		return;
	}
	memcpy(uart0tx.ArrayBuf[uart0tx.WritePos],buf,len);
	uart0tx.ArrayLen[uart0tx.WritePos]=len;
	uart0tx.WritePos++;
	uart0tx.WritePos&=(MAXLINE-1);
}


void myUART1_Send(uint8_t* buf,uint8_t len)
{
	if(len>MAXCHAR) len=MAXCHAR;
	if(uart1tx.Sending==0)
	{
		UART001_WriteDataBytes(&UART001_Handle1,buf,len);
		uart1tx.Sending=1;
		return;
	}
	memcpy(uart1tx.ArrayBuf[uart1tx.WritePos],buf,len);
	uart1tx.ArrayLen[uart1tx.WritePos]=len;
	uart1tx.WritePos++;
	uart1tx.WritePos&=(MAXLINE-1);
}

void myUART2_Send(uint8_t* buf,uint8_t len)
{
	if(len>MAXCHAR) len=MAXCHAR;
	if(uart2tx.Sending==0)
	{
		UART001_WriteDataBytes(&UART001_Handle2,buf,len);
		uart2tx.Sending=1;
		return;
	}
	memcpy(uart2tx.ArrayBuf[uart2tx.WritePos],buf,len);
	uart2tx.ArrayLen[uart2tx.WritePos]=len;
	uart2tx.WritePos++;
	uart2tx.WritePos&=(MAXLINE-1);
}




/* Fifo standard receive buffer event handler */
void Uart0RxFIFOBufferEventHandler()
{
	if(UART001_GetFlagStatus(&UART001_Handle0,UART001_FIFO_STD_RECV_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle0,UART001_FIFO_STD_RECV_BUF_FLAG);
		/* Read the received data to the buffer */
		uart0rx.ArrayLen[uart0rx.WritePos] = UART001_ReadDataBytes(&UART001_Handle0,uart0rx.ArrayBuf[uart0rx.WritePos],8);
		uart0rx.WritePos++;
		uart0rx.WritePos&=(MAXLINE-1);
		osSemaphoreRelease(uart0semaphore);
	}
}

/* Transmit buffer event handler */
void Uart0TxBufferEventHandler()
{
	if(UART001_GetFlagStatus(&UART001_Handle0,UART001_FIFO_STD_TRANSMIT_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle0,UART001_FIFO_STD_TRANSMIT_BUF_FLAG);
		if(uart0tx.SendPos!=uart0tx.WritePos)
		{
			UART001_WriteDataBytes(&UART001_Handle0,uart0tx.ArrayBuf[uart0tx.SendPos],uart0tx.ArrayLen[uart0tx.SendPos]);
			uart0tx.SendPos++;
			uart0tx.SendPos&=(MAXLINE-1);
		}
		else
		{
			uart0tx.Sending=0;
		}
	}
}






/* Fifo standard receive buffer event handler */
void Uart1RxFIFOBufferEventHandler()
{

	if(UART001_GetFlagStatus(&UART001_Handle1,UART001_FIFO_STD_RECV_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle1,UART001_FIFO_STD_RECV_BUF_FLAG);
		/* Read the received data to the buffer */
		uart1rx.ArrayLen[uart1rx.WritePos] = UART001_ReadDataBytes(&UART001_Handle1,uart1rx.ArrayBuf[uart1rx.WritePos],8);
		uart1rx.WritePos++;
		uart1rx.WritePos&=(MAXLINE-1);
		osSemaphoreRelease(uart1semaphore);
	}
}

/* Transmit buffer event handler */
void Uart1TxBufferEventHandler()
{
	if(UART001_GetFlagStatus(&UART001_Handle1,UART001_FIFO_STD_TRANSMIT_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle1,UART001_FIFO_STD_TRANSMIT_BUF_FLAG);
		if(uart1tx.SendPos!=uart1tx.WritePos)
		{
			UART001_WriteDataBytes(&UART001_Handle1,uart1tx.ArrayBuf[uart1tx.SendPos],uart1tx.ArrayLen[uart1tx.SendPos]);
			uart1tx.SendPos++;
			uart1tx.SendPos&=(MAXLINE-1);
		}
		else
		{
			uart1tx.Sending=0;
		}
	}
}


/* Fifo standard receive buffer event handler */
void Uart2RxFIFOBufferEventHandler()
{

	if(UART001_GetFlagStatus(&UART001_Handle2,UART001_FIFO_STD_RECV_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle2,UART001_FIFO_STD_RECV_BUF_FLAG);
		/* Read the received data to the buffer */
		uart2rx.ArrayLen[uart2rx.WritePos] = UART001_ReadDataBytes(&UART001_Handle2,uart2rx.ArrayBuf[uart2rx.WritePos],8);
		uart2rx.WritePos++;
		uart2rx.WritePos&=(MAXLINE-1);
		osSemaphoreRelease(uart2semaphore);
	}
}

/* Transmit buffer event handler */
void Uart2TxBufferEventHandler()
{
	if(UART001_GetFlagStatus(&UART001_Handle2,UART001_FIFO_STD_TRANSMIT_BUF_FLAG) == UART001_SET)
	{
		UART001_ClearFlag(&UART001_Handle2,UART001_FIFO_STD_TRANSMIT_BUF_FLAG);
		if(uart2tx.SendPos!=uart2tx.WritePos)
		{
			UART001_WriteDataBytes(&UART001_Handle2,uart2tx.ArrayBuf[uart2tx.SendPos],uart2tx.ArrayLen[uart2tx.SendPos]);
			uart2tx.SendPos++;
			uart2tx.SendPos&=(MAXLINE-1);
		}
		else
		{
			uart2tx.Sending=0;
		}
	}
}
