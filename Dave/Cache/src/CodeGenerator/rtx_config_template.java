package CodeGenerator;

import java.util.*;
import com.ifx.davex.appjetinteract.App2JetInterface;

public class rtx_config_template
{
  protected static String nl;
  public static synchronized rtx_config_template create(String lineSeparator)
  {
    nl = lineSeparator;
    rtx_config_template result = new rtx_config_template();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*----------------------------------------------------------------------------" + NL + " *      RL-ARM - RTX" + NL + " *----------------------------------------------------------------------------" + NL + " *      Name:    RTX_CONFIG.H" + NL + " *      Purpose: Exported functions of RTX_Config.c" + NL + " *      Rev.:    V4.70" + NL + " *----------------------------------------------------------------------------" + NL + " *" + NL + " * Copyright (c) 1999-2009 KEIL, 2009-2013 ARM Germany GmbH" + NL + " * All rights reserved." + NL + " * Redistribution and use in source and binary forms, with or without" + NL + " * modification, are permitted provided that the following conditions are met:" + NL + " *  - Redistributions of source code must retain the above copyright" + NL + " *    notice, this list of conditions and the following disclaimer." + NL + " *  - Redistributions in binary form must reproduce the above copyright" + NL + " *    notice, this list of conditions and the following disclaimer in the" + NL + " *    documentation and/or other materials provided with the distribution." + NL + " *  - Neither the name of ARM  nor the names of its contributors may be used " + NL + " *    to endorse or promote products derived from this software without " + NL + " *    specific prior written permission." + NL + " *" + NL + " * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" " + NL + " * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE " + NL + " * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE" + NL + " * ARE DISCLAIMED. IN NO EVENT SHALL COPYRIGHT HOLDERS AND CONTRIBUTORS BE" + NL + " * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR" + NL + " * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF " + NL + " * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS " + NL + " * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN " + NL + " * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) " + NL + " * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE" + NL + " * POSSIBILITY OF SUCH DAMAGE." + NL + " *---------------------------------------------------------------------------*/" + NL + "" + NL + "#ifndef __CMSIS_RTOS" + NL + "#define __CMSIS_RTOS" + NL + "#endif" + NL;
  protected final String TEXT_2 = NL + "#ifndef __CORTEX_M4F" + NL + "#define __CORTEX_M4F" + NL + "#endif";
  protected final String TEXT_3 = NL + "#ifndef __CORTEX_M0" + NL + "#define __CORTEX_M0" + NL + "#endif";
  protected final String TEXT_4 = NL + NL + "/* Error Codes */" + NL + "#define OS_ERR_STK_OVF          1" + NL + "#define OS_ERR_FIFO_OVF         2" + NL + "#define OS_ERR_MBX_OVF          3" + NL + "" + NL + "/* Definitions */" + NL + "#define BOX_ALIGN_8                   0x80000000" + NL + "#define _declare_box(pool,size,cnt)   U32 pool[(((size)+3)/4)*(cnt) + 3]" + NL + "#define _declare_box8(pool,size,cnt)  U64 pool[(((size)+7)/8)*(cnt) + 2]" + NL + "#define _init_box8(pool,size,bsize)   _init_box (pool,size,(bsize) | BOX_ALIGN_8)" + NL + "" + NL + "/* Variables */" + NL + "extern U32 mp_tcb[];" + NL + "extern U64 mp_stk[];" + NL + "extern U32 os_fifo[];" + NL + "extern void *os_active_TCB[];" + NL + "" + NL + "/* Constants */" + NL + "extern U16 const os_maxtaskrun;" + NL + "extern U32 const os_trv;" + NL + "extern U8  const os_flags;" + NL + "extern U32 const os_stackinfo;" + NL + "extern U32 const os_rrobin;" + NL + "extern U32 const os_clockrate;" + NL + "extern U32 const os_timernum;" + NL + "extern U16 const mp_tcb_size;" + NL + "extern U32 const mp_stk_size;" + NL + "extern U32 const *m_tmr;" + NL + "extern U16 const mp_tmr_size;" + NL + "extern U8  const os_fifo_size;" + NL + "" + NL + "/* Functions */" + NL + "extern void os_idle_demon   (void);" + NL + "extern int  os_tick_init    (void);" + NL + "extern U32  os_tick_val     (void);" + NL + "extern U32  os_tick_ovf     (void);" + NL + "extern void os_tick_irqack  (void);" + NL + "extern void os_tmr_call     (U16  info);" + NL + "extern void os_error        (U32 err_code);" + NL + "" + NL + "/*----------------------------------------------------------------------------" + NL + " * end of file" + NL + " *---------------------------------------------------------------------------*/";
  protected final String TEXT_5 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     App2JetInterface app = (App2JetInterface) argument; 
    stringBuffer.append(TEXT_1);
     if (app.getSoftwareId().substring(0,1).compareTo("4") == 0) { 
    stringBuffer.append(TEXT_2);
     } 
     else if (app.getSoftwareId().substring(0,1).compareTo("1") == 0) { 
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
