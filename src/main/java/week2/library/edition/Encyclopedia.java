package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class Encyclopedia extends Edition {

    private int volumesNumber;

    public Encyclopedia(String title, String author, int yearOfPublishing, String issn, String language, int pageNumber, int volumesNumber) {
        super(title, author, yearOfPublishing, issn, language, pageNumber);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Encyclopedia{");
        sb.append("volumesNumber=").append(volumesNumber);
        sb.append('}');
        return sb.toString();
    }
}
