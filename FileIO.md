# Java File I/O Guide

This guide provides an overview of how to work with files and sockets in Java. We’ll cover how to open files for various operations, read and write both text and binary data, parse files of different formats, close resources properly, and read/write using sockets.

---

## Table of Contents

1. [Opening a File (Reading, Writing, Appending, Creating)](#opening-a-file-reading-writing-appending-creating)
2. [Reading a Text File](#reading-a-text-file)
3. [Writing to a Text File](#writing-to-a-text-file)
4. [Appending to a File](#appending-to-a-file)
5. [Parsing File of Different Formats](#parsing-file-of-different-formats)
6. [Reading a Binary File](#reading-a-binary-file)
7. [Closing Files](#closing-files)
8. [Reading from and Writing to a Socket](#reading-from-and-writing-to-a-socket)

---

## Opening a File (Reading, Writing, Appending, Creating)

You can open files in multiple ways depending on the purpose. The simplest approach for text files is using **`FileReader`** or **`FileWriter`**, while for binary data you might use **`FileInputStream`** or **`FileOutputStream`**.

### Text Files
- **Reading**: `FileReader` (or `Scanner` for convenience).
- **Writing/Creating**: `FileWriter`.
- **Appending**: `FileWriter` with `append` mode set to `true`.

### Binary Files
- **Reading**: `FileInputStream`.
- **Writing**: `FileOutputStream`.

> **Note**: Often you wrap these classes with **buffered** streams (e.g., `BufferedReader`, `BufferedWriter`) for better performance.

---

## Reading a Text File

Below is a simple example using **`Scanner`** with **try-with-resources** to automatically close the file:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextExample {
    public static void main(String[] args) {
        // We'll read from a file named "input.txt"
        File file = new File("input.txt");

        // Try-with-resources ensures the file is closed automatically
        try (Scanner scanner = new Scanner(file)) {
            // Read line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); 
                System.out.println("Read line: " + line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- `Scanner` is convenient for splitting text, reading tokens, integers, or lines.
- The `try-with-resources` block automatically calls `close()` at the end.

---

## Writing to a Text File

You can use **`FileWriter`** along with **`BufferedWriter`** or **`PrintWriter`** to easily write text data:

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteTextExample {
    public static void main(String[] args) {
        // Try-with-resources for automatic resource closing
        try (FileWriter fw = new FileWriter("output.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Hello, world!");
            bw.newLine(); // Move to the next line
            bw.write("This is another line.");

        } catch (IOException e) {
            System.err.println("Error while writing to file: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- `BufferedWriter` adds efficiency by buffering characters before writing to disk.
- `newLine()` method ensures system-appropriate line breaks.

---

## Appending to a File

When you need to **append** instead of overwriting the entire file, you can set the second parameter of `FileWriter` to `true`:

```java
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AppendTextExample {
    public static void main(String[] args) {
        // 'true' indicates append mode
        try (FileWriter fw = new FileWriter("output.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            bw.write("Appended line!");
            bw.newLine();

        } catch (IOException e) {
            System.err.println("Error while appending to file: " + e.getMessage());
        }
    }
}
```

**Key Point**:
- `new FileWriter("output.txt", true)` ensures data is appended instead of replacing existing content.

---

## Parsing File of Different Formats

If your file has structured data (e.g., CSV), you can split each line by a delimiter:

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseCSVExample {
    public static void main(String[] args) {
        File csvFile = new File("data.csv");

        try (Scanner scanner = new Scanner(csvFile)) {
            while (scanner.hasNextLine()) {
                // Example CSV line: "John,Doe,30"
                String line = scanner.nextLine();
                String[] parts = line.split(","); // split by comma

                // parts[0] = "John", parts[1] = "Doe", parts[2] = "30"
                String firstName = parts[0];
                String lastName = parts[1];
                int age = Integer.parseInt(parts[2]);

                System.out.println("Name: " + firstName + " " + lastName + ", Age: " + age);
            }
        } catch (FileNotFoundException e) {
            System.err.println("CSV file not found: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- Use `String.split(delimiter)` to split text by a specific character (e.g., comma).
- Convert numeric strings using `Integer.parseInt`, `Double.parseDouble`, etc.

---

## Reading a Binary File

For non-text (binary) files, use `FileInputStream`. Example:

```java
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryExample {
    public static void main(String[] args) {
        // Example: reading raw bytes from a file named "data.bin"
        try (FileInputStream fis = new FileInputStream("data.bin")) {
            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                // 'byteRead' is an unsigned 8-bit value stored in an int
                System.out.println("Byte: " + byteRead);
            }
        } catch (IOException e) {
            System.err.println("Error reading binary file: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- `read()` returns -1 when there’s no more data.
- For reading typed data (e.g., int, float), consider wrapping it with `DataInputStream`.

---

## Closing Files

### The `try-with-resources` Statement

- Introduced in Java 7, it automatically closes resources (files, sockets, etc.) after the `try` block.  
- No need for an explicit `finally` block.

**Example** (already shown in the reading/writing sections):
```java
try (FileReader fr = new FileReader("someFile.txt")) {
    // read logic
} catch (IOException e) {
    // handle exception
}
// 'fr' gets closed automatically here
```

Without try-with-resources, you’d manually close in a `finally` block:
```java
FileReader fr = null;
try {
    fr = new FileReader("someFile.txt");
    // read logic
} catch (IOException e) {
    // handle
} finally {
    if (fr != null) {
        try {
            fr.close();
        } catch (IOException e) {
            // handle
        }
    }
}
```

---

## Reading from and Writing to a Socket

Sockets allow reading/writing data over a network connection using streams.

### Socket Example (Client Side)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) {
        // Example: Connect to a server on localhost at port 12345
        try (Socket socket = new Socket("localhost", 12345);
             // For sending data to server
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             // For reading data from server
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // Send a message to the server
            out.println("Hello server!");

            // Read a response
            String serverResponse = in.readLine();
            System.out.println("Server says: " + serverResponse);

        } catch (IOException e) {
            System.err.println("Socket error: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- **`Socket`** opens a connection to the server (hostname/IP + port).
- `getOutputStream()` and `getInputStream()` let you obtain **I/O streams** to communicate.
- `PrintWriter` with `true` for `autoFlush` ensures lines are sent immediately.

### Socket Example (Server Side)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerExample {
    public static void main(String[] args) {
        // Open a server socket on port 12345
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();

                // Once a client connects, use streams to communicate
                try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    // Read client message
                    String clientMessage = in.readLine();
                    System.out.println("Received from client: " + clientMessage);

                    // Send a response
                    out.println("Hello from server!");
                }
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }
}
```

**Key Points**:
- `ServerSocket` listens on a specified port.
- `accept()` blocks until a client connects, returning a `Socket` for communication.
- Resources (streams, sockets) again can be used with try-with-resources.

---

## Conclusion
- **Open files** in different modes (read, write, append) using classes like `FileReader`, `FileWriter`, and their buffered counterparts.
- **Read text** via `Scanner` or `BufferedReader`, and **write text** using `PrintWriter` or `BufferedWriter`.
- **Parse** structured text (CSV, TSV, etc.) by splitting lines on delimiters.
- For **binary** data, use `FileInputStream`/`FileOutputStream` (or `DataInputStream`/`DataOutputStream` for typed reads/writes).
- **Close resources** properly with try-with-resources or a `finally` block.
- For **sockets**, use `Socket` (client) or `ServerSocket` (server) and communicate over input/output streams.

With these techniques, you can reliably handle file and network I/O in Java, ensuring robust and maintainable code!
