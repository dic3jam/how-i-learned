#include <stdio.h>

float div(float a, float b);

float a, b, x;



float main(void)
{
printf("\nPlease input a : ");
scanf( "%f" , &a);

printf("\nPlease input b: ");
scanf( "%f", &b);

x = div(a,b);

printf("\nThe answer is %f" ,x);

return 0;
}

float div(float a, float b)
{
	if( b==0 )
		puts("\nCannot divide by 0!\n");
	else
	{
		return( a / b );
	}
}


