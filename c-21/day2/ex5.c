#include <stdio.h>
#include <string.h>
int main(void)
{
	char buffer[256];

	printf( "Enter your name and press <Enter>:\n");
	gets( buffer );

	printf( "\nYour name has %ld characters and spaces!",
			strlen( buffer ));

	return 0;
}
