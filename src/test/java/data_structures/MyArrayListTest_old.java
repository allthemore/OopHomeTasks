package data_structures;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by valentina on 02.06.17.
 */
public class MyArrayListTest_old {

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
    public void isEmpty_when_add_null(){
        assertTrue(myArrayList.add(null));
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

    @Test
    public void add_obj_by_index_zero_position_when_empty() {
        assertTrue(myArrayList.add("one", 0));
        assertEquals(1, myArrayList.size());
        System.out.println(myArrayList);
    }

    @Test
    public void add_obj_by_index_zero_position_when_non_empty() {
        assertTrue(myArrayList.add("one", 0));
        assertTrue(myArrayList.add("two", 0));
        assertTrue(myArrayList.add("three", 0));
        assertEquals(3, myArrayList.size());
        System.out.println(myArrayList);

    }

    @Test
    public void add_obj_by_index_last_position() {
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add("one", 1));
        assertTrue(myArrayList.add("two", 2));
        assertTrue(myArrayList.add("three", 3));
        assertTrue(myArrayList.add("four", 4));
        assertTrue(myArrayList.add("five", 5));
        assertTrue(myArrayList.add("six", 6));
        assertTrue(myArrayList.add("seven", 7));
        assertTrue(myArrayList.add("eight", 8));
        assertTrue(myArrayList.add("nine", 9));
        assertTrue(myArrayList.add("ten", 10));
        assertTrue(myArrayList.add("eleven", 11));
        assertEquals(12, myArrayList.size());
        System.out.println(myArrayList);

    }

    @Test
    public void add_obj_by_index_position_more_than_size() {
        assertFalse(myArrayList.add("one", 1));
        assertEquals(0, myArrayList.size());
        System.out.println(myArrayList);
    }
    @Test
    public void add_null_by_index_zero_position_when_empty() {
        assertTrue(myArrayList.add(null, 0));
        assertEquals(1, myArrayList.size());
        System.out.println(myArrayList);
    }

    @Test
    public void add_null_by_index_zero_position_when_non_empty() {
        assertTrue(myArrayList.add(null, 0));
        assertTrue(myArrayList.add(null, 0));
        assertTrue(myArrayList.add("tree", 2));
        assertEquals(3, myArrayList.size());
        System.out.println(myArrayList);
    }

    @Test
    public void contains_element_if_empty() {
        assertFalse(myArrayList.contains("one"));
        assertFalse(myArrayList.contains(null));
        System.out.println(myArrayList);

    }

    @Test
    public void contains_element_if_non_empty() {
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add(null, 1));
        assertFalse(myArrayList.contains("one"));
        assertTrue(myArrayList.contains(null));
        assertTrue(myArrayList.contains("zero"));
        System.out.println(myArrayList);

    }

    @Test
    public void get_element_when_empty(){
        assertEquals(null, myArrayList.get(0));
        assertEquals(null, myArrayList.get(10));
        assertEquals(null, myArrayList.get(11));
    }

    @Test
    public void get_element_when_non_empty(){
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add(null, 1));
        assertTrue(myArrayList.add("two", 2));
        assertEquals("zero", myArrayList.get(0));
        assertEquals(null, myArrayList.get(1));
        assertEquals("two", myArrayList.get(2));
        assertEquals(null, myArrayList.get(3));
        System.out.println(myArrayList);
    }

    @Test
    public void remove_element_by_index_zero_element() {
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add(null, 1));
        assertEquals("zero", myArrayList.remove(0));
        assertEquals(1, myArrayList.size());
        assertEquals(null, myArrayList.remove(0));
        assertEquals(0, myArrayList.size());
        assertEquals(null, myArrayList.remove(0));
        assertEquals(0, myArrayList.size());
        System.out.println(myArrayList);
    }

    @Test
    public void set_when_empty() {
        assertFalse(myArrayList.set("one", 0));
        assertFalse(myArrayList.set(null, 0));
        assertEquals(0, myArrayList.size());
    }

    @Test
    public void set_when_non_empty() {
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add("one", 1));
        assertTrue(myArrayList.add("two", 2));
        assertTrue(myArrayList.add("three", 3));
        assertTrue(myArrayList.set("ZERO", 0));
        assertTrue(myArrayList.set("ONE", 1));
        assertTrue(myArrayList.set(null, 2));
        assertFalse(myArrayList.set("ELEVEN", 11));
        System.out.println(myArrayList);
    }

    @Test
    public void clear_when_empty(){
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        System.out.println(myArrayList);
    }

    @Test
    public void clear_when_non_empty(){
        assertTrue(myArrayList.add("zero", 0));
        assertTrue(myArrayList.add("one", 1));
        assertTrue(myArrayList.add(null, 2));
        assertTrue(myArrayList.add("three", 3));
        System.out.println(myArrayList);
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        System.out.println(myArrayList);
    }
}
