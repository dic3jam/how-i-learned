#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define max 50

int comp(const void *s1, const void *s2);

void main () 
{
char *names[max], buffer[max], quit[5] = "quit";
int count;

	for (count = 0; count < 5; count++)
{		
		printf("Please input name. quit to quit: %d:", count+1);
		scanf("%s", buffer);
		names[count] = malloc(strlen(buffer)+1);
		strcpy(names[count], buffer);
		if (*names[count] == *quit)
			break;

}
	
	qsort(names, 5, sizeof(names[0]), comp);


	for (count=0; count <5; count++) 

		printf("\n%d: %s", count+1, names[count]);



}

int comp (const void *s1, const void *s2)
{	
	return (strcmp(*(char **)s1, *(char **)s2));
}
