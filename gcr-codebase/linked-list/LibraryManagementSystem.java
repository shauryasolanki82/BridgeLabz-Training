class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode prev;
    BookNode next;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

class LibraryDoublyLinkedList {
    private BookNode head;
    private BookNode tail;

    // Add at beginning
    public void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(int id, String title, String author, String genre, boolean status) {
        BookNode newNode = new BookNode(id, title, author, genre, status);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, int id, String title, String author, String genre, boolean status) {
        if (position <= 1 || head == null) {
            addAtBeginning(id, title, author, genre, status);
            return;
        }

        BookNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(id, title, author, genre, status);
            return;
        }

        BookNode newNode = new BookNode(id, title, author, genre, status);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove by Book ID
    public void removeByBookId(int id) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Search by Book Title
    public void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No book found with title: " + title);
        }
    }

    // Search by Author
    public void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found by author: " + author);
        }
    }

    // Update availability status
    public void updateAvailability(int id, boolean status) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                System.out.println("Availability updated for book ID: " + id);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }

    // Display forward
    public void displayForward() {
        BookNode temp = head;
        System.out.println("\nLibrary Books (Forward):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        BookNode temp = tail;
        System.out.println("\nLibrary Books (Reverse):");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public int countBooks() {
        int count = 0;
        BookNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Helper method
    private void displayBook(BookNode book) {
        System.out.println(
            "ID: " + book.bookId +
            ", Title: " + book.title +
            ", Author: " + book.author +
            ", Genre: " + book.genre +
            ", Available: " + (book.isAvailable ? "Yes" : "No")
        );
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();

        library.addAtBeginning(1, "1984", "George Orwell", "Dystopian", true);
        library.addAtEnd(2, "The Alchemist", "Paulo Coelho", "Fiction", true);
        library.addAtPosition(2, 3, "Clean Code", "Robert Martin", "Programming", false);

        library.displayForward();
        library.displayReverse();

        library.searchByTitle("1984");
        library.searchByAuthor("Paulo Coelho");

        library.updateAvailability(3, true);
        library.removeByBookId(1);

        library.displayForward();
        System.out.println("\nTotal Books in Library: " + library.countBooks());
    }
}
