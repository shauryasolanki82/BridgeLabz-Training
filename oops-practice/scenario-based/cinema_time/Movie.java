package cinema_time;

import java.util.ArrayList;

public class Movie {
	private String title;
	ArrayList<String> showTimes;
	
	public Movie(String title) {
		this.title=title;
		this.showTimes=new ArrayList<>();
	}
	public String getTitle() {
		return title;
	}
	public void addShowTime(String time) throws InvalidShowTimeException {
		TimeValidator.timeValidator(time);
		showTimes.add(time);
	}
	public ArrayList<String> getShowTimes() {
		return showTimes;
	}
}
