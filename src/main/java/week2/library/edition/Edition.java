package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public abstract class Edition {

    private String title;
    private String author;
    private int yearOfPublishing;
    private String issn;
    private String language;
    private int pageNumber;
    private boolean takenByVisitor;

    public Edition(String title, String author, int yearOfPublishing, String issn, String language, int pageNumber) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.issn = issn;
        this.language = language;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String getIssn() {
        return issn;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getTakenByVisitor() {
        return this.takenByVisitor;
    }

    public void setTakenByVisitor(boolean takenByVisitor) {
        this.takenByVisitor = takenByVisitor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Edition{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", yearOfPublishing=").append(yearOfPublishing);
        sb.append(", issn='").append(issn).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", pageNumber=").append(pageNumber);
        sb.append('}');
        return sb.toString();
    }

    public abstract void readBook();

}
