import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest {
    File file = new File("./src/test/testFile.xls");
    ArrayList<Group> groups = Utils.parse(file.getAbsolutePath());

    Group currGroup = groups.get(0);

    @Test
    public void testGroup1(){
        Group newGroup = new Group();
        assertNotEquals(newGroup, currGroup);
    }

    @Test
    public void testGroup2(){
        ArrayList<String> neededTeachers = new ArrayList<String>(
                Arrays.asList("teacher1", "teacher2", "teacher3"));
        ArrayList<String> neededStudents = new ArrayList<String>(
                Arrays.asList("Student1", "Student2", "Student3", "Student4"));

        assertEquals(currGroup.getName(), "NameGroup");
        assertEquals(currGroup.getStudents(), neededStudents);
        assertEquals(currGroup.getTeachers(), neededTeachers);
    }

    @Test
    public void testGroup3(){
        assertEquals(currGroup.getMediumCellsByTeacher("teacher1"), 94);
        assertEquals(currGroup.getMediumIndividualCell("Student1"), 96);
        assertEquals(currGroup.getMediumCellOfGroup(), 92);
    }

}

