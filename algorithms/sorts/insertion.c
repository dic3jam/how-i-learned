//Insertion sort
#include "jimSort.h"

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


