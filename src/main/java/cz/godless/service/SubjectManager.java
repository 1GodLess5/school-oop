package cz.godless.service;

import cz.godless.subjects.Subject;

import java.util.List;

public class SubjectManager {
    private final List<Subject> subjects;

    public SubjectManager(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(String newSubject) {
        long count = this.subjects.stream()
                .filter(subject -> subject.getSubjectName().equals(newSubject))
                .count();
        if (count == 0){
            this.subjects.add(new Subject(newSubject));
        }
    }

    private Subject findSubject(String subjectName) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectName().equals(subjectName))
                .findFirst()
                .orElse(null);
    }
}
