enum PriorityLevel{
    LOW,
    MEDIUM,
    HIGH
}

public class Task {
    String Title;
    String Description;
    String DueDate;
    PriorityLevel Priority;
    boolean Completed;


    public Task(String title, String desc, String dueDate, PriorityLevel priority) {
        this.Title = title;
        this.Description = desc;
        this.DueDate = dueDate;
        this.Priority = priority;
        this.Completed = false;
    }

    public String getTitle(){
        return this.Title;
    }
    public void setTitle(String input){
        this.Title = input;
    }

    public String getDescription(){
        return this.Description;
    }
    public void setDescription(String input){
        this.Description = input;
    }

    public String getDueDate(){
        return this.DueDate;
    }
    public void setDueDate(String input){
        this.DueDate = input;
    }

    public PriorityLevel getPriorityLevel(){
        return this.Priority;
    }
    public void setPriorityLevel(PriorityLevel input){
        this.Priority = input;
    }

    public boolean isCompleted(){
        return this.Completed;
    }
    public void setCompleted(){
        if (this.Completed == true){
            System.out.printf("Task \"%s\" has already been set as complete.", this.Title);
        }else{
            this.Completed = true;
        }
    }

    public String toString() {
        return String.format(
            "Task Title: %s%n" +
            "Description: %s%n" +
            "Due Date: %s%n" +
            "Priority: %s%n" +
            "Completed: %s",
            this.Title,
            this.Description,
            this.DueDate,
            this.Priority,
            this.Completed ? "Yes" : "No"
        );
    }
    
}
