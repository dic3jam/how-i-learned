#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	

int main(int argc, char *argv[]) {

	int scom = fork();

	if(scom < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	}
		
	if (scom == 0) {
		//childs path
		int i = exec("/bin/ls", ".", (char*) NULL);
		if(i < 0)
			exit(1);
				
	} else if(scom > 0) {
		//parents path
		return 0;
	}
}
