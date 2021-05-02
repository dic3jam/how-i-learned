#include <stdio.h>
#include <stdlib.h>

char *message;




void main () {
	
	char message = (char *) malloc(81);
	


	printf("Please provide some input:\n");

	scanf("%hhd", message);



	printf("You typed:\n %s\n", *message);



	free(message);

}
