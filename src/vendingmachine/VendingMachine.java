package vendingmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
	List<Drink> drinks = new ArrayList<>();
	Drink drink;
	public void on() {
		for (int i = 0; i < drinks.size(); i++) {
			drink = drinks.get(i);
			System.out.println(drink.getId() + " " + drink.getName() + " " + drink.getPrice());
		}
		
		int z = -1;
		int total = 0;
		while (z != 0) {
			System.out.println("餘額:" + total + "元");
			System.out.print("請投幣($5或$10或$50)或選擇飲料(1或2或3)，或輸入0結束:");
			Scanner scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			switch (line) {
			case "1":
				if (total >= 25) {
					drink = drinks.get(0);
					System.out.println("獲得：" + drink.getName());
					total -=drink.getPrice();
				} else {
					System.out.println("餘額不足!");
				}
				break;
			case "2":
				if (total >= 30) {
					drink = drinks.get(1);
					System.out.println("獲得：" + drink.getName());
					total -=drink.getPrice();
				} else {
					System.out.println("餘額不足!");
				}
				break;
			case "3":
				if (total >= 20) {
					drink = drinks.get(2);
					System.out.println("獲得：" + drink.getName());
					total -=drink.getPrice();
				} else {
					System.out.println("餘額不足!");
				}
				break;
			case "5":
				total = total + 5;
				break;
			case "10":
				total = total + 10;
				break;
			case "50":
				total = total + 50;
				break;
			case "0":
				System.out.println("關機!");
				z = 0;
				break;
			default:
				System.out.println("無效輸入!");
				break;
			}
		}
	}

}
