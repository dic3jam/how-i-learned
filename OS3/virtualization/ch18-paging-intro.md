# Ch.18 Paging Intro

solution to segmentation's fragmentation: paging - fixed size pieces of memory

with a fully developed paging approach the system will be able to support the abstraction of an address space 

no need to worry about direction heap and stack growing in

OS just keeps a free list of all free pages and grabs the first one off of the list when requested

**page table** - OS keeps a per process data structure to store the address translations for each of the virtual pages
- placed in physical memory

### translating virtual to physical

split virtual address into 2 components: **virtual page number** and **offset**

virtual address size = x
2^x = address space in bytes
or

size of VPN portion of virtual address = y
2^y = page size

with a page size of 16 bytes 2 higher order bytes the VPN, lower 4 the offset into that page

every virtual page corresponds to a physical page
- physical frame number of physical page number

note: offset is not translated only the virtual page number

	VPN = (VirtualAddress & VPN_MASK) >> SHIFT
	PTEAddr = PhysicakPageTableBaseRegister * (VPN * sizeof(PTE))
	
	offset = VirtualAddress & OFFSET_MASK
	PFN = PTE[PTEAddr]-> PFN
	PhysAddr = (PFN << SHIFT) | offset

end
===

for 32 bit address space:
- page tables take lots of space - if need 4 bytes per page table entry,thats 4MB for each page table

maintained in physical memory due to size

can virtualize OS memory as well

can also write pages to disk

**linear page table**

array of pointers to a page table entry
- many variations of this 
- index array by virtual page number, looks up the PFN in the PTE

common features
- valid bit - indicate whether particular translation is valid - code and heap at one end, stack at other - space inbetween marked invalid
- protection bit - rwx
- present bit - indicate if page in memory or on disk (**swapped** out)
- dirty bit - indicate if page modified since last brought into memory
- reference bit - indicate if been accessed recently

**2 problems to solve with paging**:
1. slower machine (lots of cycles just to access memory)
2. wasteful use of memory space

  

