public class Main{
    public static void main(String[] args){
        Task read = new Task("Read", "Read a damn book nigga", "12/25/24", PriorityLevel.HIGH);
        System.out.println(read);
        read.setCompleted();
        System.out.println(read);
        read.setCompleted();
    }
}