package net.salesianos.objects;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private Queue<String> warehouse = new LinkedList<String>();
    private int warehouseSize = 0;

    public Restaurant(int warehouseSize) {
        this.warehouseSize= warehouseSize;
    }

    public synchronized void receiveVegetables(String vegetable) throws InterruptedException {
        while (warehouse.size() >= warehouseSize) {
            wait();
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
