package week2.library;

import java.util.*;

import week2.library.comparators.AuthorComparator;
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

//    public void sortVisitors(Comparator<Visitor> comparator){
//        visitors.sort(comparator);
//    }

    public void printVisitorsSortedByName() {
        visitors.sort(new NameComparator());
        for (Visitor visitor : visitors) {
            System.out.println(visitor);
        }
    }

    public void printEditionsSortedByAuthor() {
        libraryEditions.sort(new AuthorComparator());
        for (Edition edition : libraryEditions) {
            System.out.println(edition);
        }
    }

    public boolean banVisitor(Visitor visitor) {
        Visitor visitor1 = getVisitor(visitor);
        if(visitor1 == null) return false;
        visitor1.setAccessAllowed(false);

        return true;
    }

//    Check if Visitor exists in Library and return link to it
    private Visitor getVisitor(Visitor visitor) {
        if(visitors.contains(visitor)) {
            return visitors.get(visitors.indexOf(visitor));
        }
        return null;
    }

//    Check if edition exists in Library and return link to it
    private Edition getEdition(Edition edition) {
        if(libraryEditions.contains(edition)) {
            return libraryEditions.get(libraryEditions.indexOf(edition));
        }
        return null;
    }

    public boolean lendEdition(Visitor visitor, Edition edition) {
        Visitor visitor1 = getVisitor(visitor);
        Edition edition1 = getEdition(edition);
        if(visitor1 == null || edition1 == null) return false;

        if(!visitor1.getAccessAllowed() || edition1.getTakenByVisitor()) return false;

        edition1.setTakenByVisitor(true);
        return visitor1.takeEdition(edition1);
    }

    public List<Edition> getBorrowedAll() {
        List<Edition> borrowed = new ArrayList<>();
        for (Edition edition : libraryEditions) {
            if(edition.getTakenByVisitor()) {
                borrowed.add(edition);
            }
        }
        return borrowed;
    }

    public List<Edition> getBorrowedByVisitor(Visitor visitor) {
        Visitor visitor1 = getVisitor(visitor);
        if(visitor1 == null) return null;
        return visitor1.getBorrowedBooks();
    }

    //    Get all editions not taken by visitors
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


    public List<Edition> findEditionByKeyWords(String ... values) {
        if(values == null) return null;
        List<Edition> editionsFound = new ArrayList<>();
        int argsNum = values.length;

        for (Edition edition : libraryEditions) {
            Set<String> wordsInArgs = new HashSet<>(Arrays.asList(values));
            wordsInArgs.retainAll(new HashSet<>(Arrays.asList(edition.getTitle().split(" "))));
            if (wordsInArgs.size() == argsNum){
                editionsFound.add(edition);
            }
        }
        return editionsFound;
    }
}
