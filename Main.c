/*
 * Main.c
 *
 *
 *  Created on: 2014-8-20
 *      Author: liudanghao
 */

#include <DAVE3.h>			//Declarations from DAVE3 Code Generation (includes SFR declaration)


//threadA define
void threadA (void const *argument);
osThreadId threadA_id;
osThreadDef(threadA, osPriorityNormal, 1, 0);

//threadB define
void threadB (void const *argument);
osThreadId threadB_id;
osThreadDef(threadB, osPriorityNormal, 1, 0);

//LED define
#define LED0 IO004_Handle0
#define LED1 IO004_Handle1



void delay(long unsigned int i)
{
	while(i--)
	{
		__NOP();
	}
}


void threadA(void const *argument)
{
    while(1)
    {
    	IO004_TogglePin(LED0);
    	osDelay(1000);

    }
}


void threadB(void const *argument)
{
    while(1)
    {
    	IO004_TogglePin(LED1);
    	osDelay(2000);

    }
}



int main(void)
{
//	status_t status;		// Declaration of return variable for DAVE3 APIs (toggle comment if required)


	DAVE_Init();			// Initialization of DAVE Apps

	threadA_id = osThreadCreate(osThread(threadA), NULL);
	threadB_id = osThreadCreate(osThread(threadB), NULL);

	osKernelStart();

	//if something error!!!
	while(1)
	{
		osDelay(400);
	}
	return 0;
}
