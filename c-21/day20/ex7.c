#include <stdio.h>


int main ()
{
int x = 0x10, y = 0xFF;

	printf("%d\n", (x & y));
	printf("%d\n", (x | y));
	printf("%d\n", (x ^ y));
}
