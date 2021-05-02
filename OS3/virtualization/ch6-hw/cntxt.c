#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <sys/wait.h>
#include <sched.h>

#define RUNS 100

double timer(clock_t, clock_t);

int main(int argc, char *argv[]) {
	printf("Parent process PID: %d\n", (int) getpid());
	int fd1[2];
	int fd2[2];
	int child1;
	clock_t start, end;
	cpu_set_t set;

	//pipe fd1 parent to child for this representation
	//fd1[0] pipe 1 read end, fd1[1] pipe 2 write end 
	pipe(fd1);
	//pipe fd2 child to parent for this representation
	//fd2[0] pipe 2 read end, fd2[1] pipe 2 write end 
	pipe(fd2);

	//establish sched_affinity so runs on only 1 core
	CPU_ZERO(&set);
	CPU_SET(1, &set);
	sched_setaffinity(0, sizeof(cpu_set_t), &set);	

	child1 = fork();

	if(child1 < 0) {
		fprintf(stderr, "fork failure\n");
		return 1;
	} else if (child1 == 0) {
		//child1 path
		for(int i = 0; i < RUNS; i++) {
			int j_rec = 0;
			read(fd1[0], &j_rec, sizeof(int));
			//printf("Child receives %d\n", j_rec);
			j_rec++;
			write(fd2[1], &j_rec, sizeof(int)); 
			//printf("Child sends back %d\n", j_rec);
		}
	} else {
		//parent path
		int j = 0;
		write(fd2[1], &j, sizeof(int)); 
		start = clock();
		for(int i = 0; i < RUNS; i++){
			j = i;
			read(fd2[0], &j, sizeof(int));
			//printf("Parent receives back %d\n", j);
			j++;
			write(fd1[1], &j, sizeof(int));
			//printf("Parent sends %d\n", j);
		}
		end = clock();
		printf("Context Switch avg time: %f\n", (timer(start, end) / RUNS));
	}

	return 0;
}

double timer(clock_t start, clock_t end){
	return ((double) (end - start)) / CLOCKS_PER_SEC;
}
