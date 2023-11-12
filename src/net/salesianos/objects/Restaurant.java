package net.salesianos.objects;

public class Restaurant {
    private int count = 0;
    private final int MAX_VEGETABLES = 5;

    public synchronized void receiveVegetables() {
        count++;
        notifyAll();
    }

    public synchronized void eatVegetables() throws InterruptedException{
        while (this.count <= 0) {
            wait();
        }
        count--;
    }

    public int getMaxVegetables(){
        return this.MAX_VEGETABLES;
    }
    public int getVegetables() {
        return this.count;
    }

}
