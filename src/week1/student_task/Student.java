package week1.student_task;

/**
 * Created by valentina on 14.05.17.
 */
public class Student {

    private String name;
    private String surName;
    private int age;

//    default constructor
    public Student() {
    }

    public Student(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String asString() {
        return String.format("Student name - %s, surName - %s, age - %d",
                name, surName, age);
    }

    public boolean equalTo(Student student) {
        if (student == null || student.hasEmptyField()) return false;
        if (student == this) return true;
        return this.name.equals(student.name) && this.surName.equals(student.surName);
    }

    public boolean hasEmptyField() {
        return (this.getName() == null || this.getSurName() == null || this.getAge() == 0);
    }

    //    move all "null" students to the end of array
//    public void normalizeArray(Student[] students) {
//        boolean sorted = false;
//        while (!sorted) {
//            sorted = true;
//            for (int i = 1; i < students.length; i++) {
//                if (students[i - 1] == null) {
//                    sorted = false;
//                    students[i - 1] = students[i];
//                    students[i] = null;
//                }
//            }
//        }
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}