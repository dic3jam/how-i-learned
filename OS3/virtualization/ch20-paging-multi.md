# Ch.20 Paging: Smaller Tables

simple linear page tables are too big and consume too much memory

one solution: multiple page sizes

problem with big pages: leads to waste within each page -> **internal fragmentation**

combine segmentations base and bounds registers with paging - add a base and bounds
- not to point to the segment itself but rather hold the physical address of the page table of that segment
- in hardware would need base/bounds for code, heap, stack
	- on context switch these registers must be changed to reflect the location of the page tables of the new processes
- bounds register just for value of maximum valid page in the segment

now unallocated pages between the stack and heap no longer take up space in a page table (marked as non-valid)

if, for instance, have large allocated heap but not using thats wasted space

also reintroduce fragmentation - page tables of arbitrary size (multiples of PTEs)

**multi-level page table** - turn linear page table into something like a a tree
1. chop up page table into page-sized units, 
2. then if entire page of PTEs is invalid, don't allocate that page of the page table at all
3. add a **Page Directory**

PD - tell you where a page of the page table is or that entire page table is invalid

page directory containes one entry per page of the page table - PDEs
- minimum: valid bit and page frame number

if PDE is valid, at least one page of that page table is 

multi-level table only allocates page-table space in proportion to the amount of address space you are using

if carefully constructed, each portion of the page table fits neatly within a page , OS can simply grab the next free page when it needs to allocate or grow a page table

this is adding a level of indirection aka another step 

also a $$ Cost $$ - on a TLB miss 2 loads from memory will be required to get the right address translation. PDE -> PTE

could also do more than 2 levels 

so normally have:

VPN|offset

VPN|   |offset
PDI|PTI|	

with multi-level do something like:

VPN|	|	|offset
PDI0|PDI1|PTI

Page table could easily consume more than one page - what happens if page directory does as well?

**inverted page table** - instead of having one page table per system process, keep single page table that has entry for each physical page in thr system

even with all of these methods - may just run out of memory. then need to implement a swap system to write some page tables to kernel virtual memory on disk


