package week1.student_task;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by valentina on 24.05.17.
 */
public class UniversityTest {

    private Student student1 = new Student("Name1", "Surname1", 29);
    private Student student2 = new Student("Name2", "Surname2", 30);
    private Student student3 = new Student("Name3", "Surname3", 31);
    private Student student4 = new Student("Name4", "Surname4", 31);
    private Student student5 = new Student("Name5", "Surname5", 31);
    private Student student6 = new Student("Name6", "Surname6", 31);
    private Student student7 = new Student("Name7", "Surname7", 31);

    private Student[] students1 = {student1, student2};
    private Student[] students2 = {student3, student4, null, null};
    private Student[] students3 = {null, student5, null, student2, null, student6};
    private Student[] students4 = {student6, student7, null, null};

    private Group group1 = new Group(10,5);
    private Group group2 = new Group(11, students1);
    private Group group3 = new Group(12, students2);
    private Group group4 = new Group(13, students3);
    private Group group5 = new Group(14, students4);
    private Group group6 = new Group(15, new Student[0]);
    private Group group7 = new Group(11, students4);
    private Group group8 = new Group(16, students1);

    private Group[] groups1 = {group1, group2, group3};
    private Group[] groups2 = {group2, group3, group4, null, null};

    private void headerFormat(String name) {
        System.out.println("===============================================");
        System.out.println(name);
        System.out.println("===============================================");
    }

    @Test
    public void testAddGroup1(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University1", groups);
        headerFormat("testAddGroup1 -- add group that was not previously added");
        assertTrue(university.addGroup(group5));
        assertEquals(4, university.getSize());
    }

    @Test
    public void testAddGroup2(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University2", groups);
        headerFormat("testAddGroup2 -- add group created by other constructor");
        assertTrue(university.addGroup(group1));
        assertEquals(4, university.getSize());
    }

    @Test
    public void testAddGroup3(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University2", groups);
        headerFormat("testAddGroup3 -- add 'null' group");
        assertFalse(university.addGroup(null));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddGroup4(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testAddGroup4 -- add group when university size is full");
        assertFalse(university.addGroup(group5));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddGroup5(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testAddGroup4 -- add group that already added");
        assertFalse(university.addGroup(group2));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddGroup6(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testAddGroup6 -- add group with zero length");
        assertFalse(university.addGroup(group6));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddGroup7(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testAddGroup7 -- add group with existing group number");
        assertFalse(university.addGroup(group7));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddGroup8() {
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testAddGroup8 -- add group with existing students array");
        assertFalse(university.addGroup(group8));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testRemoveGroup1() {
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        headerFormat("testRemoveGroup1 -- delete existing group by index");
        assertTrue(university.deleteGroup(0));
        assertEquals(2, university.getSize());
    }

    @Test
    public void testRemoveGroup2() {
        University university = new University("University2", 4);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);
        headerFormat("testRemoveGroup2 -- delete non-existing group by index");
        assertFalse(university.deleteGroup(3));
        assertEquals(3, university.getSize());

    }

    @Test
    public void testRemoveGroup3() {
        University university = new University("University2", 4);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);
        headerFormat("testRemoveGroup3 -- delete non-existing group by index that exceeds 'groups' array size");
        assertFalse(university.deleteGroup(6));
        assertEquals(3, university.getSize());
    }

    @Test
    public void testAddDynamic1(){
        University university = new University("UniversityDynamic", 1);
        headerFormat("testAddGroupDynamic1 -- add groups dynamically");
        assertTrue(university.addGroupDynamic(group2));
        assertEquals(1, university.getSize());

        assertTrue(university.addGroupDynamic(group3));
        assertEquals(2, university.getSize());

        assertTrue(university.addGroupDynamic(group4));
        assertEquals(3, university.getSize());
        System.out.println(university.asString());
        System.out.println("\n");
    }
}
