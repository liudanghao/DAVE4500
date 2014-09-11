/*******************************************************************************
**  DAVE App Name : NVIC002       App Version: 1.0.26               
**  This file is generated by DAVE, User modification to this file will be    **
**  overwritten at the next code generation.                                  **
*******************************************************************************/



/*CODE_BLOCK_BEGIN[NVIC002_Conf.h]*/
/**************************************************************************//**
 *
 * Copyright (C) 2013 Infineon Technologies AG. All rights reserved.
 *
 * Infineon Technologies AG (Infineon) is supplying this software for use with 
 * Infineon's microcontrollers.  
 * This file can be freely distributed within development tools that are 
 * supporting such microcontrollers. 
 *
 * THIS SOFTWARE IS PROVIDED "AS IS".  NO WARRANTIES, WHETHER EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, BUT NOT LIMITED TO, IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE APPLY TO THIS SOFTWARE.
 * INFINEON SHALL NOT, IN ANY CIRCUMSTANCES, BE LIABLE FOR SPECIAL, INCIDENTAL, 
 * OR CONSEQUENTIAL DAMAGES, FOR ANY REASON WHATSOEVER.
 *
********************************************************************************
**                                                                            **
**                                                                            **
** PLATFORM : Infineon XMC4000/XMC1000 Series   			                  **
**                                                                            **
** COMPILER : Compiler Independent                                            **
**                                                                            **
** AUTHOR   : App Developer                                                   **
**                                                                            **
** MAY BE CHANGED BY USER [yes/no]: Yes                                       **
**                                                                            **
** MODIFICATION DATE : Oct 08, 2013                                           **
*******************************************************************************/

/*******************************************************************************
**                       Author(s) Identity                                   **
********************************************************************************
**                                                                            **
** Initials     Name                                                          **
** ---------------------------------------------------------------------------**
** SNR          App Developer                                                 **
*******************************************************************************/

/**
 * @file   NVIC002_Conf.h
 *
 * @App    Version NVIC002 <1.0.26>
 *
 * @brief  Configuration file generated based on UI settings 
 *         of NVIC002 App
 *
 */
/* Revision History	
 * 18  Feb 2013   v1.0.12 
 * 08  Oct 2013   v1.0.20 Updated as per coding guidelines
 */
#ifndef _NVIC002_CONF_H_
#define _NVIC002_CONF_H_

#ifdef __cplusplus
extern "C" {
#endif

/****************************************************************************
@Defines
****************************************************************************/
#define DEBUG_APP false
  
/* User defined function mapped to IRQ_Hdlr_89 */
#define Uart0RxFIFOBufferEventHandler    IRQ_Hdlr_89 

/* User defined function mapped to IRQ_Hdlr_87 */
#define Uart0TxBufferEventHandler    IRQ_Hdlr_87 

/* User defined function mapped to IRQ_Hdlr_90 */
#define Uart1RxFIFOBufferEventHandler    IRQ_Hdlr_90 

/* User defined function mapped to IRQ_Hdlr_91 */
#define Uart1TxBufferEventHandler    IRQ_Hdlr_91 

/* User defined function mapped to IRQ_Hdlr_92 */
#define Uart2RxFIFOBufferEventHandler    IRQ_Hdlr_92 

/* User defined function mapped to IRQ_Hdlr_93 */
#define Uart2TxBufferEventHandler    IRQ_Hdlr_93 

/* User defined function mapped to IRQ_Hdlr_77 */
#define EventHandlerCAN0    IRQ_Hdlr_77 

/* User defined function mapped to IRQ_Hdlr_76 */
#define EventHandlerCAN1    IRQ_Hdlr_76 

/* User defined function mapped to IRQ_Hdlr_64 */
#define QEP_Period_Event_Handler    IRQ_Hdlr_64 

/* User defined function mapped to IRQ_Hdlr_46 */
#define QEP_Compare_Event_Handler    IRQ_Hdlr_46 


/**
 * @ingroup NVIC002_constants
 * @{
 */
#define NVIC002_NUM_INSTANCES 10U
/**
  * @}
  */
#ifdef __cplusplus
}
#endif

#endif  /* ifndef _NVIC002_CONF_H_ */
/*CODE_BLOCK_END*/

