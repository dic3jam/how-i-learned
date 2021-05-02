# include <stdio.h>

int x, y;

int array[10];
int array2[10];

int main (void) {
	for ( x = 0 ; x < 10 ; x++ ) {
		array[x] = x;
		printf("array 1 %d: %d\n", x, array[x]);
	
	
		
		array2[x] = (array[x] +10);
		printf("array 2 %d: %d\n", x, array2[x]);
		
	}



return 0;



}

