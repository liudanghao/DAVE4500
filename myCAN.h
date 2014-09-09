/*
 * myCAN.h
 *
 *  Created on: 2014-9-4
 *      Author: liudanghao
 */

#include <DAVE3.h>

#ifndef MYCAN_H_
#define MYCAN_H_

void myCANinit();
void myCAN0_Send(uint8_t msgbox,uint8_t* buf,uint8_t len);
void myCAN1_Send(uint8_t msgbox,uint8_t* buf,uint8_t len);
CAN001_MessageHandleType* myCAN0_Get();
CAN001_MessageHandleType* myCAN1_Get();

#endif /* MYCAN_H_ */
