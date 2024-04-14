import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @BeforeAll
    static void beforeAll(){
        Managers.getDefault().addTask(new Task("Помыть посуду",
                "в посудомойку не влезли сковородки, надо помыть ручками)",
                TaskStatus.NEW,
                Managers.getDefault()));
    }
    @Test
    void taskSetStatusTest(){
        Task task = Managers.getDefault().getTaskById(1);
        TaskStatus newStatus = TaskStatus.DONE;
        Managers.getDefault().getTaskById(1).setStatus(newStatus);
        assertEquals(task.getStatus(), newStatus);
    }



}