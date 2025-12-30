import java.util.Scanner;
public class LineComparisonProblem {
    public static double lengthofline(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first co-ordinate of line");
        System.out.println("Enter the value of x1");
        double x1 = sc.nextDouble();
        System.out.println("Enter the value of y1");
        double y1 = sc.nextDouble();
        System.out.println("Enter the second co-ordinate of line");
        System.out.println("Enter the value of x2");
        double x2 = sc.nextDouble();
        System.out.println("Enter the value of y2");
        double y2 = sc.nextDouble();
        double length = Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
        // sc.close();
        return length;
    }
    public static void main(String[] args) {
        //uc1
        double lengthOfFirstLine = lengthofline();
        System.out.println("Length of line 1 is "+lengthOfFirstLine);
        //uc2
        double lengthOfSecondLine = lengthofline();
        if(lengthOfFirstLine == lengthOfSecondLine){
            System.out.println("Both lines are equals");
        }
        //uc3
        else if(lengthOfFirstLine>lengthOfSecondLine){
            System.out.println("Line 1 is greater than line 2");
        }
        else{
            System.out.println("Line 2 is greater than line 1");
        }

    }
}
