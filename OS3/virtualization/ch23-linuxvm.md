# Ch.23 Complete Virutal Memory Systems

curse of generality - tasked with general support for a broad class of applications and systems - OS is not likely to support any one installation very well

one technique: kernel stays in same spot in virtual memory - each process essentially includes kernel in address space - stays in place upon context switch
- base and bounds register for kernel does not change
- if kernel given own address space moving data between user applications and kernel would be complicated

**demand zeroing** - OS does little work when page added to address space - puts entry in page table marks the page as inaccessible 
if process reads or writes to the page, a trap into OS takes place.
when handling the trap, OS notices this is actually a demand zero page, NOW the OS goes and finds a page, zeros it, and maps it into the process's address space

**copy on write** - when OS needs to copy a page from one address space to another, instead of copying it it maps into the target address space and marks it read-only in both address spaces
if both address spaces only read the page, no action needed
BUT if one wants to write  -> trap into OS, which will then actually allocate the page, fill it with the data, and map it to the process address space

fork() creates exact copy of address space of caller

exec() overlays calling process's address space with that of the soon to be executed program

**LINUX**

virtual address space consists of a user portion (where user program code, stack, heap, and other parts reside)
AND a kernel portion - does not change upon context switch

in classic 32bit linux split between user and kernel portions takes place at address 0xC0000000 or 3/4 way through address space and end 0xFFFFFFFF
so user is 0x00 through 0xBFFFFFFF
- 64 bit similar split just different points

kernel has 2 types of kernel virtual addresses:

**kernel logical addresses** - what consider normal (maps directly to physical at 0x00000000)
- kmalloc
- page table, per process kernel stack live here
- kernel logical memory CANNOT be swapped to disk

if chunk of memory is contiguous in kernel logical space, also contiguous in physical memory
- good for operations need contiguous physical memory to work correctly such as I/O via direct memory access

**kernel virtual address** - 
- vmalloc - returns a pointer to a virtually contiguous region of the desired size
- usually not contiguous so good for things such as large buffers where large contiguous chunk hard to find

x86 provides hardware-managed, multi-level page table structure, with one page table per process
OS simply sets up mappings in memory, points a privileged register at the start of the page directory, and hardware handles the rest
- OS gets involved at process creation, deletion, and upon context switches

for 64bit address sapces - 4 level page table - see pg 270
- 63 - 47 unused
- 47- 13 virtual address (36 bits each level 9 bits)
- 13 - 0 offset

standard 4k page size (thus 12 bit offset)

allows for use of multiple page sizes - HUGE pages

larger the pages, the fewer the mappings
- driver for HUGE pages is better TLB behavior
- mmap() or shmget()

need for better TLB behavior is becoming more common - added **transparent** HUGE page support
- which just means OS automatically looks for chances to allocate HUGE pages

but remember, HUGE pages cause internal fragmentation, also not good for swapping

to reduce cost of accessing persistent storage, use aggressive **caching** subsystems to keep popular data items in memory

linux **page cache** is unified keeping pages in memory from three primary sources **memory-mapped files**, file data, and metadata from devices
- keeps track if entries are clean (read but not modified) or dirty (modified)
- dirty data periodically written to backing store by background threads (pdflush)

linux uses a modified form os 2Q replacement
- LRU can be subverted by certain common access patterns
1. when accessed for the first time, a page is placed on one queue- **inactive list**
2. when re-referenced, page is promoted to other queue **active list**
3. periodically moves pages from the bottom of the active list to the inactive list
- keeps inactive list to 2/3 of total page cache size
- then utilizes an approximation of LRU similar to **clock** replacement to manage these lists

**buffer overflow attacks** - bug in target system which lets attacker inject arbitrary data into target's address space
- arises bc developer believes input will not be too long for buffer
- CHECK SIZE OF USER INPUT PRIOR TO ASSIGNING TO BUFFER

attackers can then inject code into the overflow, privilege escalate, and take control

defense against the dark arts:
- prevent execution of code found within certain regions of address space (within stack) 

AMDs NX bit (no execute) - prevents execution from any page which has this bit set in its corresponding page table entry

**return oriented programming** - lots of code (gadgets in ROP terminology) within programs address space
an attacker can overwrite the stack such that the return address in currently executing function points to a desired malicious instruction (or series of instructions)
followed by a return instruction

defense against the dark arts:
- **address space layout randomization (ASLR)** - OS randomizes placement of stack, heap, code
- also incorporated into kernel: **kernel address space layout randomization**

**speculative execution** - CPU guesses which instructions will be soon executed and starts executing them ahead of time
- exploit here is that information to drive prediction is stored in various places
- exploits of this: Spectre Meltdown

defense against the dark arts:
remove as much of the kernel address space from each user process and instead have separate kernel page **kernel page isolation**
when switching into kernel now a switch to kernel page table is needed
COSTs performance :(


