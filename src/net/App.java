package net;

import net.salesianos.objects.Restaurant;
import net.salesianos.threads.Client;
import net.salesianos.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant(5);

        Farmer paco = new Farmer(restaurant, 5);

        Client mrGentleman = new Client(restaurant, 5, "Mr. Gentleman", 3);
        

        paco.start();
        mrGentleman.start();
        

        try {
            paco.join();
            mrGentleman.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Restaurant Closed.");
    }
}
