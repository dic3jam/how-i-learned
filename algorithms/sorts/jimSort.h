//Header files for jimSort
#include <time.h>
#include <stdio.h>

int* randomize(int arraySize);
double makeTime(clock_t start, clock_t end); 
void selectionSort(int* sortArray, int arraySize); 
void insertionSort(int* sortArray, int arraySize);
void sorter(int sortType, int trials, int arraySize, FILE* fp);
