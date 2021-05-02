#include <stdio.h>
#include <stdlib.h>

void main (void)
{
char ch;
int count[127], index;

for(index = 0; index < 127; index++)
	count[index] = 0;

	while (1)
	{
		ch = fgetc(stdin);

		if( ch == EOF )
			break;

		if( ch > 31 && ch < 127 )
			count[ch]++;
//		printf("%c\n", ch);
	}

	for( index = 32; index < 127; index++ )
		printf("[%c]\t%d\n", index, count[index]);

}
