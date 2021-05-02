#include <stdio.h>
#include <time.h>

void mergesort(int* array, int innerBound, int outerBound);

void merge(int* array, int innerBound, int midIndex, int outerBound);

int* genArray(int size);

double timer(clock_t begin, clock_t end);
