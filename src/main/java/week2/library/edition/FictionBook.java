package week2.library.edition;

/**
 * Created by valentina on 06.06.17.
 */
public class FictionBook extends Edition {
    private String genre;

    public FictionBook(String title, String author, int yearOfPublishing, String language, int pageNumber, String genre) {
        super(title, author, yearOfPublishing, language, pageNumber);
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FictionBook)) return false;
        if (!super.equals(o)) return false;

        FictionBook that = (FictionBook) o;

        return genre != null ? genre.equals(that.genre) : that.genre == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FictionBook{");
        sb.append(super.toString());
        sb.append("genre='").append(genre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
