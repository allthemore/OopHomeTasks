package week2.library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import week2.library.edition.Edition;

/**
 * Created by valentina on 06.06.17.
 */
public class Visitor implements Comparable<Visitor>{

    private String name;
    private String surname;
    private boolean accessAllowed = true;
    private final int MAX_BOOKS_BORROWED = 3;

    private ArrayList<Edition> borrowedBooks;

    public Visitor(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.borrowedBooks = new ArrayList<>(MAX_BOOKS_BORROWED);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean getAccessAllowed() {
        return accessAllowed;
    }

    public void setAccessAllowed(boolean accessAllowed) {
        this.accessAllowed = accessAllowed;
    }

    public List<Edition> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void takeEdition(Edition edition) {
        borrowedBooks.add(edition);
    }

    public boolean hasNullField() {
        return this.name == null || this.surname == null;

    }

    @Override
    public int compareTo(Visitor visitor) {
        int compareToResult = this.name.compareTo(visitor.name);
        if(compareToResult != 0) return compareToResult;
        return this.surname.compareTo(visitor.surname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visitor{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", accessAllowed=").append(accessAllowed);
        sb.append(", borrowedBooks=").append(borrowedBooks);
        sb.append('}');
        return sb.toString();
    }
}
