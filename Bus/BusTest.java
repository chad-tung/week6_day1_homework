import static org.junit.Assert.assertEquals;
import org.junit.*;

public class BusTest{
    Bus bus;
    Person person;
    BusStop busStop;

    @Before
    public void before() {
        bus = new Bus();
        person = new Person();
        busStop = new BusStop();
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

    @Test
    public void busCollect() {
        for(int i=0; i < 5; i++){
            busStop.add(person);
        }
        for(int i=0; i < 4; i++){
            bus.add(person);
        }
        assertEquals(4, bus.passengerCount());
        assertEquals(5, busStop.queueCount());
        assertEquals(true, busStop.positionCheck(4));

        bus.collect(busStop);

        assertEquals(5, bus.passengerCount());
        assertEquals(4, busStop.queueCount());
        assertEquals(false, busStop.positionCheck(4));
    }

    @Test
    public void busFill() {
        for(int i=0; i < 5; i++){
            busStop.add(person);
        }
        for(int i=0; i < 7; i++){
            bus.add(person);
        }

        bus.fill(busStop);

        assertEquals(10, bus.passengerCount());
        assertEquals(2, busStop.queueCount());
        assertEquals(true, busStop.positionCheck(0));
        assertEquals(true, busStop.positionCheck(1));
        assertEquals(false, busStop.positionCheck(2));
        assertEquals(false, busStop.positionCheck(3));
        assertEquals(false, busStop.positionCheck(4));

    }
}
