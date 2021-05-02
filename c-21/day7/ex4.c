# include <stdio.h>

int x=1;

int main () {

while ( x != 0 ) {

puts("Enter an even integer value (0 to exit):");

scanf("%d", &x);

if ( x % 2 != 0 ) {	

printf("\n%d is not an even number, please input an even number\n", x);	
}
else{

printf("The value you entered is %d\n", x);
}
}

return 0;

}
