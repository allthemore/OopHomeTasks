package week1.student_task.tests;
import week1.student_task.Group;
import week1.student_task.Student;


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

    public void testAdd1(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        group = new Group(20, new Student[5]);

        boolean expected = true;
        boolean actual = group.addStudent(student);

        System.out.printf("Test %s result - %b, expected - %b,  actual - %b\n", "testAdd1", expected == actual, expected, actual);

    }

    public void testAdd2(){
        group = new Group(20, new Student[5]);
        boolean expected = false;
        boolean actual = group.addStudent(null);

        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);

    }

    public void testAdd3(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        group = new Group(20, new Student[0]);
        boolean expected = false;
        boolean actual = group.addStudent(student);

        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);

    }

    public void testAdd4(){
        Student student = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Oleh", "Muzichenko", 29);
        group = new Group(20, new Student[]{student, student2});
        boolean expected = false;
        boolean actual = group.addStudent(student3);

        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);

    }

    public void testRemove1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 30);
        Student student3 = new Student("Ivan", "Ivanov", 31);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = true;
        boolean actual = group.removeStudent(student2);
        int sizeExpected = 2;
        headerFormat("testRemove1");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");
    }

    public void testRemove2() {
        group = new Group(20, 5);
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        boolean expected = false;
        boolean actual = group.removeStudent(student1);
        int sizeExpected = 0;
        headerFormat("testRemove2");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");
    }

    public void testRemove3() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Ivan", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = false;
        boolean actual = group.removeStudent(student4);
        int sizeExpected = 3;
        headerFormat("testRemove3");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");
    }

    public void testRemove4() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student();
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = false;
        boolean actual = group.removeStudent(student4);
        int sizeExpected = 3;
        headerFormat("testRemove4");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");
    }

    public void testUpdate1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Vania", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = true;
        boolean actual = group.updateStudent(0, student4);
        int sizeExpected = 3;
        headerFormat("testUpdate1");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

    }

    public void testUpdate2() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student();
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = false;
        boolean actual = group.updateStudent(0, student4);
        int sizeExpected = 3;
        headerFormat("testUpdate2");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

    }

    public void testUpdate3() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        Student student4 = new Student("Vania", "Ivanov1", 29);
        group = new Group(20, 5);
        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);
        boolean expected = true;
        boolean actual = group.updateStudent(2, student4);
        int sizeExpected = 3;
        headerFormat("testUpdate3");
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.println(group.asString());
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

    }

    public void testAddDynamic1() {
        Student student1 = new Student("Maxim", "Muzichenko", 29);
        Student student2 = new Student("Oleh", "Muzichenko", 29);
        Student student3 = new Student("Ivan", "Ivanov", 29);
        group = new Group(20, 1);
        headerFormat("testUpdateDynamic1");
        boolean expected = true;
        int sizeExpected = 1;
        boolean actual = group.addStudentDynamic(student1);
        System.out.println(group.asString());
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

        actual = group.addStudentDynamic(student2);
        System.out.println(group.asString());
        sizeExpected = 2;
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

        actual = group.addStudentDynamic(student3);
        System.out.println(group.asString());
        sizeExpected = 3;
        System.out.printf("Test result - %b, expected - %b,  actual - %b\n", expected == actual, expected, actual);
        System.out.printf("Group size check - %b, expected - %d, actual - %d\n", sizeExpected == group.getSize(), sizeExpected, group.getSize());
        System.out.println("\n");

    }

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
    }
 }

