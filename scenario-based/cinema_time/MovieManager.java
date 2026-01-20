package cinema_time;

import java.util.ArrayList;

public class MovieManager {
	ArrayList<Movie> movieList=new ArrayList<>();
	
	public void addMovie(String title) {
		movieList.add(new Movie(title));
	}
	public Movie getMovie(String title) {
		for(Movie m: movieList) {
			if(m.getTitle().equalsIgnoreCase(title)) {
				return m;
			}
		}
		return null;
	}
	
	public void searchMovie(String title) {
		boolean found=false;
		for(Movie m:movieList) {
			if(m.getTitle().equalsIgnoreCase(title)) {
				System.out.println(title+" is available !");
				found=true;
				break;
			}
		}
		if(!found) System.out.println(title+" is not available !");
	}
	
	public void displayAllMovies() {
		System.out.println("All movies available :-");
		int count=1;
		for(Movie m: movieList) {
			System.out.println(count++ +". "+m.getTitle());
		}
	}
	
	public void displayMovieAndShowTime() {
		for(Movie m: movieList) {
			System.out.println(String.format("Movie: %s | Showtimes: %s",m.getTitle(),m.getShowTimes()));
		}
	}
	public void printReport() {

	    Movie[] movieArray = movieList.toArray(new Movie[0]);

	    System.out.println("===== Cinema Movie Report =====");

	    for (Movie m : movieArray) {
	        System.out.println("Movie: " + m.getTitle());

	        String[] times = m.getShowTimes().toArray(new String[0]);
	        System.out.println("Showtimes:");

	        for (String t : times) {
	            System.out.println("  - " + t);
	        }
	    }
	}

}
