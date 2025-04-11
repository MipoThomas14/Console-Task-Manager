# Trees and Graphs in Java

In this guide, we’ll explore **Trees** and **Graphs** in Java, show how to implement them, discuss **binary searching** in a **binary search tree**, and highlight some practical applications.

---

## Table of Contents

1. [Trees](#trees)
   - [What Is a Tree?](#what-is-a-tree)
   - [Binary Tree Example](#binary-tree-example)
   - [Binary Search Tree (BST)](#binary-search-tree-bst)
     - [Insertion](#insertion-in-a-bst)
     - [Searching](#searching-in-a-bst)
   - [Practical Applications of Trees](#practical-applications-of-trees)
2. [Graphs](#graphs)
   - [What Is a Graph?](#what-is-a-graph)
   - [Representing Graphs in Java](#representing-graphs-in-java)
   - [Graph Traversal (DFS and BFS)](#graph-traversal-dfs-and-bfs)
   - [Practical Applications of Graphs](#practical-applications-of-graphs)

---

## Trees

### What Is a Tree?

- A **Tree** is a hierarchical structure of nodes, where each node can have multiple children.
- The **root** node is at the top, and each node below can be considered a child of another node.
- Trees are *acyclic*, meaning there’s only one path from the root to any node (no loops).

#### Common Terminology

- **Root**: The topmost node.
- **Leaf**: A node with no children.
- **Parent/Child**: Nodes connected in an upward/downward relationship.
- **Subtree**: A tree formed by a node and all its descendants.
- **Height**: The number of edges on the longest path from the root to a leaf.

---

### Binary Tree Example

A **Binary Tree** is a tree where each node has *at most two children* (commonly called `left` and `right`).

#### Simple Java Implementation

```java
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    // Example method: in-order traversal (Left, Root, Right)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Construct a simple tree manually
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(15);

        // In-order traversal outputs: 5 10 15
        tree.inOrder(tree.root);
    }
}
```

**Traversal Orders**:
1. **In-order**: Left → Root → Right.
2. **Pre-order**: Root → Left → Right.
3. **Post-order**: Left → Right → Root.

---

### Binary Search Tree (BST)

A **Binary Search Tree** is a special binary tree where:
- **Left child** has a smaller value than its parent.
- **Right child** has a larger value than its parent.

This ordering allows **fast lookups** (on average *O(log n)* time) if the tree is balanced.

#### Insertion in a BST

```java
public class BinarySearchTree {
    Node root;

    class Node {
        int value;
        Node left, right;
        Node(int val) { this.value = val; }
    }

    // Insert a value into the BST
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private Node insertRec(Node current, int val) {
        if (current == null) {
            return new Node(val);
        }
        if (val < current.value) {
            current.left = insertRec(current.left, val);
        } else if (val > current.value) {
            current.right = insertRec(current.right, val);
        }
        // if val == current.value, do nothing or handle duplicates
        return current;
    }
}
```

**Key Points**:
- If the tree is empty, the new value becomes the root.
- If `val` is less than `current.value`, insert into the left subtree; if greater, go right.

---

#### Searching in a BST

```java
public boolean search(int target) {
    return searchRec(root, target);
}

private boolean searchRec(Node current, int target) {
    if (current == null) {
        return false; // not found
    }
    if (current.value == target) {
        return true; // found
    }
    // Explore left or right subtree based on comparison
    if (target < current.value) {
        return searchRec(current.left, target);
    } else {
        return searchRec(current.right, target);
    }
}
```

- Average time complexity: *O(log n)* if the tree is balanced, *O(n)* in the worst case (if it’s like a linked list).

---

### Practical Applications of Trees

1. **File Systems**: Directories and files form a hierarchical structure.
2. **Organization Charts**: Employees (nodes) under managers (parents).
3. **Binary Search Trees**: Efficient searching, insertion, and deletion (especially for sorted data).
4. **Parsing Expressions (Syntax Trees)** in compilers or interpreters.

---

## Graphs

### What Is a Graph?

A **Graph** is a set of **vertices** (or nodes) connected by **edges**.  
- **Undirected Graph**: Edges have no direction; movement is possible both ways.  
- **Directed Graph (Digraph)**: Each edge has a direction, like one-way streets.

#### Terminology

- **Vertex (Node)**: Represents an entity (e.g., person, city).
- **Edge**: Connects two vertices.
- **Weight (Optional)**: Edges can have weights (costs, distances).
- **Adjacent**: Two nodes are connected by an edge.

---

### Representing Graphs in Java

Common ways:
1. **Adjacency List**: Each node keeps a list of its neighbors.
2. **Adjacency Matrix**: A 2D array where `matrix[u][v]` indicates edge presence/weight from `u` to `v`.

**Adjacency List Example**:

```java
import java.util.*;

public class Graph {
    private List<List<Integer>> adjList;

    // Create a graph with n vertices (0..n-1)
    public Graph(int n) {
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an undirected edge between u and v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // remove if you want a directed graph
    }

    public void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Node " + i + ": ");
            for (Integer neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.printGraph();
    }
}
```

---

### Graph Traversal (DFS and BFS)

#### Depth-First Search (DFS)
- **Go as deep as possible** before backtracking.
- Can be implemented **recursively** or with a **stack**.

**Recursive Example**:
```java
public void dfs(int start) {
    boolean[] visited = new boolean[adjList.size()];
    dfsHelper(start, visited);
}

private void dfsHelper(int node, boolean[] visited) {
    visited[node] = true;
    System.out.println("Visited: " + node);

    for (int neighbor : adjList.get(node)) {
        if (!visited[neighbor]) {
            dfsHelper(neighbor, visited);
        }
    }
}
```

#### Breadth-First Search (BFS)
- **Explore all neighbors** first, then move outward.
- Typically uses a **queue**.

**Example**:
```java
public void bfs(int start) {
    boolean[] visited = new boolean[adjList.size()];
    Queue<Integer> queue = new LinkedList<>();
    
    visited[start] = true;
    queue.offer(start);

    while (!queue.isEmpty()) {
        int current = queue.poll();
        System.out.println("Visited: " + current);

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }
    }
}
```

---

### Practical Applications of Graphs

1. **Social Networks**: Users are nodes; friendships/follows are edges.
2. **Pathfinding**: Mapping roads (edges) between cities (nodes) for shortest path (Dijkstra’s, A*).
3. **Dependency Resolution**: Package managers use graphs to represent dependencies.
4. **Routing**: Network packet routing, where routers are nodes and connections are edges.

---

## Summary

- **Trees**: Hierarchical, acyclic structures; BSTs let you do **binary searches** for efficient data operations (insertion, deletion, lookup).
- **Graphs**: Nodes and edges, which can be directed or undirected. Traversal methods like DFS and BFS are vital for analyzing connectivity, shortest paths, and more.
- **Real-World Usage**: Both trees and graphs underlie many algorithms in file systems, compilers, social networks, and route planning.

Use the provided Java code snippets as a starting point to implement **custom** tree or graph structures and to practice searching through them.
