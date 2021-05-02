#include <string.h>
#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char* argv[]){

	int p = (int) getpid();

	printf("PID: %d\n", p);

	long memsize = atol(argv[1]);
	memsize *= 1000000;

	char* buffer = malloc(memsize * sizeof(char));

	int i = 0;
	while(1){
		char a = buffer[i];
		i++;
		if(i == memsize)
			i = 0;
	}

	return 0;
}
