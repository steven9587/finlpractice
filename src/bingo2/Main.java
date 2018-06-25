package bingo2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import bingo.BingoMain.Form;

public class Main {

	public Main() {
		try {
			// 建立bingo表格
			FileReader fr = new FileReader("bingo.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			int number = Integer.parseInt(line);
			int table = (int) Math.sqrt(number);
			line = br.readLine();
			// System.out.println(line);
			String tokens[] = line.split(",");
			List<Integer> answers = new ArrayList<>();
			for (int i = 0; i <= tokens.length - 1; i++) {
				int answer = Integer.parseInt(tokens[i]);
				answers.add(answer);
			}
			Bingo bingo = new Bingo(table, number, answers);
			bingo.print();
			bingo.judgement();
			// System.out.println(answers);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
