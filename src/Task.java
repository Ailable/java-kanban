import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Task {
    String task;
    String description;
    TaskStatus status;
    int taskId;
    public Task(String task, String description, TaskStatus status, TaskManager taskManager){
        this.task = task;
        this.status = status;
        this.description = description;
        this.taskId = taskManager.getId();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task1 = (Task) o;
        return taskId == task1.taskId && Objects.equals(task, task1.task) && Objects.equals(description, task1.description) && status == task1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(task, description, status, taskId);
    }
}