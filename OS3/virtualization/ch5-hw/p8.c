#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	
#include <sys/wait.h>

int main(int argc, char *argv[]) {

	int parent = (int) getpid();
	printf("Start process PID: %d\n", parent);	
	int child1 = fork();
	int child2 = fork();
	int fildes[2];

	if(child1 < 0 || child2 < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	} else if (child1 == 0) {
		//child1 path
		fildes[0] = STDOUT_FILENO;	
		printf("Child 1 says: \n");
	} else if (child2 == 0) {
		//child2 path
		fildes[1] = STDOUT_FILENO;
	} else {
		wait(NULL);
		pipe(fildes);
		return 0;
	}


}
