package week2.library.comparators;

import week2.library.edition.Edition;
import java.util.Comparator;

/**
 * Created by valentina on 07.06.17.
 */
public class YearComparator implements Comparator<Edition>{
    @Override
    public int compare(Edition o1, Edition o2) {
        return Integer.compare(o1.getYearOfPublishing(), o2.getYearOfPublishing());
    }
}
