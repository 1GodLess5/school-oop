package cz.godless.domain;

import cz.godless.subjects.Subject;

import java.util.List;

public class Teacher {
    private final String name;
    private final List<Subject> teachingSubjects;

    public Teacher(String name, List<Subject> teachingSubjects) {
        this.name = name;
        this.teachingSubjects = teachingSubjects;
    }

    public String getName() {
        return name;
    }

    // TODO CONTINUE HERE
    // TRIDA VE KTERE JSOU ZACI, PREDMET KTERY MA V SOBE ZAPSANE ZAKY
}
