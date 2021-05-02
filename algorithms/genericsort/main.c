#include "genquicksort.h"

int main(void) {

	//proof I did this correctly

	double* doubleArray = ranDoubArray(10);	

	printDoubleArray(doubleArray, 10);	

	quicksort(doubleArray, 0, 9, comp_doubles, sizeof(double)); 

	printDoubleArray(doubleArray, 10);

	free(doubleArray);

	int* intArray = ranIntArray(10);

	printIntArray(intArray, 10);

	quicksort(intArray, 0, 9, comp_ints, sizeof(int));

	printIntArray(intArray, 10);

	free(intArray);

	//testing times  
	
	FILE* fp = resultsFile();

	int factor = 1;
	int testSize = 10;
	clock_t start = 0;
	clock_t end = 0;

	fprintf(fp, "Array Type, Array Size, Time\n");

	for(int i = 0; i < 5; i++) {
		
		int* ranints = ranIntArray(testSize);

		start = clock();

		quicksort(ranints, 0, testSize - 1, comp_ints, sizeof(int));	

		end = clock();

		double daIntTime = timer(start, end);	

		free(ranints);

		fprintf(fp, "Int, %d, %d, %f\n", i, testSize, daIntTime);

		printf("Int, %d, %d, %f\n", i, testSize, daIntTime);

		factor += 2;

		testSize = testSize * factor;

	}	

	factor = 1;
	testSize = 10;
	start = 0;
	end = 0;

	for(int i = 0; i < 5; i++) {
	
		double* randoubs = ranDoubArray(testSize);

		start = clock();

		quicksort(randoubs, 0, testSize - 1, comp_doubles, sizeof(double));

		end = clock();

		double daDoubTime = timer(start, end);

		free(randoubs);

		fprintf(fp, "Double, %d, %d, %f\n", i, testSize, daDoubTime);

		printf("Double, %d, %d, %f\n", i, testSize, daDoubTime);

		factor += 2;

		testSize = testSize * factor;
	}

	return 0;

}//end main













