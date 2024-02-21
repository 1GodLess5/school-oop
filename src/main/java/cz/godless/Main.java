package cz.godless;

import cz.godless.student.Student;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> studentsList = new ArrayList<>();
        studentsList.add("Albert");
        studentsList.add("Denisa");
        studentsList.add("Matej");

        Clazz class1 = new Clazz("1.A", "Prokopova", studentsList);
        System.out.println(class1.getName());
        System.out.println(class1.getMainTeacher());
        System.out.println(class1.getStudents());

    }
}
