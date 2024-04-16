package Models;
import Constants.TaskStatus;

import java.util.Objects;

public class Subtask extends Task {
    int epicId;

    public Subtask(String task, String description, int epicId) {
        super(task, description);
        this.epicId = epicId;
    }

    public Subtask(String task, String description, TaskStatus status, int epicId) {
        super(task, description, status);
        this.epicId = epicId;
    }

    public Subtask(int id, String task, String description, TaskStatus status, int epicId) {
        super(id, task, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }


    @Override
    public String toString() {
        String result = "ID=" + taskId + ", EpicID=" + epicId + ", SUBTASK=" + title + ", DESCRIPTION=";
        if (description != ""){
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
        Subtask subtask = (Subtask) o;
        return epicId == subtask.epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }
}
