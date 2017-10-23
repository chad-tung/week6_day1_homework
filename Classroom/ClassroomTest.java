import static org.junit.Assert.assertEquals;
import org.junit.*;

public class ClassroomTest {
    Classroom classroom;
    Person student;

    @Before
    public void before() {
        classroom = new Classroom();
        student = new Person();
    }

    @Test
    public void studentCount() {
        assertEquals(0, classroom.studentCount());
        classroom.add(student);
        assertEquals(1, classroom.studentCount());
    }

    @Test
    public void classIsFull() {
        assertEquals(false, classroom.isClassFull());
        for(int i=0; i < 20; i++) {
            classroom.add(student);
        }
        assertEquals(true, classroom.isClassFull());
    }

    @Test
    public void classroomEmpty() {
        for(int i=0; i < 20; i++) {
            classroom.add(student);
        }
        assertEquals(20, classroom.studentCount());
        classroom.dismiss();

        assertEquals(0, classroom.studentCount());
    }
}
