package cz.godless;

import java.util.List;

public class Clazz {
    private final String name;
    private final String mainTeacher;
    private final List<String> students;

    public Clazz(String name, String mainTeacher, List<String> students) {
        this.name = name;
        this.mainTeacher = mainTeacher;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getMainTeacher() {
        return mainTeacher;
    }

    public List<String> getStudents() {
        return students;
    }
}
