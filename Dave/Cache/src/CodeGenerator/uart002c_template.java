package CodeGenerator;

import java.util.*;
import com.ifx.davex.appjetinteract.App2JetInterface;

public class uart002c_template
{
  protected static String nl;
  public static synchronized uart002c_template create(String lineSeparator)
  {
    nl = lineSeparator;
    uart002c_template result = new uart002c_template();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "/*CODE_BLOCK_BEGIN[UART002.c]*/" + NL + "/*******************************************************************************" + NL + " Copyright (c) 2014, Infineon Technologies AG                                 **" + NL + " All rights reserved.                                                         **" + NL + "                                                                              **" + NL + " Redistribution and use in source and binary forms, with or without           **" + NL + " modification,are permitted provided that the following conditions are met:   **" + NL + "                                                                              **" + NL + " *Redistributions of source code must retain the above copyright notice,      **" + NL + " this list of conditions and the following disclaimer.                        **" + NL + " *Redistributions in binary form must reproduce the above copyright notice,   **" + NL + " this list of conditions and the following disclaimer in the documentation    **" + NL + " and/or other materials provided with the distribution.                       **" + NL + " *Neither the name of the copyright holders nor the names of its contributors **" + NL + " may be used to endorse or promote products derived from this software without** " + NL + " specific prior written permission.                                           **" + NL + "                                                                              **" + NL + " THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\"  **" + NL + " AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE    **" + NL + " IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE   **" + NL + " ARE  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE   **" + NL + " LIABLE  FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR         **" + NL + " CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF         **" + NL + " SUBSTITUTE GOODS OR  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS    **" + NL + " INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN      **" + NL + " CONTRACT, STRICT LIABILITY,OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)       **" + NL + " ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE   **" + NL + " POSSIBILITY OF SUCH DAMAGE.                                                  **" + NL + "                                                                              **" + NL + " To improve the quality of the software, users are encouraged to share        **" + NL + " modifications, enhancements or bug fixes with Infineon Technologies AG       **" + NL + " dave@infineon.com).                                                          **" + NL + "                                                                              **" + NL + "********************************************************************************" + NL + "**                                                                            **" + NL + "**                                                                            **" + NL + "** PLATFORM : Infineon XMC4000/XMC1000 Series                                 **" + NL + "**                                                                            **" + NL + "** COMPILER : Compiler Independent                                            **" + NL + "**                                                                            **" + NL + "** AUTHOR   : App Developer                                                   **" + NL + "**                                                                            **" + NL + "** MAY BE CHANGED BY USER [yes/no]: Yes                                       **" + NL + "**                                                                            **" + NL + "** MODIFICATION DATE : Jan 21 , 2014                                          **" + NL + "**                                                                            **" + NL + "*******************************************************************************/" + NL + "/*******************************************************************************" + NL + "**                      Author(s) Identity                                    **" + NL + "********************************************************************************" + NL + "**                                                                            **" + NL + "** Initials     Name                                                          **" + NL + "** ---------------------------------------------------------------------------**" + NL + "** AIK          App Developer                                                 **" + NL + "*******************************************************************************/" + NL + "/**" + NL + " * @file   UART002.c" + NL + " * " + NL + " * @brief USIC_UARTOS_UART002 App provides high level Apps with Read and Write APIs which" + NL + " *   can be used from multiple Task context. The APIs uses Semaphores so that the" + NL + " *   same USIC channel can be used by multiple Applications. The App supports both" + NL + " *   Interrupt and DMA mode of operation" + NL + " *   " + NL + " * @App    Version UART002 <";
  protected final String TEXT_2 = ">" + NL + " * " + NL + " */" + NL + "/*" + NL + "* Version History : " + NL + "* 25 Jul 2013\t v1.0.8\t  1. Replaced \"DMA003_H_\" Macros with \"UART_DMA_ENABLED\"" + NL + "*                         2. Clock gating is disabled in UART002_Init API for " + NL + "*                         XMC4400 & XMC4200 devices" + NL + "*                         3. DBG002 Macros added" + NL + "*                         4. Spell corrections & Misra corrections " + NL + "*                         5. Modified for baud calculation during initialization." + NL + "*                         6. The PCTQ value update in BRG register is removed " + NL + "*                         as the value is taken as zero. " + NL + "*                         7. Updated for the baud calculation in UART002_lInit() " + NL + "*                         function." + NL + "*                         8. Updated the UART002_Init() function for disabling " + NL + "*                         the clock gating signal for XMC 1000 devices." + NL + "*                         9. DMA mode handling is disabled for XMC1000 devices " + NL + "*                         as DMA module is not available in XMC1000 devices. " + NL + "*                         10. Modified interrupt event initialization in " + NL + "*                         UART002_Init() for XMC1000 devices.  " + NL + "*                         11. Interrupt handler names are replaced with " + NL + "*                         \"IRQ_Hdlr_X\",where X will be the interrupt node ID." + NL + "*                         12. IOCR & PDR register configurations are added in" + NL + "*                         UART002_Init() for Tx & Rx Pin Configurations. " + NL + "*                         13. The function UART002_lConfigureBaudRate is removed " + NL + "*                         as the baud calculations are made in ui model level " + NL + "*                         and the values are generated in handle parameter of the " + NL + "*                         configuration file. " + NL + "*                         14. Removed TBIF bit configuration from UART002_lInit as " + NL + "*                         polling is not used in the UART002 App." + NL + "*                         15. Added open-drain output configuration for Half duplex" + NL + "*                         operation mode to allow the wired-AND connection in " + NL + "*                         multiple transmitter communication." + NL + "*                         16. TX pin set logic high (1) before configuring Open " + NL + "*                         Drain mode for Half Duplex operation mode. " + NL + "*  21 Jan 2014 v1.0.12    1. Error codes are added in various functions, that can" + NL + "*                         be logged with DBG002 App." + NL + "*                         2. Removed DBG002_FUNCTION_ENTRY & DBG002_FUNCTION_EXIT" + NL + "*                         calling from APIs as using these macros is highly " + NL + "*                         discouraged.                                                                                                         " + NL + "*/" + NL + "/*******************************************************************************" + NL + " ** INCLUDE FILES                                                             **" + NL + " ******************************************************************************/" + NL + "" + NL + "#include <DAVE3.h>" + NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = "  " + NL + "/*****************************************************************************" + NL + "              DUMMY DEFINTIONS OF DEBUG LOG MACROS" + NL + "*****************************************************************************/" + NL + "/*These definitions are included here to avoid compilation errors," + NL + " since the DBG002 app is not part of the project. All the macros are defined" + NL + " as empty*/ " + NL + "#ifndef _DBG002_H_" + NL + "" + NL + "#define DBG002_MESSAGEID_LITERAL" + NL + "#define DBG002_ERROR(groupid,messageid,length,value)" + NL + "" + NL + "#endif/* End of definitions of dummy Debug Log macros*/";
  protected final String TEXT_5 = "                  " + NL + "" + NL + "/*******************************************************************************" + NL + "**                      Private Macro Definitions                             **" + NL + "*******************************************************************************/" + NL;
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = "  " + NL + NL;
  protected final String TEXT_8 = " " + NL + " /* System Core clock frequency in MHz */ " + NL + "#define UART002_CLOCK  ";
  protected final String TEXT_9 = "F ";
  protected final String TEXT_10 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_11 = NL + NL + "#define APP_GID DBG002_GID_UART002" + NL + "" + NL + "" + NL + "/*******************************************************************************" + NL + "**                      Private Type Definitions                              **" + NL + "*******************************************************************************/" + NL + "" + NL + "" + NL + "/*******************************************************************************" + NL + "**                 Private Function Declarations:" + NL + "*******************************************************************************/" + NL + "/**" + NL + " * @ingroup UART002_PrivateFunctions" + NL + " * @{" + NL + " */";
  protected final String TEXT_12 = NL + "#ifdef UART_DMA_ENABLED " + NL + "/**" + NL + " * Dma receive listener function" + NL + " *          " + NL + " * param[in]   dev dw_device" + NL + " * param[in]   eCode Interrupt type" + NL + " * @return     None" + NL + " *" + NL + " * <b>Reentrant: YES </b><BR>" + NL + " *" + NL + " */" + NL + "void UARTDmaRxListener(DMA_IRQType IRQType, uint32_t CbArg);" + NL + "" + NL + "" + NL + "/**" + NL + " * Dma transmit listener function" + NL + " *          " + NL + " * param[in]   dev dw_device" + NL + " * param[in]   eCode Interrupt type" + NL + " * @return     None" + NL + " *" + NL + " * <b>Reentrant: YES </b><BR>" + NL + " *" + NL + " */" + NL + "void UARTDmaTxListener(DMA_IRQType IRQType, uint32_t CbArg);" + NL + "#endif";
  protected final String TEXT_13 = NL + NL + "/**" + NL + " * Function to initialise UART channel" + NL + " *          " + NL + " * param[in]   Handle Uart channel configuration" + NL + " * @return     None" + NL + " *" + NL + " * <b>Reentrant: YES </b><BR>" + NL + " *" + NL + " */" + NL + "void  UART002_lInit(const UART002_HandleType* Handle);" + NL + "/**" + NL + " *@}" + NL + " */" + NL + "/*******************************************************************************" + NL + "**                      Global Constant Definitions                           **" + NL + "*******************************************************************************/" + NL + "" + NL + "/*******************************************************************************" + NL + "**                      Global Variable Definitions                           **" + NL + "*******************************************************************************/" + NL;
  protected final String TEXT_14 = NL + NL + "osSemaphoreDef(UART002_ChannelSemHandle";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_17 = NL + "/*******************************************************************************" + NL + "**                      Private Constant Definitions                          **" + NL + "*******************************************************************************/" + NL + "" + NL + "/*******************************************************************************" + NL + "**                 Function like macro definitions                            **" + NL + "*******************************************************************************/" + NL + "/*******************************************************************************" + NL + "**                      Private Function Definitions                          **" + NL + "*******************************************************************************/" + NL;
  protected final String TEXT_18 = NL + "#ifdef UART_DMA_ENABLED" + NL + "/* Dma receive listener function */" + NL + "void UARTDmaRxListener(DMA_IRQType IRQType, uint32_t CbArg)" + NL + "{" + NL + "  /* <<<DD_UART002_non_API_1>>>*/" + NL + "  UART002_LocalStructType* Config = (UART002_LocalStructType*)CbArg;\t" + NL + "  UART002_HandleType* Handle = (UART002_HandleType*)Config->AppInstanceHandle;" + NL + "  if(IRQType == DMA_IRQ_ERR)" + NL + "  {" + NL + "    /* Disable standard transmit interrupt */" + NL + "    Handle->UartRegs->RBCTR &= \\" + NL + "                      ~(((uint32_t)USIC_CH_RBCTR_SRBIEN_Msk));" + NL + "    USIC_FlushRxFIFO(Handle->UartRegs);" + NL + "    Config->Status = UART002_TRANSFER_FAILED;" + NL + "    /* Transfer failed. Release the channel */" + NL + "    /* Signal the task that Job is completed */" + NL + "\tosSignalSet(Config->ThreadID,Config->SignalId);" + NL + "    /* Release channel semaphore */" + NL + "\tosSemaphoreRelease(Handle->DynamicData->ChannelSemId);" + NL + "  }" + NL + "  " + NL + "  if(IRQType == DMA_IRQ_TFR) " + NL + "  {" + NL + "    /* Disable standard receive and error event interrupt */" + NL + "    Handle->UartRegs->RBCTR &= \\" + NL + "                      ~(((uint32_t)USIC_CH_RBCTR_SRBIEN_Msk));" + NL + "    USIC_FlushRxFIFO(Handle->UartRegs);" + NL + "" + NL + "    Config->Status = UART002_TRANSFER_SUCCESS;" + NL + "    /* Transfer success. Release the channel */" + NL + "    /* Signal the task that Job is complete */" + NL + "\tosSignalSet(Config->ThreadID,Config->SignalId);" + NL + "    /* Release channel semaphore */" + NL + "\tosSemaphoreRelease(Handle->DynamicData->ChannelSemId);" + NL + "  }" + NL + "}" + NL + "" + NL + "" + NL + "/* Dma transmit listener function */" + NL + "void UARTDmaTxListener(DMA_IRQType IRQType, uint32_t CbArg)" + NL + "{" + NL + "\t  /* <<<DD_UART002_non_API_2>>>*/" + NL + "   UART002_LocalStructType* Config = (UART002_LocalStructType*)CbArg;" + NL + "   UART002_HandleType* Handle = (UART002_HandleType*)Config->AppInstanceHandle;" + NL + "   if(IRQType == DMA_IRQ_ERR)" + NL + "   {" + NL + "    /* DMA error interrupt occured */" + NL + "   " + NL + "      /* Disable standard transmit and error event interrupt */" + NL + "      Handle->UartRegs->TBCTR &= \\" + NL + "                          ~(((uint32_t)USIC_CH_TBCTR_STBIEN_Msk));" + NL + "      USIC_FlushTxFIFO(Handle->UartRegs);" + NL + "      Config->Status = UART002_TRANSFER_FAILED;" + NL + "      /* Transfer failed. Release the channel */" + NL + "      /* Signal the task that Job is complete */" + NL + "\t\t  osSignalSet(Config->ThreadID,Config->SignalId);" + NL + "      /* Release channel semaphore */" + NL + "\t\t  osSemaphoreRelease(Handle->DynamicData->ChannelSemId);" + NL + "    }" + NL + "\tif(IRQType == DMA_IRQ_TFR) " + NL + "    {" + NL + "    /*DMA transfer completed */" + NL + "      /* Disable standard transmit and error event interrupt */" + NL + "    Handle->UartRegs->TBCTR &= \\" + NL + "                          ~(((uint32_t)USIC_CH_TBCTR_STBIEN_Msk));" + NL + "    Config->Status = UART002_TRANSFER_SUCCESS;" + NL + "     /* Transfer success. Release the channel */" + NL + "      /* Signal the task that Job is complete */" + NL + "\t\tosSignalSet(Config->ThreadID,Config->SignalId);" + NL + "    /* Release channel semaphore */" + NL + "\t\tosSemaphoreRelease(Handle->DynamicData->ChannelSemId);" + NL + "\t}" + NL + "}" + NL + "#endif";
  protected final String TEXT_19 = NL + NL + "/* Initialises the App based on User provide configuration. */" + NL + " " + NL + "void  UART002_lInit(const UART002_HandleType* Handle)" + NL + "{ " + NL + "  USIC_CH_TypeDef* UartRegs = Handle->UartRegs;" + NL + "  " + NL + " /* <<<DD_UART002_API_1>>>*/" + NL + "" + NL + "  /** UART initialisation  */" + NL + "  /* Disable UART mode before configuring all USIC registers to avoid unintended edges */ " + NL + "  UartRegs->CCR &= ~( ((uint32_t)(UART_MODE  & USIC_CH_CCR_MODE_Msk)));    " + NL + " " + NL + "  /* Enable the USIC Channel */" + NL + "  UartRegs->KSCFG |= (uint32_t)(((USIC_CH_KSCFG_MODEN_Msk)) | \\" + NL + "                     ((0x01UL   << USIC_CH_KSCFG_BPMODEN_Pos) \\" + NL + "                                          &  USIC_CH_KSCFG_BPMODEN_Msk));" + NL + "" + NL + "  /* Configuration of USIC Channel Fractional Divider */" + NL + "  " + NL + "  /* Fractional divider mode selected */" + NL + "  UartRegs->FDR |= (uint32_t)(( 2UL << USIC_CH_FDR_DM_Pos) \\" + NL + "                    & USIC_CH_FDR_DM_Msk);" + NL + " " + NL + "  /* Set the step value */" + NL + "  UartRegs->FDR &= (uint32_t)~(USIC_CH_FDR_STEP_Msk);" + NL + "  UartRegs->FDR |= (uint32_t)( (Handle->BGR_STEP) & USIC_CH_FDR_STEP_Msk);" + NL + "\t\t" + NL + "  UartRegs->BRG |= (uint32_t)((( (Handle->BGR_PCTQ)  << USIC_CH_BRG_PCTQ_Pos) & \\" + NL + "    USIC_CH_BRG_PCTQ_Msk  ) | \\" + NL + "    (((Handle->BGR_DCTQ)  << USIC_CH_BRG_DCTQ_Pos) &  USIC_CH_BRG_DCTQ_Msk));" + NL + "" + NL + "  UartRegs->BRG &= (uint32_t)~(USIC_CH_BRG_PDIV_Msk);" + NL + "  UartRegs->BRG |= (uint32_t)(((Handle->BGR_PDIV)  << USIC_CH_BRG_PDIV_Pos) \\" + NL + "\t\t                           &  USIC_CH_BRG_PDIV_Msk);" + NL + "" + NL + "  /* Configuration of USIC Shift Control */" + NL + "  /* Transmit/Receive LSB first is selected  */" + NL + "  /* Transmission Mode (TRM) = 1  */" + NL + "  /* Passive Data Level (PDL) = 1 */" + NL + "  UartRegs->SCTR |= (uint32_t)(((0x01UL  << USIC_CH_SCTR_PDL_Pos) & \\" + NL + "                      USIC_CH_SCTR_PDL_Msk ) | \\" + NL + "                     ((0x01UL  << USIC_CH_SCTR_TRM_Pos) &  \\" + NL + "                      USIC_CH_SCTR_TRM_Msk));" + NL + "  " + NL + "  /* Configure Word length and frame length */" + NL + "  UartRegs->SCTR |= (uint32_t)(((uint32_t)(Handle->ChConfig.DataBits  << (uint32_t)USIC_CH_SCTR_FLE_Pos) & \\" + NL + "  USIC_CH_SCTR_FLE_Msk ) | \\" + NL + "  (((uint32_t)Handle->ChConfig.DataBits  << USIC_CH_SCTR_WLE_Pos) &  USIC_CH_SCTR_WLE_Msk));" + NL + "  " + NL + "  /* Configuration of Protocol Control Register */ " + NL + "  /* Sample Mode (SMD) = 1 */" + NL + "  /* Sample Point (SP) = 8 */" + NL + "  /* Pulse Length (PL) = 0 */" + NL + "  UartRegs->PCR_ASCMode &= (uint32_t)~USIC_CH_PCR_ASCMode_STPB_Msk;" + NL + "  UartRegs->PCR_ASCMode |= (uint32_t)(((0x01UL  & USIC_CH_PCR_ASCMode_SMD_Msk)) | \\" + NL + "    ((uint32_t)((uint32_t)Handle->ChConfig.StopBit  << (uint32_t)USIC_CH_PCR_ASCMode_STPB_Pos) & \\" + NL + "    USIC_CH_PCR_ASCMode_STPB_Msk) | \\" + NL + "    ((uint32_t)((Handle->BGR_SP)  << (uint32_t)USIC_CH_PCR_ASCMode_SP_Pos) & \\" + NL + "    USIC_CH_PCR_ASCMode_SP_Msk));" + NL + "      " + NL + "" + NL + "  " + NL + "  /* Configuration of USIC Transmit Control/Status Register */ " + NL + "  /* TBUF Data Enable (TDEN) = 1 */" + NL + "  /* TBUF Data Single Shot Mode (TDSSM) = 1 */     " + NL + "  UartRegs->TCSR |= (uint32_t)(((0x01UL  << USIC_CH_TCSR_TDEN_Pos) & \\" + NL + "                        USIC_CH_TCSR_TDEN_Msk ) | \\" + NL + "                        ((uint32_t)(0x01UL  << USIC_CH_TCSR_TDSSM_Pos) & \\" + NL + "                        USIC_CH_TCSR_TDSSM_Msk));" + NL + "    " + NL + "  /* Configuration of Protocol Status Register */ " + NL + "  /* TBIF is set to simplify polling*/" + NL + "  UartRegs->PSR_ASCMode |= (uint32_t)\\" + NL + "                     ((0x01UL  << USIC_CH_PSR_ASCMode_TBIF_Pos) & \\" + NL + "                      USIC_CH_PSR_ASCMode_TBIF_Msk);" + NL + "  /* Receive fifo buffer configuration */" + NL + "  UartRegs->RBCTR |= (uint32_t)((((0x01UL   << USIC_CH_RBCTR_LOF_Pos) & \\" + NL + "                        USIC_CH_RBCTR_LOF_Msk)));" + NL + "   /* Fifo trigger level configuration as per user selected mode */";
  protected final String TEXT_20 = NL + "  if((Handle->DMAMode == UART002_DMA_NONE) || \\" + NL + "                              (Handle->DMAMode == UART002_RX_DMA) )" + NL + "  {" + NL + "    UartRegs->TBCTR |= (uint32_t)(((uint32_t)Handle->TxFIFOTrigger  << \\" + NL + "                 USIC_CH_TBCTR_LIMIT_Pos ) & USIC_CH_TBCTR_LIMIT_Msk);" + NL + "  }" + NL + "  else ";
  protected final String TEXT_21 = NL + "  {" + NL + "     UartRegs->TBCTR |= \\" + NL + "    \t\t (uint32_t)(((0x1UL)  << \\" + NL + "                 USIC_CH_TBCTR_LIMIT_Pos ) & USIC_CH_TBCTR_LIMIT_Msk);" + NL + "  }" + NL + "  " + NL + "  /* Configure Parity*/" + NL + "  UartRegs->CCR &= ~((uint32_t)USIC_CH_CCR_PM_Msk);" + NL + "  UartRegs->CCR |= (uint32_t)( ((UART_MODE  & USIC_CH_CCR_MODE_Msk)) | \\" + NL + "  (((uint32_t)(Handle->ChConfig.Parity)  << USIC_CH_CCR_PM_Pos) & \\" + NL + "  USIC_CH_CCR_PM_Msk));" + NL + "    " + NL + "}" + NL;
  protected final String TEXT_22 = NL + "#ifdef UART_DMA_ENABLED" + NL + "static void UART002_lFindMSize" + NL + "(" + NL + " UART002_HandleType* Handle," + NL + " DMA003_ChannelConfigType* Config," + NL + " uint16_t BlockSize" + NL + ")" + NL + "{" + NL + "\tif(BlockSize < 4)" + NL + "\t{" + NL + "\t\tConfig->SrcMSize      =  DMA_MSIZE_1;" + NL + "\t\tConfig->DstMSize      =  DMA_MSIZE_1;" + NL + "    Handle->DynamicData->Msize = 1;" + NL + "\t}" + NL + "\telse if(BlockSize < 8)" + NL + "\t{" + NL + "\t\tConfig->SrcMSize      =  DMA_MSIZE_4;" + NL + "\t\tConfig->DstMSize      =  DMA_MSIZE_4;" + NL + "    Handle->DynamicData->Msize = 4;" + NL + "\t}" + NL + "\telse" + NL + "\t{" + NL + "\t\tConfig->SrcMSize      =  DMA_MSIZE_8;" + NL + "\t\tConfig->DstMSize      =  DMA_MSIZE_8;" + NL + "    Handle->DynamicData->Msize = 8;" + NL + "\t}" + NL + "}" + NL + "#endif";
  protected final String TEXT_23 = NL + NL + "/*******************************************************************************" + NL + "**                      Public Function Definitions                           **" + NL + "*******************************************************************************/" + NL + "void UART002_Init(void)" + NL + "{";
  protected final String TEXT_24 = NL + " /* Disable the USIC0 clock gating */" + NL + " /* " + NL + "  * The disabling of the clock gating is applicable only for" + NL + "  * XMC4400, XMC4200 and XMC1000 devices." + NL + "  */";
  protected final String TEXT_25 = NL + "  SCU_GENERAL->PASSWD = 0x000000C0UL;" + NL + "  WR_REG(SCU_CLK->CLKCR, SCU_CLK_CLKCR_CNTADJ_Msk, \\" + NL + "                               SCU_CLK_CLKCR_CNTADJ_Pos,CLK002_DELAYCNT);";
  protected final String TEXT_26 = NL + "  SET_BIT(SCU_CLK->CGATCLR0, SCU_CLK_CGATCLR0_USIC0_Pos);";
  protected final String TEXT_27 = NL + "  while ((SCU_CLK->CLKCR)&(SCU_CLK_CLKCR_VDDC2LOW_Msk))" + NL + "  {" + NL + "     ;" + NL + "  }" + NL + "  SCU_GENERAL->PASSWD = 0x000000C3UL;   ";
  protected final String TEXT_28 = " ";
  protected final String TEXT_29 = " ";
  protected final String TEXT_30 = NL + "  /* Reset the Peripheral*/" + NL + "  RESET001_DeassertReset(PER0_USIC";
  protected final String TEXT_31 = "); ";
  protected final String TEXT_32 = "  ";
  protected final String TEXT_33 = NL + " /* Disable the USIC1 clock gating */" + NL + " /* " + NL + "  * The disabling of the clock gating is applicable only for" + NL + "  * XMC4400, XMC4200 and XMC1000 devices." + NL + "  */";
  protected final String TEXT_34 = NL + "  SCU_GENERAL->PASSWD = 0x000000C0UL;" + NL + "  WR_REG(SCU_CLK->CLKCR, SCU_CLK_CLKCR_CNTADJ_Msk, \\" + NL + "                                SCU_CLK_CLKCR_CNTADJ_Pos,CLK002_DELAYCNT);";
  protected final String TEXT_35 = NL + "  SET_BIT(SCU_CLK->CGATCLR1, SCU_CLK_CGATCLR1_USIC1_Pos);";
  protected final String TEXT_36 = NL + "  while ((SCU_CLK->CLKCR)&(SCU_CLK_CLKCR_VDDC2LOW_Msk))" + NL + "  {" + NL + "\t  ;" + NL + "  }" + NL + "  SCU_GENERAL->PASSWD = 0x000000C3UL;     ";
  protected final String TEXT_37 = NL + "  /* Reset the Peripheral*/" + NL + "  RESET001_DeassertReset(PER1_USIC";
  protected final String TEXT_38 = "); ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = NL + "  " + NL + "  UART002_lInit(&UART002_Handle";
  protected final String TEXT_41 = "); ";
  protected final String TEXT_42 = NL + "  NVIC_SetPriority((IRQn_Type)";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ");" + NL + "  NVIC_SetPriority((IRQn_Type)";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ");";
  protected final String TEXT_47 = NL + "  NVIC_SetPriority((IRQn_Type)";
  protected final String TEXT_48 = ",NVIC_EncodePriority(NVIC_GetPriorityGrouping(),\\" + NL + "\t\t                          ";
  protected final String TEXT_49 = "U,";
  protected final String TEXT_50 = "U));" + NL + "  NVIC_SetPriority((IRQn_Type)";
  protected final String TEXT_51 = ",NVIC_EncodePriority(NVIC_GetPriorityGrouping(),\\" + NL + "\t\t                          ";
  protected final String TEXT_52 = "U,";
  protected final String TEXT_53 = "U));";
  protected final String TEXT_54 = "  " + NL + "  NVIC_EnableIRQ((IRQn_Type)";
  protected final String TEXT_55 = ");" + NL + "  NVIC_EnableIRQ((IRQn_Type)";
  protected final String TEXT_56 = ");" + NL + "  UART002_Handle";
  protected final String TEXT_57 = ".DynamicData->ChannelSemId = \\" + NL + "        osSemaphoreCreate(osSemaphore(UART002_ChannelSemHandle";
  protected final String TEXT_58 = "),1);";
  protected final String TEXT_59 = "   ";
  protected final String TEXT_60 = "   ";
  protected final String TEXT_61 = NL + "  /* Configure TX Pin in Open-drain mode to allow the Wired-AND connection */" + NL + "  PORT";
  protected final String TEXT_62 = "->OMR |= ((uint32_t)0x01 << ";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "  PORT";
  protected final String TEXT_65 = "->IOCR0 |= (0x18 << ";
  protected final String TEXT_66 = ");";
  protected final String TEXT_67 = NL + "  PORT";
  protected final String TEXT_68 = "->IOCR4 |= (0x18 << ";
  protected final String TEXT_69 = ");";
  protected final String TEXT_70 = NL + "  PORT";
  protected final String TEXT_71 = "->IOCR8 |= (0x18 << ";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = NL + "  PORT";
  protected final String TEXT_74 = "->IOCR12 |= (0x18 << ";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = NL + "    ";
  protected final String TEXT_77 = NL + "  /* Configuration of TX Pin ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " based on User configuration */";
  protected final String TEXT_80 = NL + "  PORT";
  protected final String TEXT_81 = "->PDR0  &= (~(PORT";
  protected final String TEXT_82 = "_PDR0_PD";
  protected final String TEXT_83 = "_Msk));";
  protected final String TEXT_84 = NL + "  PORT";
  protected final String TEXT_85 = "->PDR0  |= (((uint32_t)";
  protected final String TEXT_86 = " << PORT";
  protected final String TEXT_87 = "_PDR0_PD";
  protected final String TEXT_88 = "_Pos) & \\" + NL + "                                             PORT";
  protected final String TEXT_89 = "_PDR0_PD";
  protected final String TEXT_90 = "_Msk);";
  protected final String TEXT_91 = NL + "  PORT";
  protected final String TEXT_92 = "->PDR1 &= (~(PORT";
  protected final String TEXT_93 = "_PDR1_PD";
  protected final String TEXT_94 = "_Msk));";
  protected final String TEXT_95 = NL + "  PORT";
  protected final String TEXT_96 = "->PDR1 |= (((uint32_t)";
  protected final String TEXT_97 = " << PORT";
  protected final String TEXT_98 = "_PDR1_PD";
  protected final String TEXT_99 = "_Pos) & \\" + NL + "                                        PORT";
  protected final String TEXT_100 = "_PDR1_PD";
  protected final String TEXT_101 = "_Msk);    ";
  protected final String TEXT_102 = " ";
  protected final String TEXT_103 = NL + "  /* TXPIN instance (no.";
  protected final String TEXT_104 = ") is not mapped to any port pin. */";
  protected final String TEXT_105 = " " + NL + "  /* Configuration of RX Pin ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " based on User configuration */";
  protected final String TEXT_108 = NL;
  protected final String TEXT_109 = " ";
  protected final String TEXT_110 = NL + "  PORT";
  protected final String TEXT_111 = "->IOCR0 |= ((uint32_t)";
  protected final String TEXT_112 = " << ";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "  PORT";
  protected final String TEXT_115 = "->IOCR4 |= ((uint32_t)";
  protected final String TEXT_116 = " << ";
  protected final String TEXT_117 = ");";
  protected final String TEXT_118 = NL + "  PORT";
  protected final String TEXT_119 = "->IOCR8 |= ((uint32_t)";
  protected final String TEXT_120 = " << ";
  protected final String TEXT_121 = ");";
  protected final String TEXT_122 = NL + "  PORT";
  protected final String TEXT_123 = "->IOCR12 |= ((uint32_t)";
  protected final String TEXT_124 = " << ";
  protected final String TEXT_125 = ");";
  protected final String TEXT_126 = NL + " /* RXPIN instance (no.";
  protected final String TEXT_127 = ") is not mapped to any port pin. */";
  protected final String TEXT_128 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_129 = NL + "}" + NL + "" + NL + "/* Function will reset the App to default values */" + NL + "void UART002_Deinit(const UART002_HandleType* Handle)" + NL + "{" + NL + "" + NL + "  /* <<<DD_UART002_API_2>>>*/" + NL + "  /* Place holder function */ " + NL + "}" + NL + "" + NL + "" + NL + "/*" + NL + " *  This function initializes the Local Data structure allocated by" + NL + " *  the Task/App with default values configured through UI. " + NL + " *   This function also copies the App handle to the local data structure." + NL + "*/" + NL + "void UART002_LocalStructureInit" + NL + "(" + NL + "  const UART002_HandleType* Handle, " + NL + "  UART002_LocalStructType* Config," + NL + "  int32_t SignalId" + NL + ")" + NL + "{\t" + NL + "" + NL + "  /* <<<DD_UART002_API_3>>>*/" + NL + "  /* Copy the App handle to the local data structure App handle parameter */" + NL + "  Config->AppInstanceHandle = (uint32_t*)Handle;      " + NL + "  Config->pBuffer =  NULL;                " + NL + "  Config->DataLen =  0;                  " + NL + "  /* Store the signal id passed by Job Task*/" + NL + "  Config->SignalId = SignalId;" + NL + "  /* Get thread ID */" + NL + "  Config->ThreadID = osThreadGetId();" + NL + "  " + NL + "}" + NL + "" + NL + "" + NL + "/*" + NL + " * This function starts the  UART Reception . The Config structure" + NL + " * has the desired no of bytes to be received from the peer device." + NL + " * Timeout value is specified." + NL + "*/" + NL + "status_t UART002_StartReception(UART002_LocalStructType* Config, time_t Timeout)" + NL + "{" + NL + "  status_t Status = (status_t)UART002_FAIL;" + NL + "  int32_t SemStatus = 0;" + NL + "  UART002_HandleType* Handle = (UART002_HandleType*)Config->AppInstanceHandle;" + NL + "   /* <<<DD_UART002_API_4>>>*/" + NL + "  do" + NL + "  {" + NL + "     /* Checking for configuration errors */" + NL + "    if((Config->pBuffer == NULL) || (Config->DataLen == 0U))" + NL + "    {" + NL + "      Status = UART002_CONFIG_ERROR;" + NL + "      DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "      break;" + NL + "    }" + NL + "    /* Acquire semaphore of specified channel to start reception */" + NL + "    SemStatus = osSemaphoreWait(Handle->DynamicData->ChannelSemId, Timeout);" + NL + "    if(SemStatus == 0)                                                       " + NL + "    {" + NL + "      Status = UART002_TIMEOUT;" + NL + "      DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "      break;" + NL + "    }" + NL + "" + NL + "    /*Initialize the UART channel state to IDLE */" + NL + "    Config->Status =  UART002_IDLE; " + NL + "    /* Copy pBuffer to App Handle */" + NL + "    Handle->DynamicData->pBuffer = Config->pBuffer;" + NL + "    /* Copy Datalen to App Handle */" + NL + "    Handle->DynamicData->DataLen = Config->DataLen;" + NL + "    Handle->DynamicData->CurrentTaskStruct = Config;";
  protected final String TEXT_130 = "    " + NL + "    /* Check if DMA mode for transmission is enabled */" + NL + "    if((Handle->DMAMode == UART002_RX_DMA) || \\" + NL + "              (Handle->DMAMode == UART002_RX_TX_DMA) )" + NL + "    {" + NL + "#ifdef UART_DMA_ENABLED " + NL + "      Handle->RxDMAHandle->ChConfig.SrcAddress = \\" + NL + "                                 (uint32_t)&(Handle->UartRegs->OUTR);" + NL + "      /* Configure destination address */" + NL + "      Handle->RxDMAHandle->ChConfig.DstAddress = (uint32_t)Config->pBuffer;" + NL + "      /* Configure block size */" + NL + "      Handle->RxDMAHandle->ChConfig.BlockSize = Config->DataLen;" + NL + "      UART002_lFindMSize(Handle,&Handle->RxDMAHandle->ChConfig,Config->DataLen);" + NL + "      Handle->UartRegs->RBCTR |= (((uint32_t)(Handle->DynamicData->Msize-1) << \\" + NL + "                   USIC_CH_RBCTR_LIMIT_Pos) & USIC_CH_RBCTR_LIMIT_Msk);" + NL + "                   " + NL + "      /* Initilialize the DMA channel */" + NL + "      Status = \\" + NL + "       DMA003_SetChannelTransferParams(Handle->RxDMAHandle, \\" + NL + "                          &(Handle->RxDMAHandle->ChConfig));" + NL + "      if(Status != DAVEApp_SUCCESS)" + NL + "      {" + NL + "        Status = UART002_DMA_ERROR;" + NL + "        DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "        break;" + NL + "      }" + NL + "      DMA003_SetListener((Handle->RxDMAHandle),&UARTDmaRxListener,(uint32_t)Config);" + NL + "   \t  Status = DMA003_StartTransfer(Handle->RxDMAHandle);" + NL + "      if(Status != DAVEApp_SUCCESS)" + NL + "      {" + NL + "        Status = UART002_DMA_ERROR;" + NL + "        DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "        break;" + NL + "      }" + NL + "#endif      " + NL + "    }" + NL + "    else ";
  protected final String TEXT_131 = NL + "    {" + NL + "        Handle->UartRegs->RBCTR &= ~(USIC_CH_RBCTR_LIMIT_Msk);" + NL + "        if( Config->DataLen <= Handle->RxFIFOTrigger)" + NL + "        {" + NL + "       \t  Handle->UartRegs->RBCTR |= (uint32_t)(((uint32_t)(Config->DataLen -1U) << \\" + NL + "                   USIC_CH_RBCTR_LIMIT_Pos) & USIC_CH_RBCTR_LIMIT_Msk);" + NL + "        }" + NL + "        else" + NL + "        {" + NL + "    \t  Handle->UartRegs->RBCTR |= (uint32_t)(((uint32_t)Handle->RxFIFOTrigger << \\" + NL + "                   USIC_CH_RBCTR_LIMIT_Pos) & USIC_CH_RBCTR_LIMIT_Msk);" + NL + "        }" + NL + "    \t" + NL + "    }" + NL + "    Config->Status = UART002_TRANSFER_PENDING;" + NL + "    /* Enable standard receive buffer and error event */" + NL + "    Handle->UartRegs->RBCTR &= \\" + NL + "                              (~(((uint32_t)USIC_CH_RBCTR_SRBIEN_Msk) | \\" + NL + "                              ((uint32_t)USIC_CH_RBCTR_ARBIEN_Msk)));" + NL + "    Handle->UartRegs->RBCTR |= \\" + NL + "    \t\t\t\t\t  (uint32_t)(((0x01UL  << USIC_CH_RBCTR_SRBIEN_Pos) & \\" + NL + "                                              USIC_CH_RBCTR_SRBIEN_Msk) | \\" + NL + "                          ((uint32_t)(0x01UL  << USIC_CH_RBCTR_ARBIEN_Pos) & \\" + NL + "                                              USIC_CH_RBCTR_ARBIEN_Msk));" + NL + "    Status = (status_t)DAVEApp_SUCCESS;" + NL + "  }while(0);" + NL + "  return Status;" + NL + "}" + NL + "" + NL + "/**" + NL + " * This function starts the  UART Transmission. The Config structure" + NL + " * has the desired no of bytes to be transmitted to the peer device." + NL + " * Timeout value is also specified in case the channel is occupied by" + NL + " * some other task." + NL + "*/" + NL + "status_t UART002_StartTransmission" + NL + "(" + NL + "  UART002_LocalStructType* Config," + NL + "  time_t Timeout" + NL + ")" + NL + "{" + NL + "  status_t Status = (status_t)UART002_FAIL;" + NL + "  uint8_t SRno = 0U;" + NL + "  int32_t SemStatus = 0;" + NL + "  UART002_HandleType* Handle = (UART002_HandleType*)Config->AppInstanceHandle;" + NL + "   /* <<<DD_UART002_API_5>>>*/" + NL + "  do" + NL + "  {" + NL + "     /* Checking for configuration errors */" + NL + "    if((Config->pBuffer == NULL) || (Config->DataLen == 0U))" + NL + "    {" + NL + "      Status = (status_t)UART002_CONFIG_ERROR;" + NL + "      DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "      break;" + NL + "    }" + NL + "   /* Acquire semaphore of specified channel to start reception */" + NL + "    SemStatus = osSemaphoreWait(Handle->DynamicData->ChannelSemId, Timeout);" + NL + "    if(SemStatus == 0)                                                       " + NL + "    {" + NL + "      Status = (status_t)UART002_TIMEOUT;    " + NL + "      DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "      break;" + NL + "    }" + NL + "   " + NL + "    /* Copy pBuffer to App Handle */" + NL + "    Handle->DynamicData->pBuffer = Config->pBuffer;" + NL + "    /* Copy Datalen to App Handle */" + NL + "    Handle->DynamicData->DataLen = Config->DataLen;" + NL + "    /* Copy the current task structure to global App handle */" + NL + "    Handle->DynamicData->CurrentTaskStruct = Config;";
  protected final String TEXT_132 = "     " + NL + "    /* Check if DMA mode for transmission is enabled */" + NL + "    if((Handle->DMAMode == UART002_TX_DMA )|| \\" + NL + "              (Handle->DMAMode == UART002_RX_TX_DMA ))" + NL + "    {" + NL + "#ifdef UART_DMA_ENABLED  " + NL + "      /* Configure destination address */" + NL + "      Handle->TxDMAHandle->ChConfig.SrcAddress = (uint32_t)Config->pBuffer;" + NL + "      Handle->TxDMAHandle->ChConfig.DstAddress = \\" + NL + "                                  (uint32_t)&(Handle->UartRegs->IN[0]); " + NL + "      /* Configure block size */" + NL + "      Handle->TxDMAHandle->ChConfig.BlockSize = Config->DataLen;" + NL + "      UART002_lFindMSize(Handle,&Handle->TxDMAHandle->ChConfig,Config->DataLen);      " + NL + "      /* Initilialize the DMA channel */" + NL + "      Status = \\" + NL + "      DMA003_SetChannelTransferParams(Handle->TxDMAHandle, \\" + NL + "                         &(Handle->TxDMAHandle->ChConfig));" + NL + "      if(Status != DAVEApp_SUCCESS)" + NL + "      {" + NL + "        Status = UART002_DMA_ERROR;" + NL + "        DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "        break;" + NL + "      }" + NL + "      DMA003_SetListener((Handle->TxDMAHandle),&UARTDmaTxListener,(uint32_t)Config);" + NL + "      Status = DMA003_StartTransfer(Handle->TxDMAHandle);" + NL + "      if(Status != DAVEApp_SUCCESS)" + NL + "      {" + NL + "        Status = UART002_DMA_ERROR;" + NL + "        DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "        break;" + NL + "      }" + NL + "#endif" + NL + "    } ";
  protected final String TEXT_133 = NL + "    /* Enable standard transmit and error event interrupt */" + NL + "    Handle->UartRegs->TBCTR &= \\" + NL + "                                (~(((uint32_t)USIC_CH_TBCTR_STBIEN_Msk) | \\" + NL + "                                ((uint32_t)USIC_CH_TBCTR_TBERIEN_Msk)));" + NL + "    Handle->UartRegs->TBCTR |= \\" + NL + "    \t\t\t\t\t(uint32_t)(((0x01UL  << USIC_CH_TBCTR_STBIEN_Pos) & \\" + NL + "                                                USIC_CH_TBCTR_STBIEN_Msk) | \\" + NL + "                        ((uint32_t)(0x01UL  << USIC_CH_TBCTR_TBERIEN_Pos) & \\" + NL + "                                                USIC_CH_TBCTR_TBERIEN_Msk));" + NL + "    SRno = (uint8_t)((Handle->UartRegs->TBCTR \\" + NL + "               & USIC_CH_TBCTR_STBINP_Msk) >> (uint32_t)USIC_CH_TBCTR_STBINP_Pos);" + NL + "    Config->Status = UART002_TRANSFER_PENDING;" + NL + "    /* Trigger standard transmit interrupt by setting FMR.SIOx bit */" + NL + "    Handle->UartRegs->FMR |= \\" + NL + "    \t\t\t\t\t(uint32_t)(0x01UL << ((uint8_t)USIC_CH_FMR_SIO0_Pos + SRno));" + NL + "    Status = (status_t)DAVEApp_SUCCESS;" + NL + "  }while(0);" + NL + "  return Status;" + NL + "}" + NL + "" + NL + "/*  This function waits for transfer completion or till timeout occurs. */" + NL + "status_t UART002_WaitForCompletion" + NL + "(" + NL + "  const UART002_LocalStructType* Config, " + NL + "  time_t Timeout" + NL + ")" + NL + "{" + NL + "  status_t Status = (status_t)UART002_FAIL;" + NL + "  osEvent Event;" + NL + "  /* <<<DD_UART002_API_6>>>*/" + NL + "  /* Block the task till the semaphore is released */" + NL + "    /* Wait for completion of do-that */" + NL + "   Event = osSignalWait(Config->SignalId, Timeout);" + NL + "  " + NL + "   if(Event.status == osEventTimeout)" + NL + "   {" + NL + "     /* Timeout occured */" + NL + "     Status = (status_t)UART002_TIMEOUT;" + NL + "     DBG002_ERROR(APP_GID, DBG002_MESSAGEID_LITERAL, sizeof(Status), &Status);" + NL + "   }" + NL + "   else" + NL + "   {" + NL + "     Status = (status_t)DAVEApp_SUCCESS;" + NL + "   }" + NL + "  return Status;" + NL + "}" + NL + "" + NL + "" + NL + "/*" + NL + " * This function gets the result of  the transfer operation which was" + NL + " * scheduled earlier." + NL + "*/" + NL + "status_t UART002_GetStatus(const UART002_LocalStructType* Config)" + NL + "{" + NL + "  /* <<<DD_UART002_API_7>>>*/" + NL + "  /* Return channel status */" + NL + "  return (status_t)Config->Status;" + NL + "}" + NL;
  protected final String TEXT_134 = NL;
  protected final String TEXT_135 = NL + NL + "/* Standard transmit buffer event handler */" + NL + "void IRQ_Hdlr_";
  protected final String TEXT_136 = "(void)" + NL + "{" + NL + "   UART002_LocalStructType* CurrentLocalStruct = \\" + NL + "   UART002_Handle";
  protected final String TEXT_137 = ".DynamicData->CurrentTaskStruct;" + NL + "  /* <<<DD_UART002_non_API_3>>>*/" + NL + "  /* Clear standard transmit buffer Event bit */" + NL + "  UART002_Handle";
  protected final String TEXT_138 = ".UartRegs->TRBSCR |= (uint32_t)USIC_CH_TRBSCR_CSTBI_Msk;" + NL + "  ";
  protected final String TEXT_139 = "  " + NL + "  /* If not in DMA mode */" + NL + "  if((UART002_Handle";
  protected final String TEXT_140 = ".DMAMode == UART002_DMA_NONE) || \\" + NL + "      (UART002_Handle";
  protected final String TEXT_141 = ".DMAMode == UART002_RX_DMA) ) ";
  protected final String TEXT_142 = NL + "  {" + NL + "\tif(UART002_Handle";
  protected final String TEXT_143 = ".DynamicData->DataLen == 0U)" + NL + "\t{" + NL + "        /* Transfer Success release the semaphore */" + NL + "        CurrentLocalStruct->Status = UART002_TRANSFER_SUCCESS;" + NL + "        /* Disable standard transmit and error event interrupt */" + NL + "        UART002_Handle";
  protected final String TEXT_144 = ".UartRegs->TBCTR &= \\" + NL + "                       ~(((uint32_t)USIC_CH_TBCTR_STBIEN_Msk) | \\" + NL + "                       ((uint32_t)USIC_CH_TBCTR_TBERIEN_Msk));" + NL + "\t\t/* Signal the task that Job is complete */" + NL + "\t\tosSignalSet(CurrentLocalStruct->ThreadID,CurrentLocalStruct->SignalId);" + NL + "        /* Release channel semaphore */" + NL + "\t\tosSemaphoreRelease(UART002_Handle";
  protected final String TEXT_145 = ".DynamicData->ChannelSemId);" + NL + "\t}" + NL + "    /* Write to FIFO till Fifo is full */" + NL + "    while((USIC_IsTxFIFOfull(UART002_Handle";
  protected final String TEXT_146 = ".UartRegs) != 1U)&& \\" + NL + "                       (UART002_Handle";
  protected final String TEXT_147 = ".DynamicData->DataLen != 0U) )" + NL + "    {" + NL + "      while(USIC_IsTxFIFObusy(UART002_Handle";
  protected final String TEXT_148 = ".UartRegs))" + NL + "      {}" + NL + "      UART002_Handle";
  protected final String TEXT_149 = ".UartRegs->IN[0] = \\" + NL + "            *(UART002_Handle";
  protected final String TEXT_150 = ".DynamicData->pBuffer);" + NL + "      UART002_Handle";
  protected final String TEXT_151 = ".DynamicData->pBuffer++;" + NL + "      UART002_Handle";
  protected final String TEXT_152 = ".DynamicData->DataLen--;" + NL + "      /* Check if all data is transmitted */" + NL + "      if(UART002_Handle";
  protected final String TEXT_153 = ".DynamicData->DataLen == 0U)" + NL + "      {" + NL + "    \tbreak;" + NL + "      }" + NL + "    }" + NL + "  }" + NL + "      " + NL + "}" + NL + "" + NL + "/* Standard Receive buffer event handler */" + NL + "void IRQ_Hdlr_";
  protected final String TEXT_154 = "(void)" + NL + "{" + NL + "  UART002_LocalStructType* CurrentLocalStruct = \\" + NL + "    UART002_Handle";
  protected final String TEXT_155 = ".DynamicData->CurrentTaskStruct;" + NL + "\t  /* <<<DD_UART002_non_API_4>>>*/" + NL + "  /* Clear standard receive buffer Event bit */" + NL + "  UART002_Handle";
  protected final String TEXT_156 = ".UartRegs->TRBSCR |= (uint32_t)USIC_CH_TRBSCR_CSRBI_Msk;" + NL + "  ";
  protected final String TEXT_157 = "  " + NL + "  if((UART002_Handle";
  protected final String TEXT_158 = ".DMAMode == UART002_DMA_NONE) || \\" + NL + "                                (UART002_Handle";
  protected final String TEXT_159 = ".DMAMode == UART002_TX_DMA) ) ";
  protected final String TEXT_160 = NL + "  {" + NL + "    while(USIC_ubIsRxFIFOempty(UART002_Handle";
  protected final String TEXT_161 = ".UartRegs) != 1U)" + NL + "    {" + NL + "      while(USIC_IsRxFIFObusy(UART002_Handle";
  protected final String TEXT_162 = ".UartRegs))" + NL + "      {}" + NL + "      *(UART002_Handle";
  protected final String TEXT_163 = ".DynamicData->pBuffer) = \\" + NL + "                           (uint8_t)UART002_Handle";
  protected final String TEXT_164 = ".UartRegs->OUTR;" + NL + "      UART002_Handle";
  protected final String TEXT_165 = ".DynamicData->pBuffer++;" + NL + "      UART002_Handle";
  protected final String TEXT_166 = ".DynamicData->DataLen--;" + NL + "      if(UART002_Handle";
  protected final String TEXT_167 = ".DynamicData->DataLen == 0U)" + NL + "      {" + NL + "        /* Transfer Success release the semaphore */" + NL + "        CurrentLocalStruct->Status = UART002_TRANSFER_SUCCESS;" + NL + "        /* Disable standard receive buffer and error event */" + NL + "        UART002_Handle";
  protected final String TEXT_168 = ".UartRegs->RBCTR &= \\" + NL + "                ~((uint32_t)(USIC_CH_RBCTR_SRBIEN_Msk) | \\" + NL + "                 (uint32_t)(USIC_CH_RBCTR_ARBIEN_Msk));" + NL + "        USIC_FlushRxFIFO(UART002_Handle";
  protected final String TEXT_169 = ".UartRegs);" + NL + "        /* Signal the task that Job is complete */" + NL + "\t\t    osSignalSet(CurrentLocalStruct->ThreadID,CurrentLocalStruct->SignalId);" + NL + "        /* Release channel semaphore */" + NL + "\t\t    osSemaphoreRelease(UART002_Handle";
  protected final String TEXT_170 = ".DynamicData->ChannelSemId);" + NL + "        break;" + NL + "      }" + NL + "    }" + NL + "    if((UART002_Handle";
  protected final String TEXT_171 = ".DynamicData->DataLen < \\" + NL + "    \t\t  (uint16_t)UART002_Handle";
  protected final String TEXT_172 = ".RxFIFOTrigger) \\" + NL + "              && (UART002_Handle";
  protected final String TEXT_173 = ".DynamicData->DataLen > 0U) )" + NL + "    {" + NL + "      UART002_Handle";
  protected final String TEXT_174 = ".UartRegs->RBCTR &= (uint32_t)~USIC_CH_RBCTR_LIMIT_Msk;" + NL + "      UART002_Handle";
  protected final String TEXT_175 = ".UartRegs->RBCTR |= " + NL + "    \t\t                    ((((UART002_Handle";
  protected final String TEXT_176 = ".DynamicData->DataLen) - 1)  << \\" + NL + "                                            USIC_CH_RBCTR_LIMIT_Pos) & USIC_CH_RBCTR_LIMIT_Msk);" + NL + "    }\t" + NL + "  }";
  protected final String TEXT_177 = "                                " + NL + "  else" + NL + "  {" + NL + "\t  UART002_Handle";
  protected final String TEXT_178 = ".DynamicData->DataLen = \\" + NL + "      UART002_Handle";
  protected final String TEXT_179 = ".DynamicData->DataLen - UART002_Handle";
  protected final String TEXT_180 = ".DynamicData->Msize;" + NL + "\t  if((UART002_Handle";
  protected final String TEXT_181 = ".DynamicData->DataLen < \\" + NL + "       UART002_Handle";
  protected final String TEXT_182 = ".DynamicData->Msize) && \\" + NL + "       (UART002_Handle";
  protected final String TEXT_183 = ".DynamicData->DataLen > 0U))" + NL + "\t  {" + NL + "\t\t  UART002_Handle";
  protected final String TEXT_184 = ".UartRegs->RBCTR &= ~((uint32_t)USIC_CH_RBCTR_LIMIT_Msk);" + NL + "\t\t  UART002_Handle";
  protected final String TEXT_185 = ".UartRegs->RBCTR |= \\" + NL + "\t\t        \t            ((((UART002_Handle";
  protected final String TEXT_186 = ".DynamicData->DataLen)-1UL)  << \\" + NL + "\t\t        \t                        USIC_CH_RBCTR_LIMIT_Pos) & USIC_CH_RBCTR_LIMIT_Msk);" + NL + "" + NL + "\t  }" + NL + "  } ";
  protected final String TEXT_187 = NL + "}";
  protected final String TEXT_188 = NL + "/* CHANNEL IS NOT MAPPED */";
  protected final String TEXT_189 = NL + NL + NL + "/*CODE_BLOCK_END*/";
  protected final String TEXT_190 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     App2JetInterface app = (App2JetInterface) argument; 
     String AppBaseuri = "app/uart002/0";
    stringBuffer.append(TEXT_1);
    stringBuffer.append( app.getAppVersion(AppBaseuri));
    stringBuffer.append(TEXT_2);
     String TempApps = null;
   String MyAppName = null;
   ArrayList<String> apps;
   String TempLowerApps = null; 
   boolean DBGApp = false;   
   apps=(ArrayList<String>)(app.getApps());
        for (int k = 0; k < apps.size(); k++) {
              TempApps = apps.get(k);
/*            if(app.isAppInitProvider(apps.get(k)) == true) { */
              MyAppName = TempApps.substring(TempApps.indexOf("/app/") + 5, TempApps.lastIndexOf("/"));
              TempLowerApps = MyAppName.toLowerCase();
              if (TempLowerApps.equalsIgnoreCase("dbg002")) {DBGApp = true;}   
/*   } */ 
  } 
    stringBuffer.append(TEXT_3);
     if (!DBGApp) { 
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
     String Baseuri = "app/uart002/";
     String Uarturi = "peripheral/usic/"; 
     String MappedUri = null; 
     String UnitInst = null; 
     String appInst  = null; 
     double clockfreq = 0; 
    stringBuffer.append(TEXT_6);
     int Is44Device = -1; 
     int Is42Device = -1; 
     int Is45Device = -1; 
     int Is1xDevice = -1; 
     String deviceId = null; 
     deviceId = app.getSoftwareId(); 
     if (deviceId != null)
{      
   Is44Device = ((deviceId.substring(0,2).compareTo("44")==0)?1:0);
   Is42Device = ((deviceId.substring(0,2).compareTo("42")==0)?1:0);
   Is45Device = ((deviceId.substring(0,2).compareTo("45")==0)?1:0);
   Is1xDevice = ((deviceId.substring(0,1).compareTo("1")==0)?1:0); 	
}
    stringBuffer.append(TEXT_7);
     ArrayList<String> appsList7 = (ArrayList<String>)(app.getApps("app/uart002/"));
 for (String appIns : appsList7 ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(Baseuri + appInst + "/channel"); 
     if((MappedUri != null) && (MappedUri != "")) { 
 UnitInst = MappedUri.substring(MappedUri .length()-11,MappedUri.indexOf("/channel/")); 
 int Unit = Integer.parseInt(UnitInst); 
     if(Is1xDevice == 1){
   clockfreq = app.getDoubleValue (Baseuri + appInst + "/clockapp2/clk002_irMCLK" );
   }
   else if ((Is45Device==1)||(Is44Device==1)||(Is42Device==1)){
   clockfreq = app.getDoubleValue (Baseuri + appInst + "/clockapp/clk001_iroActualFreqPB" );
   }
   else{}
   
    stringBuffer.append(TEXT_8);
    stringBuffer.append( clockfreq);
    stringBuffer.append(TEXT_9);
    break;
     } 
     else { 
    stringBuffer.append(TEXT_10);
     } 
    } 
    stringBuffer.append(TEXT_11);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
     ArrayList<String> appsList6 = (ArrayList<String>)(app.getApps("app/uart002/"));
 for (String appIns : appsList6 ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(Baseuri + appInst + "/channel"); 
     if((MappedUri != null) && (MappedUri != "")) { 
 UnitInst = MappedUri.substring(MappedUri .length()-11,MappedUri.indexOf("/channel/")); 
 int Unit = Integer.parseInt(UnitInst); 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_15);
     } 
     else { 
    stringBuffer.append(TEXT_16);
     } 
    } 
    stringBuffer.append(TEXT_17);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_18);
    } 
    stringBuffer.append(TEXT_19);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
     String MappedUri2 = null; 
     String MappedUri3 = null; 
     String nvicInst1 = null; 
     String nvicInst2 = null; 
     ArrayList<String> appsList = (ArrayList<String>)(app.getApps("app/uart002/"));
 for (String appIns : appsList ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(Baseuri + appInst + "/channel"); 
     MappedUri2 = app.getMappedUri(Baseuri + appInst + "/nvicstbinode"); 
     MappedUri3 = app.getMappedUri(Baseuri + appInst + "/nvicsrbinode"); 
     nvicInst1 = MappedUri2.substring(MappedUri2.indexOf("/interrupt/")+11,MappedUri2.length()); 
     nvicInst2 = MappedUri3.substring(MappedUri3.indexOf("/interrupt/")+11,MappedUri3.length()); 
     int Offset1 = Integer.parseInt(nvicInst1);
     int Offset2 = Integer.parseInt(nvicInst2);
     int Prioritystbi =0; 
     int SubPrioritystbi =0; 
     int Prioritysrbi =0; 
     int SubPrioritysrbi = 0; 
     if(Is1xDevice==1) {
  Prioritystbi = app.getIntegerValue(Baseuri + appInst +"/uart002_TIMMirwstInterruptPriority");
  Prioritysrbi = app.getIntegerValue(Baseuri + appInst +"/uart002_TIMMirwsrInterruptPriority");
} else {
  Prioritystbi = app.getIntegerValue(Baseuri + appInst +"/uart002_irwstbiInterruptPriority");
  SubPrioritystbi = app.getIntegerValue(Baseuri + appInst +"/uart002_irwstbiInterruptSubPriority");
  Prioritysrbi = app.getIntegerValue(Baseuri + appInst +"/uart002_irwsrbiInterruptPriority");
  SubPrioritysrbi = app.getIntegerValue(Baseuri + appInst +"/uart002_irwsrbiInterruptSubPriority");
}
     if((MappedUri != null) && (MappedUri != "")) { 
 UnitInst = MappedUri.substring(MappedUri .length()-11,MappedUri.indexOf("/channel/")); 
 int Unit = Integer.parseInt(UnitInst); 
     if(Unit == 0)  { 
    if ((Is44Device==1)||(Is42Device==1)||(Is1xDevice==1))
  {
    stringBuffer.append(TEXT_24);
    if ((Is1xDevice==1))  {
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    if ((Is1xDevice==1))    {
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    if ((Is45Device==1)||(Is44Device==1)||(Is42Device==1))
  {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(UnitInst);
    stringBuffer.append(TEXT_31);
    }
     } else { 
    stringBuffer.append(TEXT_32);
    if ((Is44Device==1)||(Is42Device==1)||(Is1xDevice==1))
  {
    stringBuffer.append(TEXT_33);
    if ((Is1xDevice==1))  {
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    if ((Is1xDevice==1)) {
    stringBuffer.append(TEXT_36);
    }
    }
    if ((Is45Device==1)||(Is44Device==1)||(Is42Device==1))
{
    stringBuffer.append(TEXT_37);
    stringBuffer.append(UnitInst);
    stringBuffer.append(TEXT_38);
     } 
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_41);
     if(Is1xDevice ==1) 
    { 
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nvicInst1);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(Prioritystbi);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(nvicInst2);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(Prioritysrbi);
    stringBuffer.append(TEXT_46);
    } 
     else 
    { 
    stringBuffer.append(TEXT_47);
    stringBuffer.append(nvicInst1);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(Prioritystbi);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(SubPrioritystbi);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(nvicInst2);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(Prioritysrbi);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(SubPrioritysrbi);
    stringBuffer.append(TEXT_53);
    } 
    stringBuffer.append(TEXT_54);
    stringBuffer.append(nvicInst1);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(nvicInst2);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_58);
     String pinUri = app.getMappedUri(Baseuri + appInst +"/uart_txpin"); 
     if ((pinUri != null) && (pinUri.trim() != "")) { 
     String portNo = pinUri.substring(pinUri.indexOf("port/p/")+7,pinUri.indexOf("/pad/")); 
     String pinNo = pinUri.substring(pinUri.indexOf("/pad/")+5,pinUri.length()); 
    stringBuffer.append(TEXT_59);
     int PDR_PD1 = app.getIntegerValue(Baseuri + appInst +"/uart_txpin/pdr_pd"); 
     int Pin = Integer.parseInt(pinNo);
    stringBuffer.append(TEXT_60);
     int Oper_Mode = app.getIntegerValue(Baseuri + appInst +"/uart002_OprModeTemp"); 
    if ((Oper_Mode == 1)) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(pinNo);
    stringBuffer.append(TEXT_63);
    if(Pin < 4) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_65);
    stringBuffer.append((3+(Pin*8)));
    stringBuffer.append(TEXT_66);
    }else if (Pin >= 4 && Pin <= 7) {  
  Pin = Pin - 4; 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_68);
    stringBuffer.append((3+(Pin*8)));
    stringBuffer.append(TEXT_69);
    } else if (Pin >= 8 && Pin <= 11) { 
  Pin = Pin - 8; 
    stringBuffer.append(TEXT_70);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_71);
    stringBuffer.append((3+(Pin*8)));
    stringBuffer.append(TEXT_72);
    } else if (Pin >= 12 && Pin <= 15) { 
  Pin = Pin - 12; 
    stringBuffer.append(TEXT_73);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_74);
    stringBuffer.append((3+(Pin*8)));
    stringBuffer.append(TEXT_75);
    }}
    stringBuffer.append(TEXT_76);
    if ((Is45Device==1)||(Is44Device==1)||(Is42Device==1))
  {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(pinNo);
    stringBuffer.append(TEXT_79);
     if(Pin < 8) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_83);
     if(PDR_PD1 != 0) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(PDR_PD1);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_90);
     }
     } else {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_94);
     if(PDR_PD1 != 0) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(PDR_PD1);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(portNo);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(Pin);
    stringBuffer.append(TEXT_101);
    }
    }
    stringBuffer.append(TEXT_102);
    }} else { 
    stringBuffer.append(TEXT_103);
    stringBuffer.append( appInst );
    stringBuffer.append(TEXT_104);
    }
     String pinUri2 = app.getMappedUri(Baseuri + appInst +"/uart_rxpin"); 
     if ((pinUri2 != null) && (pinUri2.trim() != "")) { 
     String portNo2 = pinUri2.substring(pinUri2.indexOf("port/p/")+7,pinUri2.indexOf("/pad/")); 
     String pinNo2 = pinUri2.substring(pinUri2.indexOf("/pad/")+5,pinUri2.length());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(portNo2);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(pinNo2);
    stringBuffer.append(TEXT_107);
     int Pin2 = Integer.parseInt(pinNo2);
     int IOCR_PCR = app.getIntegerValue(Baseuri + appInst +"/uart002_inputchardummy");
    stringBuffer.append(TEXT_108);
     if(IOCR_PCR != 0) {
    stringBuffer.append(TEXT_109);
     if(Pin2 < 4) { 
    stringBuffer.append(TEXT_110);
    stringBuffer.append(portNo2);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(IOCR_PCR);
    stringBuffer.append(TEXT_112);
    stringBuffer.append((3+(Pin2*8)));
    stringBuffer.append(TEXT_113);
    }else if (Pin2 >= 4 && Pin2 <= 7) {  
  Pin2 = Pin2 - 4; 
    stringBuffer.append(TEXT_114);
    stringBuffer.append(portNo2);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(IOCR_PCR);
    stringBuffer.append(TEXT_116);
    stringBuffer.append((3+(Pin2*8)));
    stringBuffer.append(TEXT_117);
    } else if (Pin2 >= 8 && Pin2 <= 11) { 
  Pin2 = Pin2 - 8; 
    stringBuffer.append(TEXT_118);
    stringBuffer.append(portNo2);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(IOCR_PCR);
    stringBuffer.append(TEXT_120);
    stringBuffer.append((3+(Pin2*8)));
    stringBuffer.append(TEXT_121);
    } else if (Pin2 >= 12 && Pin2 <= 15) { 
  Pin2 = Pin2 - 12; 
    stringBuffer.append(TEXT_122);
    stringBuffer.append(portNo2);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(IOCR_PCR);
    stringBuffer.append(TEXT_124);
    stringBuffer.append((3+(Pin2*8)));
    stringBuffer.append(TEXT_125);
    }} else { 
    stringBuffer.append(TEXT_126);
    stringBuffer.append( appInst );
    stringBuffer.append(TEXT_127);
    }}} 
     else { 
    stringBuffer.append(TEXT_128);
     } 
    } 
    stringBuffer.append(TEXT_129);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_132);
    }
    stringBuffer.append(TEXT_133);
     ArrayList<String> appsList3 = (ArrayList<String>)(app.getApps("app/uart002/"));
 for (String appIns : appsList3 ) {
 appInst = appIns.substring(appIns.lastIndexOf("/")+1);
     MappedUri = app.getMappedUri(Baseuri + appInst + "/channel"); 
     MappedUri2 = app.getMappedUri(Baseuri + appInst + "/nvicstbinode"); 
     MappedUri3 = app.getMappedUri(Baseuri + appInst + "/nvicsrbinode"); 
     nvicInst1 = MappedUri2.substring(MappedUri2.indexOf("/interrupt/")+11,MappedUri2.length()); 
     nvicInst2 = MappedUri3.substring(MappedUri3.indexOf("/interrupt/")+11,MappedUri3.length()); 
     int Offset1 = Integer.parseInt(nvicInst1);
     int Offset2 = Integer.parseInt(nvicInst2);
    stringBuffer.append(TEXT_134);
     if((MappedUri != null) && (MappedUri != "")) { 
    stringBuffer.append(TEXT_135);
    stringBuffer.append(Offset1);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_138);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_139);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_141);
    }
    stringBuffer.append(TEXT_142);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(Offset2);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_156);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_157);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_159);
    }
    stringBuffer.append(TEXT_160);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_166);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_167);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_176);
     if(Is1xDevice == 0){ 
    stringBuffer.append(TEXT_177);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(appInst);
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
     } 
     else { 
    stringBuffer.append(TEXT_188);
     } 
    } 
    stringBuffer.append(TEXT_189);
    stringBuffer.append(TEXT_190);
    return stringBuffer.toString();
  }
}
