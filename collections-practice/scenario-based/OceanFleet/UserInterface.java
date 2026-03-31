import java.util.List;
import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vessels");
        int n = sc.nextInt();
        VesselUtil vessel = new VesselUtil();
        sc.nextLine();
        for(int i=0;i<n;i++){
            String input = sc.nextLine();
            String[] arr = input.split(":");
            vessel.addVesselPerformance(new Vessel(arr[0], arr[1], Double.parseDouble(arr[2]), arr[3]));
        }
        System.out.println("Enter the Vessel id to check speed");
        String vid = sc.nextLine();
        Vessel v = vessel.getVesselById(vid);
        System.out.println(v.vesselId+" | "+ v.vesselName+" | "+v.averageSpeed+" | "+v.vesselType);
        System.out.println("High performance vessels are");
        List<Vessel> v1 = vessel.getHighPerformanceVessels();
        for (Vessel vessel2 : v1) {
            System.out.println(vessel2.vesselId+" | "+ vessel2.vesselName+" | "+vessel2.averageSpeed+" | "+vessel2.vesselType);
        }
    }
}
