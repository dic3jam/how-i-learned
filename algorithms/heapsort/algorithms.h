#include <time.h>
#include <stdlib.h>
#include <stdio.h>

int* genArray(int testSize) {

	int *a = (int*) malloc(testSize*sizeof(int));

	srand(time(0));
	
	for(int i = 0; i < testSize; i++) {
		a[i] = rand() % 20;
	//	printf("%d\n", a[i]);
	}

//	printf("\n\n");
	
	return a;

}//end genArray

double timer(clock_t begin, clock_t end) {

	double daTime = ((double) (end - begin)) / CLOCKS_PER_SEC;

	return daTime;

}//end timer

FILE* resultsFile(void) {

	FILE *fp = fopen("results.txt", "w");
		if(fp == NULL) {
			printf("Unable to open a file");
			exit(1);
		}

	return fp;

}//end resultsFile

void printArray(int* array, int size) {

	printf("Index : Value\n");

	for(int i = 0; i < size; i++) {
	
		printf("   %d  :  %d\n", i, array[i]);	

	}

	printf("\n\n");

}//end printArray

