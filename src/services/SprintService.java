package services;

import dto.Sprint;
import dto.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class SprintService {
    private ArrayList<Sprint> sprints;
    private Scanner scanner;

    public SprintService() {
        this.sprints = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void displaySprint() {
        System.out.println("Enter Sprint Name whose details you want");
        String sprint = scanner.nextLine();
        for (Sprint sprintElement : this.sprints) {
            if (sprintElement.getSprintName().equalsIgnoreCase(sprint)) {
                System.out.println(sprintElement);
                return;
            }

        }
        System.out.println("Invalid Sprint Name");

    }

    public void deleteSprint() {
        System.out.println("Enter Sprint Name needs to be deleted");
        String sprint = scanner.nextLine();
        for (int i = 0; i < this.sprints.size(); i++) {
            if (this.sprints.get(i).getSprintName().equalsIgnoreCase(sprint)) {
                this.sprints.remove(i);
                return;
            }
        }
        System.out.println("Invalid Sprint Name");
    }

    public void createSprint(ArrayList<Task> tasks) {
        System.out.println("Enter Sprint Name");
        String sprint = scanner.nextLine();
        //String taskTitle = scanner.nextLine();
        for (int i = 0; i < this.sprints.size(); i++) {
            if (this.sprints.get(i).getSprintName().equalsIgnoreCase(sprint)) {
                int check = this.sprints.get(i).addTask(tasks);
                if (check == 0) {
                    System.out.println("Invalid Task Title");
                }
                return;
            }
        }
        Sprint sprintObj = new Sprint(sprint);
        int check = sprintObj.addTask(tasks);
        this.sprints.add(sprintObj);
        if (check == 0) {
            System.out.println("Invalid Task Title");
        }
    }
}
