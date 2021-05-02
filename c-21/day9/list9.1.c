# include <stdio.h>

int var = 1;

int *ptr;

int main (void) {

	ptr = &var;

	printf("\nDirect access, var = %d", var);
	printf("\nIndirect access, var = %d", *ptr);

	printf("\n\nThe address of var = %ls", &var);
	printf("\nThe address of var = %ls\n", ptr);

	return 0;

}
