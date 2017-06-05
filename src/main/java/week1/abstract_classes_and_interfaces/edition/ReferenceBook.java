package week1.abstract_classes_and_interfaces.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class ReferenceBook extends Book{

    private boolean isDigital;

//    Type of ordering data: by alphabet, chronologically, by topic etc
    private String orderingType;

    public ReferenceBook(String title, String author, double price, int yearOfPublishing, String issn, int pageNumber, boolean isDigital, String orderingType) {
        super(title, author, price, yearOfPublishing, issn, pageNumber);
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
    public void readBook() {
        System.out.printf("Read Reference Book: %s\n", getTitle());
    }

    public void findArticle(String articleName) {
        System.out.println("Article info");
    }
}
