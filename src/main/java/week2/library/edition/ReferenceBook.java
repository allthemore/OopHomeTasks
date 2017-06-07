package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class ReferenceBook extends Edition {

    private boolean isDigital;

//    Type of ordering data: by alphabet, chronologically, by topic etc
    private String orderingType;

    public ReferenceBook(String title, String author, int yearOfPublishing, String issn, String language, int pageNumber, boolean isDigital, String orderingType) {
        super(title, author, yearOfPublishing, issn, language, pageNumber);
        this.isDigital = isDigital;
        this.orderingType = orderingType;
    }

    public boolean getIsDigital() {
        return isDigital;
    }

    public void setIsDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }

    public String getOrderingType() {
        return orderingType;
    }

    public void setOrderingType(String orderingType) {
        this.orderingType = orderingType;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReferenceBook{");
        sb.append("isDigital=").append(isDigital);
        sb.append(", orderingType='").append(orderingType).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void readBook() {
        System.out.printf("Read Reference Book: %s\n", getTitle());
    }

    public void findArticle(String articleName) {
        System.out.println("Article info");
    }
}
