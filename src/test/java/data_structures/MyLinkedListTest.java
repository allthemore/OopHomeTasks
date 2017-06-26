package data_structures;

import org.junit.Test;

/**
 * Created by valentina on 13.06.17.
 */
public class MyLinkedListTest extends MyListTest{
    @Override
    public void setUp() {
        myList = new MyLinkedList();
    }

    @Test
    public void testPrint() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");

        for (Object o : myList) {
            System.out.println(o);
        }
    }
}
