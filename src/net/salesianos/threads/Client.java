package net.salesianos.threads;

import net.salesianos.objects.Restaurant;

public class Client extends Thread {
    
    private Restaurant restaurant;
    private int quantity;
    private String name;
    private int eatingTime;

    public Client (Restaurant restaurant, int quantity, String name, int eatingTime){
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.name = name;
        this.eatingTime = eatingTime;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            int valueNumber = (int) Math.floor(Math.random() * ((eatingTime)+1));
            try {
                sleep(valueNumber * 1000);
                restaurant.eatVegetables();
                System.out.println("The client " + name +" is eating a vegetable");
                System.out.println("    The restaurant warehouse has " + restaurant.getVegetables() + " vegetables.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
