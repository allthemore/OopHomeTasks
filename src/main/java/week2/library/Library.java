package week2.library;

import java.util.*;

import week2.library.comparators.NameComparator;
import week2.library.edition.Edition;

/**
 * Created by valentina on 06.06.17.
 */
public class Library {
    private List<Edition> libraryEditions = new ArrayList<>();
    private List<Visitor> visitors = new ArrayList<>();

    public boolean addVisitor(Visitor visitor) {
        if(visitor == null || visitor.hasNullField() || visitors.contains(visitor)) return false;
        visitors.add(visitor);
        return true;
    }

    public boolean addEdition(Edition edition) {
        if(edition == null || libraryEditions.contains(edition)) return false;
        libraryEditions.add(edition);
        return true;
    }

    public void sortVisitors(Comparator<Visitor> comparator){
        Collections.sort(visitors, comparator);
    }

    private void swap(ArrayList<Visitor> visitors, int index) {
        Visitor tmp = visitors.get(index);

    }

//    Print editions not taken by visitors
    private void printAvailableEditions(){
        for (Edition edition : libraryEditions) {
            if(!edition.getTakenByVisitor()) {
                System.out.println(edition);
            }
        }
    }

    public boolean banVisitor(Visitor visitor) {
        if(visitor == null || visitor.hasNullField() || !visitors.contains(visitor)) return false;
        visitor.setAccessAllowed(false);

        return true;
    }

    public boolean lendEdition(Edition edition, Visitor visitor) {
        if(!visitor.getAccessAllowed() || edition.getTakenByVisitor() ||
                visitor.getBorrowedBooks().size() == 3) return false;

        edition.setTakenByVisitor(true);
        visitor.takeEdition(edition);

        return true;
    }

    public List<Edition> getBorrowed() {
        List<Edition> borrowed = new ArrayList<>();
        for (Edition edition : libraryEditions) {
            if(!edition.getTakenByVisitor()) {
                borrowed.add(edition);
            }
        }
        return borrowed;
    }

    public List<Edition> getAvailable(){
        List<Edition> available = new ArrayList<>();
        for (Edition edition : libraryEditions) {
            if(!edition.getTakenByVisitor()) {
                available.add(edition);
            }
        }
        return available;
    }

    public List<Edition> getByAuthor(String author) {
        if(author == null) return null;

        ArrayList<Edition> byAuthor = new ArrayList<>();

        for (Edition edition : libraryEditions) {
            if(author.equals(edition.getAuthor())) {
                byAuthor.add(edition);
            }
        }
        return byAuthor;
    }

    public List<Edition> getByYear(int year) {
        if(year == 0) return null;

        ArrayList<Edition> byYear = new ArrayList<>();

        for (Edition edition : libraryEditions) {
            if(year == edition.getYearOfPublishing()) {
                byYear.add(edition);
            }
        }
        return byYear;
    }
}
