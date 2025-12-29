import java.util.Scanner;
public class GCDAndLCMCalculator {
  //GCD
  public static int GCD(int n1,int n2){
    while(n2!=0){
      int rem = n1%n2;
      n1=n2;
      n2=rem;
    }
    return n1;
  }
  
  //LCM
  public static int LCM(int n1,int n2){
    return(n1*n2)/GCD(n1,n2);
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n1 = sc.nextInt();
    int n2=sc.nextInt();
    System.out.println("GCD: "+GCD(n1,n2));
    System.out.println("LCM: "+LCM(n1,n2));
    sc.close();
  }
}
