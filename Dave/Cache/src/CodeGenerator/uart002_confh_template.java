package CodeGenerator;

import java.util.*;
import com.ifx.davex.appjetinteract.App2JetInterface;

public class uart002_confh_template
{
  protected static String nl;
  public static synchronized uart002_confh_template create(String lineSeparator)
  {
    nl = lineSeparator;
    uart002_confh_template result = new uart002_confh_template();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/*CODE_BLOCK_BEGIN[UART002_Conf.h]*/" + NL + "/******************************************************************************" + NL + " *" + NL + " * Copyright (C) 2011 Infineon Technologies AG. All rights reserved." + NL + " *" + NL + " * Infineon Technologies AG (Infineon) is supplying this software for use with " + NL + " * Infineon's microcontrollers.  " + NL + " * This file can be freely distributed within development tools that are " + NL + " * supporting such microcontrollers. " + NL + " *" + NL + " * THIS SOFTWARE IS PROVIDED \"AS IS\".  NO WARRANTIES, WHETHER EXPRESS, IMPLIED" + NL + " * OR STATUTORY, INCLUDING, BUT NOT LIMITED TO, IMPLIED WARRANTIES OF" + NL + " * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE APPLY TO THIS SOFTWARE." + NL + " * INFINEON SHALL NOT, IN ANY CIRCUMSTANCES, BE LIABLE FOR SPECIAL, INCIDENTAL, " + NL + " * OR CONSEQUENTIAL DAMAGES, FOR ANY REASON WHATSOEVER." + NL + " *" + NL + "********************************************************************************" + NL + "**                                                                            **" + NL + "**                                                                            **" + NL + "** PLATFORM : Infineon XMC4000/XMC1000 Series                                 **" + NL + "**                                                                            **" + NL + "** COMPILER : Compiler Independent                                            **" + NL + "**                                                                            **" + NL + "** AUTHOR   : App Developer                                                   **" + NL + "**                                                                            **" + NL + "** MAY BE CHANGED BY USER [yes/no]: Yes                                       **" + NL + "**                                                                            **" + NL + "**                                                                            **" + NL + "*******************************************************************************/" + NL + "/**" + NL + " * @file   UART002_Conf.h" + NL + " *" + NL + " * @App    Version UART002 <";
  protected final String TEXT_2 = ">" + NL + " *" + NL + " * @brief  Configuration file generated based on UI settings " + NL + " *         of UART002 App" + NL + " *" + NL + " */" + NL + "" + NL + "#ifndef _CONF_UART002_H_" + NL + "#define _CONF_UART002_H_" + NL + "" + NL + "#ifdef __cplusplus" + NL + "extern \"C\" {" + NL + "#endif" + NL + "" + NL + "/*******************************-**********************************************" + NL + " @Defines" + NL + "*******************************************************************************/" + NL + "" + NL + "#include <DAVE3.h>";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "/*Base Address of mapped USIC Module for App Instance ";
  protected final String TEXT_5 = " */" + NL + "#define UART002_";
  protected final String TEXT_6 = "_USIC \t  USIC";
  protected final String TEXT_7 = NL + "/*Base Address of mapped USIC Channel for App Instance ";
  protected final String TEXT_8 = " */" + NL + "#define UART002_";
  protected final String TEXT_9 = "_USIC_CH  USIC";
  protected final String TEXT_10 = "_CH";
  protected final String TEXT_11 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_12 = NL + NL + "extern const UART002_HandleType UART002_Handle";
  protected final String TEXT_13 = "; ";
  protected final String TEXT_14 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + NL + "#ifdef __cplusplus" + NL + "}" + NL + "#endif" + NL + "" + NL + "#endif " + NL + "/*CODE_BLOCK_END*/";
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     App2JetInterface app = (App2JetInterface) argument; 
     String AppBaseuri = "app/uart002/";
    stringBuffer.append(TEXT_1);
    stringBuffer.append( app.getAppVersion(AppBaseuri));
    stringBuffer.append(TEXT_2);
     String Uarturi = "peripheral/usic/"; 
     String MappedUri = null; 
     String appInst  = null; 
     String UnitInst = null; 
     String ChannelInst = null; 
    stringBuffer.append(TEXT_3);
     ArrayList<String> appsList = (ArrayList<String>)(app.getApps("app/uart002/")); 
      for (String appIns : appsList ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(AppBaseuri + appInst + "/channel"); 
     if((MappedUri != null) && (MappedUri != "")) { 
     UnitInst = MappedUri.substring(MappedUri .length()-11,MappedUri.indexOf("/channel/")); 
     ChannelInst = MappedUri.substring(MappedUri.length()-1); 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(UnitInst);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_9);
    stringBuffer.append( UnitInst );
    stringBuffer.append(TEXT_10);
    stringBuffer.append( ChannelInst );
     } 
     else { 
    stringBuffer.append(TEXT_11);
     } 
    } 
      for (String appIns : appsList ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(AppBaseuri + appInst + "/channel"); 
     if((MappedUri != null) && (MappedUri != "")) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_13);
     } 
     else { 
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
    } 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
