package week2.library.edition;

/**
 * Created by valentina on 06.06.17.
 */
public class FictionBook extends Edition {
    private String genre;

    public FictionBook(String title, String author, int yearOfPublishing, String issn, String language, int pageNumber, String genre) {
        super(title, author, yearOfPublishing, issn, language, pageNumber);
        this.genre = genre;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public String getAuthor() {
        return super.getAuthor();
    }

    @Override
    public int getYearOfPublishing() {
        return super.getYearOfPublishing();
    }

    @Override
    public String getIssn() {
        return super.getIssn();
    }

    @Override
    public int getPageNumber() {
        return super.getPageNumber();
    }

    @Override
    public void setTitle(String title) {
        super.setTitle(title);
    }

    @Override
    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    @Override
    public void setYearOfPublishing(int yearOfPublishing) {
        super.setYearOfPublishing(yearOfPublishing);
    }

    @Override
    public void setIssn(String issn) {
        super.setIssn(issn);
    }

    @Override
    public void setPageNumber(int pageNumber) {
        super.setPageNumber(pageNumber);
    }

    @Override
    public String getLanguage() {
        return super.getLanguage();
    }

    @Override
    public void setLanguage(String language) {
        super.setLanguage(language);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FictionBook{");
        sb.append("genre='").append(genre).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void readBook() {
        System.out.println("Read fiction book");
    }
}
