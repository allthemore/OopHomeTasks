package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public abstract class Edition {

    private final String title;
    private final String author;
    private final int yearOfPublishing;
    private final String language;
    private final int pageNumber;
    private String issn;
    private boolean takenByVisitor;

    public Edition(String title, String author, int yearOfPublishing, String language, int pageNumber) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.language = language;
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edition edition = (Edition) o;

        if (yearOfPublishing != edition.yearOfPublishing) return false;
        if (pageNumber != edition.pageNumber) return false;
        if (takenByVisitor != edition.takenByVisitor) return false;
        if (title != null ? !title.equals(edition.title) : edition.title != null) return false;
        if (author != null ? !author.equals(edition.author) : edition.author != null) return false;
        if (issn != null ? !issn.equals(edition.issn) : edition.issn != null) return false;
        return language != null ? language.equals(edition.language) : edition.language == null;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public boolean getTakenByVisitor() {
        return this.takenByVisitor;
    }

    public void setTakenByVisitor(boolean takenByVisitor) {
        this.takenByVisitor = takenByVisitor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", yearOfPublishing=").append(yearOfPublishing);
        if(issn != null) sb.append(", issn='").append(issn).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", pageNumber=").append(pageNumber);
        return sb.toString();
    }

    public final String info() {
        final StringBuilder sb = new StringBuilder("Edition{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
