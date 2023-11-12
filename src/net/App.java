package net;

import net.salesianos.objects.Restaurant;
import net.salesianos.threads.Client;
import net.salesianos.threads.Farmer;

public class App {
    public static void main(String[] args) throws Exception {
        Restaurant restaurant = new Restaurant();

        Farmer Paco = new Farmer(restaurant);
        Client Youssuf = new Client(restaurant, 4, "Yousuf");
        Client Pancho = new Client(restaurant, 3, "Pancho");

        Paco.start();
        Youssuf.start();
        Pancho.start();
        

        try {
            Paco.join();
            Youssuf.join();
            Pancho.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(restaurant.getVegetables());
        System.out.println("Restaurant Closed.");
    }
}
