package cz.godless.subjects;

import java.util.stream.Stream;

public class Subject {
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
}
