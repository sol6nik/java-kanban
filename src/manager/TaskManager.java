package manager;

import tasks.Epic;
import tasks.Subtask;
import tasks.Task;

import java.util.List;

public interface TaskManager {
    Task createTask(Task task);
    Epic createEpic(Epic epic);
    Subtask createSubtask(Subtask subtask);
    List<Task> getAllTasks();
    List<Epic> getAllEpics();
    List<Subtask> getAllSubtasks();
    void updateTask(Task task);
    void updateEpic(Epic epic);
    void updateSubtask(Subtask subtask);
    List<Subtask> getSubtasksByEpic(int epicId);
    void deleteTask(int taskId);
    void deleteSubtask(int subtaskId);
    void deleteEpic(int epicId);
    void deleteAllTasks();
    void deleteAllEpics();
    void deleteAllSubtasks();
    Task getTaskById(int id);
    List<Task> getHistory();
}