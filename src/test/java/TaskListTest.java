package test.java;

import main.java.Task;
import main.java.TaskList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;


public class TaskListTest {
    @Test
    public void testAddTask() {
        List<Task> mockTasks = new ArrayList<>();
        TaskList taskListTest = new TaskList(mockTasks);

        int initialSize = taskListTest.getSize();
        taskListTest.add("test", "test");

        assertEquals(initialSize+1, taskListTest.getSize());
    }

}
