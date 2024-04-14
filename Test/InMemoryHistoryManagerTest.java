import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {
    @Test
    public void addHistoryTestLess10Tasks(){
        TaskManager test = new InMemoryTaskManager();
        HistoryManager historyTest = new InMemoryHistoryManager();
        ArrayList<Task> historyListTest = new ArrayList<>();

        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);

        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask2);

        test.getTaskById(1);
        historyListTest.add(testTask1);

        test.getTaskById(2);
        historyListTest.add(testTask2);

        test.getTaskById(1);
        historyListTest.add(testTask1);

        test.getTaskById(1);
        historyListTest.add(testTask1);

        assertEquals(historyListTest, historyTest.getHistory());

    }
    @Test
    public void addHistoryTestMore10Tasks(){
        TaskManager test = new InMemoryTaskManager();
        HistoryManager historyTest = new InMemoryHistoryManager();
        ArrayList<Task> historyListTest = new ArrayList<>();

        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask1);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW, test);
        test.addTask(testTask2);

        test.getTaskById(2);
        test.getTaskById(2);
        for(int i = 0; i <= 8; i++) {
            test.getTaskById(1);
        }

        historyListTest.add(testTask2);
        for(int i = 0; i <= 8; i++){
            historyListTest.add(testTask1);
        }

        assertEquals(historyListTest, historyTest.getHistory());

    }

}