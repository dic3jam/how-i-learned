#include <stdio.h>

#define max 10

int inputs[max];
int a,b,tmp;
int sorted[max];
void sortAscend(int inputs[max]);
void sortDescend(int inputs[max]);

int main () {


//Receive Input

int a = 0;
int sel;

	for (a = 0; a < max; a++) {
		printf("\nInput number: %d\n", a);
		scanf("%d", &inputs[a]);

	}

//Select Ascend or Descend

printf("\nWould you like to sort ascending or descending? 1 or 2?:\n");
scanf("%d", &sel);

if ( sel == 1){ 
	sortAscend(inputs);
}
else if ( sel == 2){
	sortDescend(inputs);
}

//Print Sorted List

	for ( a=0; a < max; a++ ) {
		printf("%d\n", inputs[a]);
	}
return 0;
}

void sortDescend(int inputs[max]) {
for ( a=0; a < max; ++a) {
	for (b = a+1; b < max; ++b) {
		if (inputs[a] > inputs[b]) {
			tmp = inputs[a];
			inputs[a] = inputs[b];
			inputs[b] = tmp;
			}
		}	
	}
}

void  sortAscend(int inputs[max]) {
for ( a=0; a < max; ++a) {
	for (b = a+1; b < max; ++b) {
		if (inputs[a] < inputs[b]) {
			tmp = inputs[a];
			inputs[a] = inputs[b];
			inputs[b] = tmp;
			}
		}
	}
}
