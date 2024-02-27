package cz.godless.grades;

public class Grade {
    private final float grade;
    private final String description;


    public Grade(float grade, String description) {
        this.grade = grade;
        this.description = description;
    }

    public float getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }
}
