import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private final Map<Integer, Task> tasks;
    private final HashMap<Integer, Epic> epics;
    private final HashMap<Integer, Subtask> subtasks;
    private int id = 1;

    public TaskManager() {
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subtasks = new HashMap<>();
    }

    public void nextId(){
        id++;
    }

    public void addTask(Task task) { // Создание Задачи
        tasks.put(id,task);
        nextId();
    }
    public void addEpic(Epic epic) { // Создание Эпика
        epics.put(id,epic);
        nextId();
        updateEpicStatus();
    }
    public void addSubtask(Subtask subtask) { // Создание Подзадачи
        if(epics.containsKey(subtask.getEpicId())) {
            subtasks.put(id, subtask);
            epics.get(subtask.getEpicId()).subtasksList.add(subtask.getTaskId()); // добавляем ID Подзадачи в список
            nextId();
            updateEpicStatus();
        } else {
            System.out.println("Такого эпика не существует");
        }
    }
    public ArrayList<Task> getAllTasks (){ // Получение списка всех Задач.
        ArrayList<Task> allTasks = new ArrayList<>();
        for (Task task: tasks.values()){
            allTasks.add(task);
        }
        return allTasks;
    }
    public ArrayList<Epic> getAllEpics (){ // Получение списка всех Эпиков.
        ArrayList<Epic> allEpics = new ArrayList<>();
        for (Epic epic: epics.values()){
            allEpics.add(epic);
        }
        return allEpics;
    }
    public ArrayList<Subtask> getAllSubtasks (){ // Получение списка всех Подзадач.
        ArrayList<Subtask> allSubtasks = new ArrayList<>();
        for (Subtask subtask: subtasks.values()){
            allSubtasks.add(subtask);
        }
        return allSubtasks;
    }
    public void clearTasks() { // Удаление всех Задач.
        tasks.clear();
    }
    public void clearEpics() { // Удаление всех Эпиков.
        epics.clear();
    }
    public void clearSubtasks() { // Удаление всех Подзадач.
        subtasks.clear();
    }
    public Task getTaskById(int id) { // Получение Задачи по идентификатору.
        return tasks.get(id);
    }
    public Epic getEpicById(int id) { // Получение Эпика по идентификатору.
        return epics.get(id);
    }
    public Subtask getSubtaskById(int id) { // Получение Подзадачи по идентификатору.
        return subtasks.get(id);
    }
    public void updateTask(Task task) { // Обновление Задачи.
        tasks.put(task.getTaskId(), task);
    }
    public void updateSubtask(Subtask subtask) { // Обновление Подзадачи.
        subtasks.put(subtask.getTaskId(), subtask);
        updateEpicStatus();
    }
    public void deleteTask(int id) { // Удаление Задачи по идентификатору.
        tasks.remove(id);
    }
    public void deleteEpic(int id) { // Удаление Эпика по идентификатору.
        epics.remove(id);
    }
    public void deleteSybtask(int id) { // Удаление Подзадачи по идентификатору.
        subtasks.remove(id);
    }
    public ArrayList<Subtask> getEpicSubtascs(int epicId) { // Получение списка всех подзадач определённого эпика.
        ArrayList<Subtask> epicSubtasks = new ArrayList<>();
        for (int a: epics.get(epicId).getSubtasksList()){
            epicSubtasks.add(subtasks.get(a));
            }
        return epicSubtasks;
    }
    public int getId() {
        return id;
    }

    public void updateEpicStatus() {
        for (Epic epic : epics.values()) {
            TaskStatus status = TaskStatus.NEW;
            int subtaskNumber = 1;
            int number = 1;
            if (epic.getSubtasksList().isEmpty()) {
                epic.setStatus(TaskStatus.NEW);
            } else {
                for (int id : epic.getSubtasksList()) {
                    if (subtaskNumber == 1){
                        if (subtasks.get(id).getStatus().equals(TaskStatus.NEW)){
                            status = TaskStatus.NEW;
                            subtaskNumber++;
                            number++;
                        } else if (subtasks.get(id).getStatus().equals(TaskStatus.DONE)){
                            status = TaskStatus.DONE;
                            subtaskNumber++;
                            number++;
                        } else {
                            status = TaskStatus.IN_PROGRESS;
                            subtaskNumber++;
                            number++;
                        }
                    } else if (subtaskNumber == subtaskNumber){
                        if (!subtasks.get(id).getStatus().equals(status)){
                            status = TaskStatus.IN_PROGRESS;
                        }
                    }
                }
                epic.setStatus(status);
            }
        }
    }

}


