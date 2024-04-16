package Managers;

import Models.Epic;
import Models.Subtask;
import Models.Task;

import java.util.ArrayList;
import java.util.List;

public interface TaskManager {
    void nextId();

    void addTask(Task task);

    void addEpic(Epic epic);

    void addSubtask(Subtask subtask);

    List<Task> getAllTasks();

    List<Epic> getAllEpics();

    List<Subtask> getAllSubtasks();

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

    List<Integer> getEpicSubtascs(int epicId);

    int getTaskId();

    void updateEpicStatus();
}
