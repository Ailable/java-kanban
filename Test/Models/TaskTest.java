package Models;

import Constants.TaskStatus;
import Managers.Managers;
import Models.Task;
import Managers.TaskManager;
import Managers.InMemoryTaskManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class TaskTest {
    @Test
    void taskSetStatusTest(){
        TaskManager test = new InMemoryTaskManager();
        test.addTask(new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)",
                TaskStatus.NEW));
        Task task = test.getTaskById(1);
        TaskStatus newStatus = TaskStatus.DONE;
        test.getTaskById(1).setStatus(newStatus);
        Assertions.assertEquals(task.getStatus(), newStatus);
    }



}