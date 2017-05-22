package week1.abstract_classes_and_interfaces.edition;

/**
 * Created by valentina on 22.05.17.
 */
public abstract class Book implements Edition{

    private String title;
    private String author;
    private double price;
    private int yearOfPublishing;
    private String issn;
    private int pageNumber;

    public Book(String title, String author, double price, int yearOfPublishing, String issn, int pageNumber) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearOfPublishing = yearOfPublishing;
        this.issn = issn;
        this.pageNumber = pageNumber;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    @Override
    public String getIssn() {
        return issn;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", issn=").append(issn);
        sb.append(", pageNumber=").append(pageNumber);
        sb.append('}');
        return sb.toString();
    }

    public abstract void readBook();

}
