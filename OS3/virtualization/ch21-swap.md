# Ch.21 Beyond Physical Memory: Mechanisms 
### (should be called swap intro)

with a large address space you do not have to worry about if there is room enough in memory for your programs data structures

for page to go to swap, OS will need to remember the disk address of a given page

normally keeps some of their valid pages in memory, with the rest located in swap space on the disk

good memory access summary pg 233:
1. hardware extracts VirtualPageNumber from virtual address
2. checks TLB for a hit, if hit produces physical address if not:
3. if TLB miss hardware locates page table in memory (using page table base register) and looks up PageTableEntry using VPN as index
4. if page is valid and present in physical memory hardware extracts PFN from PTE, installs in TLB, retries instruction

may find page NOT present in physical memory, using mechanism of **present bit**

**page fault** - accessing a page that is not in physical memory - triggers a trap handler

**page fault handler** - OS will need to swap page back into memory 

PTE for page swapped to disk can now store disk address

when I/O completes, OS update page table to mark page as present - remember that while running I/O request, process goes into blocked state so ca nresume other work

if memory is full, OS will have to move some pages out, then move the new pages in - **page replacement policy**

USUALLY OS has mechanisms to keep some memorey free at all times and do not often use a page fault handler

most use a **high watermark and low watermark** 

IF OS notices there are fewer that low watermark pages available, background thread evicts pages until high watermark pages are available again
- usually some kind of swap or page daemon

so maybe the page fault handler now just informs the page daemon "hey I need some more pages" and lets it take over

so we have achieved the shroud of virtualization so that a process believes it has one contiguous address space


