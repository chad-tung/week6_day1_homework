public class Bus {
    private Person[] passengers;

    public Bus() {
        this.passengers = new Person[10];
    }

    public int passengerCount() {
        int counter = 0;
        for(Person person : this.passengers) {
            if(person != null) {
                counter ++;
            }
        }
        return counter;
    }

    public boolean isBusFull() {
        return passengerCount() == passengers.length;
    }

    public void add(Person person) {
        if(!isBusFull()) {
            int counter = passengerCount();
            this.passengers[counter] = person;
        }
    }

    public void empty() {
        int counter = passengerCount();
        for(int i=0; i < counter; i++) {
            this.passengers[i] = null;
        }
    }

    public void collect(BusStop busStop) {
        if(!isBusFull() && !busStop.isBusStopEmpty()) {
            int counter = passengerCount();
            this.passengers[counter] = new Person();
            busStop.removeShuffle();
        }
    }

    public void fill(BusStop busStop) {
        int counter = this.passengers.length - passengerCount();
        for(int i=0; i < counter; i++) {
            collect(busStop);
        }
    }
}
