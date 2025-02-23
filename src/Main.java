import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskList tasks = new TaskList();
        while(true){
            System.out.println("Menu:\n1- Add new TASK\n2- Edit a TASK\n3- Remove a TASK\n4- EXIT");
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
                        System.out.println("Menu:\n1- Edit title\n2- Edit Description\n3- Edit Status\n4- Back\n-- Enter your choice : \n");
                        innerChoise = scanner.nextInt();
//
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
                                System.out.println("\nBack...\n");
                                break;
                            default:
                                System.out.println("\nWrong number...\n");
                        }
                        if(innerChoise == 4){
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
}
