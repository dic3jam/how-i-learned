#include "algorithms.h"

int partition(void* sortArray, int innerBound, int outerBound, int (*comparator)(void*a,void*b), size_t element_size) { 

	void* pivot = shift(sortArray, outerBound, element_size);
	
	int i = innerBound - 1;

	for(int j = innerBound; j <= outerBound-1; j++) {
	
		//get a pointer to sortArray[j] and pass into applicable comparison function
		
		void* aj = shift(sortArray, j, element_size);
	
		if((comparator(pivot, aj)) > 0) {
		
			i++;

		void* ai = shift(sortArray, i, element_size);
			
		swap(sortArray, aj, ai, element_size); 

		}
	}

	void* ai1 = shift(sortArray, i+1, element_size); 
	void* ao = shift(sortArray, outerBound, element_size);

	swap(sortArray, ai1, ao, element_size);	

	return i + 1;

}//end partition

void quicksort(void* sortArray, int innerBound, int outerBound, int (*comparator)(void*a,void*b), size_t element_size){

	if(innerBound < outerBound) {

	int p = partition(sortArray, innerBound, outerBound, comparator, element_size);

	quicksort(sortArray, innerBound, p - 1, comparator, element_size);

	quicksort(sortArray, p + 1, outerBound, comparator, element_size);

	}

}//end quicksort



