package net.salesianos.objects;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private Queue<String> warehouse = new LinkedList<String>();
    // private String warehouse = 0;

    public synchronized void receiveVegetables(String vegetable) {
        while (warehouse.size() >= 20) {
            
        }
        warehouse.add(vegetable);
        notifyAll();
    }

    public synchronized void eatVegetables() throws InterruptedException{
        while (warehouse.size() <= 0) {
            wait();
        }
        warehouse.poll();
        notifyAll();
    }

    public int getVegetables() {
        return warehouse.size();
    }

}
