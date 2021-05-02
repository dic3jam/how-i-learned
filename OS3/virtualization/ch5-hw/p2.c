#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>	

int main(int argc, char *argv[]) {
	FILE* new = fopen("p2txt.txt", "w");
	int scom = fork();
	if(scom < 0) {
		fprintf(stderr, "fork failure\n");
		exit(1);
	} else if (scom == 0) {
		//childs path
		fprintf(new, "Child write\n\n");

	} else {
		//parents path
		fprintf(new, "Parent write\n\n");

	}
}
