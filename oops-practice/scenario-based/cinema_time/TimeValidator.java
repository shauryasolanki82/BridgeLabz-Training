package cinema_time;

public class TimeValidator {
	public static void timeValidator(String time) throws InvalidShowTimeException {
		String[] parts=time.split(":");
		if(parts.length!=2) {
			throw new InvalidShowTimeException("Time must be in HH:MM");
		}
		int hours=Integer.parseInt(parts[0]);
		int minutes=Integer.parseInt(parts[1]);
		if(hours>23 || hours<0 || minutes>59 || minutes<0) {
			throw new InvalidShowTimeException("Invalid time: "+time);
		}
	}
}
