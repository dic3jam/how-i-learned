# Ch.17 Free Space Management

easy when space is divided into fixed sized units - difficult with variable sized units

malloc and free control processes's virtual heap space and the subsequent free list

**external fragmentation** - is relative to the OS managing the entire memory map
**internal fragmentation** - is relative to a particular process

once space allocated for a process it is "owned" by that process and cannot be removed
- compaction could only be used in a system that was implementing segmentation

system call **sbrk()** used to grow the heap for a particular process
- reaches into whole virtual memory and maps some additional space to the requesting process

## low-level mechanisms

**splitting and coalescing and free list**

**free list** - contains a set of elements that describe the free space still remaining in the heap

linked list

**splitting** - find a free chunk of memory, take what is requested, leave the rest

**coalescing** - when memory is free mechanism for chunking it back into a nearby space (if free) then just update free list for new sized chunk

### tracking the size of allocated regions

most allocators store a little extra info in a header block just before handed out chunk of memory

so a chunk of memory looks like:
	-----------------
	|    header	|
	|		|
	-----------------
	|		|
	|		|
	|    memory	|
	|		|
	|		|
	-----------------

header may also have additional pointers to speed up deallocation, magic number for integrity checking, and pointers to next allocated space

how this goes down slim:
-----------------------
1. gets a pointer with free
2. calculates header body
3. checks magic number
4. adds region + header
5. adds to free list (coalescing if possible)

### embedding a free list

when process gets heap space (from system call **mmap()**)

create a struct for the head pointer
- contains address of space
- size of the space
- initially, heads next pointer will point to NULL

then we just build more of these nodes as space is allocated

mechanisms will chunk memory as freed

to GROW the heap process calls **sbrk()** which finds a free physical page, maps it into the address space of the requesting process, and returns the value of the end of the new heap

## Basic Strategies (brief overview of each)

ideal allocator is both fast and minimizes fragmentation

**best fit** - search through free list and find chunks of free memory as big or bigger then return the smallest candidate

**worst fit** - find largest chunk and return requested amount, keep remaining large chunk on the free list
- tries to leave big chunks free instead of lots of little chunks 

**first fit** - finds first block with enough space and returns it

**next fit** - keeps extra pointer to the location within the list where one was looking last

**segregated lists** - if a particular process makes similar requests, keep a separate list and space just for those 

lots of allocator strategies have issues with scaling - more advanced allocators make use of different data structures to achieve better performance



