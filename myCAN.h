/*
 * myCAN.h
 *
 *  Created on: 2014-9-4
 *      Author: liudanghao
 */

#ifndef MYCAN_H_
#define MYCAN_H_

void myCANinit();
void myCAN0_Send(uint32_t msgid,uint8_t* buf,uint8_t len);
void myCAN1_Send(uint32_t msgid,uint8_t* buf,uint8_t len);

#endif /* MYCAN_H_ */
