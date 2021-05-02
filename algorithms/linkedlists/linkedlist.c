#include "linkedlist.h"

//basic functions
linkedlist* create_list() {

	linkedlist* list = (linkedlist*) malloc(sizeof(linkedlist*));
	list->head = NULL;
	return list;
}

node* create_node(linkedlist* list, const void* data, const size_t dataType){

	node* newNode = (node*) malloc(sizeof(node));

	newNode->data = malloc(dataType);

	memcpy(newNode->data, data, dataType);

	list->list_size++;

	return newNode;
}	

void destroy(node* n) {

	free(n->data);
       	free(n);

}

//add functions

/* Function: add_beginning
 * 
 * Adds data to the beginning of the list
 * list: list to add to
 * data: data to place in node
 * dataType: the size of data's datatype
 *
 * returns true if operation was successful, false if otherwise
 */
bool add_beginning(linkedlist* list, const void* data, const size_t dataType) {

	node* newNode = create_node(list, data, dataType);
	
	newNode->next = list->head;

	list->head = newNode;

	return true;
}

void add_end(linkedlist* list, int pos) {

}

void add_n(linkedlist* list, int pos) {

}
//removal functions

void remove_node(linkedlist* list, int pos){

	node* trav = list->head;
	node* bridge = trav;

	for(int i = 0; i < pos; i++) {
		trav = trav->next;

		if(i != 0)
			bridge = bridge->next;

	}

	bridge->next = trav->next;

	free(trav);

}

void remove_beginning(linkedlist* list) {

}	

void remove_end(linkedlist* list) {

}

//get functions


