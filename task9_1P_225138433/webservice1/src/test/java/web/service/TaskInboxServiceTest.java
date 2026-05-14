package web.service;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class TaskInboxServiceTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "225138433";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Kavish Choudhary";
        Assert.assertNotNull("Student name is null", studentName);
    }

    // Valid student returns correct number of tasks

    @Test
    public void testInboxReturnsTasksForValidStudent() {
        List<Task> tasks = TaskInboxService.getTaskInbox("225138433");
        Assert.assertEquals(99, tasks.size());
    }

    // Valid student returns correct task names

    @Test
    public void testInboxReturnsCorrectTaskNames() {
        List<Task> tasks = TaskInboxService.getTaskInbox("225138433");
        Assert.assertEquals("Task 6.2D - Right BICEP", tasks.get(0).getTaskName());
        Assert.assertEquals("Task 7.2D - Integration Testing", tasks.get(1).getTaskName());
        Assert.assertEquals("Task 9.1P - TDD and CI", tasks.get(2).getTaskName());
    }

    // Valid student returns correct task statuses

    @Test
    public void testInboxReturnsCorrectTaskStatuses() {
        List<Task> tasks = TaskInboxService.getTaskInbox("225138433");
        Assert.assertEquals("Complete", tasks.get(0).getStatus());
        Assert.assertEquals("Submitted", tasks.get(1).getStatus());
        Assert.assertEquals("In Progress", tasks.get(2).getStatus());
    }

    // Unknown student returns empty list

    @Test
    public void testInboxReturnsEmptyForUnknownStudent() {
        List<Task> tasks = TaskInboxService.getTaskInbox("999999999");
        Assert.assertEquals(0, tasks.size());
    }

    // Null student ID throws IllegalArgumentException

    @Test(expected = IllegalArgumentException.class)
    public void testInboxThrowsExceptionForNullStudentId() {
        TaskInboxService.getTaskInbox(null);
    }

    // Empty student ID throws IllegalArgumentException

    @Test(expected = IllegalArgumentException.class)
    public void testInboxThrowsExceptionForEmptyStudentId() {
        TaskInboxService.getTaskInbox("");
    }
}