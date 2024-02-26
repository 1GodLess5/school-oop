package cz.godless.service;

import cz.godless.domain.Clazz;
import cz.godless.domain.Student;
import cz.godless.subjects.Subject;
import cz.godless.subjects.SubjectsToChoose;
import cz.godless.utility.InputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainManager {
    public void school(){
        List<Student> studentsList = new ArrayList<>();
        System.out.println("Enter student name: ");
        String student = InputUtils.readString();

        Map<String, List<Float>> studentSubjects = new HashMap<>();
        int userInput = 0;
        do {
            System.out.println("0 - Exit");
            Subject.printSubjects();
            userInput = InputUtils.readInt();
            System.out.println("Which subject do you want to add?");
        } while (userInput != 0);





        System.out.println(Subject.chooseSubject(userInput));
        // TODO continue here with user choosing subject to add to the student :}


//        List<Float> mathGrades = new ArrayList<>();
//        mathGrades.add(1F);
//        mathGrades.add(2.4F);
//        List<Float> englishGrades = new ArrayList<>();
//        englishGrades.add(2F);
//        englishGrades.add(5F);
//        albertSubjects.put(SubjectsToChoose.MATHEMATICS.getDescription(), mathGrades);
//        albertSubjects.put(SubjectsToChoose.ENGLISH.getDescription(), englishGrades);
//
//        studentsList.add(new Student("Albert", albertSubjects));
//
//        Clazz class1 = new Clazz("1.A", "Prokopova", studentsList);
//        System.out.println(class1.getName());
//        System.out.println(class1.getMainTeacher());
//        studentsList.forEach(student -> {
//            System.out.println(student.getName());
//            System.out.println(student.getSubjects());
//        });
    }


}
