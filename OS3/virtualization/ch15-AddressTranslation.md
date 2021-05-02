# Ch.15 Mechanism: Address Translation

idea behind LDE: for the most part, let the program run directly on the hardware

OS optimize efficiency and control

Applied to memory:
=================
- ensures that no application is allowed access to memory but its own
- flexibility - programs to be able to use their address space for whatever they would like 

**hardware based address translation** - changing the virtual addresses provided by the instruction to a physical address 

**dynamic relocation** - base and bounds registers hold start and end 

translation of virtual to physical:
physical address = virtual address + base

dynamic relocation enables address translation

**Memory management unit** - part of processor that helps with address translation

base and bounds can either hold physical addresses or the size

OS must maintain a data structure known one way as a **free list** which knows where all the free memory is

dynamic relocation hardware requirements
=======================================
- privileged mode - perhaps a single bit processor status word to indicate user or privileged mode
- base/bounds registers
- ability to translate virtual addresses and check if within bounds
- privileged instructions to update base/bounds
- privileged instructions to register exception handlers
- ability to raise exceptions

for context switch: OS must save and restore base/bounds registers

example of context switch now with address translation pg 151

exception handlers must be initialized at boot time


