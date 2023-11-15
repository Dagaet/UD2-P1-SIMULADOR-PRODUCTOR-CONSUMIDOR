package net;

import net.salesianos.objects.Restaurant;
import net.salesianos.threads.Client;
import net.salesianos.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant(5);

        Farmer paco = new Farmer(restaurant, 10);
        Farmer ramon = new Farmer(restaurant, 10);

        Client mrGentleman = new Client(restaurant, 5, "Mr. Gentleman", 6);
        Client faustino = new Client(restaurant, 10, "Faustino", 4);
        Client Loquendo = new Client(restaurant, 5, "Loquendo", 6);

        paco.start();
        ramon.start();
        faustino.start();
        mrGentleman.start();
        Loquendo.start();
        
        paco.setPriority(10);
        ramon.setPriority(10);

        try {
            paco.join();
            ramon.join();
            faustino.join();
            mrGentleman.join();
            Loquendo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Restaurant Closed.");
    }
}
