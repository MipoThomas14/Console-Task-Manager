import java.util.Scanner;
import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> UserTasks;

    public TaskManager(){
        this.UserTasks = new ArrayList<>();
    }

    public Task newTask(Scanner input){ // requires input
        System.out.println("What is the name of the task? ");
        String nName = input.nextLine();

        System.out.println("Would you like to give the task a description? If not, type N/A ");
        String nDesc = input.nextLine();

        System.out.println("When is this task due? MM/DD/YYYY ");
        String nDue = input.nextLine();

        System.out.println("How high on the priority list is this task? LOW/MEDIUM/HIGH ");
        String pString = (input.nextLine()).toUpperCase();
        PriorityLevel nPriority = PriorityLevel.valueOf(pString);

        return new Task(nName, nDesc, nDue, nPriority);
    }

    public void addTask(Task t){
        this.UserTasks.add(t);
        System.out.printf("Added task \"%s\" to your Task Manager (Total tasks: %d).", t.getTitle(), UserTasks.size());
    }

    public void removeTask(Task t){
        UserTasks.remove(t);
        System.out.printf("Removed task \"%s\" from your task manager (Total tasks: %d)", t.getTitle(), UserTasks.size());
    }

    public Task getTask(int Index){
        return UserTasks.get(Index);
    }

    public void printTasks(){
        int num = 1;
        System.out.println("------------------------------------");
        for(Task t : UserTasks){
            System.out.println(num + ") " + t + "\n");
            num++;
        }
        System.out.println("------------------------------------");
    }

    public void markTaskCompleted(Task t){
        t.setCompleted();
    }

    public void updateTask(Scanner input){ // requires input
        System.out.println("Which task would you like to update?");
        this.printTasks();

        int taskIndex = Integer.parseInt(input.nextLine());
        System.out.println("Great, now you can update this task with a new one: ");
        
        Task toUpdateTask = this.newTask(input);
        this.UserTasks.add(taskIndex, toUpdateTask);
    }


    // Work on later
    public void saveTasksToFile(String filename){

    }

    public void loadTasksFromFile(String filename){

    }
}
