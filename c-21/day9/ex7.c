# include <stdio.h>
# define MAX 10


int count;
int array1[MAX] = {2,4,6,8,10,12,14,16,18,20};
int array2[MAX] = {2,4,6,8,10,12,14,16,18,20};
int sumarray[MAX];


int sumfunction(int array1[], int array2[], int length);


int main (void) {

	 sumfunction(array1, array2, MAX);

	 for (count = 0 ; count < MAX ; count++) {
		 printf("\n%d\n", sumarray[count]);
	 }

return 0;

}

int sumfunction( int array1[], int array2[], int length )  {

	int sum;

	for (count = 0 ; count < length ; count++) {
		sumarray[count]  = array1[count] + array2[count];
	}

	return 0;
}
