//Selection sort testing
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "../jimSort.h"

void selectionSort(int* sortArray, int arraySize) {

	for(int a = 0; a < arraySize - 1; a++) {
		
		int small = sortArray[a];
		int smallIndex = a;

		for(int i = a; i < arraySize; i++) {
			if( sortArray[i] < small ) {
				small = sortArray[i];
				smallIndex = i;
			}//end if	
		}//end inner loop		

		int tmp = sortArray[a];
		sortArray[a] = sortArray[smallIndex];
		sortArray[smallIndex] = tmp;

	}//end outer loop

}

int main(void) {

	int arraySize = 10;	

	int* testArray = malloc(sizeof(int)*arraySize);

	srand(time(0));

	printf("\nBefore:\n"); 

	for(int i = 0; i < arraySize; i++) {
		testArray[i] = rand() % 20;
		printf("testArray[%d] = %d\n", i, testArray[i]);
	}
		
	selectionSort(testArray, arraySize);

	printf("\nAfter:\n"); 

	for(int i = 0; i < arraySize; i++) {
		printf("testArray[%d] %d\n", i, testArray[i]);
	}

	free(testArray);

	return 0;
}
