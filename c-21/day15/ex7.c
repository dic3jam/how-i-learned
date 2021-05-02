#include <stdio.h>

#define max 10

int inputs[max];
int a,b,tmp;

int  main () {


//Receive Input

int a = 0;

	for (a = 0; a < max; a++) {
		printf("\nInput number: %d\n", a);
		scanf("%d", &inputs[a]);

	}

//Apply Sort

for ( a=0; a < max; ++a) {
	for (b = a+1; b < max; ++b) {
		if (inputs[a] > inputs[b]) {
			tmp = inputs[a];

			inputs[a] = inputs[b];


			inputs[b] = tmp;


		}
	}
}	

//Print Sorted List

	for ( a=0; a < max; a++ ) {
		printf("%d\n", inputs[a]);
	}
return 0;
}

