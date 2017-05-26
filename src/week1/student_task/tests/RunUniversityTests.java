package week1.student_task.tests;
import week1.student_task.University;
import week1.student_task.tests.UniversityTest;

/**
 * Created by valentina on 24.05.17.
 */
public class RunUniversityTests {
    public static void main(String[] args) {
        UniversityTest universityTest = new UniversityTest();

        universityTest.printUniversity(universityTest.university1);
        universityTest.printUniversity(universityTest.university2);
        universityTest.printUniversity(universityTest.university3);
        universityTest.testAddGroup1();
        universityTest.testAddGroup2();
        universityTest.testAddGroup3();
        universityTest.testAddGroup4();
        universityTest.testAddGroup5();
        universityTest.testAddGroup6();
        universityTest.testAddGroup7();
        universityTest.testAddGroup8();
        universityTest.testRemoveGroup1();
        universityTest.testRemoveGroup2();
        universityTest.testRemoveGroup3();
        universityTest.testAddDynamic1();
    }
}
