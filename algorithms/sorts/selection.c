//Selection sort
#include "jimSort.h"

void selectionSort(int* sortArray, int arraySize) {

	for(int a = 0; a < arraySize; a++) {
		
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

