#define _GNU_SOURCE
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <sched.h>
#include <pthread.h>
#include <stdbool.h>	

#define PAGESIZE 4096

double timer(clock_t begin, clock_t end);
bool init_array(int* a, int size);

int main(int argc, char** argv) {

	int numpages, trials, jump;
	clock_t begin, end; 
	cpu_set_t set;
	double avg_time;

	FILE *fp = fopen("results.txt", "w");
	pthread_t thread = pthread_self();
	jump = PAGESIZE / sizeof(int);

	if(argc < 3) {
		numpages = 10;
		trials = 10;
	} else {
		numpages = atoi(argv[1]);
		trials =  atoi(argv[2]);
	}
	int pager = numpages*jump;
	int* a = (int*) malloc(pager*sizeof(int));

	//establish sched_affinity so runs on only 1 core
	CPU_ZERO(&set);
	for(int i = 0; i < 4; i++)
		CPU_SET(i, &set);
	pthread_setaffinity_np(thread, sizeof(cpu_set_t), &set);

	for(int h = 0; h < 10; h++) {
		numpages += 2;

		for(int i = 0; i < trials; i++) {
			for(int j = 0; j < pager; j += jump){
				init_array(a, pager);
				begin = clock();
				a[j]++;
				end = clock();	
				avg_time += timer(begin, end);	
			}
		//	printf("Trial %d: %.10f s\n", i, (avg_time/pager));
			fprintf(fp, "%d,%.10f\n", numpages, (avg_time/pager));

		}
	}

	free(a);

	return 0;
}

double timer(clock_t begin, clock_t end){

	return ((double) (end - begin)) / CLOCKS_PER_SEC;

}

bool init_array(int* a, int size){

	for(int i = 0; i < size; i ++)
		a[i] = 0;

	return true;

}
