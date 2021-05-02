#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

/* Structure: node
 *
 * represets a node in a singly linked list
 * data: data held by the node
 * next: pointer to the next node NULL if last element
 */
typedef struct node {
	void* data;
	struct node* next;
} node;

/* Structure: linkedlist
 *
 * Represents a singly linked list
 * head: first node in the list- if NULL then list is empty
 */
typedef struct linkedlist {
	struct node* head;
	int list_size = 0;
} linkedlist;

bool add_beginning(linkedlist* list, const void* data, const size_t dataType);

node* create_node(linkedlist* list, const void* data, const size_t dataType);

linkedlist* create_list();

void remove_node(linkedlist* list, int pos);

void destroy(node*);
