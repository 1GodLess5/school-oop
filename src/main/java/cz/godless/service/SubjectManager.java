package cz.godless.service;

import cz.godless.domain.Student;
import cz.godless.grades.Grade;
import cz.godless.subjects.Subject;
import cz.godless.utility.InputUtils;
import cz.godless.utility.PrintUtils;

import java.util.List;
import java.util.Map;

public class SubjectManager {
    private final List<Subject> subjects;

    public SubjectManager(List<Subject> subjects) {
        this.subjects = subjects;
    }

    private void addSubject(String newSubject) {
        long count = this.subjects.stream()
                .filter(subject -> subject.getSubjectName().equals(newSubject))
                .count();
        if (count == 0) {
            this.subjects.add(new Subject(newSubject));
        }
    }

    private Subject findSubject(String subjectName) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectName().equals(subjectName))
                .findFirst()
                .orElse(null);
    }

    public void addStudentToSubject() {
        System.out.println("Enter student name: ");
        Student student = new Student(InputUtils.readString());

        int userInput = 0;
        do {
            System.out.println("0 - Exit");
            Subject.printSubjects();
            System.out.println("To which subject do you want to add?");
            userInput = InputUtils.readInt();

            if (userInput != 0) {
                String chosenSubject = Subject.chooseSubject(userInput);
                if (chosenSubject == null) {
                    System.out.println("Invalid input.");
                } else {
                    this.addSubject(chosenSubject);
                    this.addingStudent(chosenSubject, student);
                }

            }
        } while (userInput != 0);


    }

    private void addingStudent(String chosenSubject, Student student) {
        Subject searchSubject = findSubject(chosenSubject);

        if (searchSubject != null) {
            for (Map.Entry<Student, List<Grade>> entry : searchSubject.getGrades().entrySet()) {
                if (entry.getKey().getName().equals(student.getName())) {
                    System.out.println("This student already exists.");
                    System.out.println("His grades: ");
                    entry.getValue().forEach(grade -> System.out.println(grade.getGrade() + " - " + grade.getDescription()));
                    System.out.println("Do you wish to add another grade?");
                    System.out.println("0 - No");
                    System.out.println("1 - Yes");

                    while (true) {
                        int userInput = InputUtils.readInt();
                        switch (userInput) {
                            case 0 -> {
                                return;
                            }
                            case 1 -> {
                                searchSubject.addGrades(entry.getKey().getName());
                                return;
                            }
                            default -> System.out.println("Invalid input.");
                        }
                    }
                }
            }
            searchSubject.addGrades(student.getName());
        }
    }

    public void printSubjects() {
        PrintUtils.printDivider();
        for (Subject subject : this.subjects) {
            System.out.println(subject.getSubjectName());
            for (Map.Entry<Student, List<Grade>> entry : subject.getGrades().entrySet()) {
                System.out.println(entry.getKey().getName() + ": ");
                entry.getValue().forEach(grade -> System.out.println(grade.getGrade() + " - " + grade.getDescription()));
            }
            PrintUtils.printDivider();
        }
    }
}
