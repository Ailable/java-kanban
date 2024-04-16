package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Constants.TaskStatus;


public class Epic extends Task {
    List<Integer> subtasksList; // Список с ID подзадач для данного Эпика

    public Epic(String task, String description) {
        super(task, description);
        this.subtasksList = new ArrayList<>();
    }

    public List<Integer> getSubtasksList() {
        return subtasksList;
    }


    public Epic(int id, String task, String description) {
        super(id, task, description, TaskStatus.NEW);
    }
    @Override
    public String toString() {
        String result = "ID=" + taskId;
        if (!subtasksList.isEmpty()) {
            result = result + ", SubtaskID=" + subtasksList + ", EPIC=" + title + ", DESCRIPTION=";
        } else {
            result = result + ", SubtaskID=Null" + ", EPIC=" + title + ", DESCRIPTION=";
        }
            if (description != "") {
                result = result + description + ", STATUS=" + status;
            } else {
                result = result + "null , STATUS=" + status;
            }
            return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subtasksList, epic.subtasksList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasksList);
    }
}
