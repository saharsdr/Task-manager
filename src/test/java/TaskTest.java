package test.java;

import main.java.Task;
import main.java.Utils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TaskTest {
    @Test
    public void testSetStatusDone(){
        Task task = new Task("test");
        task.setStatus("Done");
        assertEquals(Utils.Status.Done, task.getStatus());
    }

    @Test
    public void testSetStatusToDo() {
        Task task = new Task("test");
        task.setStatus("ToDo");
        assertEquals(Utils.Status.ToDo, task.getStatus());
    }

    @Test
    public void testSetStatusInProgress() {
        Task task = new Task("test");
        task.setStatus("InProgress");
        assertEquals(Utils.Status.InProgress, task.getStatus());
    }

    @Test
    public void testSetPriorityLow() {
        Task task = new Task("test");
        task.setPriority("Low");
        assertEquals(Utils.Priority.Low, task.getPriority());
    }
    @Test
    public void testSetPriorityMedium() {
        Task task = new Task("test");
        task.setPriority("Medium");
        assertEquals(Utils.Priority.Medium, task.getPriority());
    }
    @Test
    public void testSetPriorityHigh() {
        Task task = new Task("test");
        task.setPriority("High");
        assertEquals(Utils.Priority.High, task.getPriority());
    }
}
