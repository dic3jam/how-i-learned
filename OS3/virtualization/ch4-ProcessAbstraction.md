# OS3 Ch.2 The Abstraction: The Process

**process** - running program

**time sharing** - the CPU running on process, stopping it, then running another - promoting the illusion of virtualization

**mechanisms** - low level methods or protocols that implement needed piece of functionality

**context switch** - stop one process and start another one

**machine state** - understand what a program can read or update when it is running
- address space
- registers

program counter
stack pointer 
frame pointer
list of files has open

policy answers question of **which** process is CPU currently processing

common design practice - separate mechanisms from policies 

## Process API

APIs to manage processes

create 

destroy - forcefully. not normal program exit

wait

misc control - usually includes suspend (stop for awhile) and resume

status

## Process Creation

load code and any static variables into memory

early or simple OSs program loaded eagerly - loaded completely then run
modern/more complex OSs load code as executed lazily

OS allocates this memory and gives it to the process, then fills in parameters to main - argc and argv

in UNIX systems every program 3 open file descriptors by default - standard input, output and error

once loaded, jump to main() through special mechanism, OS transfers control of CPU to newly-created process

## Process States

can be in one of 3 states:

running

ready

blocked - not ready to run until some other event takes place (I/O request to disk)

process go from ready to running **scheduled**

then other way **unscheduled**

## Data Structures

1. process list for all processes that are ready and some additional info to track which process currently running

2. blocked processes

3. register context - hold content of registers for stopped process

also **initial** states (what in when being created) **final** state when exited but not yet cleaned up (in UNIX called zombie)

when finished parent process will make one final call (wait()) to wait for compeltion of child clean-up
