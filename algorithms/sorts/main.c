#include "jimSort.h"
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <stdbool.h>
#include <string.h>

//global value for size of arrays 
int arraySize = 0;

int main(int argc, char* argv[]) {

	//set some options for the menus
	int option = 0;
	int sortType = 0;	
	//seed the random number generator
	srand(time(0));	
	//open text file for writing
	FILE* fp = fopen("dataWrangle/sortResults.txt", "w");
		if(fp == NULL) {
			printf("Unable to open sortResults.txt");
			return(1);
		}
	//switch menu for program control can run 1 manual trial or do an auto trial
	bool quit = true;

	while(quit) {

		bool check = true;

		while(check) {
		if(option == 0) {
		
			printf("\nPlease choose an option:\n 1- Auto\n 2- Manual\n 3- Quit\n"); 
			
			scanf("%d", &option);

			if( option > 0 && option < 4 )
				check = false;
			else
				printf("\nHey guy, options are 1 - 3\n");
			}
		}
	
		int trials = 1;
		bool verify = true;	

		switch(option) {

			//case 1- run each sort 10 times at increasing array sizes
			case 1:	arraySize = 100;
 				for(int i = 0; i < 10; i++) {
				       sorter(2, 10, arraySize, fp);					   
				     //  arraySize *= 2;	
				}
				arraySize = 100;
				for(int i = 0; i < 10; i++) {
				       sorter(1, 10, arraySize, fp);					   
				   //    arraySize *= 2;	
				}
				break;
			//case 2 manual- prompt for array size and sort type and number times to execute
			case 2:	 while(verify) {
					printf("\nSort Type 1 for insertion 2 for selection\n");
					scanf("%d", &sortType);
					printf("\nArray size: \n");
					scanf("%d", &arraySize);
					printf("\nTrials: \n");
					scanf("%d", &trials);
					verify = (arraySize > 0 && trials > 0 && (sortType == 1 || sortType == 2)) ? false : true;
				}
				
				sorter(sortType, trials, arraySize, fp);
				
			break;
	
			//case 3 exit program
			case 3: quit = false; 
				break;
				}//end switch
		option = 0;

	}//end of while loop menu

	fclose(fp);

	return 0;

}//end main

//create random array at arraySize
int* randomize(int arraySize) {

	int* sortArray = malloc(sizeof(int) * arraySize);

	for(int i = 0; i < arraySize; i++)
		sortArray[i] = rand() % 20;

	return sortArray;
}

//function for timing
double makeTime(clock_t start, clock_t end) {
	
	double sortTime = ((double) (end - start)) / CLOCKS_PER_SEC;

	return sortTime;

}
//actually performs the operations specified
void sorter(int sortType, int trials, int arraySize, FILE* fp) {

	clock_t start, end;

	int* sortArray = randomize(arraySize);

	for(int i = 0; i < trials; i++) {

		char type = 'n';
			
		if( sortType == 2 ) {
			start = clock();
			selectionSort(sortArray, arraySize);	
			end = clock();
			type = 's';
		}

		else if( sortType == 1 ) {
			start = clock();
			insertionSort(sortArray, arraySize);
			end = clock();
			type = 'i';
		}
	
	double likeForever = makeTime(start, end);

	fprintf(fp, "%c,%f,%d\n", type, likeForever, arraySize);

	printf("\n Sort: %c,Performed in: %f,on Array of Size: %d\n",type, likeForever, arraySize);

	}//end trials loop

	free(sortArray);

}






