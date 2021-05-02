#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	

int main(int argc, char *argv[]) {

	printf("Start process PID: %d\n", (int) getpid());
	int x = 100;
	int scom = fork();
	if(scom < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	} else if (scom == 0) {
		//childs path
		printf("Child process PID: %d\n", (int) getpid());
		printf("Childs value of x before change: %d\n", x);
		x = 201;
		printf("Childs value of x after change: %d\n", x);
	} else {
		//parents path
		printf("Parent  process PID: %d\n", (int) getpid());
		printf("Parent value of x before change: %d\n", x);
		x = 101;
		printf("Parent value of x after change: %d\n", x);
	}
		
}
