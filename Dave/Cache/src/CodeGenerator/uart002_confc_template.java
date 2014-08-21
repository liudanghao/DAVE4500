package CodeGenerator;

import java.util.*;
import com.ifx.davex.appjetinteract.App2JetInterface;

public class uart002_confc_template
{
  protected static String nl;
  public static synchronized uart002_confc_template create(String lineSeparator)
  {
    nl = lineSeparator;
    uart002_confc_template result = new uart002_confc_template();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*CODE_BLOCK_BEGIN[UART002_Conf.c]*/" + NL + "" + NL + "/*******************************************************************************" + NL + " Copyright (c) 2013, Infineon Technologies AG                                 **" + NL + " All rights reserved.                                                         **" + NL + "                                                                              **" + NL + " Redistribution and use in source and binary forms, with or without           **" + NL + " modification,are permitted provided that the following conditions are met:   **" + NL + "                                                                              **" + NL + " *Redistributions of source code must retain the above copyright notice,      **" + NL + " this list of conditions and the following disclaimer.                        **" + NL + " *Redistributions in binary form must reproduce the above copyright notice,   **" + NL + " this list of conditions and the following disclaimer in the documentation    **" + NL + " and/or other materials provided with the distribution.                       **" + NL + " *Neither the name of the copyright holders nor the names of its contributors **" + NL + " may be used to endorse or promote products derived from this software without** " + NL + " specific prior written permission.                                           **" + NL + "                                                                              **" + NL + " THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\"  **" + NL + " AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE    **" + NL + " IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE   **" + NL + " ARE  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE   **" + NL + " LIABLE  FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR         **" + NL + " CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF         **" + NL + " SUBSTITUTE GOODS OR  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS    **" + NL + " INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN      **" + NL + " CONTRACT, STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)       **" + NL + " ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE   **" + NL + " POSSIBILITY OF SUCH DAMAGE.                                                  **" + NL + "                                                                              **" + NL + " To improve the quality of the software, users are encouraged to share        **" + NL + " modifications, enhancements or bug fixes with Infineon Technologies AG       **" + NL + " dave@infineon.com).                                                          **" + NL + "                                                                              **" + NL + "********************************************************************************" + NL + "**                                                                            **" + NL + "**                                                                            **" + NL + "** PLATFORM : Infineon XMC4000/XMC1000 Series   \t\t\t                  **" + NL + "**                                                                            **" + NL + "** COMPILER : Compiler Independent                                            **" + NL + "**                                                                            **" + NL + "** AUTHOR   : App Developer                                                   **" + NL + "**                                                                            **" + NL + "** MAY BE CHANGED BY USER [yes/no]: Yes                                       **" + NL + "**                                                                            **" + NL + "**                                                                            **" + NL + "*******************************************************************************/" + NL + "/*" + NL + " * Revision History" + NL + " * " + NL + " * 17 Apr 2013 v1.0.8   1. Modified the structure UART002_HandleType to add baud" + NL + " *                         parameters for the baud rate." + NL + " *                      2. DMA mode handling is disabled for XMC1000 devices " + NL + " *                          as DMA module is not available in XMC1000 devices.     " + NL + " */" + NL + "/**" + NL + " * @file   UART002_Conf.c" + NL + " *" + NL + " * @App    Version UART002 <";
  protected final String TEXT_2 = ">" + NL + " * " + NL + " * @brief  Configuration file generated based on UI settings " + NL + " *         of UART002 App" + NL + " *" + NL + " */" + NL + "/*******************************************************************************" + NL + " ** INCLUDE FILES                                                             **" + NL + " ******************************************************************************/" + NL + "#include <DAVE3.h>";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "UART002_DynamicDataType AppDynamicData";
  protected final String TEXT_6 = "; " + NL + "const UART002_HandleType UART002_Handle";
  protected final String TEXT_7 = "  = " + NL + "{";
  protected final String TEXT_8 = " ";
  protected final String TEXT_9 = NL + "   .TxDMAHandle = &DMA003_Handle";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = " ";
  protected final String TEXT_12 = NL + "   .RxDMAHandle = &DMA003_Handle";
  protected final String TEXT_13 = ",";
  protected final String TEXT_14 = " ";
  protected final String TEXT_15 = NL + "   .DynamicData = &AppDynamicData";
  protected final String TEXT_16 = "," + NL + "   .UartRegs = USIC";
  protected final String TEXT_17 = "_CH";
  protected final String TEXT_18 = ", /* Usic Channel offset value */" + NL + "   .Mode = (UART_ModeType)";
  protected final String TEXT_19 = ",";
  protected final String TEXT_20 = "   " + NL + "   .DMAMode = (UART002_DMAType)";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = NL + "   .ChConfig = {" + NL + "\t\t       (UART_ParityType)";
  protected final String TEXT_23 = ",/* Parity */" + NL + "\t\t       (UART_StopBitType)";
  protected final String TEXT_24 = ",/* StopBit */";
  protected final String TEXT_25 = NL + "               ";
  protected final String TEXT_26 = ",/*Baud Rate */";
  protected final String TEXT_27 = NL + "               ";
  protected final String TEXT_28 = "/* Word Length */" + NL + "   \t\t\t\t}," + NL + "   .RxFIFOTrigger = ";
  protected final String TEXT_29 = ",/* FIFO Tigger Level */" + NL + "   .TxFIFOTrigger = ";
  protected final String TEXT_30 = ",/* FIFO Tigger Level */" + NL + "   .BGR_STEP = (uint16_t)";
  protected final String TEXT_31 = ",  /* Baud Rate Generation step value */" + NL + "   .BGR_PDIV = (uint16_t)";
  protected final String TEXT_32 = ",   /* Baud Rate Generation  pdiv value */" + NL + "   .BGR_DCTQ = (uint16_t)";
  protected final String TEXT_33 = ", /* Baud Rate Generation dctq value */";
  protected final String TEXT_34 = "   " + NL + "   .BGR_SP = (uint16_t)";
  protected final String TEXT_35 = ", /* Baud Rate Generation sampling point */" + NL + "   .BGR_PCTQ = (uint8_t)0  /* Baud Rate Generation pctq value */   " + NL + "};";
  protected final String TEXT_36 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = NL + NL + "/*CODE_BLOCK_END*/" + NL;
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     App2JetInterface app = (App2JetInterface) argument; 
     String AppBaseuri = "app/uart002/";
    stringBuffer.append(TEXT_1);
    stringBuffer.append( app.getAppVersion(AppBaseuri));
    stringBuffer.append(TEXT_2);
     int Is1xDevice = -1; 
     Is1xDevice = ((app.getSoftwareId().substring(0,1).compareTo("1")==0)?1:0); 
    stringBuffer.append(TEXT_3);
     String Uarturi = "peripheral/usic/"; 
     String MappedUri = null; 
     String MappedUri2 = null; 
     String MappedUri3 = null; 
     String DMAInst1 = null; 
     String DMAInst2 = null; 
     String UnitInst = null; 
     String ChannelInst = null; 
     int mode= 0; 
     String appInst  = null; 
    stringBuffer.append(TEXT_4);
     ArrayList<String> appsList = (ArrayList<String>)(app.getApps("app/uart002/"));
 for (String appIns : appsList ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(AppBaseuri + appInst + "/channel"); 
     if((MappedUri != null) && (MappedUri != "")) { 
     UnitInst = MappedUri.substring(MappedUri .length()-11,MappedUri.indexOf("/channel/")); 
     ChannelInst = MappedUri.substring(MappedUri.length()-1); 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_7);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_8);
     int DmaMode = app.getIntegerValue(AppBaseuri + appInst +"/uart002_DMAOprModeTemp");
    if((DmaMode == 2) || (DmaMode == 3)) {
     MappedUri2 = app.getMappedUri(AppBaseuri + appInst + "/DMAapp0"); 
     DMAInst1 = MappedUri2.substring(MappedUri2.length()-1); 
    stringBuffer.append(TEXT_9);
    stringBuffer.append( DMAInst1 );
    stringBuffer.append(TEXT_10);
    }
    if((DmaMode == 1) || (DmaMode == 3)) {
    stringBuffer.append(TEXT_11);
     MappedUri3 = app.getMappedUri(AppBaseuri + appInst + "/DMAapp1"); 
     DMAInst2 = MappedUri3.substring(MappedUri3.length()-1); 
    stringBuffer.append(TEXT_12);
    stringBuffer.append( DMAInst2 );
    stringBuffer.append(TEXT_13);
    } 
    stringBuffer.append(TEXT_14);
    } 
    stringBuffer.append(TEXT_15);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_16);
    stringBuffer.append( UnitInst );
    stringBuffer.append(TEXT_17);
    stringBuffer.append( ChannelInst );
    stringBuffer.append(TEXT_18);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/uart002_OprModeTemp") );
    stringBuffer.append(TEXT_19);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_20);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/uart002_DMAOprModeTemp") );
    stringBuffer.append(TEXT_21);
    } 
    stringBuffer.append(TEXT_22);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/channel/ccr/pm") );
    stringBuffer.append(TEXT_23);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/channel/pcr/stpb") );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/uart002_irwbaudrate") );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/channel/sctr/wle") );
    stringBuffer.append(TEXT_28);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/channel/rbctr/limit") );
    stringBuffer.append(TEXT_29);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst +"/channel/tbctr/limit") );
    stringBuffer.append(TEXT_30);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst + "/uart002_stepvalue"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst + "/uart002_pdivvalue"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append( app.getIntegerValue(AppBaseuri + appInst + "/Time_Quanta_dummylevel") );
    stringBuffer.append(TEXT_33);
    	double sampling_point = 0.0;
 	long sampling_point1 = 0;
 	int dctq = (app.getIntegerValue(AppBaseuri + appInst + "/Time_Quanta_dummylevel")); 	    
   sampling_point = (((1 + dctq) / 2)  +  1);   
   sampling_point1 = Math.round(sampling_point); 			
 
    stringBuffer.append(TEXT_34);
    stringBuffer.append( sampling_point1);
    stringBuffer.append(TEXT_35);
     } 
     else { 
    stringBuffer.append(TEXT_36);
     } 
    stringBuffer.append(TEXT_37);
    } 
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
