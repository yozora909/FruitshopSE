package com.jdc.fruitshop;

import java.util.Scanner;

public class Shop {

	Fruit[] fruits = { new Fruit("Mango", 300, 100), new Fruit("Papaya", 1500, 50), new Fruit("Kiwi", 200, 100) };

	Scanner scan = new Scanner(System.in);

	public void showFruits() {
		for (int i = 0; i < fruits.length; i++) {
			System.out.printf("No. %d Name: %s Price %d Amount %d \n",
					(i+1),fruits[i].getName(),fruits[i].getPrice(),fruits[i].getAmount());
		}
	}

	public void launch() {
		showFruits();
		int total = 0;
		do {
			System.out.println("What do you want?");
			int userFruit = Integer.parseInt(userInput());
			System.out.println("How Many you want?");
			int userAmount = Integer.parseInt(userInput());

			boolean canOrder = orderControl(userFruit, userAmount);
			if (canOrder) {
				total += calculate(userFruit, userAmount);
			} else {
				System.out.printf("There is only %d for your order! Will you buy all? \n Y/N",fruits[userFruit-1].getAmount());
				
				if (userInput().equalsIgnoreCase("y")) {
					total+= calculate(userFruit, fruits[userFruit-1].getAmount());
				}
			}
			
			System.out.println("Do u want to buy other fruits? \n Y/N");
			
		} while (userInput().equalsIgnoreCase("y"));
		
		System.out.printf("Your Total Amount %d Ks",total);
	}

	private int calculate(int userFruit, int userAmount) {
		fruits[userFruit - 1].setAmount(fruits[userFruit - 1].getAmount() - userAmount);
		return fruits[userFruit - 1].getPrice() * userAmount;
	}

	public boolean orderControl(int name, int amount) {
		return fruits[name - 1].getAmount() >= amount;
	}

	public String userInput() {
		return scan.nextLine();
	}

}
