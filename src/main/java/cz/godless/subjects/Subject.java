package cz.godless.subjects;

import cz.godless.domain.Student;
import cz.godless.grades.Grade;
import cz.godless.utility.InputUtils;

import java.util.*;
import java.util.stream.Stream;

public class Subject {
    private final String subjectName;
    private final Map<Student, List<Grade>> studentGrades;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.studentGrades = new HashMap<>();
    }

    public Subject(String subjectName, Map<Student, List<Grade>> studentGrades) {
        this.subjectName = subjectName;
        this.studentGrades = studentGrades;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Map<Student, List<Grade>> getGrades() {
        return studentGrades;
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

    public void addGrades(String studentName) {
        float userInput;
        do {
            System.out.println("Add grade (if you want to stop add 0): ");
            userInput = InputUtils.readFloat();

            if ((userInput < 1 || userInput > 5) && userInput != 0) {
                System.out.println("Invalid input. Try again.");
            } else if (userInput != 0) {
                Grade grade = new Grade(userInput, addGradeDescription());
                int counter = 0;
                for (Map.Entry<Student, List<Grade>> entry: this.studentGrades.entrySet()){
                    if (entry.getKey().getName().equals(studentName)) {
                        entry.getValue().add(grade);
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    List<Grade> newStudentGrades = new ArrayList<>();
                    newStudentGrades.add(grade);
                    this.studentGrades.put(new Student(studentName), newStudentGrades);
                }
            }
        } while (userInput != 0);
    }

    private String addGradeDescription() {
        System.out.println("Do you wish to add description ?");
        System.out.println("0 - No");
        System.out.println("1 - Yes");

        while (true) {
            int choice = InputUtils.readInt();

            switch (choice) {
                case 0 -> {
                    return "";
                }
                case 1 -> {
                    System.out.println("Write description: ");
                    return InputUtils.readString();
                }
                default -> System.out.println("Invalid input.");
            }
        }
    }
}
