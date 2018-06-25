package maze2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import maze.MazeMain.Maze;

public class Main {
	public Main() {
		try {
			// 讀取資料(地圖大小)
			FileReader fr = new FileReader("maze.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String tokens[] = line.split(",");
			int col = Integer.parseInt(tokens[0]);
			int row = Integer.parseInt(tokens[1]);
			// 讀取資料(陷阱個數)
			line = br.readLine();
			int trapCount = Integer.parseInt(line);
			Random r = new Random();
			Set<String> set = new TreeSet<>();
			while (set.size() < trapCount) {
				String trap = String.valueOf(r.nextInt(24));
				set.add(trap);
			}
			Iterator it = set.iterator();
			int[] trapLocation = new int[set.size()];
			for (int a = 0; a < set.size(); a++) {
				int i = Integer.parseInt(String.valueOf(it.next()));
				trapLocation[a] = i;
			}
			// 讀取資料(陷阱位置)
			line = br.readLine();
			String enters[] = line.split(",");
			List<String> number = new ArrayList<>();
			for (int i = 0; i < enters.length; i++) {
				number.add(enters[i]);
			}
			maze2.Maze m = new maze2.Maze(row, col, trapCount, trapLocation, number);
			m.judgement();
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
