import java.util.Scanner;

public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int candidate1=0;
        int candidate2=0;
        int candidate3=0;
        int totalVotes=0;
        outerLoop:
        while(true){
            System.out.print("Enter your age: ");
            int age=sc.nextInt();
            if(age>=18){
                System.out.println("Press 1->candidate1, 2->candidate2, 3->candidate3 & -1 to exit");
                int vote=sc.nextInt();
                switch(vote){
                    case 1:
                        candidate1++;
                        totalVotes++;
                        break;
                    case 2:
                        candidate2++;
                        totalVotes++;
                        break;
                    case 3:
                        candidate3++;
                        totalVotes++;
                        break;
                    default:
                        break outerLoop;
                }
            }else{
                System.out.println("You are not eligible to vote");
            }
        }
        System.out.println("------polling booth------");
        System.out.println("candidate1 ------- "+candidate1);
        System.out.println("candidate2 ------- "+candidate2);
        System.out.println("candidate3 ------- "+candidate3);
        System.out.println("total votes ------- "+totalVotes);
        sc.close();
    }
}