package net;

import net.salesianos.objects.Restaurant;
import net.salesianos.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant();

        Farmer Paco = new Farmer(restaurant);

        Paco.start();

        try {
            Paco.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("El restaurante ha cerrado.");
    }
}
