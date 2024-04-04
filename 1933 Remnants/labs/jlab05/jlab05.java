import java.util.ArrayList;

class jlab05 {
    ArrayList<Passenger> passengers;
    int capacity = 100;
    jlab05() {
        this.passengers = new ArrayList();
    }
    jlab05(int num) {
        this.passengers = new ArrayList();
        this.capacity = num;
    }
    public int numberOfPassengers() {
        return this.passengers.size();
    }
    public int availableCapacity() {
        return this.capacity - this.numberOfPassengers();
    }
    public void addPassenger(Passenger p) {
        if(this.numberOfPassengers() < this.capacity) {
            this.passengers.add(p);
        }
    }
}