package week2.data_structures;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by valentina on 02.06.17.
 */
public class MyArrayListTest {

    private MyArrayList myArrayList;

    @Before
    public void setUp(){
        myArrayList = new MyArrayList();
    }

    @After
    public void tearDown(){
        myArrayList = null;
    }

    @Test
    public void add_when_empty(){
        assertTrue(myArrayList.add("one"));
        assertEquals(1, myArrayList.size());
    }

    @Test
    public void add_null_when_empty(){
        assertTrue(myArrayList.add(null));
        assertEquals(1, myArrayList.size());

    }

    @Test
    public void add_more_than_start_size(){
        assertTrue(myArrayList.add("one"));
        assertTrue(myArrayList.add("two"));
        assertTrue(myArrayList.add("three"));
        assertTrue(myArrayList.add("four"));
        assertTrue(myArrayList.add("five"));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertTrue(myArrayList.add("eight"));
        assertTrue(myArrayList.add("nine"));
        assertTrue(myArrayList.add("ten"));
        assertTrue(myArrayList.add("eleven"));
        assertEquals(11, myArrayList.size());
    }

    @Test
    public void size_when_empty(){
        assertEquals(0, myArrayList.size());
    }


    @Test
    public void isEmpty_when_empty(){
        assertTrue(myArrayList.isEmpty());
    }

    @Test
    public void isEmpty_when_add_one_element(){
        assertTrue(myArrayList.add("one"));
        assertFalse(myArrayList.isEmpty());
    }

    @Test
    public void remove_obj_when_empty(){
        assertFalse(myArrayList.remove("one"));
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_not_present(){
        assertTrue(myArrayList.add("five"));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertFalse(myArrayList.remove("one"));
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_present(){
        assertTrue(myArrayList.add("one"));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertTrue(myArrayList.remove("one"));
        assertEquals(2, myArrayList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_present_in_last_position(){
        assertTrue(myArrayList.add("one"));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertTrue(myArrayList.remove("seven"));
        assertEquals(2, myArrayList.size());

    }

    @Test
    public void remove_null_when_empty(){
        assertFalse(myArrayList.remove(null));
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void remove_null_when_not_empty_and_element_not_present(){
        assertTrue(myArrayList.add("five"));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertFalse(myArrayList.remove(null));
        assertEquals(3, myArrayList.size());
    }

    @Test
    public void remove_null_when_not_empty_and_element_present(){
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.add("six"));
        assertTrue(myArrayList.add("seven"));
        assertTrue(myArrayList.remove(null));
        assertEquals(2,myArrayList.size());
    }

    @Test
    public void remove_obj_when_only_one_obj_in_array() {
        assertTrue(myArrayList.add("one"));
        assertTrue(myArrayList.remove("one"));
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void remove_null_when_only_one_obj_in_array() {
        assertTrue(myArrayList.add(null));
        assertTrue(myArrayList.remove(null));
        assertEquals(0, myArrayList.size());
    }
}
