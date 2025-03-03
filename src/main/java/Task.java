package main.java;

public class Task {
    int id;
    String title = "";
    String description = "";
    Utils.Status status;
    Utils.Priority priority;

    public Task(int id, String title, String description, String status, String priority){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.valueOf(status);
        this.priority = Utils.Priority.valueOf(priority);
    }

    public Task(int id, String title, String description, String status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.valueOf(status);
        this.priority = Utils.Priority.Low;
    }

    public Task(String title, String description, String status){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.valueOf(status);
        this.priority = Utils.Priority.Low;
    }

    public Task(String title, String description){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.ToDo;
        this.priority = Utils.Priority.Low;
    }


    public Task(String title){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = "";
        this.status = Utils.Status.ToDo;
        this.priority = Utils.Priority.Low;
    }

    @Override
    public String toString() {
        String ans = "ID: -" + this.id + "-\n" +
                "Title: " + this.title.toUpperCase() + "\n" +
                "Description: **" + this.description + "**\n" +
                "[" + this.status.toString().toLowerCase() + "]"+
                "  ["+this.priority.toString().toUpperCase() + "]"+
                "\n";
        return ans;
    }

    public void setStatus(String status) {
        this.status = Utils.Status.valueOf(status);
    }
    public void setPriority(String priority) {
        this.priority = Utils.Priority.valueOf(priority);
    }

    public Utils.Status getStatus() {
        return this.status;
    }
    public Utils.Priority getPriority() {
        return this.priority;
    }
}
