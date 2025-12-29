import java.util.Scanner;
public class MovieTicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Movie Types (Comedy/Drama/Romantic/Action)");
        String MovieType = sc.nextLine();
        System.out.println("Enter seat type (Gold/Silver/Platinum)");
        String seatType = sc.nextLine();
        System.out.println("Do you want snacks(Yes/No)");
        String snacks = sc.nextLine();
        int totalPrice = 0;
        System.out.println("Enter no. of tickets");
        int noOfTickets = sc.nextInt();
        switch (MovieType.toLowerCase()) {
            case "comedy":
                if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=500;
                }
                else if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("no")){
                     totalPrice+=450;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=450;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("no")){
                     totalPrice+=500;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=400;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("no")){
                     totalPrice+=350;
                }
                break;
            case "drama":
                if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=600;
                }
                else if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("no")){
                     totalPrice+=550;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=550;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("no")){
                     totalPrice+=500;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=450;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("no")){
                     totalPrice+=450;
                }
                break;
            case "romantic":
                if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=600;
                }
                else if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("no")){
                     totalPrice+=550;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=500;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("no")){
                     totalPrice+=450;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=400;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("no")){
                     totalPrice+=350;
                }
                break;
            case "action":
                if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=700;
                }
                else if(seatType.toLowerCase().equals("platinum") && snacks.toLowerCase().equals("no")){
                     totalPrice+=650;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=550;
                }
                else if(seatType.toLowerCase().equals("gold") && snacks.toLowerCase().equals("no")){
                     totalPrice+=600;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("yes")){
                     totalPrice+=500;
                }
                else if(seatType.toLowerCase().equals("silver") && snacks.toLowerCase().equals("no")){
                     totalPrice+=450;
                }
            default:
                break;
        }
        totalPrice = noOfTickets*totalPrice;
        System.out.print("Your total Bill is "+totalPrice);
        sc.close();
    }
}
