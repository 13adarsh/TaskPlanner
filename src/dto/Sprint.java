package dto;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Sprint {
    private String sprintName;
    private HashSet<Task> taskList;
    private Scanner scanner;

    public String getSprintName() {
        return sprintName;
    }

    public void setSprintName(String sprintName) {
        this.sprintName = sprintName;
    }

    public HashSet<Task> getTaskList() {
        return taskList;
    }

    public Sprint(String sprintName) {
        this.sprintName = sprintName;
        this.scanner = new Scanner(System.in);
        this.taskList = new HashSet<>();
    }

    public int addTask(ArrayList<Task> tasks) {
        System.out.println("Enter Tasks Title which needs to be added to Sprint");
        String newTask = scanner.nextLine();
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(newTask)) {
                this.taskList.add(task);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Sprint{" +
                "sprintName='" + sprintName + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
