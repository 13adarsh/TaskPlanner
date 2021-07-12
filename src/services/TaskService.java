package services;

import dto.Status;
import dto.Task;
import dto.Type;

import java.io.IOException;
import java.util.*;

public class TaskService {
    private ArrayList<Task> tasks;
    private Scanner scanner;
    private static HashMap<String, List<String>> typeList = new HashMap<>(Map.of(
            "feature", Arrays.asList("Feature summary", "Impact"),
            "bug", Collections.singletonList("Severity"),
            "story", Arrays.asList("Story Summary", "Story points")
    ));

    public TaskService() {
        this.tasks = new ArrayList<>();
        this.scanner = new Scanner(System.in);
//        this.createTypeList();

    }
/*
    public void createTypeList() {
        typeList.put("Feature", Arrays.asList("Feature summary", "Impact"));
        typeList.put("Bug", Arrays.asList("Severity"));
        typeList.put("Story", Arrays.asList("Story Summary", "Story points"));

    }*/


    public void createTask() throws IOException {

        System.out.println("Enter following in sequence:");
        System.out.println("Title, Creator, Assignee, Type, Due Date");

        String title = scanner.nextLine();
        String creator = scanner.nextLine();
        String assignee = scanner.nextLine();
        String type = scanner.nextLine();
        String dueDate = scanner.nextLine();

        ArrayList<String> attributesValue = this.processType(type);
        if (attributesValue == null) {
            System.out.println("Invalid Type");
            return;
        }
        Task newTask = new Task(title, creator, assignee, new Type(type, attributesValue), dueDate);
        this.tasks.add(newTask);

    }


    public void displayUsersTask() {
        System.out.println("Enter Assignee Name");
        String user = scanner.nextLine();
        for (Task taskElement : this.tasks) {
            if (taskElement.getAssignee().equalsIgnoreCase(user)) {
                System.out.println(taskElement);
            }
        }
    }

    public void changeTaskStatus() {
        System.out.println(this.tasks);
        System.out.println("Enter Task Title whose status needs to be changed");
        String title = scanner.nextLine();
//        Iterator<Task> iterator =  this.tasks.iterator();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getTitle().equalsIgnoreCase(title)) {
                if (!this.tasks.get(i).getType().getTypeName().equalsIgnoreCase("Feature")) {
                    System.out.println("Current status is " + this.tasks.get(i).getStatus() +
                            " Enter new Status");
                    this.tasks.get(i).setStatus(Status.valueOf(scanner.nextLine()));
                } else {
                    HashMap<String, String> state = new HashMap<>(Map.of(
                            "Open", "InProgress",
                            "InProgress", "Testing",
                            "Testing", "Deployed"
                    ));
                    this.tasks.get(i).setStatus(Status.valueOf(state.get(String.valueOf(this.tasks.get(i).getStatus()))));
                }
                return;
            }

        }
        System.out.println("Invalid Task Title");

    }

    public void changeAssignee() {
        System.out.println("Enter Task Title whose Assignee needs to be changed");
        String title = scanner.nextLine();
//        Iterator<Task> iterator =  this.tasks.iterator();
        for (int i = 0; i < this.tasks.size(); i++) {
            if (this.tasks.get(i).getTitle().equalsIgnoreCase(title)) {
                System.out.println("Enter New Assignee name");
                this.tasks.get(i).setAssignee(scanner.nextLine());
                return;
            }
        }
        System.out.println("Invalid Task Title");
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }


    private ArrayList<String> processType(String type) {
        ArrayList<String> attributesValue = new ArrayList<>();
        if (!typeList.containsKey(type)) {
            return null;
        }
        List<String> value = typeList.get(type);
        System.out.println("Enter Tasks additional attribute in sequence " + value);
        for (int i = 0; i < value.size(); i++) {
            attributesValue.add(scanner.nextLine());
        }

        return attributesValue.size() > 0 ? attributesValue : null;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }
}