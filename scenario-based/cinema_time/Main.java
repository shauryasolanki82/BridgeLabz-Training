package cinema_time;

public class Main {

	public static void main(String[] args) {
		MovieManager movieManager=new MovieManager();
		movieManager.addMovie("Polar");
		movieManager.addMovie("F1");
		Movie polar=movieManager.getMovie("Polar");
		Movie f1=movieManager.getMovie("F1");
		try {
			polar.addShowTime("10:00");
			polar.addShowTime("14:00");
			polar.addShowTime("18:00");
			f1.addShowTime("11:00");
			f1.addShowTime("15:00");
			f1.addShowTime("19:00");
		}catch(InvalidShowTimeException e) {
			System.out.println(e.getMessage());
		}
		movieManager.displayAllMovies();
		movieManager.displayMovieAndShowTime();
		movieManager.searchMovie("Mulholland Drive");
		movieManager.printReport();

	}

}
