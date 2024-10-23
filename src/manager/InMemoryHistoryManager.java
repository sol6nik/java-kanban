package manager;

import tasks.Task;

import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;

    private LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }

        history.add(task);

        if (history.size() > MAX_HISTORY_SIZE) {
            history.removeFirst();
        }
    }

    @Override
    public List<Task> getHistory() {
        // Возвращаем копию истории
        return new LinkedList<>(history);
    }
}