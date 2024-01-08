import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

class BookComparatorByAuthor implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return book1.getAuthor().compareTo(book2.getAuthor());
    }
}

class BookComparatorByYear implements Comparator<Book> {
    @Override
    public int compare(Book book1, Book book2) {
        return Integer.compare(book1.getPublishedYear(), book2.getPublishedYear());
    }
}

class Library implements Iterable<Book> {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void sortByTitle() {
        Collections.sort(books);
    }

    public void sortByAuthor() {
        Collections.sort(books, new BookComparatorByAuthor());
    }

    public void sortByYear() {
        Collections.sort(books, new BookComparatorByYear());
    }

    @Override
    public Iterator<Book> iterator() {
        return books.iterator();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("1984", "George Orwell", 1949));

        // Sorting by title
        library.sortByTitle();
        System.out.println("Sorted by title:");
        for (Book book : library) {
            System.out.println(book);
        }

        // Sorting by author
        library.sortByAuthor();
        System.out.println("\nSorted by author:");
        for (Book book : library) {
            System.out.println(book);
        }

        // Sorting by year
        library.sortByYear();
        System.out.println("\nSorted by year:");
        for (Book book : library) {
            System.out.println(book);
        }
    }
}
