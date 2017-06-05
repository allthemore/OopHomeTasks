package week1.student_task_dynamic_array.tests;

/**
 * Created by valentina on 24.05.17.
 */
public class RunUniversityTests {
    public static void main(String[] args) {
        UniversityTest universityTest = new UniversityTest();

        universityTest.printUniversity(universityTest.university1);
        universityTest.printUniversity(universityTest.university2);
        universityTest.printUniversity(universityTest.university3);
        universityTest.testRemoveGroup1();
        universityTest.testRemoveGroup2();
        universityTest.testRemoveGroup3();
        universityTest.testAddDynamic1();
    }
}
