#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <math.h>
#include "quicksort.h"

#define SIZE 1000 
#define FACTOR 2
#define TRIALS 10

int main() {

	bool quit = true;

	while(quit) {
		char c = 'q';
		printf("Perform quicksort starting on array of %d, increasing the array size by a factor of %d, 5 times with %d trials for each size Yes/Quit\n", SIZE, FACTOR, TRIALS);
		scanf(" %c", &c);
	
		if(c == 'y' || c == 'Y')
			quit = false;
		else if( c == 'q' || c == 'Q'){
			quit = false;
			exit(0);
		}
		else
			quit = true;

	}

	FILE *fp = fopen("results.txt", "w");
		if(fp == NULL) {
			printf("Unable to open a file");
			exit(1);
	}

	//set a new variable so we can modify file size during execution
	int testSize = SIZE;

	for(int i = 0; i < 5; i++) {
		//generate the random array
		int* sortArray = genArray(testSize);

		//run TRIALS number of trials
		for (int a = 0; a < TRIALS; a++) {

			clock_t start, end = 0;

			start = clock();
			//it begins
			quicksort(sortArray, 0, testSize - 1);		
			
			/*for testing - print
			for(int i = 0; i < testSize; i++) {						
				printf("%d\n", sortArray[i]);
			}*/

			end = clock();
			//take the time of execution
			double daTime = timer(start, end);
			//send to the file the iteration number, the size of the array, and the time the sort took
			fprintf(fp, "%d,%d,%f\n", a, testSize, daTime);

		}//end for

		//free the current array before increasing the size
		free(sortArray);

		//increase array size for next testing iteration
		testSize *= FACTOR;

	}
	
	fclose(fp);

	return 0;

}//end main

int* genArray(int testSize) {

	int *a = (int*) malloc(testSize*sizeof(int));

	srand(time(0));
	
	for(int i = 0; i < testSize; i++) {
		a[i] = big_rand() % 20;
	//	printf("%d\n", a[i]);
	}

	return a;

}//end genArray

double timer(clock_t begin, clock_t end) {

	double daTime = ((double) (end - begin)) / CLOCKS_PER_SEC;

	return daTime;

}//end timer

void quicksort(int* sortArray, int innerBound, int outerBound){

	if(innerBound < outerBound) {

		int p = partition(sortArray, innerBound, outerBound);

		quicksort(sortArray, innerBound, p - 1 );

		quicksort(sortArray, p + 1, outerBound);

	}

}//end quicksort

int partition(int* sortArray, int innerBound, int outerBound){

	int pivot = sortArray[outerBound];

	int i = innerBound - 1;

	for(int j = innerBound; j <= outerBound-1; j++) {
	
		if(sortArray[j] < pivot) {
		
			i++;

			int tmp = sortArray[j];
			sortArray[j] = sortArray[i];
			sortArray[i] = tmp;
		}
	}

	int tmp = sortArray[i+1];

	sortArray[i+1] = sortArray[outerBound];

	sortArray[outerBound] = tmp;	

	return i + 1;

}//end partition

int big_rand() {
	return rand() * (rand() + 1) + rand();
}

