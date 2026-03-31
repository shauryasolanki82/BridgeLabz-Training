public class Movies{
    private String movieName;
    private int rating;
    private int yearOfRelease;

    public Movies(String movieName, int rating, int yearOfRelease){
        this.movieName = movieName;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    String getMovieName(){
        return movieName;
    }
    int getRating(){
        return rating;
    }
    int getYearOfRelease(){
        return yearOfRelease;
    }
    public String toString(){
        return movieName;
    }
}