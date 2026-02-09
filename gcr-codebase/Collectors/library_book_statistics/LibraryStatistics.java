package library_book_statistics;

import java.util.*;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class LibraryStatistics {
    public static void main(String[] args) {

        List<Book> books = Arrays.asList(new Book("Java Basics", "Programming", 300),new Book("Advanced Java", "Programming", 500),new Book("Data Structures", "Programming", 400),new Book("World History", "History", 350),new Book("Ancient India", "History", 250),new Book("Physics Fundamentals", "Science", 450),new Book("Chemistry Guide", "Science", 300));

        Map<String, IntSummaryStatistics> statsByGenre =books.stream().collect(Collectors.groupingBy(Book::getGenre,Collectors.summarizingInt(Book::getPages)));

        statsByGenre.forEach((genre, stats) -> {
            System.out.println("Genre: " + genre);
            System.out.println("Total Pages: " + stats.getSum());
            System.out.println("Average Pages: " + stats.getAverage());
            System.out.println("Max Pages: " + stats.getMax());
            System.out.println("Min Pages: " + stats.getMin());
            System.out.println("Book Count: " + stats.getCount());
            System.out.println("---------------------------");
        });
    }
}
