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

uint8_t Data[13] = {'H','E','L','L','O',' ','W','O','R','L','D','\n','\r'};
uint8_t Data1[13] = {'h','e','l','l','o',' ','w','o','r','l','d','\n','\r'};



void threadA(void const *argument)
{

	status_t Status = UART002_FAIL;
	UART002_LocalStructType TxChn1;
	UART002_LocalStructureInit(&UART002_Handle0,&TxChn1,0x0001);
	TxChn1.DataLen = 13;
	TxChn1.pBuffer = &Data1[0];

    while(1)
    {

    	osDelay(1000);
    	IO004_TogglePin(LED0);

		Status = UART002_StartTransmission(&TxChn1,10000);
		if(Status == UART002_TIMEOUT)
		{
			Status = UART002_FAIL;
		}
		else
		{
			Status = UART002_WaitForCompletion(&TxChn1,10000);
			if(Status != UART002_TIMEOUT)
			{

				Status = UART002_GetStatus(&TxChn1);
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
    UART002_LocalStructType TxChn;
    UART002_LocalStructureInit(&UART002_Handle0,&TxChn,0x0001);
    TxChn.DataLen = 13;
    TxChn.pBuffer = &Data[0];

    osDelay(500);
    while(1)
     {
        IO004_TogglePin(LED1);
        osDelay(1000);

    	Status = UART002_StartTransmission(&TxChn,10000);
    	if(Status == UART002_TIMEOUT)
    	{
    		Status = UART002_FAIL;
    	}
    	else
    	{
    		Status = UART002_WaitForCompletion(&TxChn,10000);
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
