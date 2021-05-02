#Day3 Storing Information

2 ways to store values- variables and constants

**variable**- data storage location that has a value and can be changed during program execution

**constant**- fixed value that can't change

##Variables

Variable names:
+ a-z, A-Z, 0-9, _
+ 1st character must be a letter
+ C is canse sensitive
+ C keywords cannot be used as variables

commonly use lowercase characters in variable names

camel notation- InterestRate as opposed to snake notation interest_rate

**Numeric Variables**- 2 categories:
1. integer
2. float- more storage space

int and short varaibles may be different certain hardware

**variable declaration**- *typename varname*;
	can declare multiple variables of same type on same line
	ex: int count, number, start; 

**typedef**- changes typename not varname

should always initialize a variable to a known value

= not same in programming- x = 12 really means 12 is assigned to x

be careful to not initialize a variable outside the allowed range compiler/linker may not catch it!

##Constants

###literal constants

value that is typed directly into source code

literal constant with a decimal is a floating point constant and is represented by C compiler as a double-precision number

floating point constants can also be written in scientific notation
+ 1.23E2 	1.23 times 10 to the 2nd power
+ 0.85e-4	0.85 times 10 to the -4th power or 0.000085

**integer constants can be written in 3 notations:**
1. constant starting with any digit other than 0 is interpreted as a decimal integer
2. constant starting with digit 0 is interpreted as an octal integer
3. constant starting with 0x or 0X is hexidecimal

###symbolic constants

**constant represented by a name (symbol) in program**

Ex: const circumfrence = PI * (2 * radius);

(PI and radius initialized elsewhere)

2 ways to define:
1. #define
2. const

**\#define**- does not need ; at end. can be placed anywhere. only usable "below" where they are written

**const**- cannot be modified. 
	ex: const long debt = 120000, float tax_rate = 0.21;

**&to call variable in program**

**5 rules for allocating size to varaibles:**
1. the size of a char is one byte
2. the size of a short is <= size of int
3. size of int <= size of long
4. size of unsigned = size of int
5. size of float <= size of double
