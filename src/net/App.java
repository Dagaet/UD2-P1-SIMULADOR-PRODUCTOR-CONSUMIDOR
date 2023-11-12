package net;

import net.salesianos.objects.Restaurant;
import net.salesianos.threads.Client;
import net.salesianos.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant();

        Farmer Paco = new Farmer(restaurant, 10);
        Farmer Ramon = new Farmer(restaurant, 10);

        Client MrGentleman = new Client(restaurant, 5, "Mr. Gentleman");
        Client Faustino = new Client(restaurant, 10, "Faustino");
        Client Loquendo = new Client(restaurant, 5, "Loquendo");

        Paco.start();
        Ramon.start();
        Faustino.start();
        MrGentleman.start();
        Loquendo.start();
        

        try {
            Paco.join();
            Ramon.join();
            Faustino.join();
            MrGentleman.join();
            Loquendo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(restaurant.getVegetables());
        System.out.println("Restaurant Closed.");
    }
}
