import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @BeforeAll
    static void BeforeAll(){
        Managers.getDefault().addEpic(new Epic("Сходить в магазин",
                "в холодильнике пусто",
                Managers.getDefault()));
    }
    /*
    @Test
    void getSubtasksListTest(){
        Epic epic = Managers.getDefault().getEpicById(1);
        Managers.getDefault().getEpicSubtascs(1).add(epic);
    }

    Не вижу смысла делать тест на проверку, что объект Epic нельзя добавить в самого себя в виде подзадачи,
    т.к List<Subtask> subtasksList; может хранить только сабтаски и эпики запихать в него не выйдет
     */


}