//Insertion sort
#include "../jimSort.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void insertionSort(int* sortArray, int arraySize) {

	int o = 1;

	while( o < arraySize ) {

		int i = o;

		while((i > 0) && (sortArray[i-1] > sortArray[i])) {
			
			int tmp = sortArray[i]; 
			sortArray[i] = sortArray[i-1];
			sortArray[i-1] = tmp;

			i--;

		}//end inner loop

		o++; 

	}//end outer loop	

}

int main(void) {

	int arraySize = 0;	

	printf("\nArray Size?: \n");

	scanf("%d", &arraySize);

	int* testArray = malloc(sizeof(int)*arraySize);

	srand(time(0));

	printf("\nBefore:\n"); 

	for(int i = 0; i < arraySize; i++) {
		testArray[i] = rand() % 20;
		printf("testArray[%d] = %d\n", i, testArray[i]);
	}
		
	insertionSort(testArray, arraySize);

	printf("\nAfter:\n"); 

	for(int i = 0; i < arraySize; i++) {
		printf("testArray[%d] %d\n", i, testArray[i]);
	}

	free(testArray);

	return 0;
}
