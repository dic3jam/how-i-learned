# Day 8 Using Numeric Arrays

each storage location in an array is called an array element

each element is the equivalent of 1 variable at the variable type

all of C's data types can be used for arrays

expenses[10]=expenses[11] copied index 10 to index 11

expenses[a[2]]= 100; set at index whatever a[2] is (if integer array)

C compiler does not recognize if program uses array subscript that is out of bounds

%.2f will print to 2 decimal places when using in printf()

**multi-dimensional array**- has more that one subscript ex: int checker[8][8] 

no limit to number of dimensions an array can have, however is limit to total size

\#define MONTHS 12. int array[MONTHS];

cannot declare with symbolic constant created by const. const int MONTHS = 12; int array[MONTHS] is a no no

scanf("%d", &grades[idx]);

can initialize all or part of an array when you first declare it

if you do not explicity initialize an array element cannot be sure what value it holds

for multidimensional arrays- assigned to elements in order with last subscript changing first. array[4][3] = {1, 2, 3, 4, 5,.....] would add the values in this order:

int array[0][0] = 1. array[0][1] = 2. array[0][2] = 3. array[1][0] = 4. array[1][1] = 5.... array[3][2] = n.

clearer: int array[4][3] = { {1,2,3} , {4,5,6} , .... }

getchar() pauses program until the user presses Enter key

pg 186 increments 3 dimension array across addresses by using 3 nested for loops:

int array[a][b][c]

for (increment a)
	for (increment b)
		for (increment c)
			int array[a][b][c] = rand()
		}
	}
}

**calculate memory needed**- multiply nubmer elements in array by element size- 500 element array with int variables. each int is 4 bytes (pg188 for table) so 500\*4=2000 bytes

sizeof() unary operator determining size of argument

programming tasks that involve repetitive data processing lend themselves to array storage

should always initialize variables so you know exactly what is in them

cannot add arrays together but could make a function that increments and adds each element at each address


