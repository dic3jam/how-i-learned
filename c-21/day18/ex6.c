#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>

char *concat(char string[50], ...);
char string1[50] = "Live ";
char string2[50] = "Long ";
char string3[50] = "and ";
char string4[50] = "prosper.\n";

void main () 
{
char *farewell;

farewell = concat(string1, string2, string3, string4);

printf("%s", farewell);
}

char *concat(char string[50], ... )
{
	va_list arg_ptr;
	int count;

	va_start(arg_ptr, string);

	for (count = 1; count <4; count++)
		strcat(string1, va_arg(arg_ptr, char*));
				
	va_end(arg_ptr);
	}
