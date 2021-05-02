#include "bst.h"

const int STRING_LENGTH = 1024;

/*
 * function: create_tree
 * ----------------------------
 * Creates an empty tree
 *
 *	data_size: size of keys in bytes
 *	comparator: function for comparing keys. Must obey the following rules:
 *				comparator(a, b) < 0 if a < b
 *				comparator(a, b) > 0 if a > b
 *				comparator(a, b) = 0 if a == b
 *	formatter: function that returns a string representation of keys
 *
 * returns: a tree with root = NULL
 */
Tree* create_tree(const size_t data_size,
				  int (*comparator)(const void*, const void*),
				  char* (*formatter)(const void*)) {

	// Allocate space for the tree
	Tree* tree = (Tree*) malloc(sizeof(Tree));

	// Initialize the attributes
	tree->root = NULL;
	tree->data_size = data_size;
	tree->compare = comparator;
	tree->formatter = formatter;

	// All done!
	return tree;	
}

/*
 * function: create_tree_node
 * ----------------------------
 * Creates a tree node and sets its key equal to data
 *
 *	
 * returns: A node with:
 *		key = data
 *		parent = NULL
 *		left = NULL
 *		right = NULL
 */
TreeNode* create_tree_node(const void* data, const size_t data_size) {
	// Allocate space for the node	
	TreeNode* node = (TreeNode*) malloc(sizeof(TreeNode));
	
	// Set the key
	node->key = malloc(data_size);
	memcpy(node->key, data, data_size);

	// Init pointers to the parents and kids
	node->parent = NULL;
	node->left = NULL;
	node->right = NULL;

	// All done!
	return node;
}

/*
 * function: tree_as_string
 * ----------------------------
 * Returns a char* representation of the BST
 *
 * 	tree: the tree
 * 
 */
char* tree_as_string(const Tree* tree) {
	char* output = (char*) malloc(STRING_LENGTH * sizeof(char));
	strcpy(output, "Tree:");
	subtree_as_string(tree->root, output, tree->formatter);
	return output;
}

/*
 * function: subtree_as_string
 * ----------------------------
 * Apppends the string representation of the subtree rooted at node to output
 * 	node: root of subtree
 *  output: storing the string representation of the whole tree
 *  formatter: converts node's key type to a string
 * 
 * NB: this doesn't work if the string representation of the tree exceeds
 *     STRING_LENGTH. But fixing it would be annoying and getting tree_delete to
 *     work right took me three hours, so I'm not in the mood to fix this
 *     problem at the moment.
 */
void subtree_as_string(const TreeNode* node, char* output, char* (*formatter)(const void*)) {
	if (node != NULL) {
		if(node->left != NULL){
			subtree_as_string(node->left, output, formatter);
		}
		if(node->key != NULL){
			char* key_as_string = formatter(node->key);
			sprintf(output,"%s %s", output, key_as_string);
			free(key_as_string);
		}
		else {
			return;
		}
			if(node->right != NULL)
				subtree_as_string(node->right, output, formatter);
	}
}

/*
 * Function: max_depth
 * ----------------------------
 * Recursively determines the depth of the subtree rooted at a node
 *
 *   x: node in a tree
 *
 * returns: maximum depth of subtree rooted at x
 *
 */
int max_depth(const TreeNode* x) {
	if (x == NULL) {
		return 0;
	} else {
		int lDepth = max_depth(x->left);
		int rDepth = max_depth(x->right);

		if (lDepth > rDepth) {
			return (lDepth + 1);
		} else {
			return (rDepth + 1);
		}
	}
}

/*
 * Function: tree_depth
 * ----------------------------
 * Determines the maximum depth of a tree
 *
 *   tree: a tree
 *
 * returns: maximum depth of tree
 *
 */
int tree_depth(const Tree* tree) {
	if(tree == NULL)
		return 0;
	return max_depth(tree->root);
}

/*
 * function: tree_insert
 * ----------------------------
 * Inserts a node in to a tree ob/eying the binary search tree property
 *
 * 	tree: tree to add to
 *	data: data to put in new node
 * 
 */
bool tree_insert(Tree* tree, const void* data) {

	if(tree == NULL)
		return false;
	if(data == NULL)
		return false;

	TreeNode* newNode = create_tree_node(data, tree->data_size);

	TreeNode* x = tree->root;
	TreeNode* y = NULL;

	//get to end of tree
	while(x != NULL) {
		y = x;
		if(tree->compare(data, x->key) < 0) {
			x = x->left;
		} else {
			x = x->right;
		}
	}
	//determine if newNode goes to left or right side of current node
	if(y == NULL) {
		tree->root = newNode;
	} else if ( tree->compare(data, y->key) < 0) {
		newNode->parent = y;
		y->left = newNode;
	} else {
		newNode->parent = y;
		y->right = newNode; 
	}


	return true;

}

/*
 * function: recursive_search
 * ----------------------------
 * Recursively searches a subtree for a node containing query value
 *
 * 	node: root of the subtree
 *	q: value to find in tree
 *	compare: function for comparing keys. Must obey the following rules:
 *				compare(a, b) < 0 if a < b
 *				compare(a, b) > 0 if a > b
 *				compare(a, b) = 0 if a == b
 * 
 * returns: a pointer to the node containing the key, NULL if not found
 */
TreeNode* recursive_search(TreeNode* node, const void* q, int (*compare)(const void*, const void*)) {
	if(node == NULL)
		return NULL;
	if(q == NULL)
		return NULL;

	if(compare(node->key, q) > 0)
		recursive_search(node->left, q, compare);
	else if(compare(node->key, q) < 0)
		recursive_search(node->right, q, compare);
	else if(compare(node->key, q) == 0)
		return node;	
	else	
		return NULL;
}

/*
 * function: search
 * ----------------------------
 * Searches the tree for a query value
 *
 * 	tree: the tree
 *	q: value to find in tree
 * 
 * returns: true if the key q is present in the tree, false if not
 */
bool search(const Tree* tree, const void* q) {
	if(tree == NULL)
		return false;
	if(q == NULL)
		return false;

	TreeNode* s = recursive_search(tree->root, q, tree->compare);
	
	if(s != NULL)
		return true;
	else
		return false;
}

/*
 * Function: tree_maximum
 * ----------------------------
 * Finds the node with the maximum key value in the subtree rooted at node
 *
 *   node: root of a subtree
 *
 */
TreeNode* tree_maximum(TreeNode* node) {
	if (node == NULL) {
		return NULL;
	}

	while (node->right != NULL) {
		node = node->right;
	}

	return node;
}

/*
 * Function: transplant
 * ----------------------------
 * Replaces one node with another in a tree
 *
 *   tree: a tree
 *   u: node to be replaced
 *   v: node to replace with
 *
 */
void transplant(Tree* tree, TreeNode* u, TreeNode* v) {
	if(tree == NULL)
		return;
	
	//assign as root if working with root node
	if(u->parent == NULL)
		tree->root = v;
	//if this is the left node, assign v to left side
	if(u == u->parent->left) 
		u->parent->left = v;
	//otherwise this is the right node
	else
		u->parent->right = v;

	if(v != NULL)
		v->parent = u->parent;
	
	node_delete(u);

}

/*
 * Function: tree_delete
 * ----------------------------
 * Finds the shallowest node with a given key value and removes it
 *
 *   tree: a tree
 *   key: key to remove
 *
 * returns: true if removal is successful, false otherwise
 *
 */
bool tree_delete(Tree* tree, const void* key) {

	if(tree == NULL)
		return false;
	if(key == NULL)
		return false;
	if(tree_maximum(tree->root) == 0)
		return false;

	TreeNode* foundIt = recursive_search(tree->root, key, tree->compare);

	if(foundIt == NULL)
		return false;
	//if childless	
	if(foundIt->left == NULL && foundIt->right == NULL) {
		node_delete(foundIt);
		return true;
	}
	//if no left child
	else if(foundIt->left == NULL) {
		transplant(tree, foundIt, foundIt->right);	
		return true;
	}
	//if no right child
	else if(foundIt->right == NULL) {
		transplant(tree, foundIt, foundIt->left);
		return true;
	}
	//if both
	else {
		TreeNode* prev = tree_maximum(foundIt->left);
		foundIt->key = prev->key;
		transplant(tree, prev, prev->left);
		return true;
	}

	return false;
}


/*
 * function: destroy_subtree
 * ----------------------------
 * Destroys all nodes in the subtree rooted at a given node
 *
 * 	node: node in a tree
 * 
 */
void destroy_subtree(TreeNode* node) {
	if (node == NULL) 
		return;
 	
	destroy_subtree(node->left);
	TreeNode* right = node->right;
	free(node->key);
	free(node);
	destroy_subtree(right);
}

/*
 * function: node_delete
 * ------------------------------
 *  Destroys the target node with no mercy
 *
 *  	node: the node to eliminate with no prejudice
 *  	FOR THE REPUBLIC!!
 */
void node_delete(TreeNode* node) {
	if (node == NULL) 
		return;

	free(node);
}

/*
 * function: destroy_tree
 * ----------------------------
 * Destroys all nodes in a tree and the tree itself
 *
 * 	tree: tree to destroy
 * 
 */
void destroy_tree(Tree* tree) {
	if (tree == NULL) 
		return;

	destroy_subtree(tree->root);
	free(tree);
}

// COMPARATORS //

int comp_doubles(void* a, void* b) {
	double* ia = (double*) a;
	double* ib = (double*) b;

	if(*ia > *ib) {
		return 1;	
	} else if (*ia < *ib) {
		return -1;
	} else {
		return 0;
	}

}//end comp_doubles

int comp_ints(void* a, void* b) {

	int* ia = (int*) a;
	int* ib = (int*) b;

	if(*ia > *ib) {
		return 1;	
	} else if (*ia < *ib) {
		return -1;
	} else {
		return 0;
	}
	
}//end comp_ints

void* shift(void* a, int i, size_t element_size) {

	return (void*) ((char*) a + i * element_size);

}//end shift
