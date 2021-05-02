#include <time.h>
#include <unistd.h>
#include <stdio.h>

#define RUNS 5

double timer(clock_t, clock_t);

int main(int argc, char *argv[]) {
	double avg_time = 0;
	for(int i = 0; i < RUNS; i++){
		clock_t start = clock();
		FILE *test = fopen("test_file", "w");
		clock_t end = clock();
		avg_time += timer(start, end);
		fclose(test);
	}

	avg_time /= RUNS;
	printf("Sys-call average: %f\n", avg_time);
	return 0;
}

double timer(clock_t start, clock_t end){
	return ((double) (end - start)) / CLOCKS_PER_SEC;
}
