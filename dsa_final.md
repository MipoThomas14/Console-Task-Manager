
## 1. Linked Lists 

**Definition & Variants**  
- A **linked list** is a dynamic sequence of nodes, each holding data and a reference link.  
- **Singly**: nodes have one link (`next`).  
- **Doubly**: nodes have two links (`next` and `previous`) enabling forward/backward traversal.  

**Key Operations**  
1. **Insertion**  
   - *At front*:  
     ```java
     Node newNode = new Node(data);
     newNode.next = head;
     head = newNode;
     ```
   - *At end*: traverse to last node → set its `next` to new node.  
   - *In middle*: link predecessor’s `next` to new node → new node’s `next` to successor.  
2. **Deletion**  
   - *Head*:  
     ```java
     head = head.next;
     ```
   - *Middle*: find node before target →  
     ```java
     prev.next = current.next;
     ```
3. **Traversal & Access**  
   - Iterate via `next` pointers.  
   - `.get(i)` in Java’s `LinkedList` is **O(n)**.  

**Complexity**  
| Operation                    | Time Complexity |
|------------------------------|-----------------|
| Access by index              | O(n)            |
| Insertion/deletion at head   | O(1)            |
| Insertion/deletion at middle | O(n)            |
| Memory overhead (pointers)   | +O(1) per node  |

**Built-In Java Usage**  
```java
LinkedList<String> list = new LinkedList<>();
list.addFirst("A");       // O(1)
list.addLast("B");        // O(1) (amortized)
String first = list.getFirst(); // O(1)
list.remove("A");         // O(n)
```

**Challenge Examples**  
- **Sum nodes** (recursive & iterative)  
- **Add constant to each node’s data** (recursive)  

---

## 2. Trees & Graphs 

### Trees  
- **Structure**: hierarchical; nodes have exactly one parent (except root) and zero or more children.  
- **Terminology**:  
  - **Root**: top node.  
  - **Leaf**: node with no children.  
- **Binary Trees**: each node has up to two children.  
- **Binary Search Trees (BST)**  
  - **BST Property**: left descendants < node < right descendants.  
  - Balanced BST insertion/search: **O(log n)**; worst-case unbalanced: **O(n)**.  

#### Operations  
1. **Insertion**  
   ```java
   void insert(Node root, int value) {
     if (value < root.data) insert(root.left, value);
     else insert(root.right, value);
   }
   ```
2. **Traversals** (depth-first)  
   - **Preorder (P L R)**: root → left → right  
   - **Inorder (L P R)**: left → root → right (sorted for BST)  
   - **Postorder (L R P)**: left → right → root  

#### Recursion Example  
```java
void printTree(Node cur) {
  if (cur != null) {
    System.out.println(cur.data);
    printTree(cur.left);
    printTree(cur.right);
  }
}
```

### Graphs  
- **Structure**: nodes (vertices) with multiple in/out references.  
- **Types**:  
  - **Directed vs. Undirected**  
  - **Cyclic vs. Acyclic**  
- **Relation to Trees**: every tree is a graph without cycles and with one parent per node.  

---

## 3. Hash Maps 

**Definition**  
- A **hash map** stores **key → value** pairs with fast average-case lookup.  
- Examples: Java `HashMap`, C# `Dictionary`, C++ `map`, Python `dict`.

**Core Methods**  
- `put(key, value)` – insert or update  
- `get(key)` – retrieve (returns `null` if absent)  
- `remove(key)` – delete entry  
- `clear()` – remove all entries  
- `size()` – count entries  

**Iteration**  
```java
for (K key : map.keySet()) {
  V val = map.get(key);
}
for (V val : map.values()) {
  // process values
}
```

**Use Case: Counting**  
```java
public static HashMap<String,Integer> countGrades(double[] grades) {
  HashMap<String,Integer> gradeMap = new HashMap<>();
  gradeMap.put("A",0);
  // …
  for (double g : grades) {
    if (g >= 89.5) gradeMap.put("A", gradeMap.get("A")+1);
    // …
  }
  return gradeMap;
}
```

**Complexity**  
- Average lookup/insertion/deletion: **O(1)**  
- Worst-case (collisions): **O(n)**  

---

### Quick-Reference Complexity Table

| Structure                    | Access    | Search     | Insertion  | Deletion   |
|------------------------------|-----------|------------|------------|------------|
| **ArrayList**                | O(1)      | O(n)       | O(n)       | O(n)       |
| **LinkedList**               | O(n)      | O(n)       | O(1) (head)| O(1) (head)|
| **Stack / Queue**            | O(1)      | O(n)       | O(1)       | O(1)       |
| **BST (balanced)**           | O(log n)  | O(log n)   | O(log n)   | O(log n)   |
| **HashMap / Dictionary**     | —         | O(1) avg   | O(1) avg   | O(1) avg   |

---
```
