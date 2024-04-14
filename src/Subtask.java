public class Subtask extends Task {
    int epicId;

    public Subtask(String task, String description, TaskStatus status, int epicId, TaskManager inMemoryTaskManager) {
        super(task, description, status, inMemoryTaskManager);
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
        String result = "ID=" + taskId + ", EpicID=" + epicId + ", SUBTASK=" + task + ", DESCRIPTION=";
        if (description != ""){
            result = result + description + ", STATUS=" + status;
        } else {
            result = result + "null , STATUS=" + status;
        }
        return result;
    }
}
