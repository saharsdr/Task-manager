public class Task {
    int id;
    String title = "";
    String description = "";
    Utils.Status status;

    public Task(int id, String title, String description, String status){
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.valueOf(status);
    }

    public Task(String title, String description, String status){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.valueOf(status);
    }

    public Task(String title, String description){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = description;
        this.status = Utils.Status.ToDo;
    }

    public Task(String title){
        this.id = Manager.ID;
        Manager.ID += 1;
        this.title = title;
        this.description = "";
        this.status = Utils.Status.ToDo;
    }

    @Override
    public String toString() {
        String ans = "ID: -" + this.id + "-\n" +
                "Title: " + this.title.toUpperCase() + "\n" +
                "Description: **" + this.description + "**\n" +
                "( " + this.status.toString().toLowerCase() + " )\n";
        return ans;
    }

    public void setStatus(String status) {
        this.status = Utils.Status.valueOf(status);
    }
}
