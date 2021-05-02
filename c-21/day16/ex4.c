#include <stdio.h>
#include <stdlib.h>

int main (void) {

char str[50];
FILE *fp;

	if ( (fp = fopen("test.txt", "r")) == NULL)
	{
		fprintf(stderr, "Error opening file.\n");
		exit(1);
	}

fgets(str, 50, fp);



printf("%s", str);

fclose(fp);

return 0;
}

	
