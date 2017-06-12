package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class Encyclopedia extends Edition {

    private int volumesNumber;

    public Encyclopedia(String title, String author, int yearOfPublishing, String language, int pageNumber, int volumesNumber) {
        super(title, author, yearOfPublishing, language, pageNumber);
        this.volumesNumber = volumesNumber;
    }

    public int getVolumesNumber() {
        return volumesNumber;
    }

    public void setVolumesNumber(int volumesNumber) {
        this.volumesNumber = volumesNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Encyclopedia)) return false;
        if (!super.equals(o)) return false;

        Encyclopedia that = (Encyclopedia) o;

        return volumesNumber == that.volumesNumber;
    }

    @Override
    public int hashCode() {
        return volumesNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Encyclopedia{");
        sb.append(super.toString());
        sb.append("volumesNumber=").append(volumesNumber);
        sb.append('}');
        return sb.toString();
    }

}
