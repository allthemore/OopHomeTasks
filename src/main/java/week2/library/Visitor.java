package week2.library;

import java.util.ArrayList;
import java.util.List;
import week2.library.edition.Edition;

/**
 * Created by valentina on 06.06.17.
 */
public class Visitor implements Comparable<Visitor>{

    private final String name;
    private final String surname;
    private boolean accessAllowed = true;
    private static final int MAX_BOOKS_BORROWED = 3;

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

    public int getBorrowedBooksNumber() {
        return borrowedBooks.size();
    }

    boolean takeEdition(Edition edition) {
        if(borrowedBooks.size() == 3) return false;
        return borrowedBooks.add(edition);
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Visitor visitor = (Visitor) o;
//
//        if (accessAllowed != visitor.accessAllowed) return false;
//        if (MAX_BOOKS_BORROWED != visitor.MAX_BOOKS_BORROWED) return false;
//        if (name != null ? !name.equals(visitor.name) : visitor.name != null) return false;
//        if (surname != null ? !surname.equals(visitor.surname) : visitor.surname != null) return false;
//        return borrowedBooks != null ? borrowedBooks.equals(visitor.borrowedBooks) : visitor.borrowedBooks == null;
//    }

//    Compare by name and surname only
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Visitor visitor = (Visitor) o;

        if (name != null ? !name.equals(visitor.name) : visitor.name != null) return false;
        return surname != null ? surname.equals(visitor.surname) : visitor.surname == null;
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
