
import java.util.Scanner;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int totalDistance=0;
        while(true){
            System.out.println("To get off enter -1 or enter the distance to travel: ");
            int dis=sc.nextInt();
            if(dis==-1){
                break;
            }
            totalDistance+=dis;
        }
        System.out.println("Total Distance Travelled: "+totalDistance+" km");
        sc.close();
    }
}