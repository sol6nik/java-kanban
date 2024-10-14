package manager;

import tasks.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private Map<Integer, Task> tasks = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();
    private Map<Integer, Epic> epics = new HashMap<>();
    private int currentId = 1;

    public int generateId() {
        return currentId++;
    }

    public void createTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void createSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.addSubtask(subtask.getId());
            epic.calculateStatus(new ArrayList<>(subtasks.values()));
        }
    }

    public void createEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public List<Epic> getAllEpics() {
        return new ArrayList<>(epics.values());
    }

    public List<Subtask> getAllSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        Epic epic = epics.get(subtask.getEpicId());
        if (epic != null) {
            epic.calculateStatus(new ArrayList<>(subtasks.values()));
        }
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        epic.calculateStatus(new ArrayList<>(subtasks.values()));
    }
}