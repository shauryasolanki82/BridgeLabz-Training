public class Gym{
    private String name;
    private int noOfDaysLeft;

    public Gym(String name, int noOfDaysLeft){
        this.name = name;
        this.noOfDaysLeft = noOfDaysLeft;
    }

    String getName(){
        return name;
    }
    int getNoOfDaysLeft(){
        return noOfDaysLeft;
    }

    public String toString(){
        return name;
    }
}