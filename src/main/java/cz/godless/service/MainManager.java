package cz.godless.service;

import cz.godless.domain.Student;
import cz.godless.subjects.Subject;
import cz.godless.utility.InputUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainManager {
    private final List<Student> studentList;

    public MainManager() {
        this.studentList = new ArrayList<>();
    }


    public void school(){
        System.out.println("Enter student name: ");
        String studentName = InputUtils.readString();

        Map<String, List<Float>> studentSubjects = new HashMap<>();
        int userInput = 0;
        do {
            System.out.println("0 - Exit");
            Subject.printSubjects();
            System.out.println("Which subject do you want to add?");
            userInput = InputUtils.readInt();

            if (userInput != 0){
                String chosenSubject = Subject.chooseSubject(userInput);
                if (chosenSubject == null){
                    System.out.println("Invalid input.");
                } else {
                    // TODO GRADES ADD
                }

            }
        } while (userInput != 0);


    }
}
