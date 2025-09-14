# Introduction to Data Structures

**Data structures** are ways of organizing and storing data in a computer so that it can be accessed and modified efficiently. Below, we’ll introduce four common data structures:

1. [Linked Lists](#linked-lists)  
2. [Stacks](#stacks)  
3. [Queues](#queues)  
4. [Trees and Graphs](#trees-and-graphs)

Each section will provide:
- A beginner-friendly definition
- A short explanation of how it works
- A Java code example
- Real-world scenarios where the data structure is useful

---

## Linked Lists

### Definition

A **Linked List** is a sequence of nodes where each node stores data and a link (reference) to the next node in the sequence. Unlike arrays, linked lists don’t store data in contiguous memory. Instead, each node “knows” where the next node is.

### How It Works

- **Head**: A reference to the first node.
- **Node**: Typically contains:
  1. The actual data (e.g., an integer)
  2. A reference to the next node (and sometimes the previous one in a **doubly linked list**).

When you want to **insert** or **remove** elements, you just re-link the affected nodes rather than shifting all subsequent data as in an array.

### Simple Java Example (Singly Linked List)

```java
class Node {
    int data;
    Node next; // reference to the next node

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList {
    private Node head; // reference to the first node

    // Add a node at the front
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    // Print all elements
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        // List is now 30 -> 20 -> 10 -> null
        list.printList();
    }
}
```

**Key Operations**:
- Insert (head, tail, or middle)
- Delete
- Traverse

### Real-World Example

- **Music playlist**: Skipping to the next or previous song is like moving through a linked list of songs.
- **Undo/redo functionality** in text editors often uses a linked list structure to track changes.

---

## Stacks

### Definition

A **Stack** is a linear data structure that follows a **LIFO** (Last In, First Out) principle. The last item you **push** (insert) onto the stack is the first item you **pop** (remove).

### How It Works

- **Push**: add an element on top of the stack.
- **Pop**: remove the top element.
- **Peek**: look at the top element without removing it.

Because of LIFO, you only work with one end of the structure (“the top”).

### Simple Java Example Using `java.util.Stack`

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek the top element (doesn't remove it)
        System.out.println("Top element: " + stack.peek()); // 30

        // Pop elements off
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Popped: " + stack.pop()); // 20

        System.out.println("Remaining top element: " + stack.peek()); // 10
    }
}
```

**Key Operations**:
- **push(item)**
- **pop()**
- **peek()**
- **isEmpty()**

### Real-World Example

- **Browser’s back button**: Stacks track visited pages. The last page you visited (pushed) is the first page you go back to (pop).
- **Undo operations**: Each action is placed on a stack; an undo pops the last action.

---

## Queues

### Definition

A **Queue** is a linear data structure that follows the **FIFO** (First In, First Out) principle. The first item you **enqueue** (insert) is the first item you **dequeue** (remove).

### How It Works

- **Enqueue**: add an element to the back of the queue.
- **Dequeue**: remove the element at the front of the queue.
- **Peek**: view the element at the front without removing it.

Because of FIFO, you insert at one end and remove at the other.

### Simple Java Example Using `java.util.LinkedList` as a Queue

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Enqueue elements
        queue.offer("Alice");
        queue.offer("Bob");
        queue.offer("Charlie");

        // Peek at the front
        System.out.println("Front of the queue: " + queue.peek()); // Alice

        // Dequeue elements
        System.out.println("Dequeued: " + queue.poll()); // Alice
        System.out.println("Dequeued: " + queue.poll()); // Bob

        System.out.println("Remaining front: " + queue.peek()); // Charlie
    }
}
```

**Key Operations**:
- **offer(item)** / **add(item)**: enqueue
- **poll()** / **remove()**: dequeue
- **peek()** / **element()**: look at the front element

### Real-World Example

- **Waiting lines** (like a checkout at a grocery store).
- **Print queue**: The first document sent to the printer is the first one printed.

---

## Trees and Graphs

### Trees

#### Definition

A **Tree** is a hierarchical data structure where nodes are connected in parent-child relationships. The topmost node is called the **root**. 

**Example**: A **Binary Tree** is a tree where each node can have up to two children (left and right).

#### How It Works

- **Root Node**: The node at the top.
- **Child Nodes**: Nodes directly connected below a parent.
- **Leaf Nodes**: Nodes with no children.

You can **traverse** a tree in multiple ways (in-order, pre-order, post-order for binary trees).

#### Simple Java Example (Binary Tree)

```java
class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
    }
}

public class BinaryTreeExample {
    TreeNode root;

    // Insert node (simple version, ignoring balancing)
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }
        if (value < current.value) {
            current.left = insertRec(current.left, value);
        } else {
            current.right = insertRec(current.right, value);
        }
        return current;
    }

    // In-order traversal
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeExample tree = new BinaryTreeExample();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        // Print the values in ascending order
        tree.inOrder(tree.root); // Outputs: 20 30 40 50 70
    }
}
```

### Real-World Example (Trees)

- **File systems**: Directories and files are structured as a tree.
- **Organization charts**: Represent employees and their subordinates in a hierarchical manner.

---

### Graphs

#### Definition

A **Graph** is a collection of **nodes** (also called vertices) connected by **edges**. Unlike trees (which are a special type of graph), graphs can have cycles and can be unconnected.

#### How It Works

- **Vertices (Nodes)** store data or unique IDs.
- **Edges** connect two vertices. An edge can be directed or undirected.
- Can be represented using an **adjacency list** (each node stores its neighbors) or an **adjacency matrix** (a 2D array).

#### Simple Java Example (Adjacency List)

```java
import java.util.ArrayList;
import java.util.List;

class Graph {
    private List<List<Integer>> adjacencyList;

    public Graph(int numVertices) {
        adjacencyList = new ArrayList<>();
        // Initialize each vertex's list
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an undirected edge between u and v
    public void addEdge(int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    // Print graph connections
    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Node " + i + ": ");
            for (Integer neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph with 5 vertices
        Graph graph = new Graph(5);

        // Add edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        // Print adjacency
        graph.printGraph();
    }
}
```

#### Real-World Example (Graphs)

- **Social networks**: Users are nodes, friendships/follows are edges.
- **Road networks**: Intersections or cities are nodes, roads are edges.

---

## Conclusion

- **Linked Lists** let you insert or remove elements without shifting large blocks of memory.  
- **Stacks** enforce a last-in, first-out sequence for backtracking or undo operations.  
- **Queues** follow a first-in, first-out order, ideal for sequential processing like print jobs or waiting lines.  
- **Trees** and **Graphs** organize data in more complex relationships than straight sequences, allowing hierarchical (trees) or interconnected (graphs) structures.

Each data structure is useful in different contexts. By understanding their properties, you can choose the **right** structure for each problem.
