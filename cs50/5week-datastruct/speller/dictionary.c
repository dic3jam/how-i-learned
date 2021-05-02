#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>
#include "dictionary.h"

#define DICTIONARY "dictionaries/large"
#define N 53

// Represents a node in a hash table
typedef struct node
{
    char word[LENGTH + 1];
    struct node *next;
}
node;

// Number of buckets in hash table
//const unsigned int N = 53;

//Variable for storing number of words in dictionary
int wordTotal = 0;

// Hash table
node* table[N];

// Returns true if word is in dictionary else false
bool check(const char *word)
{
	int index = hash(word);

	bool result = false;

	if( table[index] == NULL )
		result = false;	
	else
		for(node* trav = table[index]; trav != NULL; trav = trav->next) {
			if( strcasecmp(word, trav->word) == 0 ) {
				result = true;
				break;
			}
			else
				result = false;		
		}	

	return result;

}

// Hashes word to a number
unsigned int hash(const char *word)
{
	 int hashValue = 0;	
	
	 for(int i = 0; isalpha(word[i]); i++) {
		int a = (int) word[i] * i;
		hashValue += a;	       	
	 }

	 hashValue = hashValue % N;

	 return hashValue;

}

// Loads dictionary into memory, returning true if successful else false
bool load(const char *dictionary)
{
	FILE *fp = fopen(dictionary, "r");

	if( fp == NULL ) {
		printf("\nUnable to open dictionary %s", dictionary);
		return 1;
	}

	char* buffer = malloc((sizeof(char)) * (LENGTH+1));

	//for(short i = 0; i < (LENGTH+1); i++)
	//	buffer[i] = 0;

	for(short i = 0; i <= N; i++)
		table[i] = NULL;

	while(!feof(fp)) {

		fscanf(fp, "%s", buffer); 

		if( isalpha(buffer) ) {
			
			node* n = malloc(sizeof(node));
			if( n == NULL ) {
				printf("\nUnable to allocate node* n\n");
				return 1;
			}

			strcpy(n->word, buffer);

			n->next = NULL;

			int index = hash(buffer);

			if( table[index] == NULL ) {
				table[index] = n;
			}	

			else {
				n->next = table[index];
				table[index] = n;		
			}

			wordTotal++;
	
		}

		for(short i = 0; i < (LENGTH+1); i++)
			buffer[i] = 0;

	}//end while feof

	free(buffer);

	fclose(fp);

	if( wordTotal > 0 )
		return true;
	else
		return false;
}

// Returns number of words in dictionary if loaded else 0 if not yet loaded
unsigned int size(void)
{
       return wordTotal;
}

// Unloads dictionary from memory, returning true if successful else false
bool unload(void)
{	

	bool success = false;

	for(int i = 0; i <= N; i++) {
		if(table[i] == NULL)
			continue;
		else {	
			for(node* trav = table[i]; trav != NULL; ){
				node* tmp = trav->next;
				free(trav);
				trav = tmp;
			}	

			table[i] = NULL;
		}

	}

	for(int i = 0; i <= N; i++) {
		if( table[i] == NULL ) {
			success = true;
		}
		else {
			success = false;
			break;
		}
	}

	return success;
		
}
