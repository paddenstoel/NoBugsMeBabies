package me.nobugs.homework1.part1.booktask;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Displayable {
    private String bookTitle;
    private String author;
    private int pubYear;

    @Override
    public void display() {
        System.out.println("Book{" +
                "title='" + getBookTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", pubYear=" + getPubYear() +
                '}');
    }
}
