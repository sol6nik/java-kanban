import manager.TaskManager;
import tasks.Epic;
import tasks.Status;
import tasks.Subtask;
import tasks.Task;

public class Main {
    public static void main(String[] args) {
        // Создаем TaskManager
        TaskManager taskManager = new TaskManager();

        // Добавляем обычные задачи
        Task task1 = new Task("Task 1", "Description of Task 1", Status.NEW);
        Task task2 = new Task("Task 2", "Description of Task 2", Status.NEW);
        taskManager.addTask(task1);
        taskManager.addTask(task2);

        // Вывод всех задач
        System.out.println("Все задачи:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        // Обновляем задачу
        task1.setStatus(Status.IN_PROGRESS);
        taskManager.updateTask(task1);
        System.out.println("\nПосле обновления Task 1:");
        System.out.println(taskManager.getTaskById(task1.getId()));

        // Добавляем Epic
        Epic epic1 = new Epic("Epic 1", "Description of Epic 1", Status.NEW);
        taskManager.addEpic(epic1);
        System.out.println("\nВсе эпики:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        // Добавляем Subtask в Epic
        Subtask subtask1 = new Subtask("Subtask 1", "Description of Subtask 1", Status.NEW, epic1.getId());
        taskManager.addSubtask(subtask1);

        Subtask subtask2 = new Subtask("Subtask 2", "Description of Subtask 2", Status.NEW, epic1.getId());
        taskManager.addSubtask(subtask2);

        System.out.println("\nПодзадачи эпика Epic 1:");
        for (Subtask subtask : taskManager.getSubtasksOfEpic(epic1)) {
            System.out.println(subtask);
        }

        // Обновляем статус подзадачи и проверяем статус эпика
        subtask1.setStatus(Status.DONE);
        taskManager.updateSubtask(subtask1);

        System.out.println("\nПосле обновления статуса подзадачи Subtask 1:");
        System.out.println(taskManager.getEpicById(epic1.getId()));

        // Удаляем задачу
        taskManager.removeTask(task2.getId());
        System.out.println("\nПосле удаления Task 2:");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        // Удаление подзадачи и обновление эпика
        taskManager.removeSubtask(subtask1.getId());
        System.out.println("\nПосле удаления подзадачи Subtask 1:");
        System.out.println(taskManager.getEpicById(epic1.getId()));

        // Удаление эпика
        taskManager.removeEpic(epic1.getId());
        System.out.println("\nПосле удаления эпика Epic 1:");
        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }
    }
}