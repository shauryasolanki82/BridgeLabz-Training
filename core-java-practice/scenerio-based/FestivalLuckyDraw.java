import java.util.Scanner;

public class FestivalLuckyDraw {
    static int drawNumber(){
        return (int) (Math.random() * 1000);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of visitors: ");
        int numOfVisitor=sc.nextInt();
        for(int i=1;i<=numOfVisitor;i++){
            int numberDrawn=drawNumber();
            if(numberDrawn%3==0 && numberDrawn%5==0){
                System.out.println("You win a gift!");
            }else{
                System.out.println("You loose!");
            }
        }
        sc.close();
    }
}