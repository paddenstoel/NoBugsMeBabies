package me.nobugs.homework1.part2.taskmanagetask;

import java.util.ArrayList;
import java.util.Comparator;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void displayTasksByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
        tasks.forEach(System.out::println);
    }
}
