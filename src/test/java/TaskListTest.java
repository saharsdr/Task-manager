package test.java;

import main.java.Task;
import main.java.TaskList;
import org.junit.Test;

import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class TaskListTest {
    @Test
    public void testAddTask() {
        List<Task> mockTasks = new ArrayList<>();
        TaskList taskListTest = new TaskList(mockTasks);

        int initialSize = taskListTest.getSize();
        taskListTest.add("test", "test");

        assertEquals(initialSize+1, taskListTest.getSize());
    }

    @Test
    public void testRemoveTask() {
        List<Task> mockTasks = new ArrayList<>();
        TaskList taskListTest = new TaskList(mockTasks);

        int initialSize = taskListTest.getSize();
        taskListTest.add("test", "test");
        int id = taskListTest.getTasks().getFirst().getId();

        assertEquals(initialSize+1, taskListTest.getSize());
        assertTrue(taskListTest.remove(id));
        assertEquals(initialSize, taskListTest.getSize());
        assertFalse(taskListTest.remove(id));
    }

    @Test
    public void testGetTask(){
        List<Task> mockTasks = new ArrayList<>();
        TaskList testTaskList = new TaskList(mockTasks);
        Task task = new Task("test", "test");
        testTaskList.add(task);

        assertEquals(task, testTaskList.getTask(task.getId()));
        assertNull(testTaskList.getTask(15));
    }

}
