# include <stdio.h>

int x;

int eightyeight[88];

int main (void) {

	for ( x=0 ; x < 87 ; x++ ) {
		eightyeight[x] = 88;
		printf("%d\n", eightyeight[x]);
	}	
return 0;
}

