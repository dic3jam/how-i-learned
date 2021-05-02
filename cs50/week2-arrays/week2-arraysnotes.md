#CS50x Week 2 Arrays

"compilation" oversimplification:

1. preprocessing- when have source code with includes <> copies those source codes into file

2. compiling- converts source code to assembly code (not 0s and 1s yet). intermediate step

3. assembling- turn assembly code to machine code for all included files

4. linking- links all of those together into one program the CPU can execute

all of this we call compiling

**debugging**

printf is legit

debugger lets you step through code step by step
 
is CS50 add stop signs and use debug50 to run step by step

help50 if compile error. debug50 if compiles but not run correctly

**array*

single quotes necessary for chars to hard code in

strings use double quotes (no good reason)

array essentially variable stores multiple values

**if use more than once, should be a variable

const know do not want to change- capitalize by convention

	const int N = 3;

constants ok to put globally

\0 all 8 bits in byte written as 0. (terminating null character)

CS50 strings data type as array is multidimensional

when printing strings printf just iterating through each index and printing if not \0

**command line input**

	int main(int argc, string argv[])

argc argument count
argv[] argument vector

argc 1 is program name- everything after corresponds to more words

argv[] index corresponds to argc number and captures those arguments

by default main returns 0- aka all is well

can return more than 0 if something goes wrong


