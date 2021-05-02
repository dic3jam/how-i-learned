#include <stdio.h>

int x;

int main () {
	printf("\nInput your age: ");
	scanf("%d", &x);

	if (x < 21)
		printf("\nYou are a mere child!\n");
	else if ( x > 65)
		printf("\nSit down grandpa!\n");
	else
		printf("\nYou are an adult\n");

	return 0;
}
