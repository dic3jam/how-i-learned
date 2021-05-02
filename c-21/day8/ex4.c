# include <stdio.h>

int x,y;

int stuff[12][10];

int main (void) {
	for ( x = 0 ; x < 12 ; x++ ) {
		for ( y = 0 ; y < 10 ; y++ ) {
			stuff[x][y] = 0;
			printf("%d,%d : %d\n" , x , y , stuff[x][y]);
		}
	}
	return 0;
}
