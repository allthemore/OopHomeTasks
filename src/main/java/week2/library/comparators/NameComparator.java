package week2.library.comparators;

import week2.library.Visitor;

import java.util.Comparator;

/**
 * Created by valentina on 07.06.17.
 */
public class NameComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor o1, Visitor o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
