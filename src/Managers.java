public class Managers {
    private static TaskManager inMemoryTaskManager = new InMemoryTaskManager();
    private static HistoryManager historyManager = new InMemoryHistoryManager();
    public static TaskManager getDefault(){
        return inMemoryTaskManager;
    }

    public static HistoryManager getDefaultHistory() {
        return historyManager;
    }

}