import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class inMemoryTaskManagerTest {
    @Test
    public void nextIdTest(){
        TaskManager test = new InMemoryTaskManager();
        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask2);
        assertEquals(2,test.getTaskById(2).getTaskId());
    }
    @Test
    public void AddTaskSubtaskAndEpicTest(){
        TaskManager test = new InMemoryTaskManager();
        Epic testEpic = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic);
        Subtask testSubtask = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,1, test);
        test.addSubtask(testSubtask);
        Task testTask = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask);
        assertEquals(testSubtask,test.getSubtaskById(2));
        assertEquals(testEpic, test.getEpicById(1));
        assertEquals(testTask,test.getTaskById(3));
    }

    @Test
    public void AddSubtaskIfEpicNotCreated(){
        TaskManager test = new InMemoryTaskManager();
        Subtask testSubtask = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,1, test);
        test.addSubtask(testSubtask);
        assertNull(test.getSubtaskById(1));
    }
    @Test
    public void getAllTasksTest(){
        TaskManager test = new InMemoryTaskManager();
        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);
        test.addTask(testTask2);

        ArrayList<Task> testList = new ArrayList<>();
        testList.add(testTask1);
        testList.add(testTask2);

        assertEquals(testList, test.getAllTasks());

    }

    @Test
    public void getAllEpicsTest(){
        TaskManager test = new InMemoryTaskManager();
        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        Epic testEpic2 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);
        test.addEpic(testEpic2);

        ArrayList<Epic> testList = new ArrayList<>();
        testList.add(testEpic1);
        testList.add(testEpic2);

        assertEquals(testList, test.getAllEpics());

    }

    @Test
    public void getAllSubtasksTest(){
        TaskManager test = new InMemoryTaskManager();
        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        Epic testEpic2 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);
        test.addEpic(testEpic2);
        Subtask testSubtask1 = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,1, test);
        Subtask testSubtask2 = new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,2, test);
        test.addSubtask(testSubtask1);
        test.addSubtask(testSubtask2);

        ArrayList<Subtask> testList = new ArrayList<>();
        testList.add(testSubtask1);
        testList.add(testSubtask2);

        assertEquals(testList, test.getAllSubtasks());

    }

    @Test
    public void clearTasksEpicsAndSubtasksTest() {
        TaskManager test = new InMemoryTaskManager();
        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask2);

        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        Epic testEpic2 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);
        test.addEpic(testEpic2);

        Subtask testSubtask1 = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,3, test);
        Subtask testSubtask2 = new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,4, test);
        test.addSubtask(testSubtask1);
        test.addSubtask(testSubtask2);

        test.clearTasks();
        test.clearSubtasks();
        test.clearEpics();

        assertNull(test.getTaskById(1));
        assertNull(test.getTaskById(2));
        assertNull(test.getSubtaskById(5));
        assertNull(test.getSubtaskById(6));
        assertNull(test.getEpicById(3));
        assertNull(test.getEpicById(4));
    }
    @Test
    public void removeEpicTaskAndSubtaskTest(){
        TaskManager test = new InMemoryTaskManager();
        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask2);

        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        Epic testEpic2 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);
        test.addEpic(testEpic2);

        Subtask testSubtask1 = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,3, test);
        Subtask testSubtask2 = new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,4, test);
        test.addSubtask(testSubtask1);
        test.addSubtask(testSubtask2);

        test.deleteEpic(4);
        test.deleteSybtask(6);
        test.deleteTask(2);

        assertNotNull(test.getTaskById(1));
        assertNull(test.getTaskById(2));
        assertNotNull(test.getSubtaskById(5));
        assertNull(test.getSubtaskById(6));
        assertNotNull(test.getEpicById(3));
        assertNull(test.getEpicById(4));
    }

    @Test
    public void getEpicSubtasksTest(){
        TaskManager test = new InMemoryTaskManager();
        List<Subtask> epicSubtasksTestList = new ArrayList<>();

        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);

        Subtask testSubtask1 = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,1, test);
        test.addSubtask(testSubtask1);
        Subtask testSubtask2 = new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,1, test);
        test.addSubtask(testSubtask2);
        epicSubtasksTestList.add(testSubtask1);
        epicSubtasksTestList.add(testSubtask2);

        assertEquals(epicSubtasksTestList,test.getEpicById(1).getSubtasksList());

    }

    @Test
    public void updateEpicStatusTest(){
        TaskManager test = new InMemoryTaskManager();
        Epic testEpic1 = new Epic("Сходить в магазин","в холодильнике пусто", test);
        test.addEpic(testEpic1);

        Subtask testSubtask1 = new Subtask("Купить мясо",
                "мясо тоже закончилось", TaskStatus.NEW,1, test);
        test.addSubtask(testSubtask1);
        Subtask testSubtask2 = new Subtask("Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE,1, test);
        test.addSubtask(testSubtask2);

        assertEquals(TaskStatus.IN_PROGRESS ,test.getEpicById(1).getStatus());

        test.updateSubtask(new Subtask(3,"Купить молоко",
                "молоко тоже закончилось", TaskStatus.NEW, 1));
        assertEquals(TaskStatus.NEW ,test.getEpicById(1).getStatus());

        test.updateSubtask(new Subtask(3,"Купить молоко",
                "молоко тоже закончилось", TaskStatus.DONE, 1));
        test.updateSubtask(new Subtask(2, "Купить мясо",
                "мясо тоже закончилось", TaskStatus.DONE,1));
        assertEquals(TaskStatus.DONE ,test.getEpicById(1).getStatus());
    }



}