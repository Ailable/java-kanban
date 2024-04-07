import java.util.ArrayList;
import java.util.HashMap;
public class Task {
    String task;
    String description;
    TaskStatus status;
    int taskId;
    public Task(String task, String description, TaskStatus status){
        this.task = task;
        this.status = status;
        this.description = description;
        this.taskId = TaskManager.getId();
    }
    public Task( int id, String task, String description, TaskStatus status){
        this.task = task;
        this.status = status;
        this.description = description;
        this.taskId = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String result = "ID=" + taskId + ", TASK=" + task + ", DESCRIPTION=";
        if (description != ""){
            result = result + description + ", STATUS=" + status;
        } else {
            result = result + "null , STATUS=" + status;
        }
        return result;
    }
}