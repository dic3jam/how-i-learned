#include <stdio.h>
#include <stdlib.h>

FILE *fp;
char filename[50], buffer[100], ch;
int i = 0;

void main ()
{

	printf("Please provide the filename: ");
	scanf("%s", filename);

	printf("You input %s\n\n", filename);

	if( (fp = fopen(filename, "r")) == NULL )
	{
		fprintf(stderr, "Error opening file.");
		exit(1);
	}

	printf("Copying file\n");

	fread(buffer, sizeof(char), 100, fp);

/*	if(fread(buffer, sizeof(char), 100, fp) != 100)
	{
		fprintf(stderr, "Error copying file.");
		exit(1);
	}*/

	//Print before changes
	int a=0;
	for(a=0; a < 100; a++)
		printf("%c", buffer[a]);

	printf("\n");

	for(i = 0; i < 100; i++)
	{
		if(buffer[i] < 123 && buffer[i] > 96)
			buffer[i] = buffer[i] - 32;
	}


	//Print after changes
	a=0;
	for(a=0; a < 100; a++)
		printf("%c", buffer[a]);

	printf("\n");

	fclose(fp);

	if( (fp = fopen("output.txt", "w")) == NULL)
	{
		fprintf(stderr, "Error opening output file.");
		exit(1);
	}

	if (fwrite(buffer, sizeof(char), 100, fp) != 100)
	{
		fprintf(stderr, "Error reading to new file.");
		exit(1);
	}

	fclose(fp);

}

