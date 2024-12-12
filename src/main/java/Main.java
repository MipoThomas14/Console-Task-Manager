import java.util.Scanner;
/*import java.util.function.Consumer;
import java.util.ArrayList;
//import java.util.HashMap; */

public class Main{

    public static void main(String[] args){

        // Variables
        Scanner input = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        String mainMenu = "\n \nWelcome to the TaskManager Menu. Select an option: ";
        String continuationPrompt = "\n \nWhat would you like to do?";
        String promptList = "\n1: Add Task \n 2: List Tasks \n 3) Update Task \n 4) Remove Task \n 5) Complete Task \n 6: Exit.";
        

        
        Task defaultTask = new Task("Make bed", "Make your bed", "10/10/3000", PriorityLevel.HIGH);
        taskManager.addTask(defaultTask);


        boolean init=false, running=true;
        while(running){

            if(!init){
                System.out.println(mainMenu + promptList);
                init = true;
            }else{
                System.out.println(continuationPrompt + promptList);
            }


            int index;
            int userChoice = Integer.parseInt(input.nextLine());
            switch (userChoice){
                case 1: // New Task
                    Task newTask = taskManager.newTask(input);
                    taskManager.addTask(newTask);
                    continue;
                case 2: // List Tasks
                    taskManager.printTasks();
                    continue;
                case 3: // Update Tasks
                    taskManager.updateTask(input);
                    continue;
                case 4: // Remove Task
                    System.out.println("Which task would you like to remove? ");
                    taskManager.printTasks();

                    index = Integer.parseInt(input.nextLine()) - 1;
                    if(index < 0 || index > taskManager.UserTasks.size()){
                        System.out.println("Invalid index, please try again.");
                    }else{
                        taskManager.removeTask(taskManager.UserTasks.get(index));
                    }
                    continue;
                case 5: // Complete Task
                    System.out.println("Which task would you like to set as complete? ");
                    taskManager.printTasks();
                    
                    index = Integer.parseInt(input.nextLine()) - 1;
                    if(index < 0 || index > taskManager.UserTasks.size()){
                        System.out.println("Invalid index, please try again.");
                    }else{
                        taskManager.markTaskCompleted(taskManager.UserTasks.get(index));
                    }
                    continue;
                case 6: // Exit
                    running = false;
                    System.out.println("Now exiting TaskManager.");
                    break;
                default:
                    System.out.println("Invalid input, please try again. ");
                    continue;
            }
        }
        input.close();
    }
}