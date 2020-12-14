import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UtilsTest {
    @Test
    public void testUtils(){
        File file = new File("./src/test/testFileUtils.xls");
        ArrayList<Group> groups = Utils.parse(file.getAbsolutePath());

        assertEquals(groups.size(), 1);
        assertEquals(groups.get(0).name, "Name");
    }
}
