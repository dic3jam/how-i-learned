#include <stdio.h>
#include <ctype.h>

void main ()
{

int var = 1;


	if ( isalnum(var) > 0 ) {
	       printf("TRUE\n");
	}
	if (isalpha(var) > 0 ) {
		printf("TRUE\n");
	}	
	if (isblank(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (iscntrl(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isdigit(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isgraph(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (islower(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isprint(var) > 0 ) {
		printf("TRUE\n");
	}
	else if (ispunct(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isspace(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isupper(var) > 0 ) {
		printf("TRUE\n");
	}	
	else if (isxdigit(var) > 0 ) {
		printf("TRUE\n");
	}	
	else {
		printf("FALSE");
	}

}
