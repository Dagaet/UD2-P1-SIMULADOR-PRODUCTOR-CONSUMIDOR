package net.salesianos.threads;

import net.salesianos.objects.Restaurant;

public class Farmer extends Thread {
    private Restaurant restaurant;
    private Integer vegetablesPlanted;
    private final Integer VEGETABLES_QUANTITY = 14;  

    public Farmer (Restaurant restaurant, Integer vegetablesPlanted) {
        this.restaurant = restaurant;
        this.vegetablesPlanted = vegetablesPlanted;
    }

    private String[] vegetables = {"lettuce", "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
    
    private int getTime(){
        return (int) Math.floor(Math.random() * (VEGETABLES_QUANTITY)) +1;
    }

    @Override
    public void run() {
        for (int i = 0; i < vegetablesPlanted; i++) {
            int valueNumber = (int) Math.floor(Math.random() * vegetables.length);
            try {
                System.out.println("The vegetable " + vegetables[valueNumber] + " is growing. It will take " + getTime() + " seconds.");
                sleep(getTime() * 1000);
                restaurant.receiveVegetables(vegetables[valueNumber]);
                System.out.println("    The restaurant warehouse has " + restaurant.getVegetables() + " vegetables.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        } 
    }
}
