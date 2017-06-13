package week2.library.edition;

/**
 * Created by valentina on 13.06.17.
 */
public class Magazine extends Edition{
    private MonthOfEdition monthOfEdition;

    public Magazine(String title, String author, int yearOfPublishing, String language, int pageNumber) {
        super(title, author, yearOfPublishing, language, pageNumber);
    }

    public MonthOfEdition getMonthOfEdition() {
        return monthOfEdition;
    }

    public void setMonthOfEdition(MonthOfEdition monthOfEdition) {
        this.monthOfEdition = monthOfEdition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Magazine)) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;

        return monthOfEdition == magazine.monthOfEdition;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Magazine{");
        sb.append(super.toString());
        if(monthOfEdition != null) sb.append(", monthOfEdition=").append(monthOfEdition);
        sb.append('}');
        return sb.toString();
    }
}
