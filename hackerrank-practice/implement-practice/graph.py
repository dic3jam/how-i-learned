import sys
import csv
"""
graph.py
Implementation of a simple graph.... in Phierece-thon
"""

class Node:
    """
    Inputs: String name, List<links> links
    Returns: Node 
    """
    def __init__(self, name, argv):
        self.name = name
        self.links = []
        for arg in argv:
            self.links.append(arg)

    def print_node(self):
        print(self.name)
        for l in self.links:
            print(f"{l.noode}-{l.cost}")

class Link:
    """
    Inputs: Int cost, String noode (just the name of the node)
    Returns: Link
    """
    def __init__(self, noode, cost):
        self.noode = noode  
        self.cost = int(cost)

class graph:
    """
    Inputs: Node root
    Returns: graph
    """
    def __init__(self, root):
        self.root = root
        self.nodes = {}
        self.nodes[root.name] = root

    def addNode(self, node):
        self.nodes[node.name] = node

    def print_graph(self):
        self.root.print_node()
        print("")
        for x in self.nodes:
            self.nodes[x].print_node()
            print("")

def build_links(row):
    links = []
    for x in row[::2]: 
        links.append(Link(x, row[row.index(x)+1]))
    return links

"""
graph-file schema:
Node name,Neighbor1,neighbor1 cost,neighbor2....
"""
def read_graph(graph_file):
    node_num = 0
    read_csv = csv.reader(graph_file, delimiter=',')
    for row in read_csv:
        if node_num == 0:
            root = Node(row[0], (build_links(row[1:])))
            new_graph = graph(root)
        else:
            newNode = Node(row[0], (build_links(row[1:])))
            new_graph.addNode(newNode)
        node_num += 1
    print("Graph imported of " + str(node_num) + " nodes")
    return new_graph

def bfs(graph, dest_node):
    queue = []
    visited = []
    # cost = 0
    queue.insert(0, graph.root)
    visited.append(graph.root)
    while len(queue) != 0:
        check_node = queue[len(queue)-1]
        queue.remove(check_node)
        print(f"{check_node.name} ->", end=" ")
        for link in check_node.links:
            link_node = graph.nodes[link.noode]
            if link_node.name == dest_node:
               print(f"[[{dest_node}]]")
               continue
               """ 
                print(f"Cost: {cost}", end=" ")
                for node in visited:
                    print(f"{node.name} ->", end=" ")
                cost = 0
                print(f"{link_node.name}")
                continue
                """
            if link_node not in visited:
                visited.append(link_node)
                queue.insert(0, link_node)
    print("")

"""
Depth-first-search
Inputs- graph graph - the graph to search. String dest_node - node to search for
Returns- String the path to get to the dest_node, and Int the cumulative cost
"""
def dfs(graph, dest_node):
    stack = []
    visited = []
    # cost = 0
    stack.append(graph.root)
    visited.append(graph.root)
    while len(stack) != 0:
        check_node = stack.pop()
        print(f"{check_node.name} ->", end=" ")
        for link in check_node.links:
            link_node = graph.nodes[link.noode]
            if link_node.name == dest_node:
               print(f"[[{dest_node}]]")
               continue
               """ 
                print(f"Cost: {cost}", end=" ")
                for node in visited:
                    print(f"{node.name} ->", end=" ")
                cost = 0
                print(f"{link_node.name}")
                continue
                """
            if link_node not in visited:
                visited.append(link_node)
                stack.append(link_node)
                #cost += link.cost
    print("")

def main():
    if len(sys.argv) < 2:
        print("Gimme something jackass")
        return
    
    graph_file = open(sys.argv[1], "r")
    the_graph = read_graph(graph_file)
    the_graph.print_graph()

    opt = 0
    while(opt != 5):
        opt = int(input("Options:\n1 - add vertice\n2 - BFS\n3 - DFS\n4 - print graph\n5 - quit\n"))
        if opt == 1:
            vertice = input("Vertice name: ")
            links = input("In format node1,weight1,node2,weight2\nLinks: ")
            links = list(links.split(','))
            the_graph.addNode(Node(vertice, (build_links(links))))
        elif opt == 2:
            node_name = input("Node to traverse to:\n")
            bfs(the_graph, node_name)
        elif opt == 3:
            node_name = input("Node to traverse to:\n")
            dfs(the_graph, node_name)
        elif opt == 4:
            the_graph.print_graph()
        elif opt == 5:
            sys.exit(0)
        else:
            print("1-5 dummy")
            opt = 0

main()
