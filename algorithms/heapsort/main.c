#include "heapsort.h"

int main(void) {

	FILE* fp = resultsFile();

	fprintf(fp, "Iteration, Test Size, Overall Time, Heapify Time\n");

	clock_t begin = 0;
	clock_t end = 0;	

	int trials = 10;
	int factor = 2;
	int testSize = 100;

	for(int i = 0; i < trials; i++) {
	
		int* heap = genArray(testSize);

//		printArray(heap, testSize);

		begin = clock();

		double heapTime = heapsort(heap, testSize);	

		end = clock();

//		printArray(heap, testSize);

		double daTime = timer(begin, end);
		
		fprintf(fp, "%d, %d, %f, %f\n", i, testSize, daTime, heapTime);	

		testSize *= factor;
			
		free(heap);

	}

	fclose(fp);

	return 0;

}//end main
