#include <stdio.h>
#include <stdlib.h>

#define SIZE 129

void main()
{
FILE *fp;
char buffer[SIZE], filename[25];
int i = 0, a = 1, point = 129;

	printf("Which file would you like to translate: ");
	scanf("%s", filename);

	if((fp = fopen(filename, "r")) == NULL)
	{
		fprintf(stderr, "File was unable to open. You suck. Goodbye.");
		exit(1);
	}	

	while( feof(fp) != 1)
	{
		if(fread(buffer, sizeof(char), sizeof(filename), fp) != sizeof(filename))
		{
			printf("Unable to read file because you suck.");
			exit(1);
		}
		
		printf("\nBlock %d Hexadecimal\n\n", a);

		for(i=0; i < SIZE; i++)
			printf("%x", buffer[i]);	
				
		printf("\nBlock %d ASCII\n\n", a);

		for(i=0; i < SIZE; i++)
			printf("%c", buffer[i]);
			
		a++;

		if((fseek(fp, point, SEEK_SET)) != 0)
		{
			printf("Unable to move pointer because you suck.");
			exit(1);
		}

		point = point + SIZE;

	}

		fclose(fp);

}

