# include <stdio.h>

# define SIZE 10

char array1[10] = "abcdefgh";

char array2[10];

char count, *ptr;

int copyarray(char array1, char array2);

int main (void) {

	puts(array1);
	
	puts("\n==========");

	copyarray(*array1, *array2);

	puts(array2);

	return 0;

}
int copyarray(char array1, char array2) {


	for (count = 0 ; count < 10 ; count++) {
		*(array1+count) == array2[count];

	return 0;

	}

}	


