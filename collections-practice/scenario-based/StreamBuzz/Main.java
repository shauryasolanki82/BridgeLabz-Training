import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Register Creator");
        System.out.println("2. Show Top Posts");
        System.out.println("3. Calculate Average Likes");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
        int num = sc.nextInt();
        Program p = new Program();
        List<String> list = new ArrayList<>();
        List<List<Integer>> likes = new ArrayList<>();
        while(num>0 && num<4){
            if(num == 1){
                sc.nextLine();
                System.out.println("Enter Creator Name:");
                list.add(sc.nextLine());
                System.out.println("Enter weekly likes (Week 1 to 4):");
                ArrayList<Integer> like = new ArrayList<>();
                like.add(sc.nextInt());
                like.add(sc.nextInt());
                like.add(sc.nextInt());
                like.add(sc.nextInt());
                likes.add(like);
                System.out.println("Creator register successfully");
            }
            else if(num == 2){
                System.out.println("Enter like threshhold:");
                int threshhold = sc.nextInt();
                p.calThreshhold(threshhold, list, likes);
            }
            else if(num == 3){
                p.calAverageLikes(likes);
            }
            else if(num == 4){
                break;
            }
            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            num = sc.nextInt();
        }
        System.out.println("Logging off - Keep Creating with StreamBuzz!");
    }
}
