package Managers;

import Constants.TaskStatus;
import Managers.HistoryManager;
import Managers.InMemoryHistoryManager;
import Managers.InMemoryTaskManager;
import Managers.TaskManager;
import Models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    TaskManager test;
    HistoryManager historyTest;
    ArrayList<Task> historyListTest;
    @BeforeEach
    public void beforeEach(){
        test = new InMemoryTaskManager();
        historyTest = new InMemoryHistoryManager();
        historyListTest = new ArrayList<>();
        historyListTest.clear();
        historyTest.getHistory().clear();

    }

    @Test
    public void addHistoryTestLess10Tasks(){;

        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW);
        test.addTask(testTask1);

        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW);
        test.addTask(testTask2);

        test.getTaskById(1);
        historyListTest.add(testTask1);
        assertEquals(historyListTest, historyTest.getHistory());

    }
    @Test
    public void addHistoryTestMore10Tasks(){

        Task testTask1 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW);
        test.addTask(testTask1);
        Task testTask2 = new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)", TaskStatus.NEW);
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