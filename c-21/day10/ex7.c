#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *final;

char * concat(char*, char*);



void main () {

	char *a = "Hello";
	char *b = "-World!";

	final = malloc(sizeof(a)+sizeof(b));

	final = concat(a,b);

	puts(final);

	free(final);

}

char * concat(char * a, char * b) {

	strcpy(final, *a);
       	strcpy(final, *b);	

	return final;

}


