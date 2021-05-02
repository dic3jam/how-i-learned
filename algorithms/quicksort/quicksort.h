#include <stdio.h>
#include <time.h>

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

void quicksort(int* sortArray, int innerBound, int outerBound){

	if(innerBound < outerBound) {

		int p = partition(sortArray, innerBound, outerBound);

		quicksort(sortArray, innerBound, p - 1 );

		quicksort(sortArray, p + 1, outerBound);

	}

}//end quicksort



