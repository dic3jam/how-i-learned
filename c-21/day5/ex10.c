# include <stdio.h>

float a, b, c, d, e, answer;

float average(float a, float b, float c, float d, float e);

int main (void)
{
	printf("\nPlease enter the 5 numbers: ");
	scanf( "%f%f%f%f%f", &a, &b, &c, &d, &e);

	answer = average(a, b, c, d, e);

	printf("\nThe answer is %f", answer);

	return 0; 
}

float average(float a, float b, float c, float d, float e)
{
	return((a+b+c+d+e)/5);
}
