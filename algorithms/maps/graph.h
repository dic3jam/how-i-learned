#ifndef GRAPH_H_INCLUDED
#define GRAPH_H_INCLUDED

using namespace std;

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <vector>

typedef struct Graph {
	int SIZE;
	int** distance;
	char** labels;
} Graph;

Graph* read_graph_file(const char*);
vector<int> get_neighbors(Graph*, int);
void print_graph(Graph*);

#endif
