import java.util.ArrayList;

public class InMemoryHistoryManager implements HistoryManager{

    private static ArrayList<Task> historyTasks = new ArrayList<>();


    @Override
    public void add(Task task) {
        if (historyTasks.size() == 10){
            historyTasks.remove(0);
            historyTasks.add(task);
        } else {
            historyTasks.add(task);
        }
    }

    @Override
    public ArrayList<Task> getHistory() {
        return historyTasks;
    }
}
