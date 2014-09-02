/*
 * myUART.h
 *
 *  Created on: 2014-9-2
 *      Author: liudanghao
 */

#ifndef MYUART_H_
#define MYUART_H_

void myUARTinit();
void myUART0_Send(uint8_t* buf,uint8_t len);
void myUART1_Send(uint8_t* buf,uint8_t len);
void myUART2_Send(uint8_t* buf,uint8_t len);

uint8_t GetUart0RxLine(uint8_t** buf);
uint8_t GetUart1RxLine(uint8_t** buf);
uint8_t GetUart2RxLine(uint8_t** buf);


#endif /* MYUART_H_ */
