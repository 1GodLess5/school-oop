package cz.godless.domain;

import java.util.List;

public class Clazz {
    private final String name;
    private final Teacher mainTeacher;
    private final List<Student> students;

    public Clazz(String name, Teacher mainTeacher, List<Student> students) {
        this.name = name;
        this.mainTeacher = mainTeacher;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public Teacher getMainTeacher() {
        return mainTeacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
