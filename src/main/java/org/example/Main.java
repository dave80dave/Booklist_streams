package org.example;

import java.util.Comparator;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/booklist.csv";
        LoadBooks loadBooks = new LoadBooks();
        List<Books> books = loadBooks.loadBooks(path);

        System.out.println("---------- sorted language english ----------");
        // sorted language english

        long count = books.stream()
                .filter(book -> book.getLanguage().equals("Englisch"))
                .count();
        System.out.println(count);

        System.out.println("---------- how many books are read ----------");
        // how many books are read

        long isRead = books.stream()
                .filter(book -> book.isRead())
                .count();
        System.out.println(isRead);

        System.out.println("---------- printed all books where more than 500 pages ----------");
        // printed all Books where more than 500 pages
        books.stream()
                .filter(book -> book.getPages() >= 500)
                .limit(5)
                .forEach(book -> System.out.println(book.getTitle() + " " + book.getPages()));


        System.out.println("---------- printed the five most expensive books ----------");
        // printed the five most expensive Books
        books.stream()
                .sorted(Comparator.comparing(Books::getPrice).reversed())
                .limit(5)
                .forEach(book -> System.out.println(book.getTitle() + " " + book.getPrice()));

        System.out.println("---------- three oldest books ----------");
        books.stream()
                .sorted(Comparator.comparing(Books::getPublishedDate))
                .limit(3)
                .forEach(book -> System.out.println("Title: " + "'" + book.getTitle() +"'" + " " + " Published Date " + book.getPublishedDate()));

        System.out.println("---------- all german books sorted by price ----------");
        books.stream()
                .filter(book -> book.getLanguage().equals("Deutsch"))
                .sorted(Comparator.comparing(Books::getPrice))
                .forEach(book -> System.out.println("Language: " + book.getLanguage() + " " + "'"+ book.getTitle() + "'" + " " + book.getPrice() + " €"));

        System.out.println("---------- returns the average price of all books ----------");
        double average = books.stream()
                .mapToDouble(Books::getPrice)
                .average()
                .orElse(0.0);
        System.out.printf("average price is %.2f €\n", average);

        System.out.println("---------- returns the number of all books ----------");
        int number = books.stream()
                .mapToInt(Books::getPages)
                .sum();
        System.out.printf("Sum of pages is: %,d\n", number);
    }
}
