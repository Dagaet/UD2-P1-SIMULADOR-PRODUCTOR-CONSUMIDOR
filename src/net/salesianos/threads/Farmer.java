package net.salesianos.threads;

import net.salesianos.objects.Restaurant;

public class Farmer extends Thread {
    private Restaurant restaurant;
    private Integer vegetablesPlanted;

    public Farmer (Restaurant restaurant, Integer vegetablesPlanted) {
        this.restaurant = restaurant;
        this.vegetablesPlanted = vegetablesPlanted;
    }

    private String[] vegetables = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
    
    private Integer[] timers = {1,2,3,4,5,6,7,8,9,10,9,6,3,5,7};

    
    @Override
    public void run() {
        for (int i = 0; i < vegetablesPlanted; i++) {
            int valueNumber = (int) Math.floor(Math.random() * vegetables.length);
            System.out.println("The vegetable " + vegetables[valueNumber] + " is growing. It will take " + timers[valueNumber] + " seconds.");
            try {
                sleep(timers[valueNumber] * 1000);
                restaurant.receiveVegetables();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        } 
    }

}
