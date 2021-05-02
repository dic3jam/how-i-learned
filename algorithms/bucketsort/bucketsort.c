#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <limits.h>

#define DEFBUCKET 5

/*
 * Function: display
 * ----------------------------
 *   Prints out an integer array in a really nice format. Nice.
 *
 *   a: pointer to the beginning of an integer array
 *   length: array size
 *
 */
void display(int* a, const size_t LENGTH) {
	printf("[ ");
	for (int i = 0; i < LENGTH; i++) {
		printf("%d ", a[i]);
	}
	printf("]\n");
}


/*
 * Function: big_rand
 * ----------------------------
 *   Hack to get you a bigger range of random ints
 *
 */
int big_rand() {
	if (RAND_MAX < INT_MAX) {
		return rand() * (RAND_MAX - 1) + rand();
	} else {
		return rand();
	}
}

/*
 * Function: rand_ints
 * ----------------------------
 *  Generates a random array of SIZE integers in the range 0 <= n < MAX
 *  
 *	SIZE: number of elements in array
 *  MAX: upper bound for elements (exclusive)
 *
 *  returns: pointer to the array
 *
 */
int* rand_ints(const int SIZE, const int MAX) {
	int* a = (int*) malloc(SIZE * sizeof(int));
	
	for (int i = 0; i < SIZE; i++) {
		a[i] = big_rand() % MAX;
	}

	return a;
}

/*
 * Function: swap
 * ----------------------------
 *   Swaps elements i and j in int[] a
 *
 *   a: an integer array
 *   i, j: indices to swap
 *
 */
void swap(int* a, int i, int j) {
	int tmp = a[i];
	a[i] = a[j];
	a[j] = tmp;
}


/*
 * Function: insertion_sort
 * ----------------------------
 *   Takes an unsorted array and sorts it in ascending order using the insertion
 *   sort algorithm
 *
 *   a: pointer to the beginning of an integer array
 *   SIZE: size of array
 *
 */
void insertion_sort(int* a, int SIZE) {
	int i = 1;
	while (i < SIZE) {
		int j = i;
		while ((j > 0) && (a[j - 1] > a[j])) {
			swap(a, j, j - 1);
			j--;				
		}
		i++;
	}
} 

/*
 * Function: min
 * ----------------------------
 *   Finds the smallest element in an array
 *
 *   a: pointer to the beginning of an integer array
 *   SIZE: size of array
 *
 *	 returns: the smallest element in the array
 */
int min(int* a, const int SIZE) {
	int minvalue = INT_MAX;
	for (int i = 0; i < SIZE; i++) {
		if (a[i] < minvalue) {
			minvalue = a[i];
		}
	}

	return minvalue;
}

/*
 * Function: max
 * ----------------------------
 *   Finds the largest element in an array
 *
 *   a: pointer to the beginning of an integer array
 *   SIZE: size of array
 */
int max(int* a, const int SIZE) {
	int maxvalue = INT_MIN;
	for (int i = 0; i < SIZE; i++) {
		if (a[i] > maxvalue) {
			maxvalue = a[i];
		}
	}

	return maxvalue;
}

/*
 * Function: bucketsort
 * ----------------------------
 *   Takes an unsorted array and sorts it in ascending order using the
 *   bucketsort algorithm
 *
 *   a: pointer to the beginning of an integer array
 *   SIZE: size of array
 *
 */
void bucketsort(int* a, const int SIZE) {
	
	//create buckets
	int smallest = min(a, SIZE);
	int largest = max(a, SIZE);

	int bucket_size = (largest - smallest + 1) / SIZE;

	if(bucket_size == 0) {
		bucket_size = 1;	
	}

	const int numBuckets = ((largest - smallest) / bucket_size) + 1;

	int** bucketArray = (int**) malloc(numBuckets * sizeof(int*));
	
	int* n_in_bucket = (int*) malloc(numBuckets * sizeof(int));

	for(int i = 0; i < numBuckets; i++) {
		bucketArray[i] = (int*) malloc(DEFBUCKET * sizeof(int));
		n_in_bucket[i] = 0;
	}

	//put array members into buckets	
	for(int i = 0; i < SIZE; i++) {
		int ibucket = (a[i] - smallest) / bucket_size;		
		
		if((n_in_bucket[ibucket] % DEFBUCKET) == 0)
			bucketArray[ibucket] = (int*) realloc(bucketArray[ibucket], (sizeof(int)*(n_in_bucket[ibucket] + DEFBUCKET)));	

		bucketArray[ibucket][n_in_bucket[ibucket]] = a[i];
		n_in_bucket[ibucket]++;
	}	
	
	//use insertion sort on each bucket
	for(int i = 0; i < numBuckets; i++)
		insertion_sort(bucketArray[i], n_in_bucket[i]);
	
	//paste sorted members back into array
	int position = 0;	
	for(int i = 0; i < numBuckets; i++) {
		for(int j = 0; j < n_in_bucket[i]; j++) {
			a[position] = bucketArray[i][j];
			position++;
		}
	}

	//free memory
	for(int i = 0; i < numBuckets; i++)
		free(bucketArray[i]);
	free(bucketArray);
	free(n_in_bucket);
}

int main(void){

	srand(time(NULL));

	//prove it works
	int* array = rand_ints(10, 100);

	display(array, 10);

	bucketsort(array, 10);

	display(array, 10);

	free(array);

	//test for time
	int size = 10000;
	FILE* fp = fopen("results.txt", "w");
	clock_t begin, end;
	double daTime;

	fprintf(fp, "Array Size, Time\n");

	for(int i = 0; i < 5; i++) {

		for(int j = 0; j < 10; j++) {

			int* array = rand_ints(size, 1000);

			begin = clock();
		
			bucketsort(array, size);

			end = clock();

			daTime = ((double) (end - begin)) / CLOCKS_PER_SEC;

			fprintf(fp, "%d, %f\n", size, daTime);

			free(array);

		}

		size *= 2;

	}

	fclose(fp);

	return 0;	
}
