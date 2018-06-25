package schedule2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	List<Course> courses = new ArrayList<>();

	public Main() {
		readCourse();
		// for(Course c:courses) { System.out.println(c.getCourse()); }
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入星期:");
		int week = scanner.nextInt();
		System.out.print("請輸入時間:");
		int time = scanner.nextInt();
		boolean free = true;
		for (Course c : courses) {
			if (!c.isFree(week, time)) {
				System.out.println("【有課：  " + c.getId() + " " + c.getCourse() + " " + "到" + " "
						+ (c.getTime() + c.getDuration()) + "】");
				free = false;
			}
		}
		if (free) {
			System.out.println("【有空檔】");
		}

	}

	public void readCourse() {
		try {
			FileReader fr = new FileReader("schedule.txt");
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {
				String tokens[] = line.split(",");
				String id = tokens[0];
				String course = tokens[1];
				int week = Integer.parseInt(tokens[2]);
				int time = Integer.parseInt(tokens[3]);
				int duration = Integer.parseInt(tokens[4]);
				Course c = new Course(id, course, week, time, duration);
				courses.add(c);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
