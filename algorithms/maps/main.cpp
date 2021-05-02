#include "graph.h"
#include <stack>
#include <queue>
#include <limits.h>
#include <iostream>

using namespace std;

const int INFINITY = INT_MAX;
const int NO_PREDECESSOR = -1;

/*
 * Function: min_dist_vertex
 * ----------------------------
 *  Helper function for dijkstra.
 *  Finds the vertex in the search queue with the minimum
 *  estimated distance from the source vertex.
 *
 *  queue: search queue
 *  dist: distance array from Dijkstra's method. dist[i]
 *         is the distance from the source vertex to vertex i
 *         along the lowest-cost path found so far
 *
 * returns: the vertex u with the smallest estimated distance to the source
             Also removes u from queue.
 *
 */
int min_dist_vertex(vector<int> &queue, int* dist) {
    int min_dist = INFINITY;

    // u will be the index of the vertex in the queue
    // which is the minimum distance from source
    int u = -1;

    // index in search queue of minimum distance vertex
    int mindex = -1;

    for (int i = 0; i < queue.size(); i++) {
        int v = queue[i];

        if (dist[v] < min_dist) {
            min_dist = dist[v];
            u = v;
            mindex = i;
        }
    }

    // Remove u from the queue
    queue.erase(queue.begin() + mindex);
    return u;
}

/*
 * Function: dijkstra
 * ----------------------------
 *  Searches a graph using Dijkstra's algorithm, returning
 *  the predecessor array that will give you the lowest-cost
 *  path from the source node to any other node in the graph
 *
 *  graph: graph to search
 *  src: index of source vertex to begin search from
 *
 * returns: a predecessor array prev. prev[i] yields the index of
 *           vertex i's predecessor in a search begun at a source vertex.
 *       prev[src] is defined to be the constant NO_PREDECESSOR (usually -1)
 *
 */
int* dijkstra(Graph* graph, int src) {
    vector<int> queue;
    int* prev = (int*) malloc(graph->SIZE * sizeof(int));
    int dist[graph->SIZE];

    for (int v = 0; v < graph->SIZE; v++) {
        dist[v] = INFINITY;
        prev[v] = NO_PREDECESSOR;
        queue.push_back(v);
    }

    dist[src] = 0;

    while (!queue.empty()) {
        int u = min_dist_vertex(queue, dist);

        for (int neighbor : get_neighbors(graph, u)) {
            int alt = dist[u] + graph->distance[u][neighbor];

            if (alt < dist[neighbor]) {
                dist[neighbor] = alt;
                prev[neighbor] = u;
            }
        }
    }

    return prev;
}

/*
 * Function: print_path
 * ----------------------------
 *  Prints the path from a destination vertex to the source, using the
 *	predecessor array output from a search method
 *
 *   graph: graph that was searched, used for getting node labels
 *   prev: predecessor array fom a search method. prev[i] yields the index of
 *         vertex i's predecessor in a search begun at a source vertex.
 *		   prev[src] is defined to be the constant NO_PREDECESSOR (usually -1)
 *	 dst: index of destination vertex to trace back to source
 *
 */
 void print_path(Graph* graph, int* prev, int dst) {
	//start at destination
	//-1 0 0 1
	//to get to 3, I went to 1, to get to 1 I came from 0
	//3 <- 1 <- 0
	
	//make a stack
	stack<int> path;
	int current = dst;

	while(current != NO_PREDECESSOR) {
		path.push(current);
		current = prev[current];
	}

	//will produce 0 1 3
	//now when iterate through stack will be in order
	
	while(!path.empty()) {
		int v = path.top();
		path.pop();
		cout << graph->labels[v] << " -> ";
	}

	cout << endl;

}

/*
 * Function: dfs
 * ----------------------------
 *  Searches a graph using a depth-first strategy
 *
 *	 graph: graph to search
 *	 src: index of source vertex to begin search from
 *
 *	returns: a predecessor array prev. prev[i] yields the index of
 *           vertex i's predecessor in a search begun at a source vertex.
 *		     prev[src] is defined to be the constant NO_PREDECESSOR (usually -1)
 *
 */
int* dfs(Graph* graph, int src) {
	bool discovered[graph->SIZE];
	int* predecessor = (int*) malloc(graph->SIZE * sizeof(int));

	for(int i = 0; i < graph->SIZE; i++) {
		discovered[i] = false;
		predecessor[i] = NO_PREDECESSOR;
	}

	stack<int> s;
	s.push(src);

	while(!s.empty()) {
		int v = s.top();
		s.pop();
		if(!discovered[v]) {
			discovered[v] = true;	
			for(int n : get_neighbors(graph, v)) {
				s.push(n);
				if(!discovered[n])
					predecessor[n] = v;			
			}
		}
	}

	return predecessor;
}

/*
 * Function: bfs
 * ----------------------------
 *  Searches a graph using a breadth-first strategy
 *
 *	 graph: graph to search
 *	 src: index of source vertex to begin search from
 *
 *	returns: a predecessor array prev. prev[i] yields the index of
 *           vertex i's predecessor in a search begun at a source vertex.
 *		     prev[src] is defined to be the constant NO_PREDECESSOR (usually -1)
 *
 */
int* bfs(Graph* graph, int src) {
	bool discovered[graph->SIZE];
	int* predecessor = (int*) malloc(graph->SIZE * sizeof(int));

	for(int i = 0; i < graph->SIZE; i++) {
		discovered[i] = false;
		predecessor[i] = NO_PREDECESSOR;
	}

	queue<int> q;
	q.push(src);
	discovered[src] = true;

	while(!q.empty()) {
		int v = q.front();
		q.pop();
		
		for(int n : get_neighbors(graph, v)) {
			if(!discovered[n]) {
				q.push(n);
				discovered[n] = true;
				predecessor[n] = v;
			}

		}
	}

	return predecessor;
}

int main() {
	Graph* graph = read_graph_file("boston.dat");
	print_graph(graph);
/*
	cout << "BFS\n";
	int* bfs_predecessor = bfs(graph, 0);
	cout << "[ ";
	for(int i = 0; i < graph->SIZE; i++) {
		cout << bfs_predecessor[i] << " ";
	}
	cout << " ]\n" << endl;

	cout << "DFS\n";
	int* dfs_predecessor = dfs(graph, 0);
	cout << "[ ";
	for(int i = 0; i < graph->SIZE; i++) {
		cout << dfs_predecessor[i] << " ";
	}
	cout << " ]\n" << endl;
*/
	cout << "DJ's\n";
	int* djs_predecessor = dijkstra(graph, 0);
	cout << "[ ";
	for(int i = 0; i < graph->SIZE; i++) {
		cout << djs_predecessor[i] << " ";
	}
	cout << " ]\n" << endl;

}
