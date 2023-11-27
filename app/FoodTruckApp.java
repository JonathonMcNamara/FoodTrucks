package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	public static void main(String[] args) {
		FoodTruckApp app = new FoodTruckApp();
		app.run();
	}

	Scanner sc = new Scanner(System.in);

	private FoodTruck[] fleet = new FoodTruck[5];
	private int numFoodTrucks = 0;

	public void run() {

		while (numFoodTrucks < 5) {
			if (numFoodTrucks >= 0) {
				System.out.println("Please enter a foodtruck name or type quit to exit");
				String foodTruckName = sc.next();
				if (foodTruckName.equals("quit")) {
					break;
				}
				if (foodTruckName != "quit") {
					System.out.println("Please enter a foodtruck type: ");
					String foodType = sc.next();
					System.out.println("Please enter a foodtruck rating 1 thru 5: ");
					int rating = sc.nextInt();
					if (rating < 1 || rating > 5) {
						System.out.println("Please enter a rating 1 - 5");
					}
					fleet[numFoodTrucks++] = new FoodTruck(foodTruckName, foodType, rating);
				}
			}
		}
		while (true) {
			System.out.println("Choose from the following options and select the number beside it");
			System.out.println("1. List all existing food trucks");
			System.out.println("2. See the average rating of the food trucks");
			System.out.println("3. Display the highest rated food truck");
			System.out.println("4. Quit the program");

			int userChoice = sc.nextInt();

			if (userChoice == 1) {
				showFoodTrucks(fleet, numFoodTrucks);
			} else if (userChoice == 2) {
				averageFoodTruckRating(fleet, numFoodTrucks);
			} else if (userChoice == 3) {
				bestRatedFoodTruck(fleet, numFoodTrucks);
			} else if (userChoice == 4) {
				System.out.println("You have chosen to exit the program");
				sc.close();
				break;
			} else {
				System.out.println("Invalid choice. Please select a number 1 thru 4 ");
			}
		}

	}

	public void showFoodTrucks(FoodTruck[] fleet, int numFoodTrucks) {
		if (numFoodTrucks == 0) {
			System.out.println("No food trucks in the fleet");
			return;
		}
		for (int i = 0; i < numFoodTrucks; i++) {
			String trucks = fleet[i].getFoodTruckData();
			System.out.println(trucks);
		}
	}

	public void averageFoodTruckRating(FoodTruck[] fleet, int numFoodTrucks) {
		double averageRatings = 0.0;
		double sumOfRatings = 0.0;
		if (numFoodTrucks == 0) {
			System.out.println("No food trucks in the fleet to rate");
			return;
		}
		for (int i = 0; i < numFoodTrucks; i++) {
			sumOfRatings += fleet[i].getRating();
		}
		averageRatings = sumOfRatings / numFoodTrucks;
		System.out.println("Average Rating is " + averageRatings);
	}

	public void bestRatedFoodTruck(FoodTruck[] fleet, int numFoodTrucks) {
		FoodTruck bestRated = fleet[0];
		if (numFoodTrucks == 0) {
			System.out.println("No food trucks in the fleet to average");
			return;
		}
		for (int i = 0; i < numFoodTrucks; i++) {
			if (fleet[i].getRating() > bestRated.getRating()) {
				bestRated = fleet[i];
			}
		}
		System.out.println("The best rated food truck is " + bestRated.name + " with a rating of " + bestRated.rating);
	}
}