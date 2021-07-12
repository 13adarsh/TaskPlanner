package dto;

import java.util.Date;
import java.util.HashMap;

public class Task {
    private String title;
    private String creator;
    private String assignee;
    private Status status;
    private Type type;
    private String dueDate;
//    private HashMap<String,String> attributes;

    public Task(String title, String creator, String assignee, Type type, String dueDate) {
        this.title = title;
        this.creator = creator;
        this.assignee = assignee;
        this.status = Status.Open;
        this.type = type;
        this.dueDate = dueDate;
           }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", assignee='" + assignee + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", dueDate=" + dueDate +
                '}';
    }
}

