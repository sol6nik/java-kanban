import manager.TaskManager;
import tasks.Epic;
import tasks.Status;
import tasks.Task;
import tasks.Subtask;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        Task task1 = new Task(manager.generateId(), "Task 1", "Description 1", Status.NEW);
        manager.createTask(task1);

        Epic epic1 = new Epic(manager.generateId(), "Epic 1", "Description Epic 1", Status.NEW);

        manager.createEpic(epic1);

        Subtask subtask1 = new Subtask(manager.generateId(), "Subtask 1", "Description Subtask 1", Status.NEW, epic1.getId());
        manager.createSubtask(subtask1);

        System.out.println("Tasks: " + manager.getAllTasks());
        System.out.println("Epics: " + manager.getAllEpics());
        System.out.println("Subtasks: " + manager.getAllSubtasks());

        subtask1.setStatus(Status.DONE);
        manager.updateSubtask(subtask1);

        System.out.println("Updated Epics: " + manager.getAllEpics());
    }
}