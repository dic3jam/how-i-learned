# include <stdio.h>
# include <stdlib.h>

int x,y;

int array[5][4];

int main (void) {
	for ( x = 0 ; x < 5 ; x++) {
		for ( y = 0 ; y < 4 ; y++) {
			array[x][y] = rand();
			printf("%d,%d : %d\n", x, y, array[x][y]);
		}
	}
	return 0;
}
