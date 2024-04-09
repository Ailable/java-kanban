import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


public class Epic extends Task {
    List<Integer> subtasksList; // Список с ID подзадач для данного Эпика

    public Epic(String task, String description, TaskManager taskManager) {
        super(task, description, TaskStatus.NEW, taskManager);
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
            result = result + ", SubtaskID=" + subtasksList + ", EPIC=" + task + ", DESCRIPTION=";
        } else {
            result = result + ", SubtaskID=Null" + ", EPIC=" + task + ", DESCRIPTION=";
        }
            if (description != "") {
                result = result + description + ", STATUS=" + status;
            } else {
                result = result + "null , STATUS=" + status;
            }
            return result;
    }
}
