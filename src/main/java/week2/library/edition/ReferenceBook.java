package week2.library.edition;

/**
 * Created by valentina on 22.05.17.
 */
public class ReferenceBook extends Edition {

    private final boolean isDigital;

//    Type of ordering data: by alphabet, chronologically, by topic etc
    private String orderingType;

    public ReferenceBook(String title, String author, int yearOfPublishing, String language, int pageNumber, boolean isDigital) {
        super(title, author, yearOfPublishing, language, pageNumber);
        this.isDigital = isDigital;
    }

    public boolean getIsDigital() {
        return isDigital;
    }

    public String getOrderingType() {
        return orderingType;
    }

    public void setOrderingType(String orderingType) {
        this.orderingType = orderingType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReferenceBook)) return false;
        if (!super.equals(o)) return false;

        ReferenceBook that = (ReferenceBook) o;

        if (isDigital != that.isDigital) return false;
        return orderingType != null ? orderingType.equals(that.orderingType) : that.orderingType == null;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ReferenceBook{");
        sb.append(super.toString());
        sb.append(", isDigital=").append(isDigital);
        if(orderingType != null) sb.append(", orderingType='").append(orderingType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
