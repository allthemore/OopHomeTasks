package data_structures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by valentina on 15.06.17.
 */
public abstract class MyListTest {
    protected MyList<String> myList;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        myList = null;
    }

    @Test
    public void add_when_empty(){
        assertTrue(myList.add("one"));
        assertEquals(1, myList.size());
    }

    @Test
    public void add_null_when_empty(){
        assertTrue(myList.add(null));
        assertEquals(1, myList.size());

    }

    @Test
    public void add_more_than_start_size(){
        assertTrue(myList.add("one"));
        assertTrue(myList.add("two"));
        assertTrue(myList.add("three"));
        assertTrue(myList.add("four"));
        assertTrue(myList.add("five"));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertTrue(myList.add("eight"));
        assertTrue(myList.add("nine"));
        assertTrue(myList.add("ten"));
        assertTrue(myList.add("eleven"));
        assertEquals(11, myList.size());
    }

    @Test
    public void size_when_empty(){
        assertEquals(0, myList.size());
    }

    @Test
    public void isEmpty_when_empty(){
        assertTrue(myList.isEmpty());
    }

    @Test
    public void isEmpty_when_add_one_element(){
        assertTrue(myList.add("one"));
        assertFalse(myList.isEmpty());
    }

    @Test
    public void isEmpty_when_add_null(){
        assertTrue(myList.add(null));
        assertFalse(myList.isEmpty());
    }

    @Test
    public void remove_obj_when_empty(){
        assertFalse(myList.remove("one"));
        assertEquals(0, myList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_not_present(){
        assertTrue(myList.add("five"));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertFalse(myList.remove("one"));
        assertEquals(3, myList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_present(){
        assertTrue(myList.add("one"));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertTrue(myList.remove("one"));
        assertEquals(2, myList.size());
    }

    @Test
    public void remove_obj_when_not_empty_and_element_present_in_last_position(){
        assertTrue(myList.add("one"));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertTrue(myList.remove("seven"));
        assertEquals(2, myList.size());

    }

    @Test
    public void remove_null_when_empty(){
        assertFalse(myList.remove(null));
        assertEquals(0, myList.size());
    }

    @Test
    public void remove_null_when_not_empty_and_element_not_present(){
        assertTrue(myList.add("five"));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertFalse(myList.remove(null));
        assertEquals(3, myList.size());
    }

    @Test
    public void remove_null_when_not_empty_and_element_present(){
        assertTrue(myList.add(null));
        assertTrue(myList.add("six"));
        assertTrue(myList.add("seven"));
        assertTrue(myList.remove(null));
        assertEquals(2,myList.size());
    }

    @Test
    public void remove_obj_when_only_one_obj_in_array() {
        assertTrue(myList.add("one"));
        assertTrue(myList.remove("one"));
        assertEquals(0, myList.size());
    }

    @Test
    public void remove_null_when_only_one_obj_in_array() {
        assertTrue(myList.add(null));
        assertTrue(myList.remove(null));
        assertEquals(0, myList.size());
    }

    @Test
    public void add_obj_by_index_zero_position_when_empty() {
        assertTrue(myList.add("one", 0));
        assertEquals(1, myList.size());
    }

    @Test
    public void add_obj_by_index_zero_position_when_non_empty() {
        assertTrue(myList.add("one", 0));
        assertTrue(myList.add("two", 0));
        assertTrue(myList.add("three", 0));
        assertEquals(3, myList.size());
    }

    @Test
    public void add_obj_by_index_last_position() {
        assertTrue(myList.add("zero", 0));
        assertTrue(myList.add("one", 1));
        assertTrue(myList.add("two", 2));
        assertTrue(myList.add("three", 3));
        assertTrue(myList.add("four", 4));
        assertTrue(myList.add("five", 5));
        assertTrue(myList.add("six", 6));
        assertTrue(myList.add("seven", 7));
        assertTrue(myList.add("eight", 8));
        assertTrue(myList.add("nine", 9));
        assertTrue(myList.add("ten", 10));
        assertTrue(myList.add("eleven", 11));
        assertEquals(12, myList.size());
    }

    @Test
    public void add_obj_by_index_position_more_than_size() {
        assertFalse(myList.add("one", 1));
        assertEquals(0, myList.size());
    }

    @Test
    public void add_null_by_index_zero_position_when_empty() {
        assertTrue(myList.add(null, 0));
        assertEquals(1, myList.size());
    }

    @Test
    public void add_null_by_index_zero_position_when_non_empty() {
        assertTrue(myList.add(null, 0));
        assertTrue(myList.add(null, 0));
        assertTrue(myList.add("tree", 2));
        assertEquals(3, myList.size());
    }

    @Test
    public void contains_element_if_empty() {
        assertFalse(myList.contains("one"));
        assertFalse(myList.contains(null));
    }

    @Test
    public void contains_element_if_non_empty() {
        assertTrue(myList.add("zero", 0));
        assertTrue(myList.add(null, 1));
        assertFalse(myList.contains("one"));
        assertTrue(myList.contains(null));
        assertTrue(myList.contains("zero"));
    }

    @Test
    public void get_element_when_empty(){
        assertEquals(null, myList.get(0));
        assertEquals(null, myList.get(10));
        assertEquals(null, myList.get(11));
    }

    @Test
    public void get_element_when_non_empty(){
        assertTrue(myList.add("zero", 0));
        assertTrue(myList.add(null, 1));
        assertTrue(myList.add("two", 2));
        assertEquals("zero", myList.get(0));
        assertEquals(null, myList.get(1));
        assertEquals("two", myList.get(2));
        assertEquals(null, myList.get(3));
    }

    @Test
    public void remove_element_by_index_zero_element() {
        assertTrue(myList.add("zero", 0));
        assertTrue(myList.add(null, 1));
        assertEquals("zero", myList.remove(0));
        assertEquals(1, myList.size());
        assertEquals(null, myList.remove(0));
        assertEquals(0, myList.size());
        assertEquals(null, myList.remove(0));
        assertEquals(0, myList.size());
    }

    @Test
    public void set_when_empty() {
        assertFalse(myList.set("one", 0));
        assertFalse(myList.set(null, 0));
        assertEquals(0, myList.size());
    }

    @Test
    public void set_when_non_empty() {
        assertTrue(myList.add("zero", 0));
        assertTrue(myList.add("one", 1));
        assertTrue(myList.add("two", 2));
        assertTrue(myList.add("three", 3));
        assertTrue(myList.set("ZERO", 0));
        assertTrue(myList.set("ONE", 1));
        assertTrue(myList.set(null, 2));
        assertFalse(myList.set("ELEVEN", 11));
    }

    @Test
    public void clear_when_empty(){
        myList.clear();
        assertEquals(0, myList.size());
    }

    @Test
    public void clear_when_non_empty(){
        assertTrue(myList.add("zero"));
        assertTrue(myList.add("one"));
        assertTrue(myList.add(null));
        assertTrue(myList.add("three"));
        myList.clear();
        assertEquals(0, myList.size());
    }
}
