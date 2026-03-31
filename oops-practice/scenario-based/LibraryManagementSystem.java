import java.util.Scanner;

public class LibraryManagementSystem {
    static class Book{
        private String title;
        private String author;
        private boolean status;
        Book(String title, String author, boolean status){
            this.title=title;
            this.author=author;
            this.status=status;
        }
        void display(){
            System.out.println("Title: " + title + ", Author: " + author +
                    ", Status: " + (status ? "Available" : "Checked Out"));
        }
        void updateStatus(boolean status){
            this.status=status;
        }
        String getTitle() {
            return title;
        }
        String getAuthor(){
            return author;
        }
        boolean getStatus(){
            return status;
        }

    }
    static void storeBooks(Book[] books,int n,Scanner sc){
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Book " + (i + 1));
            System.out.print("Title: ");
            String title = sc.nextLine();
            System.out.print("Author: ");
            String author = sc.nextLine();
            System.out.print("Status (available/checked out): ");
            String status = sc.nextLine().trim().toLowerCase();
            boolean isAvailable = status.equals("available");
            books[i] = new Book(title, author, isAvailable);
        }
    }
    static void canBorrow(Book b,Scanner sc){
        if(b.getStatus()){
            System.out.println("Book is available, want to borrow (enter yes or no): ");
            String borrow=sc.next().toLowerCase();
            if(borrow.equals("yes")){
                b.updateStatus(false);
            }else{
                System.out.println("Check out other books to borrow");
            }
        }else{
            System.out.println("Book is not available, check other books.");
        }
    }
    static void searchByPartialTitle(Book[] books, Scanner sc) {
        System.out.print("Enter title to search: ");
        String query = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Book b : books) {
            if(b == null) continue;
            if(b.getTitle().toLowerCase().contains(query)) {
                b.display();
                canBorrow(b,sc);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for: " + query);
        }
    }
    static void displayAllBooks(Book[] books){
        for (Book b : books) {
            b.display();
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of books to store: ");
        int n=sc.nextInt();
        sc.nextLine();
        Book[] books=new Book[n];
        storeBooks(books,n,sc);
        searchByPartialTitle(books, sc);
        displayAllBooks(books);
    }
}
