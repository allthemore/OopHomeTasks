package week2.library.edition;

/**
 * Created by valentina on 13.06.17.
 */

//  Video tutorial https://www.youtube.com/watch?v=yLhWUezprNo&list=PLwwk4BHih4fi8LTppXzTrCBgMJjC7FX7t&index=21

public enum MonthOfEdition {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private int monthNumber;

    MonthOfEdition(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public int getMonthNumber() {
        return this.monthNumber;
    }
}
