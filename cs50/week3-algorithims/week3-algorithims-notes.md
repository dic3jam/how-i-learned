#CS50 Week 3 Algorithims

think of memory of grid of bytes- can create data structures off of that

**linear search**- going in a line

want to search efficiently

**binary search**- must be sorted. start at half then go to half of next half then half of that until reach request

*O* big italicized O- "on the order of" n, O(n), on the order of n/2: O(n/2), O(logn) - for how efficient algorithim is

as problem gets bigger they converge so really we just say on the order of n or on the order of log n

binary search O(log n)

greek omega- opposite of O (O is really upper bound) omega is best case or lower bound

successful outcome return 0 . no success return 1- just a convention

**Structure**

	typedef struct
	{
	string name;
	string number;
	} person;

	person people[4];

	people[0].name = "Emma";
	people[0].number = "617-555-0100";

**bubble sort**- "bubbled" its way up to the right spot. essentially compares itself to the data to the right

repeat n-1 times
	for i from 0 to n-2
		if i'th and i + 1'th elements out of order
			swap them
O(n^2) omega n^2 as well

to make more efficient:
change repeat n-1 times to repeat until no swaps
then omega becomes (n)

**selection sort**- identify smallest element of list and move to the left side and evict in place want to be
each iteration select next smallest element

for i from 0 to n-1
	find smallest item between i'h item and last item
	swap smallest element with i'th item

O(n^2) omega O(n^2)

**recursion**- implement algorithim, code etc. that calls itself

functions can call itself so long as 

have base case first- point where it stops- could have multiple base cases

solves a smaller portion with itself

in general, recursive functions can be used to replace loops

**merge sort**- 

if only 1 item- return
sort left half of items
sort right half of items
merge sorted halves (can make a new list)

merge sort in each half **RECURSIVELY**

process dividing again and again -> logarithim

O(n log n) omega O(n log n)















