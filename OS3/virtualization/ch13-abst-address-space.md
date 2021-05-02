# Ch.13 The Abstraction: Address Space

multiprogramming - multiple processes run at any given time

protection is important - do not want one process to be able to access memory of another process

## The Address Space

the abstraction of memory is called the **address space**

3 parts to programs address space: **code heap stack**
1. code - the instructions
2. stack - function call chain, allocate variables, pass parameters and return values
3. heap - dynamically allocated, user-managed memory, or statically initialized variables

heap at top, stack at bottom - grow in opposite directions

multiple threads means space cannot be divided so evenly (each thread will have own stack and heap)

all memory addresses that program can "return" are virtual

## Goals of this

1. transparency - OS should implement memory in a way that is invisible to running program
2. efficiency - virtualization should be as efficient as possible (this will need some hardware support)
3. protection - OS should protect one process from another


