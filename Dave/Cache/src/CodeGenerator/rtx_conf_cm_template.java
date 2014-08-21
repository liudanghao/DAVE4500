package CodeGenerator;

import java.util.*;
import com.ifx.davex.appjetinteract.App2JetInterface;

public class rtx_conf_cm_template
{
  protected static String nl;
  public static synchronized rtx_conf_cm_template create(String lineSeparator)
  {
    nl = lineSeparator;
    rtx_conf_cm_template result = new rtx_conf_cm_template();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/*----------------------------------------------------------------------------" + NL + " *      RL-ARM - RTX" + NL + " *----------------------------------------------------------------------------" + NL + " *      Name:    RTX_Conf_CM.C" + NL + " *      Purpose: Configuration of CMSIS RTX Kernel for Cortex-M" + NL + " *      Rev.:    V4.74" + NL + " *----------------------------------------------------------------------------" + NL + " *" + NL + " * Copyright (c) 1999-2009 KEIL, 2009-2013 ARM Germany GmbH" + NL + " * All rights reserved." + NL + " * Redistribution and use in source and binary forms, with or without" + NL + " * modification, are permitted provided that the following conditions are met:" + NL + " *  - Redistributions of source code must retain the above copyright" + NL + " *    notice, this list of conditions and the following disclaimer." + NL + " *  - Redistributions in binary form must reproduce the above copyright" + NL + " *    notice, this list of conditions and the following disclaimer in the" + NL + " *    documentation and/or other materials provided with the distribution." + NL + " *  - Neither the name of ARM  nor the names of its contributors may be used " + NL + " *    to endorse or promote products derived from this software without " + NL + " *    specific prior written permission." + NL + " *" + NL + " * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" " + NL + " * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE " + NL + " * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE" + NL + " * ARE DISCLAIMED. IN NO EVENT SHALL COPYRIGHT HOLDERS AND CONTRIBUTORS BE" + NL + " * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR" + NL + " * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF " + NL + " * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS " + NL + " * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN " + NL + " * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) " + NL + " * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE" + NL + " * POSSIBILITY OF SUCH DAMAGE." + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "#include \"INC/cmsis_os.h\"" + NL + "" + NL + "" + NL + "/*----------------------------------------------------------------------------" + NL + " *      RTX User configuration part BEGIN" + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "//-------- <<< Use Configuration Wizard in Context Menu >>> -----------------" + NL + "//" + NL + "// <h>Thread Configuration" + NL + "// =======================" + NL + "//" + NL + "//   <o>Number of concurrent running user threads <1-250>" + NL + "//   <i> Defines max. number of user threads that will run at the same time." + NL + "//   <i> Default: 6" + NL + "#ifndef OS_TASKCNT" + NL + " #define OS_TASKCNT     ";
  protected final String TEXT_2 = NL + "#endif" + NL + "" + NL + "//   <o>Default Thread stack size [bytes] <64-4096:8><#/4>" + NL + "//   <i> Defines default stack size for threads with osThreadDef stacksz = 0" + NL + "//   <i> Default: 200" + NL + "#ifndef OS_STKSIZE" + NL + " #define OS_STKSIZE     ";
  protected final String TEXT_3 = NL + "#endif" + NL + "" + NL + "//   <o>Main Thread stack size [bytes] <64-32768:8><#/4>" + NL + "//   <i> Defines stack size for main thread." + NL + "//   <i> Default: 200" + NL + "#ifndef OS_MAINSTKSIZE" + NL + " #define OS_MAINSTKSIZE 0" + NL + "#endif" + NL + "" + NL + "//   <o>Number of threads with user-provided stack size <0-250>" + NL + "//   <i> Defines the number of threads with user-provided stack size." + NL + "//   <i> Default: 0" + NL + "#ifndef OS_PRIVCNT" + NL + " #define OS_PRIVCNT     ";
  protected final String TEXT_4 = NL + "#endif" + NL + "" + NL + "//   <o>Total stack size [bytes] for threads with user-provided stack size <0-1048576:8><#/4>" + NL + "//   <i> Defines the combined stack size for threads with user-provided stack size." + NL + "//   <i> Default: 0" + NL + "#ifndef OS_PRIVSTKSIZE" + NL + " #define OS_PRIVSTKSIZE ";
  protected final String TEXT_5 = NL + "#endif" + NL + "" + NL + "//   <q>Check for stack overflow" + NL + "//   <i> Includes the stack checking code for stack overflow." + NL + "//   <i> Note that additional code reduces the Kernel performance." + NL + "#ifndef OS_STKCHECK" + NL + " #define OS_STKCHECK    ";
  protected final String TEXT_6 = NL + "#endif" + NL + "" + NL + "//   <o>Processor mode for thread execution " + NL + "//     <0=> Unprivileged mode " + NL + "//     <1=> Privileged mode" + NL + "//   <i> Default: Privileged mode" + NL + "#ifndef OS_RUNPRIV";
  protected final String TEXT_7 = NL + " #define OS_RUNPRIV     0";
  protected final String TEXT_8 = NL + " #define OS_RUNPRIV     1";
  protected final String TEXT_9 = NL + "#endif" + NL + "" + NL + "// </h>" + NL + "" + NL + "// <h>RTX Kernel Timer Tick Configuration" + NL + "// ======================================" + NL + "//   <q> Use Cortex-M SysTick timer as RTX Kernel Timer" + NL + "//   <i> Cortex-M processors provide in most cases a SysTick timer that can be used as " + NL + "//   <i> as time-base for RTX." + NL + "#ifndef OS_SYSTICK" + NL + " #define OS_SYSTICK     ";
  protected final String TEXT_10 = NL + "#endif" + NL + "//" + NL + "//   <o>RTOS Kernel Timer input clock frequency [Hz] <1-1000000000>" + NL + "//   <i> Defines the input frequency of the RTOS Kernel Timer.  " + NL + "//   <i> When the Cortex-M SysTick timer is used, the input clock " + NL + "//   <i> is on most systems identical with the core clock." + NL + "#ifndef OS_CLOCK" + NL + " #define OS_CLOCK       ";
  protected final String TEXT_11 = NL + "#endif" + NL + "" + NL + "//   <o>RTX Timer tick interval value [us] <1-1000000>" + NL + "//   <i> The RTX Timer tick interval value is used to calculate timeout values." + NL + "//   <i> When the Cortex-M SysTick timer is enabled, the value also configures the SysTick timer." + NL + "//   <i> Default: 1000  (1ms)" + NL + "#ifndef OS_TICK" + NL + " #define OS_TICK        ";
  protected final String TEXT_12 = NL + "#endif" + NL + "" + NL + "// </h>" + NL + "" + NL + "// <h>System Configuration" + NL + "// =======================" + NL + "//" + NL + "// <e>Round-Robin Thread switching" + NL + "// ===============================" + NL + "//" + NL + "// <i> Enables Round-Robin Thread switching." + NL + "#ifndef OS_ROBIN" + NL + " #define OS_ROBIN       ";
  protected final String TEXT_13 = NL + "#endif" + NL + "" + NL + "//   <o>Round-Robin Timeout [ticks] <1-1000>" + NL + "//   <i> Defines how long a thread will execute before a thread switch." + NL + "//   <i> Default: 5" + NL + "#ifndef OS_ROBINTOUT" + NL + " #define OS_ROBINTOUT   ";
  protected final String TEXT_14 = NL + "#endif" + NL + "" + NL + "// </e>" + NL + "" + NL + "// <e>User Timers" + NL + "// ==============" + NL + "//   <i> Enables user Timers" + NL + "#ifndef OS_TIMERS" + NL + " #define OS_TIMERS      ";
  protected final String TEXT_15 = NL + "#endif" + NL + "" + NL + "//   <o>Timer Thread Priority" + NL + "//                        <1=> Low" + NL + "//     <2=> Below Normal  <3=> Normal  <4=> Above Normal" + NL + "//                        <5=> High" + NL + "//                        <6=> Realtime (highest)" + NL + "//   <i> Defines priority for Timer Thread" + NL + "//   <i> Default: High" + NL + "#ifndef OS_TIMERPRIO" + NL + " #define OS_TIMERPRIO   ";
  protected final String TEXT_16 = NL + "#endif" + NL + "" + NL + "//   <o>Timer Thread stack size [bytes] <64-4096:8><#/4>" + NL + "//   <i> Defines stack size for Timer thread." + NL + "//   <i> Default: 200" + NL + "#ifndef OS_TIMERSTKSZ" + NL + " #define OS_TIMERSTKSZ  ";
  protected final String TEXT_17 = NL + "#endif" + NL + "" + NL + "//   <o>Timer Callback Queue size <1-32>" + NL + "//   <i> Number of concurrent active timer callback functions." + NL + "//   <i> Default: 4" + NL + "#ifndef OS_TIMERCBQS" + NL + " #define OS_TIMERCBQS   ";
  protected final String TEXT_18 = NL + "#endif" + NL + "" + NL + "// </e>" + NL + "" + NL + "//   <o>ISR FIFO Queue size<4=>   4 entries  <8=>   8 entries" + NL + "//                         <12=> 12 entries  <16=> 16 entries" + NL + "//                         <24=> 24 entries  <32=> 32 entries" + NL + "//                         <48=> 48 entries  <64=> 64 entries" + NL + "//                         <96=> 96 entries" + NL + "//   <i> ISR functions store requests to this buffer," + NL + "//   <i> when they are called from the interrupt handler." + NL + "//   <i> Default: 16 entries" + NL + "#ifndef OS_FIFOSZ" + NL + " #define OS_FIFOSZ      ";
  protected final String TEXT_19 = NL + "#endif" + NL + "" + NL + "// </h>" + NL + "" + NL + "//------------- <<< end of configuration section >>> -----------------------" + NL + "" + NL + "// Standard library system mutexes" + NL + "// ===============================" + NL + "//  Define max. number system mutexes that are used to protect " + NL + "//  the arm standard runtime library. For microlib they are not used." + NL + "#ifndef OS_MUTEXCNT" + NL + " #define OS_MUTEXCNT    8" + NL + "#endif" + NL + "" + NL + "/*----------------------------------------------------------------------------" + NL + " *      RTX User configuration part END" + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "#define OS_TRV          ((uint32_t)(((double)OS_CLOCK*(double)OS_TICK)/1E6)-1)" + NL + "" + NL + "" + NL + "/*----------------------------------------------------------------------------" + NL + " *      Global Functions" + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "/*--------------------------- os_idle_demon ---------------------------------*/";
  protected final String TEXT_20 = NL + "void os_idle_demon (void) {" + NL + "  /* The idle demon is a system thread, running when no other thread is      */" + NL + "  /* ready to run.                                                           */" + NL + "" + NL + "  for (;;) {" + NL + "    /* HERE: include optional user code to be executed when no thread runs.*/" + NL + "  }" + NL + "}";
  protected final String TEXT_21 = NL + NL + "#if (OS_TIMERS == 0)" + NL + "void os_tmr_call(uint16_t info) {" + NL + "   switch (info) {" + NL + "      case 1:                 /* Signal that first timer has expired.        */" + NL + "                              /* Supervised task is locked, do some actions. */" + NL + "               break;" + NL + "      case 2:                 /* Second task is locked. Do some actions.     */" + NL + "" + NL + "               break;" + NL + "   }" + NL + "}" + NL + "#endif" + NL + "" + NL + "#if (OS_SYSTICK == 0)   // Functions for alternative timer as RTX kernel timer" + NL + "" + NL + "/*--------------------------- os_tick_init ----------------------------------*/" + NL + "" + NL + "// Initialize alternative hardware timer as RTX kernel timer" + NL + "// Return: IRQ number of the alternative hardware timer" + NL + "int os_tick_init (void) {" + NL + "  return (-1);  /* Return IRQ number of timer (0..239) */" + NL + "}" + NL + "" + NL + "/*--------------------------- os_tick_val -----------------------------------*/" + NL + "" + NL + "// Get alternative hardware timer current value (0 .. OS_TRV)" + NL + "uint32_t os_tick_val (void) {" + NL + "  return (0);" + NL + "}" + NL + "" + NL + "/*--------------------------- os_tick_ovf -----------------------------------*/" + NL + "" + NL + "// Get alternative hardware timer overflow flag" + NL + "// Return: 1 - overflow, 0 - no overflow" + NL + "uint32_t os_tick_ovf (void) {" + NL + "  return (0);" + NL + "}" + NL + "" + NL + "/*--------------------------- os_tick_irqack --------------------------------*/" + NL + "" + NL + "// Acknowledge alternative hardware timer interrupt" + NL + "void os_tick_irqack (void) {" + NL + "  /* ... */" + NL + "}" + NL + "" + NL + "#endif   // (OS_SYSTICK == 0)" + NL + "" + NL + "/*--------------------------- os_error --------------------------------------*/" + NL + "" + NL + "/* OS Error Codes */" + NL + "#define OS_ERROR_STACK_OVF      1" + NL + "#define OS_ERROR_FIFO_OVF       2" + NL + "#define OS_ERROR_MBX_OVF        3" + NL + "" + NL + "extern osThreadId svcThreadGetId (void);" + NL;
  protected final String TEXT_22 = NL + "void os_error (uint32_t error_code) {" + NL + "  /* This function is called when a runtime error is detected.  */" + NL + "  /* Parameter 'error_code' holds the runtime error code.       */" + NL + "" + NL + "  /* HERE: include optional code to be executed on runtime error. */" + NL + "  switch (error_code) {" + NL + "    case OS_ERROR_STACK_OVF:" + NL + "      /* Stack overflow detected for the currently running task. */" + NL + "      /* Thread can be identified by calling svcThreadGetId().   */" + NL + "      break;" + NL + "    case OS_ERROR_FIFO_OVF:" + NL + "      /* ISR FIFO Queue buffer overflow detected. */" + NL + "      break;" + NL + "    case OS_ERROR_MBX_OVF:" + NL + "      /* Mailbox overflow detected. */" + NL + "      break;" + NL + "  }" + NL + "  for (;;);" + NL + "}";
  protected final String TEXT_23 = NL + NL + "/*----------------------------------------------------------------------------" + NL + " *      RTX Configuration Functions" + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "#include \"INC/RTX_CM_lib.h\"" + NL + "" + NL + "/*----------------------------------------------------------------------------" + NL + " * end of file" + NL + " *---------------------------------------------------------------------------*/" + NL;
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     App2JetInterface app = (App2JetInterface) argument; 
     
   int Timer_Priority = -1;
   if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/1") == 1)
   {
     Timer_Priority = 1;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/2") == 1)
   {
     Timer_Priority = 2;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/3") == 1)
   {
     Timer_Priority = 3;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/4") == 1)
   {
     Timer_Priority = 4;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/5") == 1)
   {
     Timer_Priority = 5;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_erwtimerprio/6") == 1)
   {
     Timer_Priority = 6;
   }

    
   int FIFOSZ = -1;
   if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/4") == 1)
   {
     FIFOSZ = 4;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/8") == 1)
   {
     FIFOSZ = 8;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/12") == 1)
   {
     FIFOSZ = 12;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/16") == 1)
   {
     FIFOSZ = 16;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/24") == 1)
   {
     FIFOSZ = 24;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/32") == 1)
   {
     FIFOSZ = 32;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/48") == 1)
   {
     FIFOSZ = 48;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/64") == 1)
   {
     FIFOSZ = 64;
   }
   else if (app.getIntegerValue("app/rtos001/0/rtos001_irwfifosz/96") == 1)
   {
     FIFOSZ = 96;
   }
 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwtaskcnt") + 1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwstksize") / 4);
    stringBuffer.append(TEXT_3);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwpricnt"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwprivstksize") / 4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_erwstkcheck/0"));
    stringBuffer.append(TEXT_6);
     if (app.getIntegerValue("app/rtos001/0/rtos001_erwrprivmode/0") == 1) {
    stringBuffer.append(TEXT_7);
     } 
     else if (app.getIntegerValue("app/rtos001/0/rtos001_erwrprivmode/1") == 1) {
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_erwkerneltimer/0"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwclock"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwtick"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_erwrndrobin/0"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwrobintout"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_erwtimers/0"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append( Timer_Priority);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwtimerstksize") / 4);
    stringBuffer.append(TEXT_17);
    stringBuffer.append( app.getIntegerValue("app/rtos001/0/rtos001_irwtimercbqsize"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append( FIFOSZ);
    stringBuffer.append(TEXT_19);
    if (app.getIntegerValue("app/rtos001/0/rtos001_idledemon/0") == 0) {
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    if (app.getIntegerValue("app/rtos001/0/rtos001_oserror/0") == 0) { 
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
