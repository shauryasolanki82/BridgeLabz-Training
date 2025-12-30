import java.util.Scanner;
class Mobile{
    String brand;
    String model;
    int price;
    public Mobile(String brand, String model, int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public int Display(){
        System.out.println("Brand Of mobile "+brand);
        System.out.println("Model of mobile: "+model);
        System.out.println("Price of mobile: "+price);
        return price;
    }
}
public class HandleMobilePhoneDetail {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
       System.out.println("Enter the no. of mobile: ");
       int n = sc.nextInt();
       int totalAmount = 0;
       for(int i=0;i<n;i++){
       System.out.println("Enter Brand of mobile: ");
       String brand = sc.next();
       System.out.println("Enter Model of mobile: ");
       String model = sc.next();
       System.out.println("Enter Price of mobile: ");
       int price = sc.nextInt();
       Mobile mobile = new Mobile(brand, model, price);
       totalAmount+=mobile.Display();
       }
       System.out.println("Total Amount: "+totalAmount);
       sc.close();
    }
}

