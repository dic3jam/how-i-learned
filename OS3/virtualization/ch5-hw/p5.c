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
		int wc = wait(NULL);
		printf("Child says hi PID: %d, wait returns %d\n", (int) getpid(), wc);	
	} else {
		//parents path
		printf("Parent says hi\n");	
	}
		
}
