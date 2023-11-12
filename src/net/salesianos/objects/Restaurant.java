package net.salesianos.objects;

public class Restaurant {
    private int count = 0;

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

    public int getVegetables() {
        return this.count;
    }

}
