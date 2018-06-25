package bingo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BingoMain {
	public BingoMain() {
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
			Form form = new Form(table, number, answers);
			form.print();
			form.bingo();
			// System.out.println(answers);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BingoMain();
	}

	public class Form {
		int table;
		int number;
		List<Integer> answers;
		List<Integer> numbers = new ArrayList<>();

		public Form(int table, int number, List<Integer> answers) {
			this.table = table;
			this.number = number;
			this.answers = answers;
		}

		public void print() {
			for (int i = 1; i <= number; i++) {
				numbers.add(i);
			}
			Collections.shuffle(numbers);
			int[][] finaltable = new int[table][table];
			for (int i = 0; i < table; i++) {
				for (int j = 0; j < table; j++) {
					finaltable[i][j] = numbers.get(i * table + j);
					if (finaltable[i][j] > 9) {
						System.out.print(finaltable[i][j] + " ");
					} else {
						System.out.print(" " + finaltable[i][j] + " ");
					}
				}
				System.out.println();
			}
			/*
			 * 用list方法印出 for (int p = 0; p < numbers.size(); p++) { if (numbers.get(p) > 9)
			 * {
			 * 
			 * System.out.print(numbers.get(p) + " "); } else { System.out.print(" " +
			 * numbers.get(p) + " "); } if (p % 5 == 4) { System.out.println(); } }
			 */
		}
		
		public int getTable() {
			return table;
		}

		public void setTable(int table) {
			this.table = table;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public List<Integer> getAnswers() {
			return answers;
		}

		public void setAnswers(List<Integer> answers) {
			this.answers = answers;
		}

		public List<Integer> getNumbers() {
			return numbers;
		}

		public void setNumbers(List<Integer> numbers) {
			this.numbers = numbers;
		}

		public void bingo() {
			int rowbingo ;
			int row = 0;
			int columnbingo ;
			int column = 0;
			int slashbingo ;
			int slash = 0;
			int[][] finaltable = new int[table][table];
			
			//放值
			for (int i = 0; i < table; i++) {
				for (int j = 0; j < table; j++) {
					finaltable[i][j] = numbers.get(i * table + j);
				}
			}
			
			//判斷橫的
			for (int ri = 0; ri < table; ri++) {
				rowbingo = 0;
				for (int rj = 0; rj < table; rj++) {
					for (int rp = 0; rp < answers.size(); rp++) {
						if (finaltable[ri][rj] == answers.get(rp)) {
							rowbingo+=1;
						}
					}
				}
				if(rowbingo==5) {
					row+=1;
				}
			}
			System.out.println("橫線："+row+"條");
			//判斷直的
			for (int ci = 0; ci < table; ci++) {
				columnbingo = 0;
				for (int cj = 0; cj < table; cj++) {
					for (int cp = 0; cp < answers.size(); cp++) {
						if (finaltable[cj][ci] == answers.get(cp)) {
							columnbingo+=1;
						}
					}
				}
				if(columnbingo==5) {
					column+=1;
				}
			}
			System.out.println("直線："+column+"條");
			//判斷斜線的(左上到右下)
			slashbingo = 0;
			for (int si1 = 0; si1 < table; si1++) {
					for (int sp1 = 0; sp1 < answers.size(); sp1++) {
						if (finaltable[si1][si1] == answers.get(sp1)) {
							slashbingo+=1;
						}
					}
				if(slashbingo==5) {
					slash+=1;
				}
			}
			//判斷斜線的(右上到左下)
			slashbingo = 0;
			for (int si2 = 0; si2 < table; si2++) {
					for (int sp2 = 0; sp2 < answers.size(); sp2++) {
						if (finaltable[si2][table-(si2+1)] == answers.get(sp2)) {
							slashbingo+=1;
						}
					}
				if(slashbingo==5) {
					slash+=1;
				}
			}
			System.out.println("斜線："+slash+"條");
			System.out.println("共："+(row+column+slash)+"條");
		}
	}
}