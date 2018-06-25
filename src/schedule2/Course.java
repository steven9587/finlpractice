package schedule2;

public class Course {
	String id;
	String course;
	int week;
	int time;
	int duration;

	public Course(String id, String course, int week, int time, int duration) {
		this.id = id;
		this.course = course;
		this.week = week;
		this.time = time;
		this.duration = duration;
	}

	public boolean isFree(int week,int time) {
		if(week == this.week) {
			if(time >=this.time && time <= this.time+duration ) {
				return false;
			}else {
				return true;
			}
		}
        return true;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
