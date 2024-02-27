package cz.godless.domain;

import cz.godless.subjects.Subject;

import java.util.List;

public class Student {
    private final String name;
    private final List<Subject> subjects;

    public Student(String name, List<Subject> subjects){
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
