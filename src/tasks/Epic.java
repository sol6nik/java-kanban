package tasks;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Integer> subtasksIds = new ArrayList<>();

    public Epic(String title, String description, Status status) {
        super(title, description, status);
    }

    public ArrayList<Integer> getSubtasksIds() {
        return subtasksIds;
    }

    public void addSubtaskId(int idOfSubtask) {
        subtasksIds.add(idOfSubtask);
    }

    public void removeSubtaskId(Integer idOfSubtask) {
        subtasksIds.remove(idOfSubtask);
    }
}