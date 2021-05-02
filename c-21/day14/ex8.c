#include <stdio.h>
#include <stdlib.h>

#define MAX 1000

void main (void)
{
char ch;
char words[MAX]; 
int i = 2; 

printf("1 : ");

	do
	{
		if ( ch == '\n' )
		{
		printf("%d : ", i);
		i++;
		}

		ch = fgetc(stdin);

		if( ch == EOF )
			break;
	
		printf("%c", ch);
	
	}while (1);


}
