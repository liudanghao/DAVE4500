<?xml version="1.0" encoding="ASCII"?>
<ResourceModel:App xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:ResourceModel="http://www.infineon.com/Davex/Resource.ecore" name="RTOS001" description="The CMSIS-RTOS API is a generic&#xA;RTOS interface for Cortex-M &#xA;processor-based devices." descriptionURL="/doc/html/group___r_t_o_s001_app.html" mode="SHARABLE" URI="http://www.infineon.com/1.0.24/app/rtos001/0">
  <provided xsi:type="ResourceModel:IntegerParameter" name="Dummy UI Param to avoid infinite loop" evalFunction="&#x9;&#x9;&#x9;    &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var PRIVCNT_RES = SCM.getResource(&quot;dummypricnt&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var PRIVCNT_VAL = SCM.getIntValue(PRIVCNT_RES);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var TASKCNT_RES = SCM.getResource(&quot;dummytaskcnt&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var PRIVCNT_VAL = SCM.getIntValue(TASKCNT_RES);&#xD;&#xA;             &#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var PRIVCNT_RES = SCM.getResource(&quot;dummypricnt&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var PRIVCNT_VAL = SCM.getIntValue(PRIVCNT_RES);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var TASKCNT_RES = SCM.getResource(&quot;dummytaskcnt&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var TASKCNT_VAL = SCM.getIntValue(TASKCNT_RES);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if(PRIVCNT_VAL > TASKCNT_VAL)&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(PRIVCNT_RES, TASKCNT_VAL);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;                }&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwnonrecursive" maxValue="FA" minValue="0">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="6"/>
    <localValue xsi:type="ResourceModel:StringValue" value="6"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="6"/>
    <toolTipHelpDescription>This allows user to enter maximum number of threads that will run at the same time.
 It should be within the range of 0 to 250.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Number of concurrent running threads" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummytaskcnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummytaskcnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwtaskcnt" downWardmappedList="//@consumed.16" maxValue="FA" minValue="0">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="6"/>
    <localValue xsi:type="ResourceModel:StringValue" value="8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="8"/>
    <toolTipHelpDescription>Defines max. number of threads that will run at the same time.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Number of threads with user-provided stack size" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummypricnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummypricnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwpricnt" downWardmappedList="//@consumed.15" maxValue="FA" minValue="0">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <toolTipHelpDescription>Defines the number of threads with user-provided stack size.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Default Thread stack size [bytes]" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummystksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummystksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwstksize" downWardmappedList="//@consumed.14" maxValue="1000" minValue="40">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="C8"/>
    <localValue xsi:type="ResourceModel:StringValue" value="C8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <toolTipHelpDescription>Defines default stack size for threads with osThreadDef stacksz = 0.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Total stack size for threads with user-provided stack size [bytes]" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;         &#x9;&#x9;  var Res3 = SCM.getResource(&quot;dummyprivstksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  var value3 = SCM.getIntValue(currentResource);&#xD;&#xA;                  var Res4 = SCM.getResource(&quot;dummypricnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  var value4 = SCM.getIntValue(Res4);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  SCM.setIntValue(Res3,value3);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  var Res0 = SCM.getResource(&quot;dummyprivstksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  var value0 = SCM.getIntValue(Res0);&#xD;&#xA;                  var Res4 = SCM.getResource(&quot;dummypricnt&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;  var value4 = SCM.getIntValue(Res4);&#xD;&#xA;                  SCM.setIntValue(currentResource,value0);&#xD;&#xA;                  if (value4 == 0)&#xD;&#xA;                  {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#x9;&#xD;&#xA;                  }       &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwprivstksize" downWardmappedList="//@consumed.12" maxValue="40000" minValue="0">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <toolTipHelpDescription>Defines the combined stack size for threads with user-provided stack size.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="Check for stack overflow" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwstkcheck" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
    <localValue xsi:type="ResourceModel:StringValue" value="1"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
    <toolTipHelpDescription>Includes the stack checking code for stack overflow.
Note that additional code reduces the Kernel performance.</toolTipHelpDescription>
    <item name="Enable check for stack overflow" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwstkcheck/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
      <toolTipHelpDescription>Includes the stack checking code for stack overflow.
Note that additional code reduces the Kernel performance.</toolTipHelpDescription>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="Processor mode for thread execution" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwrprivmode">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    <item name="Unprivileged mode" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwrprivmode/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    </item>
    <item name="Privileged mode" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwrprivmode/1" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Timer clock value [Hz]" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;    &#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var XMC1xxx=SCM.getSoftwareId().substring(0,1).compareTo(&quot;1&quot;);  &#xD;&#xA;   &#x9;&#x9;&#x9; &#x9;&#x9;&#x9;if(XMC1xxx==0)&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res = SCM.getResource(&quot;clkapp2/clk002_irPCLK&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;else&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res = SCM.getResource(&quot;clkapp/clk001_iroActualFreqCPU&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Value = SCM.getIntValue(Res);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var XMC1xxx=SCM.getSoftwareId().substring(0,1).compareTo(&quot;1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;if(XMC1xxx==0)&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res = SCM.getResource(&quot;clkapp2/clk002_irPCLK&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;else&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res = SCM.getResource(&quot;clkapp/clk001_iroActualFreqCPU&quot;); &#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Value = SCM.getIntValue(Res);&#xD;&#xA;&#x9;                &#x9;var Value1 = Value * 1000000;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource, Value1);&#xD;&#xA;&#x9;&#x9;&#x9;    &#x9;}&#xD;&#xA; &#x9;&#x9;&#x9;  &#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwclock" maxValue="3B9ACA00" minValue="1">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="6000000"/>
    <localValue xsi:type="ResourceModel:StringValue" value="6000000"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="7270e00"/>
    <toolTipHelpDescription>This allows user to enter timer clock value in Hz</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Timer tick value [us]" evalFunction="" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwtick" maxValue="F4240" minValue="1">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="3E8"/>
    <localValue xsi:type="ResourceModel:StringValue" value="3E8"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="3E8"/>
    <toolTipHelpDescription>This allows user to enter the timer tick value in us</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="Use Cortex-M SysTick timer as RTX Kernel Timer" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwkerneltimer" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
    <localValue xsi:type="ResourceModel:StringValue" value="1"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
    <toolTipHelpDescription>Use the Cortex-M SysTick timer as a time-base for RTX.</toolTipHelpDescription>
    <item name="Use Cortex-M SysTick timer as RTX Kernel Timer" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwkerneltimer/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="Round-Robin Thread switching" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwrndrobin" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
    <localValue xsi:type="ResourceModel:StringValue" value="1"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
    <toolTipHelpDescription>This allows user to enable round robin thread switching.</toolTipHelpDescription>
    <item name="Enable Round-Robin thread switching" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwrndrobin/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="1"/>
      <toolTipHelpDescription>This allows user to enable round robin thread switching.</toolTipHelpDescription>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Round-Robin Timeout [ticks]" evalFunction="" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwrobintout" maxValue="3E8" minValue="1">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="5"/>
    <localValue xsi:type="ResourceModel:StringValue" value="5"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="5"/>
    <toolTipHelpDescription>Defines how long a thread will execute before a thread switch.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="User Timers" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimers" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    <toolTipHelpDescription>Enables user Timers.
Note user needs to implement void os_tmr_call(uint16_t info);</toolTipHelpDescription>
    <item name="Enable user timers" evalFunction="&#xD;&#xA;                    &#x9;&#x9;function ForwardMapping()&#xD;&#xA;                        &#x9;{&#xD;&#xA;                                var value = SCM.getIntValue(currentResource);&#xD;&#xA;  &#x9;&#x9;&#x9;&#x9;&#x9;            var Res1 = SCM.getResource(&quot;chkval&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            SCM.setIntValue(Res1,value);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;                            function BackwardMapping()&#xD;&#xA;                            {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;chkval&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            if(value1 == 1) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            &#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            } else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;        &#x9;    SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;            }                                 &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;        }&#xD;&#xA;                        " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimers/0" downWardmappedList="//@consumed.11" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <toolTipHelpDescription>Enables user Timers.
Note user needs to implement void os_tmr_call(U16  info);</toolTipHelpDescription>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="Timer Thread Priority" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio" downWardmappedList="//@consumed.8">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
    <localValue xsi:type="ResourceModel:StringValue" value="1"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="5"/>
    <toolTipHelpDescription>Defines priority for Timer Thread.</toolTipHelpDescription>
    <item name="Low" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,1);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 1 || value1 == -1) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/1" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>Low Priority</toolTipHelpDescription>
    </item>
    <item name="Below Normal" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                       &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,2);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 2) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/2" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>Below Normal Priority</toolTipHelpDescription>
    </item>
    <item name="Normal" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                       &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                       &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,3);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 3) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/3" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>Normal Priority</toolTipHelpDescription>
    </item>
    <item name="Above Normal" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,4);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 4) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/4" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>Low Priority</toolTipHelpDescription>
    </item>
    <item name="High" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,5);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9; &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 5) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/5" downWardmappedList="//@consumed.8" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <toolTipHelpDescription>High Priority</toolTipHelpDescription>
    </item>
    <item name="Realtime (highest)" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,6);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9; &#x9;&#x9; &#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 6) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_erwtimerprio/6" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>Realtime Priority</toolTipHelpDescription>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Timer Thread stack size [bytes]" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummytimerstksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;dummytimerstksize&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwtimerstksize" downWardmappedList="//@consumed.13" maxValue="1000" minValue="40">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="C8"/>
    <localValue xsi:type="ResourceModel:StringValue" value="C8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <toolTipHelpDescription>Defines stack size for Timer thread.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:IntegerParameter" name="Timer Callback Queue size" evalFunction="" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwtimercbqsize" maxValue="20" minValue="1">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="4"/>
    <localValue xsi:type="ResourceModel:StringValue" value="4"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="4"/>
    <toolTipHelpDescription>Number of concurrent active timer callback functions.</toolTipHelpDescription>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="ISR FIFO Queue size" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(Res0,value0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;var value0 = SCM.getIntValue(Res0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;SCM.setIntValue(currentResource,value0);&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz" downWardmappedList="//@consumed.9">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
    <localValue xsi:type="ResourceModel:StringValue" value="1"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="4"/>
    <toolTipHelpDescription>ISR functions store requests to this buffer, when they are called from the interrupt handler.</toolTipHelpDescription>
    <item name="4" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9; &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                     &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;                      &#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;&#x9;SCM.setIntValue(Res0,1);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;if(value1 == 1 || value1 == -1) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/4" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>4 Entries</toolTipHelpDescription>
    </item>
    <item name="8" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;        &#x9;              &#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;if (value0 == 1)&#xD;&#xA;                &#x9;      &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,2);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 2) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/8" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>8 Entries</toolTipHelpDescription>
    </item>
    <item name="12" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;        &#x9;              &#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;if (value0 == 1)&#xD;&#xA;                &#x9;      &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,3);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 3) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/12" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>12 Entries</toolTipHelpDescription>
    </item>
    <item name="16" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;&#x9;                      &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,4);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 4) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/16" downWardmappedList="//@consumed.9" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <localValue xsi:type="ResourceModel:StringValue" value="1"/>
      <globalValue xsi:type="ResourceModel:IntegerValue" value="1"/>
      <toolTipHelpDescription>16 Entries</toolTipHelpDescription>
    </item>
    <item name="24" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;if (value0 == 1)&#xD;&#xA;    &#x9;                  &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,5);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 5) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/24" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>24 Entries</toolTipHelpDescription>
    </item>
    <item name="32" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                    &#x9;  &#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;&#x9;                      &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,6);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 6) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/32" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>32 Entries</toolTipHelpDescription>
    </item>
    <item name="48" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;                      &#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;if (value0 == 1)&#xD;&#xA;        &#x9;              &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,7);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 7) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/48" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>48 Entries</toolTipHelpDescription>
    </item>
    <item name="64" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;&#x9;                      &#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;if (value0 == 1)&#xD;&#xA;        &#x9;              &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,8);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 8) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/64" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>64 Entries</toolTipHelpDescription>
    </item>
    <item name="96" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function ForwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;var value0 = SCM.getIntValue(currentResource);&#xD;&#xA;                      &#x9;&#x9;&#x9;var Res0 = SCM.getResource(&quot;index1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;&#x9;if (value0 == 1)&#xD;&#xA;&#x9;                      &#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;    &#x9;&#x9;SCM.setIntValue(Res0,9);&#xD;&#xA; &#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;function BackwardMapping()&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;{&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var Res1 = SCM.getResource(&quot;index1&quot;);&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;var value1 = SCM.getIntValue(Res1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;   &#x9;&#x9;if(value1 == 9) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,1);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;} else {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;&#x9;SCM.setIntValue(currentResource,0);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;&#x9;" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_irwfifosz/96" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
      <toolTipHelpDescription>96 Entries</toolTipHelpDescription>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="User defined function for idle demon" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_idledemon" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    <toolTipHelpDescription>The idle demon is a system low priority thread, running when no other thread is ready to run.
Note: If enabled user needs to provide an implementation of void os_idle_demon(void) function.</toolTipHelpDescription>
    <item name="Enable user defined function for idle demon" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_idledemon/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    </item>
  </provided>
  <provided xsi:type="ResourceModel:EnumerationParameter" name="User defined function for error handling" URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_oserror" multipleSelections="true">
    <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <localValue xsi:type="ResourceModel:StringValue" value="0"/>
    <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    <toolTipHelpDescription>This function is called when a runtime error is detected.
Note: If enabled user needs to provide an implementation of void os_error(uint32_t error_code) function.
Parameter 'error_code' holds the runtime error code.
</toolTipHelpDescription>
    <item name="Enable user defined function for error handling" evalFunction=" " URI="http://www.infineon.com/1.0.24/app/rtos001/0/rtos001_oserror/0" maxValue="1" minValue="0">
      <defaultValue xsi:type="ResourceModel:IntegerValue" value="0"/>
      <localValue xsi:type="ResourceModel:StringValue" value="0"/>
      <globalValue xsi:type="ResourceModel:StringValue" value="0"/>
    </item>
  </provided>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/systick">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.24"/>
    <requiredResource uriString="peripheral/cpu/0/systick" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" evalFunction="function resourceCondition() {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value1 = Solver.getSoftwareId().substring(0,1).compareTo(&quot;4&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if((value1  == 0 )) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  &#x9;return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}" URI="http://www.infineon.com/1.0.24/app/rtos001/0/fpu">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.25"/>
    <requiredResource uriString="peripheral/cpu/0/fpu" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" evalFunction="function resourceCondition() {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value1 = Solver.getSoftwareId().substring(0,1).compareTo(&quot;4&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if((value1  == 0 )) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}" URI="http://www.infineon.com/1.0.24/app/rtos001/0/memory_protection">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.26"/>
    <requiredResource uriString="peripheral/cpu/0/memory_protection" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/exceptionsystick">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.27"/>
    <requiredResource uriString="peripheral/cpu/0/exception/systick" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/pendsv">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.28"/>
    <requiredResource uriString="peripheral/cpu/0/exception/pendsv" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/svcall">
    <downWardmappedList xsi:type="ResourceModel:ResourceGroup" href="../../CPU/CPU_0.dd#//@provided.29"/>
    <requiredResource uriString="peripheral/cpu/0/exception/svcall" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" evalFunction="function resourceCondition() {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value1 = Solver.getSoftwareId().substring(0,1).compareTo(&quot;4&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if((value1  == 0 )) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}" URI="http://www.infineon.com/1.0.24/app/rtos001/0/clkapp">
    <downWardmappedList xsi:type="ResourceModel:App" href="../../CLK001/1.0.42/clk001_0.app#/"/>
    <requiredResource uriString="app/clk001/*" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" evalFunction="function resourceCondition() {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;var value1 = Solver.getSoftwareId().substring(0,1).compareTo(&quot;1&quot;);&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;if((value1  == 0 )) {&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;  return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}" URI="http://www.infineon.com/1.0.24/app/rtos001/0/clkapp2">
    <requiredResource uriString="app/clk002/*" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/index" upWardMappingList="//@provided.13 //@provided.13/@item.4" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="5"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="5"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/index1" upWardMappingList="//@provided.16 //@provided.16/@item.3" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="4"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="4"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/index2" isSystemDefined="true">
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/chkval" upWardMappingList="//@provided.12/@item.0" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/dummyprivstksize" upWardMappingList="//@provided.4" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/dummytimerstksize" upWardMappingList="//@provided.14" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/dummystksize" upWardMappingList="//@provided.3" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="c8"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/dummypricnt" upWardMappingList="//@provided.0 //@provided.2 //@provided.4" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="0"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/dummytaskcnt" upWardMappingList="//@provided.0 //@provided.1" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="8"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="8"/>
    <requiredResource uriString="" uriType="LOCALTYPE"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/clkapp/clk001_iroactualfreqcpu" upWardMappingList="//@provided.7" isSystemDefined="true">
    <localValue xsi:type="ResourceModel:IntegerValue" value="78"/>
    <downWardmappedList xsi:type="ResourceModel:IntegerParameter" href="../../CLK001/1.0.42/clk001_0.app#//@provided.43"/>
    <globalValue xsi:type="ResourceModel:IntegerValue" value="78"/>
  </consumed>
  <consumed xsi:type="ResourceModel:ProxyResource" URI="http://www.infineon.com/1.0.24/app/rtos001/0/clkapp2/clk002_irpclk" isSystemDefined="true"/>
  <categoryDescription description="Service Apps" name="Service Apps">
    <subCategory description="RTOS" name="RTOS"/>
  </categoryDescription>
  <manifestInfo version="1.0.24">
    <keywords>RTOS</keywords>
    <keywords>CMSIS</keywords>
    <keywords>OS</keywords>
    <keywords>RTX</keywords>
    <keywords>RTOS001</keywords>
    <keywords>Sharable</keywords>
    <properties xsi:type="ResourceModel:AppProperties_1_0" initProvider="true" singleton="true"/>
  </manifestInfo>
  <datagenerate fileName="RTX_Conf_CM.c" templateFileName="RTX_Conf_CM.cjet"/>
  <datagenerate fileName="INC" fileType="CDIR" templateFileName="INC" templateEngine="NONE" fileAction="COPY"/>
  <datagenerate fileName="SRC" fileType="CDIR" templateFileName="SRC" templateEngine="NONE" fileAction="COPY"/>
  <datagenerate fileName="SRC/RTX_Config.h" templateFileName="RTX_Config.hjet"/>
  <datagenerate fileName="SRC/rt_CMSIS.c" templateFileName="rt_CMSIS.cjet"/>
  <datagenerate fileName="SRC/HAL_CM0_armcc.c" templateFileName="HAL/HAL_CM0_armcc.c" templateEngine="NONE" fileAction="COPY" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function preCondition() {&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;var value1 = CG.getSoftwareId().substring(0,1).compareTo(&quot;1&quot;);&#xD;&#xA;&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;if(value1 == 0) {&#xD;&#xA;&#x9;&#x9; &#x9;&#x9;&#x9;&#x9;return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9; "/>
  <datagenerate fileName="SRC/HAL_CM0.s" templateFileName="HAL/HAL_CM0.s" templateEngine="NONE" fileAction="COPY" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function preCondition() {&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;var value1 = CG.getSoftwareId().substring(0,1).compareTo(&quot;1&quot;);&#xD;&#xA;&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;if(value1 == 0) {&#xD;&#xA;&#x9;&#x9; &#x9;&#x9;&#x9;&#x9;return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9; "/>
  <datagenerate fileName="SRC/HAL_CM4_armcc.c" templateFileName="HAL/HAL_CM4_armcc.c" templateEngine="NONE" fileAction="COPY" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function preCondition() {&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;var value1 = CG.getSoftwareId().substring(0,1).compareTo(&quot;4&quot;);&#xD;&#xA;&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;if(value1 == 0) {&#xD;&#xA;&#x9;&#x9; &#x9;&#x9;&#x9;&#x9;return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9; "/>
  <datagenerate fileName="SRC/HAL_CM4.s" templateFileName="HAL/HAL_CM4.s" templateEngine="NONE" fileAction="COPY" evalFunction="&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;function preCondition() {&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;var value1 = CG.getSoftwareId().substring(0,1).compareTo(&quot;4&quot;);&#xD;&#xA;&#xD;&#xA;&#x9;   &#x9;&#x9;&#x9;&#x9;if(value1 == 0) {&#xD;&#xA;&#x9;&#x9; &#x9;&#x9;&#x9;&#x9;return true;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;&#x9;return false;&#xD;&#xA;&#x9;&#x9;&#x9;&#x9;}&#xD;&#xA;&#x9;&#x9;&#x9; "/>
  <datagenerate fileName="License.txt" templateFileName="License.txt" templateEngine="NONE" fileAction="COPY"/>
  <datagenerate fileName="RTOS001.h" fileType="HFILE" templateFileName="RTOS001.h" templateEngine="NONE" fileAction="COPY"/>
  <softwareIdList>45.0.1</softwareIdList>
  <softwareIdList>45.0.2</softwareIdList>
  <softwareIdList>45.0.3</softwareIdList>
  <softwareIdList>45.2.3</softwareIdList>
  <softwareIdList>45.4.2</softwareIdList>
  <softwareIdList>45.4.3</softwareIdList>
  <softwareIdList>44.0.3</softwareIdList>
  <softwareIdList>44.00.5</softwareIdList>
  <softwareIdList>44.02.3</softwareIdList>
  <softwareIdList>44.02.5</softwareIdList>
  <softwareIdList>42.00.5</softwareIdList>
  <softwareIdList>42.0.6</softwareIdList>
  <softwareIdList>42.04.5</softwareIdList>
  <softwareIdList>42.04.6</softwareIdList>
  <softwareIdList>11.0100.7</softwareIdList>
  <softwareIdList>11.0100.9</softwareIdList>
  <softwareIdList>12.0100.7</softwareIdList>
  <softwareIdList>13.0102.7</softwareIdList>
  <softwareIdList>45.0200.1</softwareIdList>
  <softwareIdList>45.0200.2</softwareIdList>
  <softwareIdList>45.0200.3</softwareIdList>
  <softwareIdList>45.0202.3</softwareIdList>
  <softwareIdList>45.0204.3</softwareIdList>
  <softwareIdList>45.0204.2</softwareIdList>
  <softwareIdList>12.0101.7</softwareIdList>
  <softwareIdList>12.0102.9</softwareIdList>
  <softwareIdList>12.0102.8</softwareIdList>
  <softwareIdList>13.0101.9</softwareIdList>
  <softwareIdList>13.0101.7</softwareIdList>
  <softwareIdList>42.0200.5</softwareIdList>
  <softwareIdList>42.0204.5</softwareIdList>
  <softwareIdList>42.0204.6</softwareIdList>
  <softwareIdList>42.0200.6</softwareIdList>
  <softwareIdList>42.0208.6</softwareIdList>
  <softwareIdList>44.0200.5</softwareIdList>
  <softwareIdList>44.0202.3</softwareIdList>
  <softwareIdList>44.0202.5</softwareIdList>
  <softwareIdList>44.0200.3</softwareIdList>
  <softwareIdList>45.0300.1</softwareIdList>
  <softwareIdList>45.0300.3</softwareIdList>
  <softwareIdList>45.0302.3</softwareIdList>
  <softwareIdList>45.0304.2</softwareIdList>
  <softwareIdList>45.0300.2</softwareIdList>
  <softwareIdList>45.0304.3</softwareIdList>
  <softwareIdList>11.0100.10</softwareIdList>
  <softwareIdList>11.0100.11</softwareIdList>
  <softwareIdList>12.0101.11</softwareIdList>
  <softwareIdList>12.0102.10</softwareIdList>
  <softwareIdList>12.0102.11</softwareIdList>
  <softwareIdList>13.0101.10</softwareIdList>
  <softwareIdList>13.0101.11</softwareIdList>
  <softwareIdList>13.0102.10</softwareIdList>
  <softwareIdList>13.0102.11</softwareIdList>
  <softwareIdList>13.0102.9</softwareIdList>
</ResourceModel:App>
