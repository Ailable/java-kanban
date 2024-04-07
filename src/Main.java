public class Main {
    public static void main(String[] args) {
        System.out.println("Поехали!");
        TaskManager taskManager = new TaskManager();
        taskManager.addTask(new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW));
        taskManager.addTask(new Task("Выкинуть мусор",
                "тут все просто, соброал, выкинул))", TaskStatus.NEW));
        taskManager.addEpic(new Epic("Сходить в магазин","в холодильнике пусто"));
        taskManager.addSubtask(new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,3));
        taskManager.addSubtask(new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,3));
        taskManager.addEpic(new Epic("Проверить почту",
                "писем накопилось с пррошлой недели"));
        taskManager.addSubtask(new Subtask("Проверить сообщения от начальника",
                "и отправить их в спам)", TaskStatus.NEW,6));

        for (Task task : taskManager.getAllTasks()) {
            System.out.println(task);
        }

        for (Epic epic : taskManager.getAllEpics()) {
            System.out.println(epic);
        }

        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }

        taskManager.updateSubtask(new Subtask(4,"Купить мясо",
                "мясо тоже закончилось", TaskStatus.DONE,3));
        for (Subtask subtask : taskManager.getEpicSubtascs(3)) {
            System.out.println(subtask);
        }
        System.out.println(taskManager.getEpicById(3));

        taskManager.deleteTask(2);
        taskManager.deleteEpic(3);
        for (Subtask subtask : taskManager.getAllSubtasks()) {
            System.out.println(subtask);
        }
    }
}
