package week1.abstract_classes_and_interfaces.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class Encyclopedia extends Book{

    private int volumesNumber;

    public Encyclopedia(String title, String author, double price, int yearOfPublishing, String issn, int pageNumber, int volumesNumber) {
        super(title, author, price, yearOfPublishing, issn, pageNumber);
        this.volumesNumber = volumesNumber;
    }

    public int getVolumesNumber() {
        return volumesNumber;
    }

    public void setVolumesNumber(int volumesNumber) {
        this.volumesNumber = volumesNumber;
    }

    @Override
    public void readBook() {
        System.out.printf("Read Encyclopedia: %s\n", getTitle());
    }

    public void findDefinition(String word) {
        System.out.printf("Definition of %s\n", word);
    }

}
