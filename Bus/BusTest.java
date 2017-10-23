import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest{
    Bus bus;
    Person person;

    @Before
    public void before() {
        bus = new Bus();
        person = new Person();
    }

    @Test
    public void passengerCount() {
        assertEquals(0, bus.passengerCount());
        bus.add(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void busIsFull() {
        assertEquals(false, bus.isBusFull());
        for(int i=0; i < 10; i++){
            bus.add(person);
        }
        assertEquals(true, bus.isBusFull());
    }

    @Test
    public void busEmpty() {
        for(int i=0; i < 10; i++){
            bus.add(person);
        }
        assertEquals(10, bus.passengerCount());
        bus.empty();

        assertEquals(0, bus.passengerCount());
    }
}
