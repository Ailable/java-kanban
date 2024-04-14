import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class InMemoryTaskManager implements TaskManager {
    private final Map<Integer, Task> tasks;
    private final Map<Integer, Epic> epics;
    private final Map<Integer, Subtask> subtasks;
    private int subtask = 1;

    public InMemoryTaskManager() {
        this.tasks = new HashMap<>();
        this.epics = new HashMap<>();
        this.subtasks = new HashMap<>();
    }
    @Override
    public void nextId(){
        subtask++;
    }

    @Override
    public void addTask(Task task) { // Создание Задачи
        tasks.put(subtask,task);
        nextId();
    }
    @Override
    public void addEpic(Epic epic) { // Создание Эпика
        epics.put(subtask,epic);
        nextId();
        updateEpicStatus();
    }
    @Override
    public void addSubtask(Subtask subtask) { // Создание Подзадачи
        if(epics.containsKey(subtask.getEpicId())) {
            subtasks.put(this.subtask, subtask);
            epics.get(subtask.getEpicId()).subtasksList.add(subtask); // добавляем ID Подзадачи в список
            nextId();
            updateEpicStatus();
        } else {
            System.out.println("Такого эпика не существует");
        }
    }
    @Override
    public ArrayList<Task> getAllTasks(){ // Получение списка всех Задач.
        ArrayList<Task> allTasks = new ArrayList<>();
        for (Task task: tasks.values()){
            allTasks.add(task);
        }
        return allTasks;
    }
    @Override
    public ArrayList<Epic> getAllEpics(){ // Получение списка всех Эпиков.
        ArrayList<Epic> allEpics = new ArrayList<>();
        for (Epic epic: epics.values()){
            allEpics.add(epic);
        }
        return allEpics;
    }
    @Override
    public ArrayList<Subtask> getAllSubtasks(){ // Получение списка всех Подзадач.
        ArrayList<Subtask> allSubtasks = new ArrayList<>();
        for (Subtask subtask: subtasks.values()){
            allSubtasks.add(subtask);
        }
        return allSubtasks;
    }
    @Override
    public void clearTasks() { // Удаление всех Задач.
        tasks.clear();
    }
    @Override
    public void clearEpics() { // Удаление всех Эпиков.
        epics.clear();
    }
    @Override
    public void clearSubtasks() { // Удаление всех Подзадач.
        subtasks.clear();
    }
    @Override
    public Task getTaskById(int id) { // Получение Задачи по идентификатору.
        Managers.getDefaultHistory().add(tasks.get(id));
        return tasks.get(id);
    }
    @Override
    public Epic getEpicById(int id) { // Получение Эпика по идентификатору.;
        Managers.getDefaultHistory().add(epics.get(id));
        return epics.get(id);
    }
    @Override
    public Subtask getSubtaskById(int id) { // Получение Подзадачи по идентификатору.
        Managers.getDefaultHistory().add(subtasks.get(id));
        return subtasks.get(id);
    }
    @Override
    public void updateTask(Task task) { // Обновление Задачи.
        tasks.put(task.getTaskId(), task);
    }
    @Override
    public void updateSubtask(Subtask subtask) { // Обновление Подзадачи.
        subtasks.put(subtask.getTaskId(), subtask);
        updateEpicStatus();
    }
    @Override
    public void deleteTask(int id) { // Удаление Задачи по идентификатору.
        tasks.remove(id);
    }
    @Override
    public void deleteEpic(int id) { // Удаление Эпика по идентификатору.
        epics.remove(id);
    }
    @Override
    public void deleteSybtask(int id) { // Удаление Подзадачи по идентификатору.
        subtasks.remove(id);
    }
    @Override
    public List<Subtask> getEpicSubtascs(int epicId) { // Получение списка всех подзадач определённого эпика.
        return Managers.getDefault().getEpicById(epicId).getSubtasksList();
    }
    @Override
    public int getSubtask() {
        return subtask;
    }

    @Override
    public void updateEpicStatus() {
        for (Epic epic : epics.values()) {
            TaskStatus status = TaskStatus.NEW;
            int subtaskNumber = 1;
            int number = 1;
            if (epic.getSubtasksList().isEmpty()) {
                epic.setStatus(TaskStatus.NEW);
            } else {
                for (Subtask subtask : epic.getSubtasksList()) {
                    if (subtaskNumber == 1){
                        if (subtasks.get(subtask.getTaskId()).getStatus().equals(TaskStatus.NEW)){
                            status = TaskStatus.NEW;
                            subtaskNumber++;
                            number++;
                        } else if (subtasks.get(subtask.getTaskId()).getStatus().equals(TaskStatus.DONE)){
                            status = TaskStatus.DONE;
                            subtaskNumber++;
                            number++;
                        } else {
                            status = TaskStatus.IN_PROGRESS;
                            subtaskNumber++;
                            number++;
                        }
                    } else if (subtaskNumber == subtaskNumber){
                        if (!subtasks.get(subtask.getTaskId()).getStatus().equals(status)){
                            status = TaskStatus.IN_PROGRESS;
                        }
                    }
                }
                epic.setStatus(status);
            }
        }
    }
}


