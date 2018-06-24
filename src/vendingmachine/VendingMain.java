package vendingmachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class VendingMain {
	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		FileReader fr;
		try {
			fr = new FileReader("vending.txt");
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			String token[] = line.split(",");
			int number = Integer.parseInt(token[0]);
			for (int id = 1; id <= number; id++) {
				String name = token[id * 2 - 1];
				int price = Integer.parseInt(token[id*2]);
				vm.drinks.add(new Drink(id, name, price));
			}
			vm.on();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
