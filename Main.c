/*
 * Main.c
 *
 *
 *  Created on: 2014-8-20
 *      Author: liudanghao
 */

#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)
#include "myGlobe.h"
#include "myUART.h"



//thread_idle define
void thread_idle (void const *argument);
osThreadId thread_idle_id;
osThreadDef(thread_idle, osPriorityNormal, 1, 0);






void thread_idle(void const *argument)
{
	uint8_t buf[16];
	while(1)
	{
		osDelay(500);
		IO004_TogglePin(LED0);
		myUART0_Send(buf,4);
		myUART1_Send(buf,5);
		myUART2_Send(buf,7);
    }
}














int main(void)
{
//	status_t status;		// Declaration of return variable for DAVE3 APIs (toggle comment if required)
	DAVE_Init();			// Initialization of DAVE Apps

	myUARTinit();

	thread_idle_id = osThreadCreate(osThread(thread_idle), NULL);

	osKernelStart();

	//if something error!!!
	while(1)
	{
		osDelay(1000);
	}
	return 0;
}
