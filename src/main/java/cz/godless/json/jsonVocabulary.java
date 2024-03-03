package cz.godless.json;

public enum jsonVocabulary {
    CLASS_NAME("className"),
    MAIN_TEACHER("mainTeacher"),
    TEACHER_NAME("teacherName"),
    TEACHING_SUBJECTS("teachingSubjects"),
    SUBJECT_NAME("subjectName"),
    STUDENT_GRADES("studentGrades")

    ;

    private final String description;


    jsonVocabulary(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
