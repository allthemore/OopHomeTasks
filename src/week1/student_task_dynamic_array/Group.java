package week1.student_task_dynamic_array;


import java.util.Arrays;

/**
 * Created by valentina on 14.05.17.
 */
public class Group {
    private int groupNumber;
    private Student[] students;

    // number of not null students in the group
    private int size;


    public Group(int groupNumber, Student[] students) {
        this.groupNumber = groupNumber;
        this.students = students;
        this.size = countStudents();
    }


    public Group(int groupNumber, int groupSize) {
        this.groupNumber = groupNumber;
        this.students = new Student[groupSize];

    }

    private int countStudents() {
        int count = 0;
        for (Student student : students) {
            if (student != null) {
                count++;
            }
        }
        return count;
    }

    public boolean addStudent(Student student) {
        if(student == null || student.hasEmptyField()) return false;

        for (int i = 0; i < size; i++) {
            if(student.equals(students[i])) return false;
        }

        if(students.length == size) {
            this.expandArray();
        }
        students[size++] = student;
        return true;
    }

    private void expandArray() {
        Student[] expanded = new Student[students.length + 1];
        System.arraycopy(students, 0, expanded, 0, students.length);
        students = expanded;
    }

    public boolean updateStudent(int position, Student student) {
        if (student == null || size == 0 || student.hasEmptyField() || size - 1 < position) {
            return false;
        }
        students[position] = student;
        return true;
    }

    public boolean removeStudent(Student student) {
        if (student == null || size == 0 || student.hasEmptyField()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (student.equals(students[i])) {
                System.arraycopy(students, i + 1, students, i, size - i - 1);
                students[--size] = null;
                return true;
            }
        }

        return false;
    }

    public void sortByName() {
        Student tmp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 1; i < size; i++) {
                if (students[i - 1].getName().compareTo(students[i].getName()) > 0) {
                    sorted = false;
                    tmp = students[i - 1];
                    students[i - 1] = students[i];
                    students[i] = tmp;
                }
            }
        }
    }

    public boolean equalTo(Group group) {
        if (group == null || group.hasEmptyField()) return false;
        if (group == this) return true;
        return this.groupNumber == group.groupNumber && this.students.equals(group.students);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof Group)) return false;
        if(o == this) return true;

        Group groupCasted = (Group) o;
        if(this.groupNumber != groupCasted.groupNumber || this.size != groupCasted.size) return false;
        return Arrays.equals(this.students, groupCasted.students);
    }

    public boolean hasEmptyField() {
        return this.groupNumber == 0 || students.length == 0;
    }

    public String asString() {

        String info = "";

        for (int i = 0; i < students.length; i++) {
            info += students[i] == null ? null : students[i].asString();
            info += "\n";
        }
        return String.format("Group number - %d\nStudents:\n%s", groupNumber, info);
    }

    public int getSize() {
        return size;
    }
}
