package cz.godless;

import cz.godless.student.Student;

import java.util.List;

public class Clazz {
    private final String name;
    private final String mainTeacher;
    private final List<Student> students;

    public Clazz(String name, String mainTeacher, List<Student> students) {
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

    public List<Student> getStudents() {
        return students;
    }
}
