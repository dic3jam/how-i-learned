#CS50X Week 5- Data Structures- Notes

resize array- how to resize?

have to copy data, free old memory, then add new data

if you allocate memory to a pointer from malloc, can still use [] to access the contents of each block:

	int *ex = malloc(3*sizeof(int));
	if(list == NULL) { return 1; } //always good practice
	ex[0] = 1;
	ex[1] = 2;
	ex[2] = 3;

[0] is first byte. [1] is 4 bytes over. [2] is 8 bytes over.

now to resize:

	int *tmp = malloc(4* sizeof(int));
	if(tmp == NULL) { return 1; }

to do it O(n) use for loop, then free original chunk, then reassign pointer

new function: **realloc**(original chunk, new size);

can resize a previously sized chunk of memory

**data structure**- allow store information differently in memory

**linked list**- data structure multiple chunks of memory linked together by pointers. have to store info as well as pointers

	typedef struct node
	{
	int number;
	struct node *next;
	}
	node;

typedef just creates that alias of node so its easier to use later

**node**- general term to describe the data plus the pointer to next element in list

	node *n = malloc(sizeof(node));
	(*n).number = 2;

need () around \*n porque need to be specific "go there first, then access the .number field and assign 2 to it"

the same thing is accomplished by 
	
	n->number = 2;

	n->next = NULL;

however since a malloc is happening, usually want to do this way:

	if( n!= NULL)
	{
		n->number = 2;
		n->next = NULL;
	}

 use \*tmp pointer to move through list

	while (tmp->next != NULL)
	{
	tmp = tmp->next;	
	}
	
bc NULL is supposed to be the value of the last item in the list

so want to add to end of list, follow breadcrumbs until null then do the assigning and reassigning operations

add item to beginning of list

	n->next = listbeginning;
	list = n;

price we paid is searching the data structure is O(n) when the sorted array can be O(log n)

incrementing across a list. "list" is beginning

	n->next = NULL;
	list->next->next = n;

iterate across linked list with for loop:

	for(node *tmp = list; tmp != NULL; tmp = tmp->next)
		action;

could create fancier structure with 2 pointers to set for instance left or right

can create a **binary search tree**

so recursively every element to left is "less" every element to the "right" is greater

brought our O to O(log n)

maintain pointer to the "root" or the top which is the direct middle. then comapre and set from there

2 dimensions

recursive binary tree search:

	bool search(node *tree)
	{
		if(tree == NULL)
		{
			return false;
		}
		else if(50 < tree->number)
		{
			return search(tree->left)
		}
		else if(50 > tree->number)
		{
			return search(tree->right)
		}
		else if(50 == tree->number)
		{
			return true;
		}
	}

so using recursive function to search recursive data structure

**hash table**- combination of array and linked lists inside of it. conceptually vertical horizontally linked list

index into with **hash function** decides given name tag what bucket to put that in

for names it is looking at first letter

ideal hash function- no input data collides with any other data to preserve O(1) random access.

but that is going to create a lot of buckets, so hash tables considered O(n)


**trie**- short for retrieval. use lot of memory but give actual time lookup. tree each of whose nodes is an array. 

so for names each letter becomes a node. each node is a whole 26 character array. then link down a chain. Names that share the first few letters would share the same node-arrays. This results in a search time of O(1) or really the best its gonna get

memory requirement is HUUUUUUUUUGE

**abstract data structures**- applying the data structures to real-world

**queue**- data structure first in first out

enqueue- to get in line
dequeue- to get out of line

**stacks**- LIFO

push- put onto stack
pop- pulling off of stack

**dictionary**- abstraction get on top of hash table. has keys and values.  

##Data Structures

##Singly Linked Lists

structures that are self-referential need to have temp name and if using typedef a final name:

	typedef struct temp
	{
		VALUE val;
		struct *temp next;
	} final;

first element of list could be a global variable to keep track of it

could call it head

good practice to copy the head then use the copy to begin moves

could call it trav

to insert at end must start at beginning then work to end making that insertion O(n) if insert at beginning happens at O(1)

step 1 malloc space for new node step 2 new node point to second element step 3 head point to new item

operations to work with linked list:
1. create a linked list when does not exist
2. search through linked list to find and element
3. insert a new node into the linked list
4. delete a single element from a linked list
5. delete an entire linked list

to delete single element may need 2 pointers- one to move through and find, and another to perform the bridging operation to the element atfer the deleted element

##Hash Tables

combine array with linked list- gain back random access

insertion, deletion, lookup can get close to constant time

only use if don't care if data is sorted

**hash function**- returns nonnegative integer value called a hash code

run our data through hash function say int hash("John") and it retunrns 4. Then store "John" at index 4 of array. 

now if you want to lookup position 4 reverse hash. could return position in array by hashing input

good hash function:
1. all of the data needs to be hashed
2. use only the data to be hashed
3. be deterministic
4. uniformly distribute data
5. generate very different codes for similar data

**collision**- two pieces of data go through hash function and return same hash code

**linear probing**- if have collision, could do index +1, then if something there index +2. now if he is not at search index, know how to look

push too many elements- lose the theta as the average case time of operatrions trends towards O(n). creates **clustering**- increasing changes of collision more elements bump with linear probing

lends to **chaining**- each element of array can be head pointer o linked list and grow arbitrarily. the lookup is not O(n) like a normal linked list but is O(n) / arraySize

easiest to insert new item at beginning

##Tries

key guaranteed to be unique. value could be simple boolean tell you whether data exists in the structure

if can follow data from beginning to end then know exists in the trie

no collisions unless data is duplicated

have root node then jump down from there

	typedef struct _trie
	{
		char university[20];
		struct _trie*[10];
	} trie;



	

















