import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    void nextId();

    void addTask(Task task);

    void addEpic(Epic epic);

    void addSubtask(Subtask subtask);

    ArrayList<Task> getAllTasks();

    ArrayList<Epic> getAllEpics();

    ArrayList<Subtask> getAllSubtasks();

    void clearTasks();

    void clearEpics();

    void clearSubtasks();

    Task getTaskById(int id);

    Epic getEpicById(int id);

    Subtask getSubtaskById(int id);

    void updateTask(Task task);

    void updateSubtask(Subtask subtask);

    void deleteTask(int id);

    void deleteEpic(int id);

    void deleteSybtask(int id);

    List<Subtask> getEpicSubtascs(int epicId);

    int getSubtask();

    void updateEpicStatus();
}
