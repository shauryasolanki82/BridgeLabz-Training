public class VolumeOfEarth {
    public static void main(String[] args) {
        double radius = 6378.0; 
        double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius,3); 
        int cubicKilometers = (int) volume;
        int cubicMiles = (int) (volume * 0.239912);
        System.out.println("The Volume of the Earth in cubic kilometer is " + cubicKilometers + " and cubic miles is " + cubicMiles);
    }
}
