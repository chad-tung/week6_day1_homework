public class BusStop {
    private Person[] queue;

    public BusStop() {
        this.queue = new Person[5];
    }

    public int queueCount() {
        int counter = 0;
        for(Person person : this.queue) {
            if(person != null) {
                counter ++;
            }
        }
        return counter;
    }

    public boolean isBusStopFull() {
        return queueCount() == queue.length;
    }

    public void add(Person person) {
        if(!isBusStopFull()) {
            int counter = queueCount();
            this.queue[counter] = person;
        }
    }

    public void empty() {
        int counter = queueCount();
        for(int i=0; i < counter; i++) {
            this.queue[i] = null;
        }
    }
}
