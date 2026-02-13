public class LibraryApp {
    public static void main(String[] args){
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User student = UserFactory.createUser("student", "Himanshu");
        User faculty = UserFactory.createUser("faculty", "Dr. Arun");

        catalog.addObserver(student);
        catalog.addObserver(faculty);

        Book book = new Book.BookBuilder("Design Patterns")
                .author("Gang of Four")
                .edition("1st")
                .genre("Software Engineering")
                .build();

        catalog.addBook(book);
    }
}
