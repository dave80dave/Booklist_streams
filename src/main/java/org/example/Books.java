package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Books {
    // ID,Title,Author,publishday,pages,Read,Genre,ISBN,Price,Language,Publisher,Rating,Tags
    // 1,Verbotene Gipfel an der Grenze,Emilia Lang,1983-01-15,685,false,Krimi,850-673108-878-3,13.28,Spanisch,Buchhaus Wien,1.9,Familie;Zukunft;Liebe
    private int id;
    private String title;
    private String author;
    private LocalDate publishedDate;
    private int pages;
    private boolean read;
    private String genre;
    private String isbn;
    private double price;
    private String language;
    private String publisher;
    private double rating;
    private String tags;

    public Books(int id, String title, String author, LocalDate publishedDate,
                 int pages, boolean read, String genre, String isbn, double price,
                 String language, String publisher, double rating, String tags) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedDate = publishedDate;
        this.pages = pages;
        this.read = read;
        this.genre = genre;
        this.isbn = isbn;
        this.price = price;
        this.language = language;
        this.publisher = publisher;
        this.rating = rating;
        this.tags = tags;
    }

    public static Books readCSV(String[] book) {
        return new Books(
                Integer.parseInt(book[0].trim()),
                book[1].trim(),
                book[2].trim(),
                LocalDate.parse(book[3].trim()),
                Integer.parseInt(book[4].trim()),
                Boolean.parseBoolean(book[5].trim()),
                book[6].trim(),
                book[7].trim(),
                Double.parseDouble(book[8].trim()),
                book[9].trim(),
                book[10].trim(),
                Double.parseDouble(book[11].trim()),
                book[12].trim()
        );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedDate=" + dtf.format(publishedDate) +
                ", pages=" + pages +
                ", read=" + read +
                ", genre='" + genre + '\'' +
                ", isbn=" + isbn +
                ", price=" + price +
                ", language='" + language + '\'' +
                ", publisher='" + publisher + '\'' +
                ", rating=" + rating +
                ", tags='" + tags + '\'' +
                '}';
    }
}
