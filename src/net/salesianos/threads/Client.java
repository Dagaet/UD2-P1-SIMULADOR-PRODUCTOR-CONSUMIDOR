package net.salesianos.threads;

import net.salesianos.objects.Restaurant;

public class Client extends Thread {
    
    private Restaurant restaurant;
    private int quantity;
    private String name;

    public Client (Restaurant restaurant, int quantity, String name){
        this.restaurant = restaurant;
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            try {
                restaurant.eatVegetables();
                System.out.println("El cliente " + name +" se ha comido una verdura");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
