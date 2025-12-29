import java.util.Scanner;
public class SandeepFitnessChallengeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pushUpArray = new int[7];
        for(int i=1;i<=7;i++){
            System.out.println("Enter no of pushups in Day "+i+" and -1 for rest");
            pushUpArray[i-1] = sc.nextInt();
        }
        int totalPushUp = 0;
        for(int pushUp:pushUpArray){
            totalPushUp+=pushUp;
        }
        System.out.println("Total no. of Pushups in this week "+totalPushUp+" and Average of this week is "+totalPushUp/7);
        sc.close();
    }
}
