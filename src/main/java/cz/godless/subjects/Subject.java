package cz.godless.subjects;

import cz.godless.grades.Grade;
import cz.godless.utility.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Subject {
    private final String subjectName;
    private List<Grade> grades;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.grades = new ArrayList<>();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public static void printSubjects(){
        Stream.of(SubjectsToChoose.values())
                .forEach(subject -> System.out.println(subject.getSubjectCount() + " - " + subject.getDescription()));
    }

    public static String chooseSubject(int input) {
        return Stream.of(SubjectsToChoose.values())
                .filter(subject -> input == subject.getSubjectCount())
                .map(SubjectsToChoose::getDescription)
                .findFirst()
                .orElse(null);
    }

    public void addGrades() {
        float userInput;
        do {
            System.out.println("Add grade (if you want to stop add 0): ");
            userInput = InputUtils.readFloat();

            if ((userInput < 1 || userInput > 5) && userInput != 0) {
                System.out.println("Invalid input. Try again.");
            } else if (userInput != 0) {
                Grade grade = new Grade(userInput, "");
                this.grades.add(grade);
            }
        } while (userInput != 0);
    }
}
