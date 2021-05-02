# Ch.6 Limited Direct Execution

challenges to time sharing:
- performance
- control - namely return control of cpu from process to OS

## 6.1 Limited Direct Execution

run directly on CPU but limit 

direct execution protocol w/o limits:

OS						Program
--------------------------------------------------------------
- create entry 
for process list
- allocate memory for program
- load program into memory
- set up stack with argc/argv
- clear registers
- execute by jumping to main()
					- run main()
					- execute return from main

- free memory of process
- remove from process list	


## 6.2 Problem 1 Restricted Operations

sys calls look like C procedure calls - is a procedure call BUT has a trap instruction in it

uses agreed upon calling convention with the kernel to put arguments in well known locations (on the stack or CPU registers)

... which is a system-call number and uses that to execute trap instruction

trap will return values to calling program - system-calls usually hand-coded in assembly in order to unpack values correctly

using trap handlers for allocating resources allows for user modes

system calls are layer of security for kernel - that way user programs can still execute privileged operations on resources without compromising kernel

user mode and kernel mode

hardware keeps the following: instructions to trap into the kernel, return from trap, where trap table resides in memory

**trap table** - is built at boot time and keeps record of the instructions for each trap handler (in hardware)

system-call numbers are assigned to each system call. the OS, when handling the system call inside the trap handler, examines the number and ensures it is valid

soo user code cannot request a specific address to jump to but must request a system call by type - more protection

limited direct execution protocol is on pg 53

a secure system must treat user input with great suspicion

## 6.3 Problem 2 Switching between processes

if a process is running on the CPU, that means the OS is NOT running

**cooperative approach**: OS trusts processes to behave

most processes transfer control back to OS by making sys calls

cooperative systems usually include a **yield** call to transfer control back

applications also transfer control to the OS when they do something illegal - triggers a trap
OS usually terminates that process

non-cooperative approach brought about by a **timer interrupt**

every few milliseconds triggers an interrupt handler that gives the OS control over the CPU again

for cooperative systems, best way regain control from infinite process is a reboot

during timer interrupt handling, hardware must save current state of program such that a return from trap instruction will be able to resume it

enables the **scheduler** to make a decision, which if it does is known as a **context switch**

in some way (push to stack, save state in registers) saves current context of current process and SWITCHES into the context of another
usually pushes and pulls from the kernel stack

**to go from process A to B A's registers pushed onto kernel stack, moves k-stack pointer to use B's kernel stack, return-from-trap by restoring B's registers and then run**
while handling the timer interrupt handler the switch() routine will save registers in the proc-struct as well

so if there is a switch because of handling a trap from a timer interrupt registers are save in hardware (on k-stack) and software proc-struct 
see pg. 59

if another timer interrupt happens while in the middle of handling another interrupt.... topic for **concurrency** section

**limited direct execution == baby proofing**

when int is being processed saves registers to kernel stack. only when performing context switch does it save registers in the software struct of the currently executing process

**WHEN USE USER STACK VS KERNEL STACK**

kernel stack is used for processing a syscall (to include a timer interrupt) 

user stack is used when processor in user mode (so on norm until syscall is made)






