
/*CODE_BLOCK_BEGIN[POSQE001.h]*/

/**************************************************************************//**
 *
 * Copyright (C) 2014 Infineon Technologies AG. All rights reserved.
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
** PLATFORM : Infineon XMC4000 Series                                         **
**                                                                            **
** COMPILER : Compiler Independent                                            **
**                                                                            **
** AUTHOR   : App Developer                                                   **
**                                                                            **
** MAY BE CHANGED BY USER [yes/no]: Yes                                       **
**                                                                            **
** MODIFICATION DATE : April 25, 2014                                           **
**                                                                            **
*******************************************************************************/

/*******************************************************************************
**                       Author(s) Identity                                   **
********************************************************************************
**                                                                            **
** Initials     Name                                                          **
** KP           App Developer
** RG           App Developer
** ---------------------------------------------------------------------------**
**                                                                            **
*******************************************************************************/


/**
 * @file POSQE001.h
 *
 * @brief  This header file contains POSQE001 App function prototypes
 * 
 * Revision History
 * 25 April 2014 v1.0.14 Initial Version
 *
 */

#ifndef POSQE001_H_
#define POSQE001_H_

#ifdef __cplusplus
extern "C" {
#endif

/*****************************************************************************
 * INCLUDE FILES
 *****************************************************************************/

#include <DAVE3.h>

/*****************************************************************************
 *                            Macros                                        **
 *****************************************************************************/

#define POSQE001_POSIF_MODE                 (0x01)
#define POSQE001_TIMER_COUNTING_MODE        (0x00)
#define POSQE001_CAPTURE_MODE               (0x01)
#define POSQE001_EVENT0                     (0x01)
#define POSQE001_EVENT1                     (0x02)
#define POSQE001_EVENT2                     (0x03)
#define POSQE001_FLUSH_START                (0x01)
#define POSQE001_FLUSH_STOP                 (0x02)
#define POSQE001_OVERWRITE_CAP              (0x01)
#define POSQE001_START_SLICE                (0x01)

/*******************************************************************************
**                 Function like macro definitions                            **
*******************************************************************************/

/*******************************************************************************
 *                                TYPEDEFS                                    **
 ******************************************************************************/

/**
 * @brief This is the typedef for the Position Interface function pointer.
 * Based on the selected profile a particular function pointer is assigned in
 * the Handle.
 */
typedef void (*POSQE001_GetPosInterpolationFuncPtr)(void*,void* ,uint32_t);

/**
 * @ingroup POSQE001_publicparam
 * @{
 */

/*******************************************************************************
 *                                ENUMERATIONS                                **
 ******************************************************************************/
/**
 * @brief This App uses 4 CCU slices. This enumerates the Slices types
 */
typedef enum POSQE001_CCUSliceType
{
  /**
   * The Position Counter Slice. This slice counts the Quadrature Clock coming
   * from the POSIF Module.
   */
  POSQE001_POSITION_COUNTER,
  /**
   * The Revolution Counter Slice. This Slice counts the Index Signal coming
   * from the POSIF Module.
   */
  POSQE001_REVOLUTION_COUNTER,
  /**
   * The Velocity Counter0 Slice. This slice counts the Period Clock coming from
   * the POSIF Module.
   */
  POSQE001_VELOCITY_COUNTER0,
  /**
   * The Velocity Timer0 Slice. This slice Generates the Timer window for the
   * tick capture.
   */
  POSQE001_VELOCITY_TIMER0,
  /**
   * The Velocity Timer1 Slice. This slice is used in the Profile-1.
   */
  POSQE001_VELOCITY_TIMER1

}
POSQE001_CCUSliceType;

/**
 * @brief This enumerates the interrupts possible in this app
 */
typedef enum POSQE001_EventNameType
{
  /**
   * This is the Period match Event for a CCU slice
   */
  POSQE001_CCU_PERIOD_MATCH = 0,
  /**
   * The compare match Event while counting UP for CCU slice
   */
  POSQE001_CCU_UP_COMPARE_MATCH = 2,
  /**
   * The compare match Event while counting DOWN for CCU slice
   */
  POSQE001_CCU_DOWN_COMPARE_MATCH = 3,
  /**
   * The Event 1 Event occurrence for CCU slice
   */
  POSQE001_CCU_EVENT0 = 8,
  /**
   * The Event 1 Event occurrence for CCU slice
   */
  POSQE001_CCU_EVENT1 = 9,
  /**
   * The Event 2 Event occurrence for CCU slice
   */
  POSQE001_CCU_EVENT2 = 10,
  /**
   * POSIF Module Index Event Occurrence
   */
  POSQE001_POSIF_INDEX = 24,
  /**
   * POSIF Module Phase Error Event
   */
  POSQE001_POSIF_PHASE_ERR = 25,
  /**
   * POSIF Module Quadrature clock Event
   */
  POSQE001_POSIF_QCLK = 26,
  /**
   * POSIF Module Direction change Event
   */
  POSQE001_POSIF_DIR_CHANGE = 27,
  /**
   * POSIF Module Period Clock Event
   */
  POSQE001_POSIF_PCLK = 28,

}POSQE001_EventNameType;

/**
 * @brief This enumerates the type of the quadrature encoder sensor.
 */
typedef enum POSQE001_SensorType
{
  /**
   * Quadrature encoder outputs phase signals - Phase A and Phase B and
   * index marker signal.
   */
  POSQE001_SIGNALS_AB_INDEX,

  /**
   * Quadrature encoder outputs Phase signals A and B only
   */
  POSQE001_SIGNALS_AB,

  /**
   * Quadrature encoder sensor outputs clock and direction signal
   */
  POSQE001_SIGNALS_CLOCK_DIR,

  /**
   * Quadrature encoder sensor outputs clock only
   */
  POSQE001_SIGNALS_CLOCK,

}POSQE001_SensorType;

/**
 * @brief This enumerates the state of the App.
 */
typedef enum POSQE001_StateType
{
  /**
   * This is the Default state of an APP after power on reset.
   */
  POSQE001_UNINITIALIZED,
  /**
   * App will go in INITIALIZED state after Init() command is received or Stop()
   * command is received.
   */
  POSQE001_INITIALIZED,
  /**
   * The App is in the start State.
   */
  POSQE001_START
}POSQE001_StateType;

/**
 * @brief This enumerates the error codes which are returned from a function.
 */
typedef enum POSQE001_ErrorCodesType
{

  /**
   * This code would be returned when any operation is not possible cause that
   * operation was tried in invalid state
   */
  /**
   * @cond INTERNAL_DOCS
   * @param MODULENAME POSQE001
   * @endcond
  */
  /**
   * @cond INTERNAL_DOCS
   * @param ERRCODESTRING1 POSQE001_OPER_NOT_ALLOWED_ERROR
   * @param STRCODESTRING1 = Function execution is not allowed in the current state
   * @endcond
   */
  POSQE001_OPER_NOT_ALLOWED_ERROR = 1,
  /**
   * This code is returned when parameter passed to API are invalid
   */
  /**
   * @cond INTERNAL_DOCS
   * @param ERRCODESTRING2 POSQE001_INVALID_PARAM_ERROR
   * @param STRCODESTRING2 Input parameter is not valid
   * @endcond
  */
  POSQE001_INVALID_PARAM_ERROR,
  /**
   * This code is returned when wrong phase pair is detected.
   */
  /**
   * @cond INTERNAL_DOCS
   * @param ERRCODESTRING3 POSQE001_CRITICAL_ERROR
   * @param STRCODESTRING3 Quadrature wrong phase pair is detecteed
   * @endcond
   */
  POSQE001_CRITICAL_ERROR,
  /**
   * This code is returned when zero speed is detected.
   */

  /**
   * Debug log messages start here
   * */

  /**
   * Message ID for Function Entry
   */
  /**
   * @cond INTERNAL_DOCS
   * @param ERRCODESTRING4 POSQE001_FUNCTION_ENTRY
   * @param STRCODESTRING4 = Entered Function \%s
   * @endcond
  */
  POSQE001_FUNCTION_ENTRY,
  /**
   * Message ID for Function EXIT
   */
  /**
   * @cond INTERNAL_DOCS
   * @param ERRCODESTRING5 POSQE001_FUNCTION_EXIT
   * @param STRCODESTRING5 Exited Function \%s
   * @endcond
  */
  POSQE001_FUNCTION_EXIT,
}POSQE001_ErrorCodesType;

/**
 * @brief This enumerates the direction of rotation.
 */
typedef enum POSQE001_DirectionType
{
  /**
   * Direction of rotation is counter clockwise.
   */
  POSQE001_ANTI_CLOCKWISE,
  /**
   * Direction of rotation is clockwise.
   */
  POSQE001_CLOCKWISE
}POSQE001_DirectionType;

/**
 * @brief This enumerates the event Type
 */
typedef enum POSQE001_EventType
{
  /**
   * The event is External Start Event
   */
  POSQE001_EXT_START = 0,
  
  /**
     * The event is External stop Event
     */
  POSQE001_EXT_STOP = 2,

  /**
   * The connected event is External Capture 0
   */
  POSQE001_EXT_CAP0 = 4,

  /**
   * The connected event is External Capture 1
   */
  POSQE001_EXT_CAP1 = 6,

  /**
   * The connected event is External Up Down
   */
  POSQE001_EXT_UP_DOWN = 10,

  /**
   * The connected event is External Count
   */
  POSQE001_EXT_COUNT = 14,

}
POSQE001_EventType;

/**
 * @brief This enumerates the event active edge Type
 */
typedef enum POSQE001_EventEdgeType
{
  /**
   * The active edge is not used
   */
  POSQE001_EVT_NONE = 0,
  
  /**
   * The active edge is rising edge
   */
  POSQE001_EVT_RISING = 1,

  /**
   * The active edge is falling
   */
  POSQE001_EVT_FALLING,

  /**
   * Both rising and falling edges are active
   */
  POSQE001_EVT_BOTH,
}
POSQE001_EventEdgeType;

/**
 * @brief This enumerates the phase of the quadrature encoder.
 */
typedef enum POSQE001_LeadingPhaseType
{
  /**
   * Leading phase is Phase A
   */
  POSQE001_PHASE_A,
  /**
   * Leading phase is Phase B
   */
  POSQE001_PHASE_B
}POSQE001_LeadingPhaseType;

/**
 *  @brief This structure holds the Event Configuration
 */
typedef struct POSQE001_EventConfigType
{

  /**
   * The Type of the Event.
   */
  POSQE001_EventType EventType;

   /**
    * The Active Edge for the event.
    */
  POSQE001_EventEdgeType ActiveEdge;

}
POSQE001_EventConfigType;

/**
 * @brief This structure holds the Slice Configurations
 */
typedef struct POSQE001_SliceConfigType
{
  /**
   * This variable tells if slice is in Use or Not.
   */
  uint8_t SliceInUse;

  /**
   * The Prescalar value for a slice
   */
  uint8_t  PrescalarVal;

  uint8_t SliceNum;
  /**
   * The Clear on capture Value
   */
  uint8_t ClearOnCapture;

  /**
   * The Compare Value for the slice
   */
  uint16_t CompareVal;

  /**
   * The Period Value for the slice
   */
  uint16_t PeriodVal;

  /**
   * The Base Address of the Slice Register
   */
  CCU4_CC4_TypeDef* SliceAddress;

  /**
   * The Address of the Global registers of the Slice.
   */
  CCU4_GLOBAL_TypeDef* SliceGlobalAddress;

  /**
   * This is the pointer to the event0 Configurations
   */
  const POSQE001_EventConfigType* Event0Cfg;

  /**
   * This is the pointer to the event1 Configurations
   */
  const POSQE001_EventConfigType*  Event1Cfg;

  /**
   * This is the pointer to the event2 Configurations
   */
  const POSQE001_EventConfigType*  Event2Cfg;

  /**
   * The Slice Interrupt Mask
   */
  uint32_t InterruptMask;

}
POSQE001_SliceConfigType;

/**
 * @brief This enumerates the Register read method. The value for revolution and
 * position can be read from the running timer or from the capture register.
 */
typedef enum POSQE001_ReadRegType
{
  /**
   * Read the Capture register.
   */
  POSQE001_READ_CAPTURE,
  /**
   * Read the Timer register
   */
  POSQE001_READ_TIMER,
}
POSQE001_ReadRegType;

/**
 * @brief This is the Position Interpolation Structure.
 */
typedef struct POSQE001_PositionInterpolation
{
  /**
   * This is the current Position
   */
  uint16_t PositionCount;
  /**
   * This has the Time between the last two Ticks
   */
  uint16_t LastTicksDelta;
  /**
   * This has the Time between the second last two Ticks. In profile 3 this value
   * is always retured as zero.
   */
  uint16_t SecondLastTickDelta;
  /**
   * This has the Time since the Last Tick. In profile 4 this value is captured
   * by the hardware trigger, whereas in profile3 this is obtained by reading
   * the Timer value as a result of which there could be jitters in this value
   * in profile 3.
   */
  uint16_t TimesinceLastTick;
}
POSQE001_PositionInterpolation;
/**
 * @brief This structure holds the parameters which change at run time.
 */
typedef struct POSQE001_DynamicDataType
{
  /**
   * This is the Num Ticks 4 Time capture
   */
  uint16_t NumTicks4TimeCapture;
  /**
   * This is the Time period for Ticks Capture
   */
  uint16_t Time4TicksCapture;
  /**
   * This is the Low speed Limit RAW Timer Value
   */
  uint16_t LowSpeedLimit;
  /**
   * This is the High Speed Limit RAW Timer Value
   */
  uint16_t HighSpeedLimit;
  /**
   * This is the Low speed limit in RPM
   */
  float LowSpeedLimitRPM;
  /**
   * This is the High speed limit in RPM
   */

  float HighSpeedLimitRPM;
  /**
   * The current state of the POSQE001 App.
   */
  POSQE001_StateType AppState;

}POSQE001_DynamicDataType;


/**
 * @brief This is the handle of the Quadrature Decoder APP which holds all static
 * configurations.
 */
typedef struct POSQE001_HandleType
{
  /**
   * The current Profile in use
   */
  uint8_t ProfileInUse;
  /**
   * The POSIF Module does a low pass filtering on the inputs. This value is
   * stored in the kLPF variable
   */
  uint8_t kLPF;

  /**
   * The Index Generation Mode, whether Index is Generated every Index Occurence
   * or just once or it's Disabled
   */
  uint8_t IndexGenMode;
  /**
   * Type of the Quadrature encoder in use.
   */
  POSQE001_SensorType DecoderType;

  /**
   * This Value is Programmed in the POSIF Register depending on the Decoder
   * mode Selected
   */
  uint8_t PosifDecoderType;

  /**
   * The Leading edge for the Clockwise Direction of Rotation
   */
  POSQE001_LeadingPhaseType LeadingEdge;

  /**
   * The Number of Ticks per revolution. This is the ticks as seen by CCU
   * Module
   */
  uint32_t NumTicksPerRevolution;

  /**
   * The Base Address of the POSIF Module
   */
  POSIF_GLOBAL_TypeDef*     PosifModulePtr;

  /**
   * The Pointer to the Slice Configuration
   */
  const POSQE001_SliceConfigType*  CCUSliceConfigPtr[5];
  /**
   * The Pointer to the Dynamic Data.
   */
  POSQE001_DynamicDataType* const DynamicHandlePtr;

  /**
   * The Pointer to the Position Interpolation Function.
   */
  POSQE001_GetPosInterpolationFuncPtr PosInterpolationFuncPtr;

  /**
   * The Low Speed Limit in RPM
   */
  float LowSpeedLimit;
  /**
   * The High Speed Limit in RPM
   */
  float HighSpeedLimit;
  /**
   * The Time multiplier to get the Time
   */
  float TimeMultiplier;
  /**
   * The boolean value, if Low speed Limit is possible or not
   */
  uint8_t LowSpeedLimitPossible;
  /**
   * The boolean value, if high speed Limit is possible or not
   */
  uint8_t HighSpeedLimitPossible;
  /**
   * This is the Start during Initialisation Option
   */
   
  uint8_t StartDuringInit;
  /**
   * The Address of the Position Counter Registers for reading Position
   */
  __I uint32_t *PosCounterRegPtr[2];
  /**
   * The Address of the Velocity Timer1 Register.
   */
  __I uint32_t *VelTimer1PtrRegPtr[4];
  /**
   * The Address of the Velocity Timer0 Register.
   */
  __I uint32_t *VelTimer0PtrRegPtr[3];

}POSQE001_HandleType;


/**
 * @}
 */

/******************************************************************************
 *                      PUBLIC FUNCTION DECLARATIONS                         **
 *****************************************************************************/

/**
 * @ingroup POSQE001_apidoc
 * @{
 */


/**
 * @brief This function initializes the POSIF and CCU4x_CCy peripherals with the
 * configured parameters to get the speed and position from quadrature encoder
 * inputs.<BR>
 *
 * @return None<BR>
 *
 * <b>Reentrant: yes</b> <BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  while(1);
 *  return 0;
 * }
 * @endcode
 */
void POSQE001_Init(void);

/**
 * @brief This function will reset the App. <BR>
 * return void
 * <b>Reentrant: yes</b> <BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  //Do something
 *  Status = POSQE001_Deinit();
 *  while(1);
 *  return 0;
 * }
 * @endcode
 */
void POSQE001_Deinit(void);

/**
 * @brief This function will start the App which in turn starts POSIF
 * and CCU4x_CCy peripherals.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when not in
 * POSQE001_INITIALIZED State.<BR>
 * <BR>
 *
 *  <b>Reentrant: yes</b><BR>
 *  <b>Sync/Async:  Synchronous</b><BR>
 *
  * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1);
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_Start(const POSQE001_HandleType* HandlePtr);

/**
 * @brief This function will stop the App which in turn will stop the
 * POSIF and CCU4x_CCy peripherals. <BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @return status_t<BR>
 *
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is not called in
 * POSQE001_START state<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b> <BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_Stop(&POSQE001_Handle0);
 *  while(1);
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_Stop(const POSQE001_HandleType* HandlePtr);

/**
 * @brief This function will return the current direction of rotation.<BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Dir Current direction of the rotation<BR>

 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is not called when in
 * POSQE001_START. <BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
  * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  POSQE001_DirectionType Dir;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetDirection(&POSQE001_Handle0, &Dir);
 *  }
 *  return 0;
 * }
 * @endcode
 */

status_t POSQE001_GetDirection
(
    const POSQE001_HandleType* HandlePtr,
    POSQE001_DirectionType* Dir
);

/**
 * @brief This function will return the number of Quadrature encoder revolutions. <BR>
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [out] Revolutions Current number of revolutions<BR>
 * @param [in] ReadMethod The Method to read the number of revolution. It can be
 * software read of a Timer or Reading of the capture register<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State or when encoder type doesn't have Index Signal.<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when revolution Counter
 * is not selected from the UI.
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Revolutions;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetRevolutions(&POSQE001_Handle0, &Revolutions,POSQE001_READ_TIMER);
 *  }
 *  return 0;
 * }
 * @endcode

 */
status_t POSQE001_GetRevolutions
(
    const POSQE001_HandleType* HandlePtr,
    uint16_t* Revolutions,
    POSQE001_ReadRegType ReadMethod
);

/**
 * @brief This function will return the position of the motor. The Position returned
 * is the Ticks count<BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Position Current position of the motor<BR>
 * @param[in] ReadMethod The method to read the Position, whether Timer is read
 * or the Capture register is read.<BR>
 *
 *<b>   can be used with: all profiles</b><BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED state.<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Position;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetPosition(&POSQE001_Handle0, &Position, POSQE001_READ_TIMER);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetPosition
(
    const POSQE001_HandleType* HandlePtr,
    uint16_t* Position,
    POSQE001_ReadRegType ReadMethod
);

/**
 * @brief This function will return the Interpolated position of the motor.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] PositionInterpolation The pointer to the Interpolation Structure.<BR>
 * @param[in] ReadMethod The method to read the Position, whether Timer is read
 * or the Capture register is read.<BR>
 *
 * <b>can be used with: Profile1, Profile3 and Profile4</b><BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or if the interpolation is not possible(i.e Profile2
 * is in use).<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  POSQE001_PositionInterpolation Position;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetPositionInterPolation(&POSQE001_Handle0, &Position,POSQE001_READ_TIMER);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetPositionInterPolation
(
    const POSQE001_HandleType* HandlePtr,
    POSQE001_PositionInterpolation* PositionInterpolation,
    POSQE001_ReadRegType ReadMethod
);

/**
 * @brief This function will return the position of the motor in terms of Angle.(0-360)
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Angle The pointer to the Angle.<BR>
 * @param[in] ReadMethod The method to read the Position, whether Timer is read
 * or the Capture register is read.<BR>
 *
 * <b>can be used with: All profiles</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED.<BR>
 * <BR>
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Angle;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetAngle(&POSQE001_Handle0, &Angle,POSQE001_READ_TIMER);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetAngle
(
    const POSQE001_HandleType* HandlePtr,
    float* Angle,
    POSQE001_ReadRegType ReadMethod
);

/**
 * @brief This function will return the interpolated position of the motor in terms of
 * Angle.(0-360)
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] AngleInterpolated The pointer to the Angle.<BR>
 * @param[in] ReadMethod The method to read the Position, whether Timer is read
 * or the Capture register is read.<BR>
 *
 * <b>can be used with: Profile1, Profile3 and Profile4</b><BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or Interpolation is not possible i.e profile 2
 * is in use.<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Angle;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetAngleInterpolate(&POSQE001_Handle0, &Angle,POSQE001_READ_TIMER);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetAngleInterpolate
(
    const POSQE001_HandleType* HandlePtr,
    float* AngleInterpolated,
    POSQE001_ReadRegType ReadMethod
);

/**
 * @brief This function will return the velocity when profile-1 is selected. The
 * velocity calculations are done by measuring the Time between known number
 * of ticks
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Velocity The pointer to the Velocity in RPM.<BR>
 *
 * <b>can be used with: Profile1 only</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or when the selected profile is not Profile1.<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Velocity;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetVelocityInversed(&POSQE001_Handle0, &Velocity);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetVelocityInversed
(
    const POSQE001_HandleType* HandlePtr,
    float* Velocity
);

/**
 * @brief This function will return the velocity when profile-1 is selected. This
 * function returns the velocity in terms of raw capture values of Velocity Timer0.
 *
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Velocity The pointer to the Velocity raw capture values.<BR>
 *
 * <b>can be used with: Profile1 only</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or when profile is not Profile1.<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Velocity;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetVelocityInversedRAW(&POSQE001_Handle0, &Velocity);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetVelocityInversedRAW
(
  const POSQE001_HandleType* HandlePtr,
  uint16_t* Velocity
);

/**
 * @brief This function will return the velocity in profile 2,3 and 4. This
 * function returns the velocity in terms RPM. This function uses the number of
 * ticks in a time window to calculate the velocity
 *
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Velocity The pointer to the Velocity raw capture values.<BR>
 *
 * <b>can be used with: Profile2, Profile3 and Profile4</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or when selected profile is profile1.<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Velocity;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetVelocity(&POSQE001_Handle0, &Velocity);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetVelocity
(
    const POSQE001_HandleType* HandlePtr,
    float* Velocity
);

/**
 * @brief This function will return the velocity in profile 2,3 and 4. This
 * function returns the velocity counter0 register value.
 *
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Velocity The pointer to the Velocity raw capture values.<BR>
 *
 * <b>can be used with: Profile2, Profile3 and Profile4</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED.<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If Velocity Counter0 is not used.<BR>
 *
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Velocity;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *    Status = POSQE001_GetVelocityRAW(&POSQE001_Handle0, &Velocity);
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetVelocityRAW
(
    const POSQE001_HandleType* HandlePtr,
    uint16_t* Velocity
);


/**
 * @brief This function will get the time period for tick capture required for velocity
 * measurement in profile 2,3,4.<BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Time Current time period for which ticks to be captured<BR>
 *
 * <b>can be used with: Profile2, Profile3 and Profile4</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or if selected profile is profile1.<BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Time;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetTimePeriod4TickCap(&POSQE001_Handle0, &Time);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetTimePeriod4TickCap
(
    const POSQE001_HandleType* HandlePtr,
    float* Time
);

/**
 * @brief This function will modify the time period for tick capture required for
 * velocity measurement. <BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[in] Time Current time period for which ticks to be captured<BR>
 *
 * <b>can be used with: Profile2, Profile3 and Profile4</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State Or if the selected profile is profile1<BR>
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float Time = 0.00005;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_SetTimePeriod4TickCap(&POSQE001_Handle0, Time);
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetTimePeriod4TickCap
(
    const POSQE001_HandleType* HandlePtr,
    float Time
);

/**
 * @brief This function will get the number of ticks of the period clock for time capture
 * for velocity measurement. This should be called in profile 1<BR>
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Ticks Number of ticks for which time to be captured<BR>
 *
 * <b>can be used with: Profile1 only</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED or the selected profile is not profile1<BR><BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
  * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Ticks;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetNumTicks4TimCap(&POSQE001_Handle0, &Ticks);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetNumTicks4TimCap
(
    const POSQE001_HandleType* HandlePtr,
    uint16_t* Ticks
);

/**
 * @brief This function will modify the number of ticks of the period clock for time
 * capture for velocity measurement.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[in] Ticks Number of ticks for which time to be captured<BR>
 *
 * <b>can be used with: Profile1 only</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State or the selected profile is not profile1<BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t Ticks = 10;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_SetNumTicks4TimCap(&POSQE001_Handle0, Ticks);
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetNumTicks4TimCap
(
    const POSQE001_HandleType* HandlePtr,
    uint16_t Ticks
);


/**
 * @brief This function will enable the event. This should be called by the user.
 *
 *
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [in] SliceType The Slice for which the event is to be enabled<BR>
 * @param [in] Event Event to be enabled <BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <b>Reentrancy:  Yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 * int main(void)
 * {
 *    status_t Status;
 *    DAVE_Init();
 *    Status = POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);
 *    Status = POSQE001_Start(&POSQE001_Handle0);
      return 0;
 * }
 * @endcode
 */
status_t POSQE001_EnableEvent
(
  const POSQE001_HandleType * HandlePtr,
  const POSQE001_CCUSliceType SliceType,
  const POSQE001_EventNameType Event
);

/**
 * @brief This function will disable the event.<BR>
 *
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [in] SliceType The slice for which a particular event is to be disabled
 * @param [in] Event Event to be disabled <BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <b>Reentrancy:  Yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 * int main(void)
 * {
 *    status_t Status;
 *    DAVE_Init();
 *    Status = POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);
 *    Status = POSQE001_Start(&POSQE001_Handle0);
 *   //....
 *    Status = POSQE001_DisableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);
      return 0;
 * }

 * @endcode
 */
status_t POSQE001_DisableEvent
(
    const POSQE001_HandleType * HandlePtr,
    const POSQE001_CCUSliceType SliceType,
    const POSQE001_EventNameType Event
);

/**
 * @brief This function will clear the event by SW.<BR>
 *
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [in] SliceType The slice type for which the event is to be cleared.
 * @param [in] Event Event to be cleared <BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <b>Reentrancy:  Yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 * int main(void)
 * {
 *    status_t Status;
 *    DAVE_Init();
 *    Status = POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);
 *    Status = POSQE001_Start((POSQE001_HandleType*)&POSQE001_Handle0);
 *      return 0;
 * }
 *
void POSQE001_EventHandler(void)
{
  status_t Status;
  //....
 *    Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                        POSQE001_POSITION_COUNTER,
 *                                        POSQE001_CCU_PERIOD_MATCH);


}
 * @endcode
 */
status_t POSQE001_ClearPendingEvent
(
    const POSQE001_HandleType * HandlePtr,
    const POSQE001_CCUSliceType SliceType,
    const POSQE001_EventNameType Event
);

/**
 * @brief This function will set the event.This should not be called within
 * interrupt handler as it will result into infinite loop.<BR>
 *
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [in] SliceType The Slice for which the event is to be set.
 * @param [in] Event Event to be set <BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <b>Reentrancy:  Yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 * int main(void)
 * {
 *    status_t Status;
 *    DAVE_Init();
 *    Status = POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);

 *    Status = POSQE001_Start(&POSQE001_Handle0);
 *    Status = POSQE001_SetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                      POSQE001_POSITION_COUNTER,
 *                                      POSQE001_CCU_PERIOD_MATCH);

      return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetPendingEvent
(
    const POSQE001_HandleType * HandlePtr,
    const POSQE001_CCUSliceType SliceType,
    const POSQE001_EventNameType Event
);

/**
 * @brief This function will check whether given event is set. <BR>
 *
 * @param [in] HandlePtr pointer to the Instance variable<BR>
 * @param [in] SliceType The slice for which the Event is to be checked
 * @param [in] Event Event to Checked Pending <BR>
 * @param [out] EvtStatus Status of the eventwhether it is set <BR>
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <b>Reentrancy:  Yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 * @code
 * #include <DAVE3.h>
 * int main(void)
 * {
 *    status_t Status;
 *    DAVE_Init();
 *    Status = POSQE001_EnableEvent((POSQE001_HandleType*)&POSQE001_Handle0,
 *                                  POSQE001_POSITION_COUNTER,
 *                                  POSQE001_CCU_PERIOD_MATCH);
 *    Status = POSQE001_Start(&POSQE001_Handle0);
      return 0;
 * }
 *
 void POSQE001_EventHandler(void)
{
  status_t Status;
  uint8_t EvtStatus;
  Status = POSQE001_GetPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,
                                 POSQE001_POSITION_COUNTER,
                                 POSQE001_CCU_PERIOD_MATCH,
                                 &EvtStatus);
  if(EvtStatus == (uint8_t) SET)
  {
    //Do something
  }
  Status = POSQE001_ClearPendingEvent((POSQE001_HandleType*)&POSQE001_Handle0,
                                 POSQE001_POSITION_COUNTER,
                                 POSQE001_CCU_PERIOD_MATCH);
}
 * @endcode
 */
status_t POSQE001_GetPendingEvent
(
  const POSQE001_HandleType * HandlePtr,
  const POSQE001_CCUSliceType SliceType,
  const POSQE001_EventNameType Event,
  uint8_t* EvtStatus
);

/**
 * @brief This function will set the Low Speed Limit in Profile 1.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Speed The Low Speed Limit in RPM <BR>
 *
 * <b>can be used with: If Low Speed limit is possible based on UI</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.Or the low speed limit is not possible<BR>
 * POSQE001_INVALID_PARAM: If parameter passed is invalid.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float LowSpeed;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetLowSpeedLimit(&POSQE001_Handle0, LowSpeed);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetLowSpeedLimit
(
  const POSQE001_HandleType * HandlePtr,
  float Speed
);

/**
 * @brief This function will get the Low Speed Limit in Profile 1.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Speed The Low Speed Limit in RPM <BR>
 *
 * <b>can be used with: If Low Speed limit is possible based on UI</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State or Low Speed limit is not possible based on
 * UI configuration.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float LowSpeed;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetLowSpeedLimit(&POSQE001_Handle0, &LowSpeed);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetLowSpeedLimit
(
  const POSQE001_HandleType * HandlePtr,
  float* Speed
);

/**
 * @brief This function will set the High Speed Limit in Profile 1.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Speed The High Speed Limit in RPM <BR>
 *
 * <b>can be used with: If High Speed limit is possible based on UI</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.or the High speed limit is not possible<BR>
 * POSQE001_INVALID_PARAM: If parameter passed is invalid.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float HighSpeed;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetHighSpeedLimit(&POSQE001_Handle0, HighSpeed);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetHighSpeedLimit
(
  const POSQE001_HandleType * HandlePtr,
  float Speed
);

/**
 * @brief This function will get the High Speed Limit in Profile 1.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] Speed The High Speed Limit in RPM <BR>
 *
 * <b>can be used with: If High Speed limit is possible based on UI</b><BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State or the High speed limit is not possible.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  float HighSpeed;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetHighSpeedLimit(&POSQE001_Handle0, &HighSpeed);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetHighSpeedLimit
(
  const POSQE001_HandleType * HandlePtr,
  float* Speed
);

/**
 * @brief This function will set the compare value for the Position Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] CompareMatch The Comapre Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t CompareMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetPeriodCounterCM(&POSQE001_Handle0, CompareMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetPeriodCounterCM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t CompareMatch

);

/**
 * @brief This function will get the compare value for the Position Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] CompareMatch The Compare Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t CompareMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetPeriodCounterCM(&POSQE001_Handle0, &CompareMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetPeriodCounterCM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t* CompareMatch

);

/**
 * @brief This function will set the period value for the Position Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] PeriodMatch The Period Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t PeriodMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetPeriodCounterPM(&POSQE001_Handle0, PeriodMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */

status_t POSQE001_SetPeriodCounterPM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t PeriodMatch
);

/**
 * @brief This function will get the period value for the Position Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] PeriodMatch The Period Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t PeriodMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetPeriodCounterPM(&POSQE001_Handle0, PeriodMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetPeriodCounterPM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t* PeriodMatch

);

/**
 * @brief This function will set the compare value for the Revolution Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] CompareMatch The Compare Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State. If the revolution counter is not used.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t CompareMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetRevCounterCM(&POSQE001_Handle0, CompareMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */

status_t POSQE001_SetRevCounterCM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t CompareMatch
);

/**
 * @brief This function will get the compare value for the Revolution Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] CompareMatch The Compare Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State. If the revolution counter is not used.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t CompareMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetRevCounterCM(&POSQE001_Handle0, CompareMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetRevCounterCM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t* CompareMatch
);

/**
 * @brief This function will set the period value for the Revolution Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] PeriodMatch The Period Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State. If the revolution counter is not used.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t PeriodMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_SetRevCounterPM(&POSQE001_Handle0, PeriodMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_SetRevCounterPM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t PeriodMatch
);

/**
 * @brief This function will get the period value for the Revolution Counter.
 * @param[in] HandlePtr pointer to the Instance variable<BR>
 * @param[out] PeriodMatch The Period Match Value<BR>
 *
 * @return status_t<BR>
 * DAVEApp_SUCCESS: if the function is successful<BR>
 * POSQE001_OPER_NOT_ALLOWED_ERROR: If the function is called when in
 * POSQE001_UNINITIALIZED State. If the revolution counter is not used.<BR>
 *
 * <BR>
 *
 * <b>Reentrant: yes</b><BR>
 * <b>Sync/Async:  Synchronous</b><BR>
 *
 * @code
 * #include <DAVE3.h>
 *
 * int main(void)
 * {
 *  status_t Status;
 *  uint16_t PeriodMatch;
 *  DAVE_Init(); //POSQE001_Init is called within DAVE_Init()
 *  Status = POSQE001_Start(&POSQE001_Handle0);
 *  Status = POSQE001_GetRevCounterPM(&POSQE001_Handle0, &PeriodMatch);
 *  while(1)
 *  {
 *
 *  }
 *  return 0;
 * }
 * @endcode
 */
status_t POSQE001_GetRevCounterPM
(
  const POSQE001_HandleType * HandlePtr,
  uint16_t* PeriodMatch
);


#include "POSQE001_Conf.h"

/**
 * @}
 */

#ifdef __cplusplus
}
#endif

#endif /* POSQE001_H_ */

/*CODE_BLOCK_END*/
