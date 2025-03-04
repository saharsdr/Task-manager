package main.java;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList {
    List<Task> tasks;
    public TaskList(){
        tasks = loadTasksFromFile();
        if(tasks.isEmpty()){
            Manager.ID = 1;
        } else{
            Manager.ID = tasks.getLast().id+1;
        }
        tasks.forEach(System.out::println);
    }

    public TaskList(List<Task> testTasks) {
        this.tasks = testTasks;
    }

    private List<Task> loadTasksFromFile() {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(Manager.FILE_PATH))) {
            String line;
            while( (line = reader.readLine()) != null){
                if (line.trim().isEmpty()) {
                    continue;
                }
                Task task;
                String[] taskAttr = line.split("[|]");
                task=new Task(Integer.parseInt(taskAttr[0].strip()), taskAttr[1], taskAttr[2], taskAttr[3], taskAttr[4]);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return tasks;
    }
    public boolean isValid(int id){
        return tasks.stream().anyMatch(task-> task.id == id);
    }
    public Task getTask(int id){
        return tasks.stream().filter(task -> task.id == id).findFirst().orElse(null);
    }
    public void add(String title, String des){
        Task task = new Task(title, des);
        tasks.add(task);

        try(FileWriter writer = new FileWriter(Manager.FILE_PATH, true)){
            writer.write("\n"+task.id+"|"+task.title+"|"+task.description+"|"+task.status+"|"+task.priority);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void add(Task task){
        this.tasks.add(task);
        try(FileWriter writer = new FileWriter(Manager.FILE_PATH, true)){
            writer.write("\n"+task.id+"|"+task.title+"|"+task.description+"|"+task.status+"|"+task.priority);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean remove(int id){
        return tasks.removeIf(task -> task.id == id);
    }

    @Override
    public String toString() {
        StringBuilder ans = new StringBuilder();
        for (Task task : tasks) {
            ans.append(task.toString());
            ans.append("\n\n");
        }
        return ans.toString();
    }

    public void printGroupedByPriority(String priorityStr){
        Utils.Priority priority = Utils.Priority.valueOf(priorityStr);

        List<Task> tasks = this.tasks.stream()
                .filter(task -> task.priority == priority)
                .toList();

        for(Task task : tasks){
            System.out.println(task);
            System.out.println();
        }
    }

    public void editTaskByTitle(int id, String newTitle) {

    }

    public int getSize(){
        return this.tasks.size();
    }
    public List<Task> getTasks(){
        return this.tasks;
    }
}
