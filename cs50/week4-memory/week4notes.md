#CS50X Week 4 Memory

**hexadecimal**

00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F 10

0 to 16 in hexadecimal. sooo 20 is 32 30 is 48

RGB

FF 00 00

255 red 0 green 0 blue- so lots of red

0x is hex prefix

memory addresses are usually represented in hex

& is address of operator. %p to print address with printf

**pointer**- value of address of

\* - go to address

	int *p = &n

DIFFERENT CONTEXT OF \* . this just means this is a pointer to an int

pointers will take 64 bit address space modern computers

String is char *

	typedef char *string;

used in CS50.h to create strings

so instead of string a = "x"; can do

	char *s = "x";

s[0] and s[1] is really just (s) and (s+1) soo its just adding onto the address 1 sizeof(variable)

	char *t = malloc(how many bytes)

	strcpy((pointer string copying to), (string copying from))

opposite malloc **free** hand back memory allocated

good practice to free when not using- could memory leak

	free(t);

use address of memory location, pointer etc.

when passing inputs to function, function getting copies of inputs

loading into memory:

program loaded, then global variables then the **heap** - space for malloc calls

grows and shrinks as malloc 'd and free 'd

**stack** - where local variables go when functions called

program loaded into **stack frame**

functions get slice above stack frame. so global variables are in one stack or section, the parameter  and local variables are in another section 

when function done, loses memory allocation- main still intact after allocation

use pointers to the variables to prevent the loss

now function can move to global variables

uses this for a simple swap function:
function prototype:

	void swap(&x, &y);

function declaration:

	void swap(int *a, int *b) {
	int tmp = *a;
	*a = *b;	
	*b = tmp;	
	}

swaps a with b

malloc to heap, functions run on stack

**stack overflow** when function calls itself again and again and again

**heap overflow** is opposite- too much memory allocation

initialize to NULL for pointer if not assigning anything

	FILE *file = fopen("phonebook.csv", "a);

fopen returns pointer to file

fprintf() print to a file

	fprintf(file, "%s, %s", name, number);

fclose(file)

**CSV** comma separated values

really easy to write a program that can write in comma separated data and use excel to see a spreadsheet of info

##Pointers

different way to pass data between functions

passing variable to function just uses a copy

need pointers to modify data in functions- modifying variables in main is different

**random access**- just means can access at any point does not have to be sequential

**POINTERS ARE NOTHING MORE THAN AN ADDRESS**

**dereferencing**- go to pointer to see value at the pointers address

for pointer to char pc 
	*pc is the value of the variable

dereferencing a null pointer is a segmenation fault

	int* px, py, pz;

will make a pointer called px, and ints py and pz. * is shared. so...

	int* px, *py, *pz;

pointer to any data type is systems's byte width. 32 bit system, 32 bit pointer, 64 bit system, 64 bit address

	*pk = 35;

changing what is at pk

##Dynamic Memory Allocation

if do not know how much memory need at compile-time

dynam ically allocated memory from heap

stack and heap same pool- stack from "bottom to top" heap from "top to bottom"

stack for statically allocated memory (variables and such) heap for dynamically allocated memory

malloc() from stdlib.h allocates to heap. only argument is how many bytes you want

return a pointer to that memory

if cannot get memory it will return a null always check for null after malloc

must dereference pointer to access contents 

static
	int x;
dynamic
	int *px = malloc(sizeof(int));

	float stack_array[x];

	float* heap_array = malloc(x * sizeof(float));

free(pointer to malloc'd memory)

##Call Stack

when call a function, sets aside memory for function to do work. called **stack frames or function frames**

more than 1 functions stack frame may exist in memory at any time

while multiple frames can be active, only 1 can run at any time

frames are arranged in a **stack** frame for most recently called function is on top of the stack

when new function called new frame **pushed** onto the stack and becomes active frame

when function finishes work, its frame is **popped** off the stack and frame immediately below it becomes active frame. this function picks up where it left off

##File Pointers

writing to and from files is means to storing persistent data

abstraction of file that C provides is implemented in a data structure known as a FILE

using pointer to that FILE\*

all in stdio.h

fopen() creates the pointer, other file i/o functions work with that pointer

	FILE* ptr = fopen(<filename>, <operation>);

check for null

	fclose(<file pointer>);

read next character in file

	char ch = fgetc(<file pointer>);

pointer must be open for reading "r"

will increment across the file- can use to print contents to screen

how cat works

	char ch;
	while((ch = fgetc(ptr)) != EOF)
		printf("%c", ch);

write or append specified character to file

	fputc(<character>, <file pointer>);

fopen must specify "w" or "a"

get any amount of information from file (instead of just 1 character0

	fread(<buffer>, <size of chunk>, <qty of chunks>, <file pointer>);

	<buffer> really need pointer to memory

writes from buffer units of size to file depending if FILE ptr is "w" or "a"

	fwrite(<buffer>, <size of chunk>, <qty of chunks>, ptr);

fgets() and fputs() reading writing strings

fprintf() write formatted string to file

feof() whether read to end of file

ferror() tells if error has occurred in working with the file

fseek() point to part of file

ftel() tells you what byte (position) are at in file



























