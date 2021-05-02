# include <stdio.h>
# include <stdlib.h>
# include <time.h>

void sleep( int nbr_seconds);

int main (void) {

	int ctr;
	int wait = 13;

	printf("Delay for %d seconds\n", wait);
	printf(">");

	for (ctr=1 ; ctr <= wait ; ctr++) {
		printf(".");
		fflush(stdout);
		sleep( (int) 1 );

	}
	printf( "Done!\n");

	return 0;
}

void sleep( int nbr_seconds ) {

	clock_t goal;

	goal = ( nbr_seconds * CLOCKS_PER_SEC ) + clock();

	while( goal > clock() ) {
		;
	}
}
