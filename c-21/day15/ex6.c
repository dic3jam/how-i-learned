#include <stdio.h>

void main ()
{
int x = 0, y = 0;
char array[4][4];

for(x=0;x<5;x++)
	for(y=0;y<5;y++)
		array[x][y] = 0;

	for(x=0;x<5;x++)
	{
		printf("\n");

		for(y=0;y<5;y++)
		{
			if((y%2))
				array[x][y] = 'X';
			else
				array[x][y] = '_';

			printf("%s", &array[x][y]);
		}
	}
}

