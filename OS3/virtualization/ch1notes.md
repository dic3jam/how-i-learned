# OS3 Ch.1 Into to Operating Systems

running program executes instructions

processor **fetches** instruction from memory decodes it and executes it

Von Neumann model of computing - execute 1 instruction at a time

HOW does the Operating System virtualize resources

sometimes call OS a virtual machine

take physical resource and make it into more useful virtual resource

OS provides system calls for resources and standard library for applications

also called resource manager

virtualizing the CPU - executing multiple processes simultaneously

**policy** used to determine which program runs at a time

virtualizing memory means giving each process its own address space

**thread** - function running within same memory space as other functions with more than 1 active at a time

**persiostence** not volatile memory

syscalls to file system can include open() write() close()

want to **isolate** processes from one another

syscall transfers control to OS while simultaneously raising hardware privilege level

user applications run in user mode - hardware restricts what applications can do

cant do things like write to disk sooo when you make a restricted syscall, control transferred to **trap handler** then raises privilege to kernel mode
 when done passes control back to user with return-from-trap instruction




