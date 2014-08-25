################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../Dave/Generated/src/RTOS001/SRC/HAL_CM.c \
../Dave/Generated/src/RTOS001/SRC/HAL_CM4_armcc.c \
../Dave/Generated/src/RTOS001/SRC/rt_CMSIS.c \
../Dave/Generated/src/RTOS001/SRC/rt_Event.c \
../Dave/Generated/src/RTOS001/SRC/rt_List.c \
../Dave/Generated/src/RTOS001/SRC/rt_Mailbox.c \
../Dave/Generated/src/RTOS001/SRC/rt_MemBox.c \
../Dave/Generated/src/RTOS001/SRC/rt_Memory.c \
../Dave/Generated/src/RTOS001/SRC/rt_Mutex.c \
../Dave/Generated/src/RTOS001/SRC/rt_Robin.c \
../Dave/Generated/src/RTOS001/SRC/rt_Semaphore.c \
../Dave/Generated/src/RTOS001/SRC/rt_System.c \
../Dave/Generated/src/RTOS001/SRC/rt_Task.c \
../Dave/Generated/src/RTOS001/SRC/rt_Time.c \
../Dave/Generated/src/RTOS001/SRC/rt_Timer.c 

S_SRCS += \
../Dave/Generated/src/RTOS001/SRC/HAL_CM4.s \
../Dave/Generated/src/RTOS001/SRC/SVC_Table.s 

OBJS += \
./Dave/Generated/src/RTOS001/SRC/HAL_CM.o \
./Dave/Generated/src/RTOS001/SRC/HAL_CM4.o \
./Dave/Generated/src/RTOS001/SRC/HAL_CM4_armcc.o \
./Dave/Generated/src/RTOS001/SRC/SVC_Table.o \
./Dave/Generated/src/RTOS001/SRC/rt_CMSIS.o \
./Dave/Generated/src/RTOS001/SRC/rt_Event.o \
./Dave/Generated/src/RTOS001/SRC/rt_List.o \
./Dave/Generated/src/RTOS001/SRC/rt_Mailbox.o \
./Dave/Generated/src/RTOS001/SRC/rt_MemBox.o \
./Dave/Generated/src/RTOS001/SRC/rt_Memory.o \
./Dave/Generated/src/RTOS001/SRC/rt_Mutex.o \
./Dave/Generated/src/RTOS001/SRC/rt_Robin.o \
./Dave/Generated/src/RTOS001/SRC/rt_Semaphore.o \
./Dave/Generated/src/RTOS001/SRC/rt_System.o \
./Dave/Generated/src/RTOS001/SRC/rt_Task.o \
./Dave/Generated/src/RTOS001/SRC/rt_Time.o \
./Dave/Generated/src/RTOS001/SRC/rt_Timer.o 

C_DEPS += \
./Dave/Generated/src/RTOS001/SRC/HAL_CM.d \
./Dave/Generated/src/RTOS001/SRC/HAL_CM4_armcc.d \
./Dave/Generated/src/RTOS001/SRC/rt_CMSIS.d \
./Dave/Generated/src/RTOS001/SRC/rt_Event.d \
./Dave/Generated/src/RTOS001/SRC/rt_List.d \
./Dave/Generated/src/RTOS001/SRC/rt_Mailbox.d \
./Dave/Generated/src/RTOS001/SRC/rt_MemBox.d \
./Dave/Generated/src/RTOS001/SRC/rt_Memory.d \
./Dave/Generated/src/RTOS001/SRC/rt_Mutex.d \
./Dave/Generated/src/RTOS001/SRC/rt_Robin.d \
./Dave/Generated/src/RTOS001/SRC/rt_Semaphore.d \
./Dave/Generated/src/RTOS001/SRC/rt_System.d \
./Dave/Generated/src/RTOS001/SRC/rt_Task.d \
./Dave/Generated/src/RTOS001/SRC/rt_Time.d \
./Dave/Generated/src/RTOS001/SRC/rt_Timer.d 

S_DEPS += \
./Dave/Generated/src/RTOS001/SRC/HAL_CM4.d \
./Dave/Generated/src/RTOS001/SRC/SVC_Table.d 


# Each subdirectory must supply rules for building sources it contributes
Dave/Generated/src/RTOS001/SRC/%.o: ../Dave/Generated/src/RTOS001/SRC/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: ARM-GCC C Compiler'
	"C:\DAVE-3.1.10\ARM-GCC/bin/arm-none-eabi-gcc" -DDAVE_CE -DUC_ID=4503003 -I"C:\DAVE-3.1.10\eclipse\/../CMSIS/Include" -I"C:\DAVE-3.1.10\eclipse\/../CMSIS/Infineon/Include" -I"C:\DAVE-3.1.10\ARM-GCC/arm-none-eabi/include" -I"C:\DAVE-3.1.10\eclipse\/../emWin/Start/GUI/inc" -I"C:\DAVE-3.1.10\eclipse\/../CMSIS/Infineon/XMC4500_series/Include" -I"X:\DAVE3-examples\DAVE4500\Dave\Generated\inc\LIBS" -I"X:\DAVE3-examples\DAVE4500\Dave\Generated\inc\DAVESupport" -I"X:\DAVE3-examples\DAVE4500\Dave\Generated\inc\MOTORLIBS" -O0 -ffunction-sections -Wall -std=gnu99 -mfloat-abi=softfp -Wa,-adhlns="$@.lst" -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d) $@" -mcpu=cortex-m4 -mfpu=fpv4-sp-d16 -mthumb -g3 -gdwarf-2 -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

Dave/Generated/src/RTOS001/SRC/%.o: ../Dave/Generated/src/RTOS001/SRC/%.s
	@echo 'Building file: $<'
	@echo 'Invoking: ARM-GCC Assembler'
	"C:\DAVE-3.1.10\ARM-GCC/bin/arm-none-eabi-gcc" -x assembler-with-cpp -DDAVE_CE -DUC_ID=4503003 -I"C:\DAVE-3.1.10\eclipse\/../CMSIS/Infineon/Include" -Wall -Wa,-adhlns="$@.lst" -mfloat-abi=softfp -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d) $@" -mcpu=cortex-m4 -mfpu=fpv4-sp-d16 -mthumb -g3 -gdwarf-2 -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


