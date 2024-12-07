import java.util.Scanner;
/*import java.util.function.Consumer;
import java.util.ArrayList;
//import java.util.HashMap; */

public class Main{
    public static void main(String[] args){

        // Variables
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        String mainMenu = "Welcome to the TaskManager Menu. Select an option:" + 
        "1: Add Task /n 2: List Tasks /n 3) Update Task /n 4) Remove Task /n 5) Complete Task /n 6: Exit.";
        
        
        Task defaultTask = new Task("Make bed", "Make your bed", "10/10/3000", PriorityLevel.HIGH);
        System.out.println(defaultTask);
        taskManager.markTaskCompleted(defaultTask);

        while(true){
            System.out.println(mainMenu);
            int userChoice = input.nextInt();
            
            switch (userChoice){
                case 1: // Add Task
                    
                case 2: // List Tasks
                    
                case 3: // Update Tasks
                    
                case 4: // Remove Task
                    
                case 5: // Complete Task
                    
                case 6: // Exit
                    input.close();
                    System.out.println("Now exiting TaskManager.");
                    break;
                default:
                    System.out.println("Invalid input, please try again");
                    continue;
            }
            
        }
    }
}