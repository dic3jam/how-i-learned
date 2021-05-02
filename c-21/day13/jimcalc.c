# include <stdio.h>

double calc(double n1, char op, double n2);

void main ()
{

int ctrl = 0;
double n1 = 0, n2 = 0;
static double output = 0;
int op;
		
do {
	if ( ctrl == 1) {
		n1 = output;}
	else{
		n1 = 0; 

	printf("\nInput your first number:");
	scanf("%lf", &n1);
			}
	do {
	printf("\nInput operation: (1-add, 2- subtract, 3- multiply, 4- divide)\n");
	scanf("%d", &op);
	} while ( op < 5 ); 

	printf("\nInput your second number:");
	scanf("%lf", &n2);

	output = calc(n1, op, n2);

	printf("\nThe answer is %lf\n", output);

	printf("Would you like to continue?\n");
	printf("1 calc again with last output\n");
	printf("2 calc again new\n");
	printf("3 quit\n");
	scanf("%d", &ctrl);


} while (ctrl != 3);
}

double calc(double n1, char op, double n2) 
{
double answer = 0;	
	
	switch (op)
	{
		case 1: answer= n1 + n2;
		break;
		case 2: answer= n1 - n2;
		break;
		case 3: answer= n1 * n2;
		break;
		case 4: answer= n1 / n2;
	default: answer = 42;
	}

return answer;
}
