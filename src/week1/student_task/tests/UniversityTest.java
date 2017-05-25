package week1.student_task.tests;

import week1.student_task.Group;
import week1.student_task.Student;
import week1.student_task.University;

/**
 * Created by valentina on 24.05.17.
 */
public class UniversityTest {

    private University university;

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

    private Group[] groups;
    private Group[] groups1 = {group1, group2, group3};
    private Group[] groups2 = {group2, group3, group4, null, null};
    private Group[] groups3 = {group5, null, null};


    public University university1 = new University("University1", 1);
    public University university2 = new University("University2", groups1);
    public University university3 = new University("University3", groups2);

    private void headerFormat(String name) {
        System.out.println("===============================================");
        System.out.println(name);
        System.out.println("===============================================");
    }

    public void printUniversity(University university) {
        headerFormat("Print University");
        System.out.println(university.asString());
    }

    public void testAddGroup1(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University1", groups);
        boolean expected = true;
        int sizeExpected = 4;
        boolean actual = university.addGroup(group5);
        headerFormat("testAddGroup1 -- add group that was not previously added");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup1", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup2(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University2", groups);
        boolean expected = true;
        int sizeExpected = 4;
        boolean actual = university.addGroup(group1);
        headerFormat("testAddGroup2 -- add group created by other constructor");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup2", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup3(){
        Group[] groups = {group2, group3, group4, null, null};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(null);
        headerFormat("testAddGroup3 -- add 'null' group");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup3", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup4(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(group5);
        headerFormat("testAddGroup4 -- add group when university size is full");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup4", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup5(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(group2);
        headerFormat("testAddGroup4 -- add group that already added");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup5", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup6(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(group6);
        headerFormat("testAddGroup6 -- add group with zero length");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup6", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup7(){
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(group7);
        headerFormat("testAddGroup7 -- add group with existing group number");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup7", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testAddGroup8() {
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.addGroup(group8);
        headerFormat("testAddGroup8 -- add group with existing students array");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAddGroup8", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testRemoveGroup1() {
        Group[] groups = {group2, group3, group4};
        University university = new University("University2", groups);
        boolean expected = true;
        int sizeExpected = 2;
        boolean actual = university.deleteGroup(0);
        headerFormat("testRemoveGroup1 -- delete existing group by index");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testRemoveGroup1", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testRemoveGroup2() {
        University university = new University("University2", 4);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.deleteGroup(3);
        headerFormat("testRemoveGroup2 -- delete non-existing group by index");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testRemoveGroup2", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }

    public void testRemoveGroup3() {
        University university = new University("University2", 4);
        university.addGroup(group2);
        university.addGroup(group3);
        university.addGroup(group4);
        boolean expected = false;
        int sizeExpected = 3;
        boolean actual = university.deleteGroup(6);
        headerFormat("testRemoveGroup3 -- delete non-existing group by index that exceeds 'groups' array size");
        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testRemoveGroup3", expected == actual, expected, actual);
        System.out.printf("University size check - %b, expected - %d, actual - %d\n", sizeExpected == university.getSize(), sizeExpected, university.getSize());
        System.out.println("\n");
    }


}
