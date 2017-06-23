package week2.library;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import week2.library.edition.*;

import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * Created by valentina on 10.06.17.
 */
public class LibraryTest {
    Library myLibrary;

    @Before
    public void setUp() {
        myLibrary = new Library();
    }

    @After
    public void tearDown() {
        myLibrary = null;
    }

    @Test
    public void addVisitors() {
        Visitor visitor1 = new Visitor("Ivan", "Ivanov");
        Visitor visitor2 = new Visitor("Ivan", "Ivanov");
        assertTrue(myLibrary.addVisitor(visitor1));
        assertFalse(myLibrary.addVisitor(visitor1));
        assertFalse(myLibrary.addVisitor(visitor2));
    }

    @Test
    public void printVisitors() {
        Visitor visitor1 = new Visitor("Ivan", "Ivanov");
        Visitor visitor2 = new Visitor("Ivan2", "Ivanov");
        Visitor visitor3 = new Visitor("Ivan3", "Ivanov");
        Visitor visitor4 = new Visitor("Ivan4", "Ivanov");
        assertTrue(myLibrary.addVisitor(visitor1));
        assertTrue(myLibrary.addVisitor(visitor2));
        assertTrue(myLibrary.addVisitor(visitor3));
        assertTrue(myLibrary.addVisitor(visitor4));
        myLibrary.printVisitorsSortedByName();
    }

    @Test
    public void printEditions() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("Золотой теленок", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new ReferenceBook("Справочник2", "Автор1", 2016, "Russian", 600, true);
        Edition book5 = new ReferenceBook("Справочник3", "Автор1", 2017, "Russian", 600, true);
        Edition book6 = new ReferenceBook("Справочник4", "Автор1", 2015, "Russian", 600, true);
        Edition book7 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book8 = new Encyclopedia("Encyclopedia2", "Author2", 2016, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.addEdition(book5));
        assertTrue(myLibrary.addEdition(book6));
        assertTrue(myLibrary.addEdition(book7));
        assertTrue(myLibrary.addEdition(book8));
        myLibrary.printEditionsSortedByAuthor();
    }

    @Test
    public void addEdition() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book4 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book3 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertFalse(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
//        In the current implementation it is forbidden to add more than one book with the same attributes to Library
        assertFalse(myLibrary.addEdition(book4));
    }

    @Test
    public void lendEditionSuccessful() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Visitor visitor1 = new Visitor("Ivan", "Ivanov");
        assertTrue(myLibrary.addVisitor(visitor1));
        assertTrue(visitor1.getAccessAllowed());
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.lendEdition(new Visitor("Ivan", "Ivanov"), new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE)));
        assertTrue(book1.getTakenByVisitor());
        assertEquals(1, visitor1.getBorrowedBooksNumber());
        assertTrue(visitor1.getBorrowedBooks().contains(book1));
    }

    @Test
    public void lendEditionUnsuccessful() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("Золотой теленок", "Ильф, Петров", 2017, "Russian", 700, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book_1 = new Encyclopedia("Encyclopedia4", "Author2", 2017, "English", 400, 5);
//        book_1 and visitor_1 are not in library
        Visitor visitor1 = new Visitor("Ivan", "Ivanov");
        Visitor visitor2 = new Visitor("Ivan", "Petrov");
        Visitor visitor_1 = new Visitor("Ivan5", "Petrov4");
        assertTrue(myLibrary.addVisitor(visitor1));
        assertTrue(myLibrary.addVisitor(visitor2));
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.banVisitor(visitor2));
        assertFalse(myLibrary.banVisitor(visitor_1));
        assertFalse(visitor2.getAccessAllowed());
        assertFalse(myLibrary.lendEdition(visitor2, book1));
        assertFalse(book2.getTakenByVisitor());
        assertEquals(0, visitor2.getBorrowedBooksNumber());
        assertTrue(myLibrary.lendEdition(visitor1, book1));
        assertFalse(myLibrary.lendEdition(visitor1, book_1));
        assertTrue(myLibrary.lendEdition(visitor1, book2));
        assertTrue(myLibrary.lendEdition(visitor1, book3));
        assertFalse(myLibrary.lendEdition(visitor1, book4));
        assertEquals(3, visitor1.getBorrowedBooksNumber());
        assertFalse(myLibrary.lendEdition(visitor_1, book4));
        assertFalse(myLibrary.lendEdition(visitor_1, book_1));
    }

    @Test
    public void getEditionsByYear() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("12 Стульев", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new ReferenceBook("Справочник2", "Автор1", 2016, "Russian", 600, true);
        Edition book5 = new ReferenceBook("Справочник3", "Автор1", 2017, "Russian", 600, true);
        Edition book6 = new ReferenceBook("Справочник4", "Автор1", 2015, "Russian", 600, true);
        Edition book7 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book8 = new Encyclopedia("Encyclopedia2", "Author2", 2016, "English", 400, 5);
        Edition book9 = new Encyclopedia("Encyclopedia3", "Author2", 2015, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.addEdition(book5));
        assertTrue(myLibrary.addEdition(book6));
        assertTrue(myLibrary.addEdition(book7));
        assertTrue(myLibrary.addEdition(book8));
        assertTrue(myLibrary.addEdition(book9));
        List<Edition> tmp = new ArrayList<>();
        tmp.add(book1);
        tmp.add(book3);
        tmp.add(book5);
        tmp.add(book7);
        assertTrue(myLibrary.getByYear(2017).equals(tmp));

    }

    @Test
    public void getEditionsByAuthor() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("12 Стульев", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new ReferenceBook("Справочник2", "Автор1", 2016, "Russian", 600, true);
        Edition book5 = new ReferenceBook("Справочник3", "Автор1", 2017, "Russian", 600, true);
        Edition book6 = new ReferenceBook("Справочник4", "Автор1", 2015, "Russian", 600, true);
        Edition book7 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book8 = new Encyclopedia("Encyclopedia2", "Author2", 2016, "English", 400, 5);
        Edition book9 = new Encyclopedia("Encyclopedia3", "Author2", 2015, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.addEdition(book5));
        assertTrue(myLibrary.addEdition(book6));
        assertTrue(myLibrary.addEdition(book7));
        assertTrue(myLibrary.addEdition(book8));
        assertTrue(myLibrary.addEdition(book9));
        List<Edition> tmp = new ArrayList<>();
        tmp.add(book7);
        tmp.add(book8);
        tmp.add(book9);
        assertTrue(myLibrary.getByAuthor("Author2").equals(tmp));
    }

    @Test
    public void testBorrowedAndAvailableBooks() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("Золотой теленок", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("Справочник1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new ReferenceBook("Справочник2", "Автор1", 2016, "Russian", 600, true);
        Edition book5 = new ReferenceBook("Справочник3", "Автор1", 2017, "Russian", 600, true);
        Edition book6 = new ReferenceBook("Справочник4", "Автор1", 2015, "Russian", 600, true);
        Edition book7 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book8 = new Encyclopedia("Encyclopedia2", "Author2", 2016, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.addEdition(book5));
        assertTrue(myLibrary.addEdition(book6));
        assertTrue(myLibrary.addEdition(book7));
        assertTrue(myLibrary.addEdition(book8));
        book1.setTakenByVisitor(true);
        book3.setTakenByVisitor(true);
        book5.setTakenByVisitor(true);
        book7.setTakenByVisitor(true);
        List<Edition> borrowed = new ArrayList<>();
        borrowed.add(book1);
        borrowed.add(book3);
        borrowed.add(book5);
        borrowed.add(book7);
        List<Edition> available = new ArrayList<>();
        available.add(book2);
        available.add(book4);
        available.add(book6);
        available.add(book8);
        assertEquals(borrowed, myLibrary.getBorrowedAll());
        assertEquals(available, myLibrary.getAvailable());
    }

    @Test
    public void getEditionsTakenByVisitor() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Visitor visitor1 = new Visitor("Ivan", "Ivanov");
        assertTrue(myLibrary.addVisitor(visitor1));
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.lendEdition(new Visitor("Ivan", "Ivanov"), new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE)));
        assertEquals(1, visitor1.getBorrowedBooksNumber());
        assertEquals(myLibrary.getBorrowedAll(), myLibrary.getBorrowedByVisitor(new Visitor("Ivan", "Ivanov")));
        assertEquals(myLibrary.getBorrowedAll(), myLibrary.getBorrowedByVisitor(visitor1));

    }

    @Test
    public void getEditionsByKeyWords() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("Золотой теленок", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("English Grammar #1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new ReferenceBook("English Grammar #2", "Автор1", 2016, "Russian", 600, true);
        Edition book5 = new ReferenceBook("English Grammar In Examples", "Автор1", 2017, "Russian", 600, true);
        Edition book6 = new ReferenceBook("Spanish Grammar For Advanced Level", "Автор1", 2015, "Russian", 600, true);
        Edition book7 = new Encyclopedia("Encyclopedia1", "Author2", 2017, "English", 400, 5);
        Edition book8 = new Encyclopedia("Encyclopedia2", "Author2", 2016, "English", 400, 5);
        assertTrue(myLibrary.addEdition(book1));
        assertTrue(myLibrary.addEdition(book2));
        assertTrue(myLibrary.addEdition(book3));
        assertTrue(myLibrary.addEdition(book4));
        assertTrue(myLibrary.addEdition(book5));
        assertTrue(myLibrary.addEdition(book6));
        assertTrue(myLibrary.addEdition(book7));
        assertTrue(myLibrary.addEdition(book8));
        List<Edition> tmp1 = myLibrary.findEditionByKeyWords("English", "Grammar");
        List<Edition> tmp2 = myLibrary.findEditionByKeyWords("12");
        List<Edition> tmp3 = myLibrary.findEditionByKeyWords("Advanced", "Spanish");

        List<Edition> tmp_1 = new ArrayList<>();
        List<Edition> tmp_2 = new ArrayList<>();
        List<Edition> tmp_3 = new ArrayList<>();
        tmp_1.add(book3);
        tmp_1.add(book4);
        tmp_1.add(book5);
        tmp_2.add(book1);
        tmp_3.add(book6);
        assertEquals(tmp1, tmp_1);
        assertEquals(tmp2, tmp_2);
        assertEquals(tmp3, tmp_3);
    }

    @Test
    public void editionInfo() {
        Edition book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book2 = new FictionBook("Золотой теленок", "Ильф, Петров", 2000, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        Edition book3 = new ReferenceBook("English Grammar #1", "Автор1", 2017, "Russian", 600, true);
        Edition book4 = new Encyclopedia("Encyclopedia1", "John Smith", 2017, "English", 400, 5);
        Edition book5 = new Encyclopedia("Encyclopedia2", "Jane Smith", 2016, "English", 400, 5);
        assertEquals("Edition{title='12 Стульев', author='Ильф, Петров'}", book1.info());
        assertEquals("Edition{title='Золотой теленок', author='Ильф, Петров'}", book2.info());
        assertEquals("Edition{title='English Grammar #1', author='Автор1'}", book3.info());
        assertEquals("Edition{title='Encyclopedia1', author='John Smith'}", book4.info());
        assertEquals("Edition{title='Encyclopedia2', author='Jane Smith'}", book5.info());
    }

    @Test
    public void bookEnum() {
        FictionBook book1 = new FictionBook("12 Стульев", "Ильф, Петров", 2017, "Russian", 600, Genre.ACTION_AND_ADVENTURE);
        FictionBook book2 = new FictionBook("Сказки", "Пушкин", 2017, "Russian", 150, Genre.CHILDRENS);
        FictionBook book3 = new FictionBook("Золотой Теленок", "Ильф, Петров", 2017, "Russian", 700, Genre.ACTION_AND_ADVENTURE);
        assertEquals(book1.getGenre(), Genre.ACTION_AND_ADVENTURE);
        assertEquals(book2.getGenre(), Genre.CHILDRENS);
    }

    @Test
    public void magazineEnum() {
        Magazine magazine1 = new Magazine("Oxygen", "John Smith", 2017, "English", 150);
        magazine1.setMonthOfEdition(MonthOfEdition.JULY);
        assertEquals(magazine1.getMonthOfEdition(), MonthOfEdition.JULY);
    }
}
