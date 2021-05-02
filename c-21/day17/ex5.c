#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char name[50], mname[25], lname[25], buffer[25];

void main() 
{

printf("Please input your first name: \n");

	scanf("%s", buffer);	

printf("\nPlease input your middle name: \n");

	scanf("%s", mname);	

printf("\nPlease input your last name: \n");

	scanf("%s", lname);

size_t n = 1, a = 50;

strncpy(name, buffer, n);

strncpy(buffer, mname, n);

strncat(name, buffer, a);

strncat(name, lname, a);

puts(name);
	
}


