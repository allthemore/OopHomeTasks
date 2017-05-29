package week1.student_task_dynamic_array;

/**
 * Created by valentina on 23.05.17.
 */
public class University {
    private String universityName;
    private Group[] groups;

//    similarly to the 'size' variable of 'Group' class represents number of not null groups in the 'groups' array
    private int size;

    public University(String universityName, Group[] groups) {
        this.universityName = universityName;
        this.groups = groups;
        this.size = countGroups();
    }


//    universitySize - number of groups in University
    public University(String universityName, int universitySize) {
        this.universityName = universityName;
        this.groups = new Group[universitySize];

    }

    public String getUniversityName() {
        return this.universityName;
    }

    public Group[] getUniversityGroups() {
        return this.groups;
    }

    public int getSize() {
        return this.size;
    }

    private int countGroups() {
        int count = 0;
        for (Group group : groups) {
            if (group != null) {
                count++;
            }
        }
        return count;
    }


    public boolean addGroup(Group group) {
        if(group == null || group.hasEmptyField()) return false;

        for (int i = 0; i < size; i++) {
            if(group.equals(groups[i])) return false;
        }

        if(groups.length == size) {
            this.expandArray();
        }
        groups[size++] = group;
        return true;
    }

    private void expandArray() {
        Group[] expanded = new Group[groups.length + 1];
        System.arraycopy(groups, 0, expanded, 0, groups.length);
        groups = expanded;
    }


    public boolean deleteGroup(int groupIndex) {
        if(size <= groupIndex) return false;

        System.arraycopy(groups, groupIndex + 1, groups, groupIndex, size - groupIndex - 1);
        groups[--size] = null;
        return true;

    }

    public String asString() {
        String info = "";

        for (int i = 0; i < groups.length; i++) {
            info += groups[i] == null ? null : groups[i].asString();
            info += "\n";
        }

        return String.format("University name - %s\nGroups:\n%s", universityName, info);
    }

}
