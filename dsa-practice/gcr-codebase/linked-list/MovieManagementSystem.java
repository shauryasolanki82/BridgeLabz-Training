class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove by movie title
    public void removeByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie removed: " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search by rating
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Update rating by title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        MovieNode temp = head;
        System.out.println("\nMovies (Forward):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        MovieNode temp = tail;
        System.out.println("\nMovies (Reverse):");
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method
    private void displayMovie(MovieNode movie) {
        System.out.println(
            "Title: " + movie.title +
            ", Director: " + movie.director +
            ", Year: " + movie.year +
            ", Rating: " + movie.rating
        );
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        list.addAtPosition(2, "Avatar", "James Cameron", 2009, 7.8);

        list.displayForward();
        list.displayReverse();

        list.searchByDirector("Christopher Nolan");
        list.searchByRating(7.8);

        list.updateRating("Avatar", 8.0);
        list.removeByTitle("Inception");

        list.displayForward();
    }
}
