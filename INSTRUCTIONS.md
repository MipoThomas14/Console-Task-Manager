# Console-Based Task Manager Project Requirements

## Project Overview
You will create a command-line application that allows users to manage a list of tasks. Each task should have at least a **title**, **description**, **due date**, and **priority level**. The user should be able to:

- **Add tasks**
- **View existing tasks**
- **Update a task's details**
- **Mark tasks as completed**
- **Remove tasks**

By completing this project, you will:

- Refresh your knowledge of **Java syntax**, **classes**, and **methods**.
- Practice working with **collections** (e.g., `ArrayList`).
- Revisit **user input handling** in a console environment.
- Reinforce **OOP principles** (e.g., encapsulation, and potentially inheritance).
- Practice basic **error handling** and **input validation**.
- Optionally, gain experience with **file I/O** for data persistence.

---

## Core Features

### 1. Add Task
- Prompt the user for task details: **Title**, **Description**, **Due Date**, and **Priority**.
- Create a `Task` object and add it to a list of tasks.

### 2. List Tasks
- Display all tasks in a readable format.
- Show **index**, **title**, **due date**, **priority**, and **completion status**.

### 3. Update a Task
- Allow the user to select a task by **index**.
- Prompt for new details and update them.
- Handle invalid input (e.g., non-existent task index).

### 4. Mark Task as Completed
- Let the user mark a task as done by selecting its **index**.
- Display confirmation after updating its completion status.

### 5. Remove a Task
- Allow the user to remove a completed or no-longer-needed task.
- Handle invalid indexes appropriately.

### 6. Exit
- Provide a menu option to terminate the program gracefully.

---

## Optional Features

### 1. Persistence (File I/O)
- On startup, read tasks from a file (e.g., `tasks.txt`) to restore saved data.
- After modifications, save the updated tasks back to the file.

### 2. Filtering/Sorting Tasks
- Add commands to display only **incomplete tasks** or sort them by **due date/priority**.
- Practice using comparators and `Collections.sort()`.

### 3. Search by Keyword
- Implement a search feature to find tasks by **keyword** in the title or description.

---

## Suggested Class Structure

### Class Task
- **Fields**: `title`, `description`, `dueDate`, `priority`, `completed` (boolean).
- **Constructor**: Sets `title`, `description`, `dueDate`, `priority`, and defaults `completed=false`.
- **Getters/Setters**: For each field.
- `toString()`: Returns a formatted string summarizing the task.

### Class TaskManager
- **Field**: `ArrayList<Task> tasks`.
- **Methods**:
  - `addTask(Task t)`
  - `removeTask(int index)`
  - `getTask(int index)`
  - `listTasks()` (to print tasks)
  - `markTaskCompleted(int index)`
  - `updateTask(int index, Task updatedTask)`
  - **Optional**: `saveTasksToFile(String filename)` and `loadTasksFromFile(String filename)`

### Class Main or TaskManagerApp
- Contains the **main method**.
- Manages **user input** and **menu display**.
- Calls `TaskManager` methods based on user selections.
- **File I/O**: Load tasks on start and save on updates or exit (if using persistence).

---

## Implementation Steps

### 1. Task Class
- Define fields, constructor, getters, setters, and `toString()`.

### 2. TaskManager Class
- Initialize `ArrayList<Task>` in the constructor.
- Implement add, remove, update, and list operations.

### 3. Main Application Loop
- Create a `TaskManager` instance.
- *(Optional)* Load tasks from file at startup.
- Display menu options:
  - **1: Add**, **2: List**, **3: Update**, **4: Complete**, **5: Remove**, **6: Exit**.
- Handle user input with a `Scanner`.
- Validate input and handle errors gracefully.

### 4. Incremental Testing
- Start with **add/list functionality**.
- Then implement **update** and **remove**.
- Add **file I/O** and other optional features last.

---

## Tips for Success

- Start small and incrementally add features.
- Test each feature as you go.
- Comment code for clarity.
- Don't strive for "perfect" code initially—focus on correctness and clarity.
- If stuck, temporarily skip a challenging feature and return to it later.

By completing this console-based task manager, you will solidify your Java fundamentals and reacquaint yourself with the language. **Good luck and enjoy the process!**
