#include <stdio.h>
#include <stdlib.h>

char ch, filename[50];
int n;
FILE *fp;

void main (void) 
{	
	printf("\nPlease specify the file you would like to count the characters of: ");
	scanf("%s", filename); 

	if ( (fp = fopen(filename, "r")) == NULL) 
	{
		fprintf(stderr, "\nError opening file specifed");
		exit(1);
	}

	while (1)
	{
	ch = fgetc(fp);

	if(feof(fp))
		break;

	if(ch > 31 && ch < 127)
		n++;	
	}

	printf("There are %d characters in this file\n", n);

	fclose(fp);

}
