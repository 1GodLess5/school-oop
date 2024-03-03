package cz.godless.service;

import cz.godless.domain.Student;
import cz.godless.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class MainManager {
    private final List<Subject> subjects;

    public MainManager() {
        this.subjects = new ArrayList<>();
    }
    public void school(){
        JsonService jsonService = new JsonService();

//        Subject mathematics = new Subject("Mathematics");
//        mathematics.addGrades("Albert");
//
//        this.subjects.add(mathematics);
//
//        SubjectManager subjectManager = new SubjectManager(this.subjects);
//        subjectManager.addStudentToSubject();
//        subjectManager.printSubjects();

    }
}
