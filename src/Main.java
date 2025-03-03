import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        while(true){
            System.out.println("Menu:");
            System.out.println("1- Add new TASK");
            System.out.println("2- Edit a TASK");
            System.out.println("3- Remove a TASK");
            System.out.println("4- EXIT");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1 :
                    System.out.println("\n ---- Add new task ----\n -- Enter Title : ");
                    String title = scanner.nextLine();

                    System.out.println(" -- Enter Description : ");
                    String des = scanner.nextLine();

                    tasks.add(title, des);
                    System.out.println(tasks);
                    break;
                case 2:
                    System.out.println("\n ---- Edit a task ----\n -- Enter the ID : ");
                    int id = scanner.nextInt();
                    while(!tasks.isValid(id)){
                        System.out.println("The ID is wrong, Enter again\n");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a valid integer ID.");
                            scanner.next();  // مصرف ورودی نادرست
                        }
                        id = scanner.nextInt();
                    }

                    Task task = tasks.getTask(id);
                    int innerChoise;
                    while(true){
                        System.out.println("\nChossen Task: \n"+task);
                        // Updated: Used printMenuEditTask() for better readability.
                        printMenuEditTask();
                        innerChoise = scanner.nextInt();

                        switch (innerChoise){
                            case 1:
                                System.out.println("Enter new title:\n");
                                scanner.next();
                                task.title = scanner.nextLine();
                                break;
                            case 2:
                                System.out.println("Enter new description:\n");
                                scanner.next();
                                task.description = scanner.nextLine();
                                break;
                            case 3:
                                System.out.println("1- To Do / 2- In Progress / 3- Done\nEnter new status:\n");
                                int status = scanner.nextInt();
                                switch (status) {
                                    case 1 -> task.setStatus("ToDo");
                                    case 2 -> task.setStatus("InProgress");
                                    case 3 -> task.setStatus("Done");
                                }
                                break;
                            case 4:
                                System.out.println("1- Low / 2- Medium / 3- High\nEnter new status:\n");
                                int priority = scanner.nextInt();
                                switch (priority) {
                                    // TODO: create a funtin in the Task class to setPriority and call it
                                    case 1 -> task.priority = Utils.Priority.valueOf("Low");
                                    case 2 -> task.priority = Utils.Priority.valueOf("Medium");
                                    case 3 -> task.priority = Utils.Priority.valueOf("High");
                                }
                                break;
                            case 5:
                                System.out.println("\nBack...\n");
                            default:
                                System.out.println("\nWrong number...\n");
                        }
                        if(innerChoise == 5){
                            break;
                        }
                    }
                    System.out.println(tasks);
                    break;
                case 3:
                    System.out.println("\n ---- Remove a task ----\n -- Enter the ID : ");
                    id = scanner.nextInt();
                    if(tasks.remove(id)){
                        System.out.println("Task removed successfully\n");
                    }
                    System.out.println(tasks);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Wrong number!\n");

            }
            if (choice == 4) {
                break; // Exits while loop
            }
        }






    }


    static void printMenuEditTask(){
        System.out.println("Menu:");
        System.out.println("1- Edit title");
        System.out.println("2- Edit Description");
        System.out.println("3- Edit Status");
        System.out.println("4- Edit Priority");
        System.out.println("5- Back");
        System.out.println("-- Enter your choice :");
    }
}
