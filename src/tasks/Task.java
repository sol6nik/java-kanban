package tasks;

import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private int idOfTask;
    private Status status;

    public Task(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdOfTask() {
        return idOfTask;
    }

    public void setIdOfTask(int idOfTask) {
        this.idOfTask = idOfTask;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", idOfTask=" + idOfTask +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return idOfTask == task.idOfTask &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, idOfTask, status);
    }
}