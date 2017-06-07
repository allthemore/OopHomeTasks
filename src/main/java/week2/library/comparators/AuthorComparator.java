package week2.library.comparators;

import week2.library.edition.Edition;
import java.util.Comparator;

/**
 * Created by valentina on 07.06.17.
 */
public class AuthorComparator implements Comparator<Edition>{
    @Override
    public int compare(Edition o1, Edition o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}
