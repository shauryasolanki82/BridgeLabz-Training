import java.util.Scanner;

public class CafeteriaMenuApp {
    static void displayMenu(String[] menuItems,int[] prices){
        System.out.printf("%-3s %-25s %10s%n", "#", "Cafeteria items", "Price (INR)");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<10;i++){
            System.out.printf("%-3d %-20s %10d%n", (i + 1), menuItems[i], prices[i]);
        }
    }
    static String getItemByIndex(String[] menuItems,int idx){
        return menuItems[idx-1];
    }
    public static void main(String[] args) {
        String[] menuItems={"Coffee","Croissant","Muffin","French Fries","Burger","Pasta","Salad","Soup",
                         "Cheese Sandwich","Maggie"};
        int[] prices={80,60,40,70,50,90,70,60,70,40};
        displayMenu(menuItems,prices);
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the index of the item: ");
        int idx=sc.nextInt();
        System.out.println(getItemByIndex(menuItems,idx));
        sc.close();
    }
} 
