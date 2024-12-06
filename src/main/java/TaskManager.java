import java.util.ArrayList;

public class TaskManager {
    ArrayList<Task> UserTasks;

    public TaskManager(){
        this.UserTasks = new ArrayList<>();
    }

    public void addTask(Task t){
        UserTasks.add(t);
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
        for(Task t : UserTasks){
            int num = 1;
            System.out.println(num + ") " + t);
            num++;
        }
    }

    public void markTaskCompleted(Task t){
        t.setCompleted();
    }

    public void updateTask(int i, Task updated){
        UserTasks.set(i, updated);
    }


    // Work on later
    public void saveTasksToFile(String filename){

    }

    public void loadTasksFromFile(String filename){

    }
}
