#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	
#include <signal.h>

int main(int argc, char *argv[]) {

	int parent = (int) getpid();
	int scom = fork();

	if(scom < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	}
		
	kill(parent, SIGSTOP);

	if (scom == 0) {
		//childs path
		printf("Child says hello, PID: %d\n", (int) getpid());
		kill(parent, SIGCONT);
	}

	if(scom > 0) {
		//parents path
		printf("Parent says goodbye, PID: %d\n", (int) getpid());

	}
}
