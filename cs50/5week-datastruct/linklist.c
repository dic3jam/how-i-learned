#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
//make test
typedef struct node 
{		
int ID;
char* name;
struct node *next;	
} node;	

node* newNode(int id, char* n);

bool searchName(node* h, char* n);

void delID(int id, node* h);

node* delList(node *h);

void displayAll(node* h);

int main (void) {

	node* head = NULL;
	
	bool quit = true;

	int uniqID = 0;

	while(quit) {
	
		short option = 0;
		
		printf("1- Create a new linked list\n2- Search by name\n3- Insert a new node to the beginning of the list\n4- Insert a new node at the end of the list\n5- Delete an element by uniqID\n6- Delete the current list\n7- Display all nodes\n8- QUIT\n\n");
	
		scanf("%hd",&option);

		char* n = malloc(20*sizeof(char));
			if( n == NULL )
				return 1;
	   
		switch(option) {
				//create a new linked list
			case 1: if( head == NULL ) { 
					printf("\nPlease input the first name: ");
					scanf("%s",n);	
					node* i = newNode(uniqID, n);
					head = i; 
					uniqID++;
				}
				break;		
				//search by name 
			case 2: printf("\nPlease input the name: ");	
				scanf("%s",n);
				bool isItThere = searchName(head, n);
				if ( isItThere )
					printf("\nThat name is on the list\n\n");
				else
					printf("\nThat name is not on the list\n\n");
				break;
				//insert a new node at the beginning of the list
			case 3: if( head == NULL ) {
					printf("Create a list first");
					break;
				}
				else {			
					printf("\nWhat is their name?: ");
					scanf("%s",n);
					node* i  = newNode(uniqID,n);
					i->next = head;
					head = i;	
					uniqID++;
					break;
				}
				break;
				//insert a new node at the end of the list
			case 4:	if( head == NULL ) {
					printf("Create a list first");
					break;
				}
				else {			
					printf("\nWhat is their name?: ");
					scanf("%s",n);
					node* i  = newNode(uniqID,n);	
					node* trav = head;
					for( node* tmp = trav; tmp != NULL; tmp = tmp->next) 
						if( tmp->next == NULL )
							trav = tmp;	
					trav->next = i;		
					uniqID++;
				}
				break;
				//delete an item by uniqID
			case 5: printf("\nWhat is the ID?: ");
				int id = 0;
				scanf("%d",&id);
				delID(id, head);
				break;
				//delete the current list
			case 6: if( head != NULL )
					head = delList(head);
				printf("TERMINATED!\n\n");
			       	break;
				//display all nodes
			case 7:	if( head == NULL )
				       printf("There is no list\n\n");	
				else
					displayAll(head);
				break;
				//quit
			case 8: quit = false;
				if( head != NULL )
					head = delList(head);
				free(n);
				free(head);
				break;

			default: printf("You must input 1 through 8 only\n\n");
		
		}//end switch menu
			
	}//end menu while	

	return 0;

}//end main

node* newNode(int id, char* n) {

	node* a  = malloc(sizeof(node));

	a->ID = id;
	a->name = n;
	a->next = NULL;
	
	return a;	
}

bool searchName(node* h, char* n) {

	bool existName = false;

	for( node* trav = h; trav != NULL; trav = trav->next ) {
		if( strcmp(n, trav->name) == 0 ){
			existName = true;	
			break;
		}
		else
			existName = false;	
	}

	return existName;
}

//TODO
void delID(int id, node* h) {






}


node* delList(node* h) {
	
	while(h != NULL) {
		
		node *trav = h->next;
		free(trav);
		h = trav;
	}

	return h;
}

void displayAll(node* h) {

	int i = 0;

	for( node *trav = h; trav != NULL; trav = trav->next ) {
		if( trav->next == NULL ) { 
			printf("\n%d: uniqID %d, Name: %s, EOL\n\n", i, trav->ID, trav->name);
			printf("\nThe list has %d items\n", i);
		}
		else{	
			printf("\n%d: uniqID %d, Name: %s\n", i, trav->ID, trav->name);
		}
		
		i++;	

	}	
}










