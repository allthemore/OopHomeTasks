package week1.abstract_classes_and_interfaces.edition;

/**
 * Created by valentina on 22.05.17.
 */
public interface Edition {

    String getTitle();
    String getAuthor();
    double getPrice();
    int getYearOfPublishing();
    String getIssn();
    int getPageNumber();
}
