package week1.student_task.tests;
import week1.student_task.tests.GroupTest;

/**
 * Created by valentina on 16.05.17.
 */
public class RunGroupTests {
    public static void main(String[] args) {
        GroupTest groupTest = new GroupTest();
        groupTest.testAdd1();
        groupTest.testAdd2();
        groupTest.testAdd3();
        groupTest.testAdd4();
        groupTest.testRemove1();
        groupTest.testRemove2();
        groupTest.testRemove3();
        groupTest.testRemove4();
        groupTest.testUpdate1();
        groupTest.testUpdate2();
        groupTest.testUpdate3();
        groupTest.testSort1();
    }
}
