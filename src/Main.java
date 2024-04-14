public class Main {
    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskManager inMemoryTaskManager = Managers.getDefault();
        HistoryManager historyManager = Managers.getDefaultHistory();

        inMemoryTaskManager.addTask(new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, inMemoryTaskManager));
        inMemoryTaskManager.addTask(new Task("Выкинуть мусор",
                "тут все просто, соброал, выкинул))", TaskStatus.NEW, inMemoryTaskManager));
        inMemoryTaskManager.addEpic(new Epic("Сходить в магазин","в холодильнике пусто", inMemoryTaskManager));
        inMemoryTaskManager.addSubtask(new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,3, inMemoryTaskManager));
        inMemoryTaskManager.addSubtask(new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,3, inMemoryTaskManager));
        inMemoryTaskManager.addEpic(new Epic("Проверить почту",
                "писем накопилось с пррошлой недели", inMemoryTaskManager));
        inMemoryTaskManager.addSubtask(new Subtask("Проверить сообщения от начальника",
                "и отправить их в спам)", TaskStatus.NEW,6, inMemoryTaskManager));
        for (Task task : inMemoryTaskManager.getAllTasks()) {
            System.out.println(task);
        }


        for (Epic epic : inMemoryTaskManager.getAllEpics()) {
            System.out.println(epic);
        }

        for (Subtask subtask : inMemoryTaskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
        inMemoryTaskManager.updateSubtask(new Subtask(4,"Купить мясо",
                "мясо тоже закончилось", TaskStatus.DONE,3));
        for (Subtask subtask : inMemoryTaskManager.getEpicSubtascs(3)) {
            System.out.println(subtask);
        }
        System.out.println(inMemoryTaskManager.getEpicById(3));


        for (Subtask subtask : inMemoryTaskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
        System.out.println(inMemoryTaskManager.getTaskById(1));
        System.out.println(inMemoryTaskManager.getEpicById(3));
        System.out.println(inMemoryTaskManager.getEpicById(6));
        for (Task history : historyManager.getHistory()) {
            System.out.println(history);
        }
        for (Subtask subtask : inMemoryTaskManager.getEpicSubtascs(3)) {
            System.out.println(subtask);
        }
    }
}
