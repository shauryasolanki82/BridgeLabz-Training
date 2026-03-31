public class Book {
	
	private static String libraryName = "Egmore Library";
	private String title;
	private String author;
	private final String isbn;
	
	Book(String title, String author, String isbn){
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	public void displayBookDetails() {
		if(this instanceof Book) {
			System.out.println("Title: "+title);
			System.out.println("Author: "+author);
			System.out.println("ISBN: "+isbn);
		}else {
			System.err.println("Book details not found");
		}
	}
	
	public static void dispalyLibraryName() {
		System.out.println("Library Name: "+libraryName);
	}

	public static void main(String[] args) {
		Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");
		Book.dispalyLibraryName();
		book1.displayBookDetails();
	}
}
