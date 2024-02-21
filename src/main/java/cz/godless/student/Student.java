package cz.godless.student;

import java.util.List;
import java.util.Map;

public class Student {
    private final String name;
    private final Map<String, List<Float>> subjects;

    public Student(String name, Map<String, List<Float>> subjects){
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Float>> getSubjects() {
        return subjects;
    }
}
