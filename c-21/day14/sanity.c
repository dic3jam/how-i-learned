#include <stdio.h>

int main( void )
{
	char buf[80];

	fgets(buf, 100, stdin);
	printf("The input was: %s\n", buf);

	return 0;
}
