#include "algorithms.h"

int leftChild(int parent) {

	return (2 * parent) + 1;

}//end leftChild

int findParent(int index) {

	return (index - 1) / 2;	

	
}//end findParent

void siftDown(int* heap, int start, int end) {

	int p = start;

	int lefty = leftChild(p);

	while( lefty <= end ) {
	
		int swap = p;
	
		if(heap[swap] < heap[lefty]) 
			swap = lefty;
		
		if(lefty + 1 <= end && heap[swap] < heap[lefty + 1])
			swap = lefty + 1;

		if(swap == p)
			break;
		else {
			int tmp = heap[p];
			heap[p] = heap[swap];
			heap[swap] = tmp;
		}

		p = swap;

		lefty = leftChild(p);

	}

}//end siftDown


void heapify(int* heap, int count) {

	int start = findParent(count - 1);

	while( start >= 0 ) {

		siftDown(heap, start, count - 1);

		start--;

		if((start < 0) && (heap[0] < heap[1] || heap[0] < heap[2]))
			siftDown(heap, 0, count - 1);

	}		

}//end heapify

double heapsort(int* array, int sizeOfUnsort) {

	clock_t start = clock();

	heapify(array, sizeOfUnsort);

	clock_t TIME = clock();

	double heapTime = timer(start,TIME);

	int end = sizeOfUnsort-1;

	while ( end > 0 ) {

		int tmp = array[0];
		array[0] = array[end];
		array[end] = tmp;

		end--;

		siftDown(array, 0, end);
			
	}

	return heapTime;

}//end heapsort





