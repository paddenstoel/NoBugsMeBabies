package me.nobugs.homework1.part2.booktask;

import java.util.HashSet;
import java.util.stream.Collectors;

public class BookCollection {
    private HashSet<Book> books = new HashSet<>();

    public HashSet<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        getBooks().add(book);
    }

    public void deleteBook(Book book) {
        getBooks().remove(book);
    }

    public boolean isPresentInCollection(Book book) {
        return getBooks().contains(book);
    }

    public void printBooks() {
        System.out.println(books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n")));
    }
}
