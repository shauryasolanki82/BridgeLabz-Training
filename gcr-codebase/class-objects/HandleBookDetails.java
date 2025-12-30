import java.util.Scanner;
class Book{
    String titleOfBook;
    String author;
    int price;
        public Book(String titleOfBook, String author, int price){
        this.titleOfBook = titleOfBook;
        this.author = author;
        this.price = price;
        }
        public void DisplayDetails(){
        System.out.println("Title of Book is: "+ titleOfBook);
        System.out.println("Author of Book is: "+ author);
        System.out.println("Price of Book is: "+ price);
    }
}
public class HandleBookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Title of Book: ");
        String titleOfBook = sc.nextLine();
        System.out.println("Enter the Author of the Book: ");
        String author = sc.nextLine();
        System.out.println("Enter the price of Book: ");
        int price = sc.nextInt();
        Book book = new Book(titleOfBook, author, price);
        book.DisplayDetails();
        sc.close();
    }
}
