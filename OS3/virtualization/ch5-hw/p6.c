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
		printf("Child says hi PID: %d\n", (int) getpid());	
	} else {
		//parents path
		int wc = waitpid(scom, NULL, 0);
		printf("Parent says hi, PID: %d, wait: %d\n", (int) getpid(), wc);	
	}
		
}
