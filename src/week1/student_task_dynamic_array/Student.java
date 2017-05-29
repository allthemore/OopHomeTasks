package week1.student_task_dynamic_array;

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

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Student)) return false;
        if(obj == this) return true;

        Student studentCasted = (Student) obj;
        if(this.age != studentCasted.age) return false;
        if(this.name != null ? !this.name.equals(studentCasted.name) : studentCasted.name != null) return false;
        return this.surName != null ? this.surName.equals(studentCasted.surName) : studentCasted.surName == null;
    }


    public boolean hasEmptyField() {
        return this.getName() == null || this.getSurName() == null || this.getAge() == 0;
    }

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