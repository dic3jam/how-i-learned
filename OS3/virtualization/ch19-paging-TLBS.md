# Ch.19 Paging Faster Translations TLBs

**TLB** - little cache on CPU of commonly accessed virtual emeory addresses so does not have to go to page table in RAM EVERY time

TLB keeping track of frequently accessed PAGES - so if a TLB hit just calculate offset

larger page sizes fewer misses

spatial (elements in pages packed tightly together)  and temporal locality (quick re-referencing of items in time) are the factors of speed here

larger caches slower - have to keep small
- caches are read from beginning to end everytime - hardware cannot be that cumbersome

CISC - hardware handles TLB miss

RISC - software handles TLB miss
- TLB miss causes hardware exception trap into kernel, handle trap, return from trap
	- just have to return from trap to start of instruction (so it will replay the instruction with the value returned from the page table lookup that the trap handler is running)
- need to ensure not causing infinite chain of TLB misses - several techniques to this

software is flexible

CISC architecture is hardware driven - large instruction sets
RISC architecture is software driven - keep few powerful instructions and abstract into software

**TLB entry**

VPN | PFN | other bits

lots of different information  you can include in a TLB entry
- valid bit useful for context switches - **flush** TLB on process context switch by turning all valid bits invalid
- global bit communicate if translation used in multiple proceses
- Address space identifier - 8 bit identifier for processes (like a PID but 8 bits instead of 32)

typical TLB have 32, 64, 128 entries and be fully associative - TLB entries not in any particular order every read to TLB reads from start to finish

**cache replacement** - how do we handle replacing an old TLB entry? every page table lookup should result in TLB update
- trying to increase hit rate

couple ways:
- least-recently-used
- random

believe it or not random is pretty good

TLBs not so good when process uses many pages - more than will fit into TLB (exceeding **TLB coverage**)

BIGGER PAGES!!


