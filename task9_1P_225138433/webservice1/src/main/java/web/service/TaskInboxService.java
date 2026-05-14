package web.service;

import java.util.ArrayList;
import java.util.List;

public class TaskInboxService {

    // Simulated database of tasks per student
    private static final java.util.Map<String, List<Task>> taskDatabase = new java.util.HashMap<>();

    static {
        List<Task> kavishTasks = new ArrayList<>();
        kavishTasks.add(new Task("T1", "Task 6.2D - Right BICEP", "Complete"));
        kavishTasks.add(new Task("T2", "Task 7.2D - Integration Testing", "Submitted"));
        kavishTasks.add(new Task("T3", "Task 9.1P - TDD and CI", "In Progress"));
        taskDatabase.put("225138433", kavishTasks);
    }

    public static List<Task> getTaskInbox(String studentId) {
        // Validate input
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be null or empty.");
        }

        List<Task> tasks = taskDatabase.get(studentId);
        if (tasks == null) {
            return new ArrayList<>();
        }
        return tasks;
    }
}