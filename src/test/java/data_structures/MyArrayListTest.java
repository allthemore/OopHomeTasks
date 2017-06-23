package data_structures;

//import data_structures.MyArrayList;

import org.junit.Test;

/**
 * Created by valentina on 15.06.17.
 */
public class MyArrayListTest extends MyListTest {
    @Override
    public void setUp() {
        myList = new MyArrayList();
    }

    @Test
    public void printMyArrayList() {
        myList.add("one");
        myList.add("two");
        myList.add("three");
        myList.add("four");

        for (Object o : myList) {
            System.out.println(o);
        }
    }
}
