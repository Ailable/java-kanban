package Models;
import Constants.TaskStatus;

import java.util.Objects;

public class Task  {
    String title;
    String description;
    TaskStatus status = TaskStatus.NEW;
    int taskId;
    public Task(String task, String description){
        this.title = task;
        this.description = description;
    }
    public Task(String task, String description, TaskStatus status){
        this.title = task;
        this.status = status;
        this.description = description;
    }
    public Task( int id, String task, String description, TaskStatus status){
        this.title = task;
        this.status = status;
        this.description = description;
        this.taskId = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        String result = "ID=" + taskId + ", TASK=" + title + ", DESCRIPTION=";
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
        return taskId == task1.taskId && Objects.equals(title, task1.title) && Objects.equals(description, task1.description) && status == task1.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, status, taskId);
    }
}