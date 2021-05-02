#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	
#include <sys/wait.h>

int main(int argc, char *argv[]) {

	printf("Start process PID: %d\n", (int) getpid());
	int scom = fork();
	if(scom < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	} else if (scom == 0) {
		//childs path
		printf("Child process");
		close(STDOUT_FILENO);
		printf("Child print after stdout close?");
	} else {
		//parents path
		printf("If this works, the parent can still print\n");
	}
		
}
