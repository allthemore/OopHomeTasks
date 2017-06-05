package week1.student_task;

import static org.junit.Assert.*;
import week1.student_task.Group;
import week1.student_task.Student;
import org.junit.Test;


/**
 * Created by valentina on 16.05.17.
 */
public class GroupTest {

    private Group group;

    private void headerFormat(String name) {
        System.out.println("===================");
        System.out.println(name);
        System.out.println("===================");
    }

    @Test
    public void testAdd1(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        group = new Group(20, new Student[5]);
        assertTrue(group.addStudent(student));
    }

    @Test
    public void testAdd2(){
        group = new Group(20, new Student[5]);
        assertFalse(group.addStudent(null));
    }

    @Test
    public void testAdd3(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        group = new Group(20, new Student[0]);
        assertFalse(group.addStudent(student));
    }

    @Test
    public void testAdd4(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Oleh", "Muzichenko", 29);
        group = new Group(20, new Student[]{student, student2});
        assertFalse(group.addStudent(student3));
    }

    @Test
    public void testRemove1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 30);
        Student student3 = new Student("Ivan", "Ivanov", 31);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testRemove1");
        System.out.println(group.asString());
        assertTrue(group.removeStudent(student2));
        assertEquals(2, group.getSize());
    }

    @Test
    public void testRemove2() {
        group = new Group(20, 5);
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        headerFormat("testRemove2");
        System.out.println(group.asString());
        assertFalse(group.removeStudent(student1));
        assertEquals(0, group.getSize());
    }

    @Test
    public void testRemove3() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Ivan", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testRemove3");
        System.out.println(group.asString());
        assertFalse(group.removeStudent(student4));
        assertEquals(3, group.getSize());
    }

    @Test
    public void testRemove4() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student();
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testRemove4");
        System.out.println(group.asString());
        assertFalse(group.removeStudent(student4));
        assertEquals(3, group.getSize());
    }

    @Test
    public void testUpdate1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Vania", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testUpdate1");
        System.out.println(group.asString());
        assertTrue(group.updateStudent(0, student4));
        assertEquals(3, group.getSize());
    }

    @Test
    public void testUpdate2() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student();
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testUpdate2");
        System.out.println(group.asString());
        assertFalse(group.updateStudent(0, student4));
        assertEquals(3, group.getSize());
    }

    @Test
    public void testUpdate3() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Vania", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        headerFormat("testUpdate3");
        System.out.println(group.asString());
        assertTrue(group.updateStudent(2, student4));
        assertEquals(3, group.getSize());

    }

    @Test
    public void testAddDynamic1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);

        group = new Group(20, 1);
        headerFormat("testUpdateDynamic1");
        assertTrue(group.addStudentDynamic(student1));
        assertEquals(1, group.getSize());

        assertTrue(group.addStudentDynamic(student2));
        assertEquals(2, group.getSize());

        assertTrue(group.addStudentDynamic(student3));
        assertEquals(3, group.getSize());
        System.out.println(group.asString());
    }

    @Test
    public void testSort1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Vania", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        group.addStudent(student4);
        headerFormat("testSort1");
        System.out.println(group.asString());
        group.sortByName();
        System.out.println("Group sorted:");
        System.out.println(group.asString());
        Student[] expectedSort = {student3, student1, student2, student4, null};
        assertArrayEquals(group.getStudents(), expectedSort);
    }
 }

