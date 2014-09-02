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
#define MAXLINE 8

typedef struct{
	uint8_t ArrayBuf[MAXLINE][MAXCHAR];
	uint8_t ArrayLen[MAXLINE];
	uint8_t WritePos;
	uint8_t SendPos;
	uint8_t Sending;
}my_UART_TX_BUF;

uint8_t UART0_rx_buffer[16];

my_UART_TX_BUF uart0tx;
my_UART_TX_BUF uart1tx;
my_UART_TX_BUF uart2tx;


void myUARTinit()
{
	uart0tx.SendPos=0;
	uart0tx.WritePos=0;
	uart0tx.Sending=0;
	uart1tx.SendPos=0;
	uart1tx.WritePos=0;
	uart1tx.Sending=0;
	uart2tx.SendPos=0;
	uart2tx.WritePos=0;
	uart2tx.Sending=0;
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
		IO004_TogglePin(LED1);
		UART001_ClearFlag(&UART001_Handle0,UART001_FIFO_STD_RECV_BUF_FLAG);
		/* Read the received data to the buffer */
		UART001_ReadDataBytes(&UART001_Handle0,UART0_rx_buffer,8);
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
		IO004_TogglePin(LED1);
		UART001_ClearFlag(&UART001_Handle1,UART001_FIFO_STD_RECV_BUF_FLAG);
		/* Read the received data to the buffer */
		UART001_ReadDataBytes(&UART001_Handle1,UART0_rx_buffer,8);
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
		UART001_ReadDataBytes(&UART001_Handle2,UART0_rx_buffer,8);
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
