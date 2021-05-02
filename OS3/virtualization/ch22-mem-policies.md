# Ch 22 Beyond Physical Memory: policies

memory pressure forces the OS to start paging out pages to make room for actively used pages

deciding which page to evict is encapsulated within the replacement policy

given that memory holds some subset of all the pages in the system, it can be viewed as a **cache** 

our goal in picking a replacement policy is to minimize the number of cache misses
- minimize number of times we have to fetch a page from disk

**AMAT** - average memory access time

AMAT = Tm + (Pmiss * Td)
- Tm cost of accessing memory
- Pmiss probability
- Td cost of accessing disk

always have to pay the cost of accessing the data in memory - where miss must pay additional cost of I/O

as hit rate approaches 100%, AMAT approaches Tm

cost of I/O so high even tiny miss rate will dominat the overall AMAT

optimal replacement policy leads to the fewest number of misses overall
- replaces the page that will be accessed furthest in the future 
- looks at history of accesses to determine future

cache begins in empty state - **cold start** as the first few misses are compulsory as cache gets filled

3 types of cache misses:
1. cold start
2. capacity miss - cache ran out of space and had to evict and item to bring new one into cache
3. conflict miss - limits on where an item can be placed in hardware cache due to set-associativity
- OS page cache are always fully-associative

FIFO - simple but crude - 57.1% after cold start

random - 40% but must have large sample

**LRU** - the shit.
- uses recency of access (frequency based)
- based on principle of locality
- Last Frequently Used policy replaces least frequently used page when an eviction must take place

types of locality:
1. spatial locality - if P is accessed likely that P+1 or P-1 will also be needed
2. temporal locality - states that have been accessed in near past are likely to be accessed in near future

- principle of locality not hard and fast - designing to optimize for locality not guarantee of success

all policies will converge tp 100% hit rate when all referenced blocks fit in cache

LRU more likely to hold onto hot pages

improvement over other policies COULD be a big deal just depends upon how expensive I/O is

to implement well upon each page access must update some data structure to move this page to the front of the list
- which means system has to do accounting on EVERY memory reference - could be expensive

COULD (add hardware) and update a time field - place in array - but now need to scan that

**approximate the LRU**

use bit or reference bit

clock algorithm

all pages in system arranged in clock. clock hand points to rando page to start. checks if currently pointed page hsa use bit 1 or 0. If a 1 implies recently used and NOT a good candidate for replacement. so sets to 0 then goes to P+1. continues until finds use bit of 0

COULD also add a **dirty** bit which just tracks if page has been modified. 

if modified must be written back to disk to evict it which is expensive. if clean eviction is free and physical frame can be used for other purposes w/o additional I/O.

prefer to evict clean pages over dirty

for most pages, OS uses **demand paging** - when accessed brought in

**prefetching** - guess that a page needed soon and grab

cluster writes to disk - more efficient

**thrashing** - running processes exceeds system memory system will be constantly paging

**scan resistance** - algorithms like LRU but try to avoid worst case behavior of LRU (looping sequential workload)


