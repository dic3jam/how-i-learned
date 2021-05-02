# Day 17 Manipulating Strings

string.h

## String Length

strlen() 

	size_t strlen(char *str);

size_t unsigned integer used a lot with strings

## Copying Strings

must copy source string from its location in memory to memory location of destination string

strcpy() copies entire string including null 

	char *strcpy( char *destination, const char *source );

must first allocate storage space for destination string

strncpy() specify how many characters to copy

	char *strncpy(char *destination, const char *source, size_t n);

copies at most first n characters of source to destination. if shorter adds nulls, if source longer n characters, no n added

non-ansi strdup() similar strcpy() except performs own memory allocation

## Concatenating Strings

strcat() appends copy of str2 onto end str1 moving n to end of new string
	
	char *strcat(char *str1, const char *str2);

strncat() " but lets you specify how many characters of source string to append to destination

	char *strncat(char *str1, const char *str2, size_t n);

str2 contains more than n characters, first n characters appended to end of str1. str2 contains fewer than n characters all of str2 is appended. in either case n added to new end. must allocate enuf space for str1 to hold new string

strcpy(str1, " "); copies to empty string consisting of single newline

## Comparing Strings

determines whether = or !=. if != one is greater than the other. those determinations made with ASCII codes of the characters. in case letters equivalent alphabetical order- excpet all uppercase less than lowercase

strcmp() compares 2 strings character by character

	int strcmp(const char *str1, const char *str2);

return values: <0 str1 is less than str2. 0 str1 equal to str2. >0 str1 greater than str2. 

strncmp() specified \# number characters

	int strncmp(const char *str1, const char *str2, size_t n);

## Searching Strings

determine whether one string occurs within another string and if so where

strchr() finds first occurrence of specified character in a string

	char *strchr(const char *str, int ch);

searches from left to right until character ch is found or terminating null. if ch found, poitner returned. if not NULL returned

strrchr() "" except searches string for last occurrence of a specified character in a string

	char *strrchr(const char *str, int ch);

returns pointer to last occurrence of str and NULL if no match

strcspn() "" for first occurrence 

	size_t strcspn( const char *str1, const char *str2);

not looking str2 but characters it contains. if finds match, returns offset from beginning of str1 where matching character is located. if no match returns value of strlen(str1)

strspn() "" returns length of initial segment of str1 that consists entirely of characters found in str2

strpbrk() "" first occurrence of any character contained in another string

strstr() searches for first occurrence of one string in another- searches for entire string 

	char *strstr(const char *str1, const char *str2);

## String Conversions

not ansi

strlwr() upper to lowercase

	char *strlwr(char *str);

strupr()

	char *strupr(char *str);

both return str- ie modify string in place 

ansi

	toupper(char *str) and tolower(char *str)

## Misc String Functions

not ansi- strrev() reverses order of characters

	char *strrev(char *str);

non ansi- strset() and strnset() changes all characters in str to ch except null

	char *strnset(char *str, int ch, size_t n);

## String to Number Conversions

atoi() converts string to integer

	int atoi(const char *ptr);

	long atol(const char *ptr);
	
	long long atoll(const char *ptr);

	double atof

## Character Test Functions

ctype.h

test characters returning TRUE (nonzero) or FALSE (zero) if character meets certain conditions

testing **character value**

see chart pg.507 for isxxxx() macros

subtracting character '0' from number changes a character number to a real number

 


