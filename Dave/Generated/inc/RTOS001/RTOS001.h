/*******************************************************************************
 *
 * Copyright (C) 2013 Infineon Technologies AG. All rights reserved.
 *
 * Infineon Technologies AG (Infineon) is supplying this software for use with
 * Infineon’s microcontrollers.
 * This file can be freely distributed within development tools that are
 * supporting such microcontrollers.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS".  NO WARRANTIES, WHETHER EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, BUT NOT LIMITED TO, IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE APPLY TO THIS SOFTWARE.
 * INFINEON SHALL NOT, IN ANY CIRCUMSTANCES, BE LIABLE FOR SPECIAL, INCIDENTAL,
 * OR CONSEQUENTIAL DAMAGES, FOR ANY REASON WHATSOEVER.
********************************************************************************
**                                                                            **
**                                                                            **
** PLATFORM : Infineon XMC4000, XMC1000 Series                           	  **
**                                                                            **
** COMPILER : Compiler Independent                                            **
**                                                                            **
** AUTHOR : App Developer                                                     **
**                                                                            **
** MAY BE CHANGED BY USER [yes/no]: Yes                                       **
**                                                                            **
** MODIFICATION DATE : Mar 2, 2011                                            **
**                                                                            **
*******************************************************************************/

/*******************************************************************************
**                       Author(s) Identity                                   **
********************************************************************************
**                                                                            **
** Initials     Name                                                          **
** ---------------------------------------------------------------------------**
** kks          App Developer                                                 **
*******************************************************************************/

/**
 * @file RTOS001.h
 *
 * @brief  This file includes all the header file for cmsis.
 *
 */

#ifndef _RTOS001_H
#define _RTOS001_H

#ifdef  __cplusplus
extern "C"
{
#endif

#include "../../src/RTOS001/INC/cmsis_os.h"

/**
 * @ingroup RTOS001_apidoc
 * @{
 */
/**
 * @brief This function initializes the OS kernel.
 * @return void
 * <b>Reentrant: NO </b><BR>
 *  @code
 * #include <DAVE3.h>
 *  int main(void)
 *  {
 *    RTOS001_Init();
 *    return 0;
 *  }
 * @endcode<BR>
*/
#if defined ( __CC_ARM )
static __inline void RTOS001_Init(void)
#else
static inline void RTOS001_Init(void)
#endif
{
	osKernelInitialize();
}

/**
 * @}
 */
 
#ifdef  __cplusplus
}
#endif

#endif


