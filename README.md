# UD2-P1-SIMULADOR-PRODUCTOR-CONSUMIDOR

## Objective:

In this exercise the main task is to make a program to manage vegetables sent to a restaurant, including the usage of this vegetables and their creation in the farm.

> In programming we can say that this is an exersise made to use threads, ine of them being the Farmer and other the Client. They both are going to use the warehouse in the Restaurant to store and consume vegetables.

## Objects

### Restaurant:

This class creates an object Restaurant with a size of the warehouse passed through its constructor. It also has multiple functions to deal with different situations.

- **_receiveVegetables()_**: This function checks if the size of the queue is greater than the size of the warehouse it just waits for it to be other than 0. If it is not, it gets the name of the vegetable in a _String_ used in the Farmer class and stores it on a _Queue_ to use their names later. Then it notifies all the other threads that it ended.

  - Constructor params: **_String vegetable_** -> Passes the name of the vegetable

- **_eatVegetables()_**: This function checks if there is something in the warehouse, if it is empty, the program waits, it it contains something it gets one of the vegetables and then notifies all the other threads.

- **_getVegetables()_**: This function get the amount of vegetables in the warehouse.

## Threads:

### Client:

This class extends _Thread_. It is created to define the client that is going to eat the vegetables. Into it we have a constructor with the next params:

> **_Restaurant restaurant_**: It is an object that is type _Restaurant_. Passed through params to use some of the functions into the Restaurant class.

> **_Int quantity_**: The quantity of vegetables that the client is going to eat.

> **_String name_**: The name of the client.

> **_Int eatingTime_**: The max time it is going to take for the client to eat a vegetable.

**Functions:**

- **_getTime()_**: This function automatically creates a random number between the maximum time a client can take to eat and 1 and returns it.

- **_run()_**: This is a function writen in the class _Thread_, we use it here with an Override to change some things when the thread starts. First we make a loop with the quantity of vegetables that the client is going to eat, then into this loop, we create a new random number between 1 and the maximum amount of time it can take to eat a vegetable, then we make the thread sleep to _"simulate"_ the eating time. After that we display that the client is eating and the actual state of the warehouse.

### Farmer:

This class extends _Thread_. It is created to define the Farmer that is going to plant and cultivate the vegetables. Into it we have a constructor with the next params:

> _**Restaurant restaurant**_: It is an object that is type _Restaurant_. Passed through params to use some of the functions into the Restaurant class.

> _**Integer vegetablesPlanted**_: The amount of vegetables a farmer can plant and cultivate.

This class has an array of vegetables names called **_vegetables_**.

**Functions:**

- **_getTime()_**: This function automatically creates a random number between the maximum time a vegetable can take to grow and 1 and returns it.

- **_run()_**: This is a function writen in the class _Thread_, we use it here with an Override to change some things when the thread starts. First it loops with the quantity of vegetables planted passed through params. Then into the loop we calculate a random number to get the vegetables from the array. Then we use the data to show it into the console. Then the thread sleeps an amount of time that we get from the function _getTime()_. After this we use the function _*receiveVegetables()*_ from the object restaurant, pasiisnt through params the name of the vegetable. Then it prints to console the state of the warehouse.
