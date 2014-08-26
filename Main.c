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

uint8_t rxbuf[16];
uint8_t txbuf[13] = {'h','e','\r','\n'};



void threadA(void const *argument)
{

	status_t Status = UART002_FAIL;
	UART002_LocalStructType TxChn;
	UART002_LocalStructureInit(&UART002_Handle0,&TxChn,0x0001);
	TxChn.DataLen = 4;
	TxChn.pBuffer = &txbuf[0];

    while(1)
    {

    	osDelay(500);
    	IO004_TogglePin(LED0);

		Status = UART002_StartTransmission(&TxChn,10000);
		if(Status == UART002_TIMEOUT)
		{
			Status = UART002_FAIL;
		}
		else
		{
			Status = UART002_WaitForCompletion(&TxChn,5000);
			if(Status != UART002_TIMEOUT)
			{

				Status = UART002_GetStatus(&TxChn);
				if(Status != UART002_TRANSFER_SUCCESS)
				{
						Status = UART002_FAIL;
				}
			}
		}

    }
}


void threadB(void const *argument)
{

	status_t Status = UART002_FAIL;
	UART002_LocalStructType RxChn;
	UART002_LocalStructureInit(&UART002_Handle1,&RxChn,0x0001);
	RxChn.DataLen=4;
	RxChn.pBuffer=&rxbuf[0];

    while(1)
     {
        Status = UART002_StartReception(&RxChn,10000);
        if(Status == UART002_TIMEOUT)
        {
        	Status = UART002_FAIL;
        }

        else
        {
        	Status = UART002_WaitForCompletion(&RxChn,10000);
        	if(Status != UART002_TIMEOUT)
        	{
        		Status = UART002_GetStatus(&RxChn);
        		if(Status != UART002_TRANSFER_SUCCESS)
        		{
        			Status = UART002_FAIL;
        		}
        		else IO004_TogglePin(LED1);
        	}
        }

   //     if(Status != UART002_FAIL)
    //    {
     //   	IO004_TogglePin(LED1);
      //  }

//    	osDelay(1000);
 //   	IO004_TogglePin(LED1);
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
		osDelay(1000);
	}
	return 0;
}
