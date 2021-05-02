#Bonus Day 2: The C++ Programming Language

different set of libraries and routines

stdio.h is now iostream.h

**cout** sends text to output device. redirect values to it

	cout << "Hello World!";

cout ENCAPSULATES printing functionality and do not need to specify data types of variables to be printed like printf()

add **bool** data type- either true- 1 or false-0 stored in a single byte

classes define objects in c++

can declare a variable at any time- can wait to declare variable when ready to use it

after declared basic variables will stay in scope until current block ends

ex: need a counter for a for loop? just declare it in the for declaration

**overloading** a function- use function name more than once

must be differences between function prototypes data types OR less inputs OR default values

	void rectangle(int width = 3, int length = 3);

should place values that will probably be defaulted as right as possible

**inline functions**- requesting compiler to replace every function call with the literal code of the function- for speed-
only good for smaller functions

	inline long square(long value);

**cin**- does opposite of cout and redirects input into a variable

	cin >> nbr;



