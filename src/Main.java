import dto.Task;
import dto.Type;
import services.SprintService;
import services.TaskService;

import java.io.IOException;
import java.util.*;

public class Main {

    private TaskService taskService;
    private SprintService sprintService;
    private Scanner scanner;

    public Main() {

        taskService = new TaskService();
        sprintService = new SprintService();
        this.scanner = new Scanner(System.in);
    }


    public static void main(String[] args) throws IOException {
        Main obj = new Main();
        Task task1 = new Task("create dashboard","bansal","adarsh", new Type("feature", new ArrayList<String>(){{add("create dashboard site");add("low");}}), "14/07/2021");
        Task task2 = new Task("fix swl issue","bansal","team", new Type("bug", new ArrayList<String>(){{add("P1");}}), "14/07/2021");
        Task task3 = new Task("create a microservice","amy","adarsh", new Type("story", new ArrayList<String>(){{add("add logging to feature");}}), "14/07/2021");
        Task task4 = new Task("console api","ryan","ryan", new Type("feature", new ArrayList<String>(){{add("create api for console");add("High");}}), "14/07/2021");
        obj.taskService.addTask(task1);
        obj.taskService.addTask(task2);
        obj.taskService.addTask(task3);
        obj.taskService.addTask(task4);
        obj.run(obj.taskService, obj.sprintService);
    }

    public void run(TaskService taskService, SprintService sprintService) throws IOException {
        do {

            int choice = printMenu();

            switch (choice) {
                case 1:
                    taskService.createTask();
                    System.out.println(taskService.getTasks());
                    break;
                case 2:
                    taskService.changeTaskStatus();
                    break;
                case 3:
                    taskService.changeAssignee();
                    break;
                case 4:
                    taskService.displayUsersTask();
                    break;
                case 5:
                    sprintService.createSprint(taskService.getTasks());
                    break;
                case 6:
                    sprintService.deleteSprint();
                    break;
                case 7:
                    sprintService.displaySprint();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Wrong Choice");
            }
        } while (true);

    }

    public int printMenu() {
        System.out.println("Press 1 to Create a task of any type");
        System.out.println("Press 2 to Change the status of the task");
        System.out.println("Press 3 to Change assignee of the task");
        System.out.println("Press 4 to Display tasks assigned to a particular user");
        System.out.println("Press 5 to Create a Sprint");
        System.out.println("Press 6 to Delete a Sprint");
        System.out.println("Press 7 to Display sprint snapshot");
        System.out.println("Press 8 to Exit Application");
        return scanner.nextInt();
    }


}


/*
        Task task1 = new Task("demo", "Adarsh", "Asison", Status.Open, new Type("Feature", new ArrayList<String>() {
            {
                add("Create console for debugging");
                add("Low");
            }
        }), new Date("14/07/2021"), new HashMap<>());
        Task task2 = new Task("demo", "Adarsh", "Asison", Status.Open, new Type("Feature", new ArrayList<>()), new Date("14/07/2021"), new HashMap<>());
        tasks.add(task1);
        tasks.add(task2);
        System.out.println(tasks);
        Main obj = new Main();
        obj.displayUsersTask();
        Checking App
flipkart
Adarsh
Feature
14/07/2021
Task Planner for Team
Low
*/