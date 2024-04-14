import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    void creatingObjectTest(){
        assertNotNull(Managers.getDefault());
        assertNotNull(Managers.getDefaultHistory());
    }
}