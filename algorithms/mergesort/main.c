#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <math.h>
#include "mergesort.h"

#define SIZE 1000 
#define FACTOR 2
#define TRIALS 10

int main() {

	bool quit = true;

	while(quit) {
		char c = 'q';
		printf("Perform mergesort starting on array of %d, increasing the array size by a factor of %d, 5 times with %d trials for each size Yes/Quit\n", SIZE, FACTOR, TRIALS);
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
			mergesort(sortArray, 0, testSize - 1);		
		
			/*for testing - print
			for(int i = 0; i < SIZE; i++) {
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
		a[i] = rand() % 20;
	//	printf("%d\n", a[i]);
	}

	printf("\n\n");
	
	return a;

}//end genArray

double timer(clock_t begin, clock_t end) {

	double daTime = ((double) (end - begin)) / CLOCKS_PER_SEC;

	return daTime;

}//end timer

void mergesort(int* array, int innerBound, int outerBound) {

	if(innerBound < outerBound) {
	
		int m = floor((innerBound + outerBound) / 2);

		mergesort(array, innerBound, m);

		mergesort(array, m + 1, outerBound);

		merge(array, innerBound, m, outerBound);

	}

}//end mergesort

void merge(int* array, int innerBound, int midIndex, int outerBound){

	//set bounds for how much of the array goes to the left and right copies
	int nleft = midIndex - innerBound + 1;

	int nright = outerBound - midIndex;

	//create arrays to copy each half of array into
	int rightArray[nright+1], leftArray[nleft+1];

	//copy half of the array into a left and right half
	for(int r = 0; r < nright; r++)
		rightArray[r] = array[midIndex + 1 + r];

	for(int l = 0; l < nleft; l++)
		leftArray[l] = array[innerBound + l];

	//assign infinity as the final bound in each half for assignment
	
	rightArray[nright] = (int) INFINITY;

	leftArray[nleft] = (int) INFINITY;
		
	//create counters for each half of the array
	int ileft = 0;
	int iright = 0;

	//increment across array, compare the half arrays, assign the lower value to array[i]
	for(int i = innerBound; i < outerBound + 1; i++) {
		if(leftArray[ileft] <= rightArray[iright]){
			array[i] = leftArray[ileft];
			ileft++;
		}
		else {
			array[i] = rightArray[iright];
			iright++;
		}

	}	

}//end merge

