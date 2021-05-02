# include <stdio.h>

int x=1, y=6, w=0;

int array[100];

int main () {

while ( x != 99 ) {

puts("Enter an even integer value (99 to exit):");

scanf("%d", &x);

if ( x % 2 != 0 ) {	

printf("\n%d is not an even number, please input an even number\n", x);	
}
else{

printf("The value you entered is %d\n", x);

for ( ; ; y--,w++){
	array[w] = x;
}
}
}

return 0;

}
