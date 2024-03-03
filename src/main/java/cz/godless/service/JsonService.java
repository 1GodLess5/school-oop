package cz.godless.service;

import com.google.gson.stream.JsonReader;
import cz.godless.constant.Constant;
import cz.godless.domain.Clazz;
import cz.godless.domain.Student;
import cz.godless.grades.Grade;
import cz.godless.json.jsonVocabulary;
import cz.godless.subjects.Subject;
import cz.godless.subjects.SubjectsToChoose;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JsonService {
    private final List<Clazz> clazzes;
    private String className;
    private String mainTeacherName;
    private List<Subject> subjects;
    private Subject subject;
    private Map<Student, List<Grade>> studentGrades;
    private Grade grade;
    private List<Grade> grades;
    private Student student;
    private String subjectName;
    private String studentName;

    public JsonService() {
        this.clazzes = new ArrayList<>();
    }

    public void processJsonFile() {
        String filePath = Constant.SCHOOL_FILES_PATH;
        try (JsonReader reader = new JsonReader(new FileReader(filePath))) {
            reader.beginArray(); // Start reading the JSON array
            while (reader.hasNext()) {
                processClazz(reader);
            }
            reader.endArray(); // End of JSON array
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processClazz(JsonReader reader) throws IOException {
        reader.beginObject(); // Start reading the Clazz object
        while (reader.hasNext()) {
            String nextElement = reader.nextName();
            if (jsonVocabulary.CLASS_NAME.getDescription().equals(nextElement)) {
                this.className = reader.nextString();
//                System.out.println("Class Name: " + reader.nextString());
            } else if (jsonVocabulary.MAIN_TEACHER.getDescription().equals(nextElement)) {
//                TODO
                processMainTeacher(reader);
            } else if ("students".equals(nextElement)) {
                processStudents(reader);
            } else {
                reader.skipValue(); // Skip values of other elements
            }
        }
        reader.endObject(); // End of Clazz object
    }

    private void processMainTeacher(JsonReader reader) throws IOException {
        reader.beginObject(); // Start reading the mainTeacher object
        while (reader.hasNext()) {
            String nextElement = reader.nextName();
            if (jsonVocabulary.TEACHER_NAME.getDescription().equals(nextElement)) {
                this.mainTeacherName = reader.nextString();
//                System.out.println("Main Teacher: " + reader.nextString());
            } else if (jsonVocabulary.TEACHING_SUBJECTS.getDescription().equals(nextElement)) {
                processTeachingSubjects(reader);
            } else {
                reader.skipValue(); // Skip values of other elements
            }
        }
        reader.endObject(); // End of mainTeacher object
    }

    private void processTeachingSubjects(JsonReader reader) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            boolean isValidSubject = true;
            while (reader.hasNext()) {
                String nextElement = reader.nextName();
                if (jsonVocabulary.SUBJECT_NAME.getDescription().equals(nextElement)) {
//                    System.out.println("Subject Name: " + reader.nextString());
                    String checkSubject = reader.nextString();

                    if (!isSubjectValid(checkSubject)) {
                        System.out.println("Invalid subject encountered " + checkSubject + "!");
                        isValidSubject = false;
                        break;
                    } else {
                        this.subjectName = checkSubject;
                    }
                } else if (jsonVocabulary.STUDENT_GRADES.getDescription().equals(nextElement)) {
                    if (isValidSubject) {
                        processStudentGrades(reader);
                    } else {
                        reader.skipValue();
                    }
                } else {
                    reader.skipValue();
                }
            }
            reader.endObject();
        }
        reader.endArray();
    }

    private void processStudentGrades(JsonReader reader) throws IOException {
        reader.beginObject();
        while (reader.hasNext()) {
            this.studentName = reader.nextName();
            this.student = new Student(studentName);
//            System.out.println("\tStudent Name: " + studentName);
            reader.beginArray();
            while (reader.hasNext()) {
                reader.beginObject();
                while (reader.hasNext()) {
                    String nextElement = reader.nextName();
                    float gradeValue = 0;
                    if (jsonVocabulary.GRADE.getDescription().equals(nextElement)) {
//                        System.out.println("\t\tGrade: " + reader.nextDouble());
                        gradeValue = (float) reader.nextDouble();
                    } else if (jsonVocabulary.DESCRIPTION.getDescription().equals(nextElement)) {
//                        System.out.println("\t\tDescription: " + reader.nextString());
                        if (gradeValue != 0) {
                            this.grade = new Grade(gradeValue, reader.nextString());
                            this.grades.add(grade);
                        }
//                        TODO CONTINUE HERE
//                         this.studentGrades.put(this.student, this.grades);
//                            this.subject = new Subject(this.subjectName, this.studentGrades);
//                      TODO  MY BRAIN IS FUCKED :}
                    } else {
                        reader.skipValue(); // Skip values of other elements
                    }
                }
                reader.endObject(); // End of grade object
            }
            reader.endArray(); // End of grades array
        }
        reader.endObject(); // End of studentGrades object
    }

    private static void processStudents(JsonReader reader) throws IOException {
        reader.beginArray(); // Start reading the students array
        while (reader.hasNext()) {
            reader.beginObject(); // Start reading a student object
            while (reader.hasNext()) {
                String name = reader.nextName(); // Get the name of the next JSON element
                if ("name".equals(name)) {
                    System.out.println("\tStudent Name: " + reader.nextString());
                } else {
                    reader.skipValue(); // Skip values of other elements
                }
            }
            reader.endObject(); // End of student object
        }
        reader.endArray(); // End of students array
    }

    private boolean isSubjectValid(String subjectNameToCheck) {
        String check =  Stream.of(SubjectsToChoose.values())
                .map(SubjectsToChoose::getDescription)
                .filter(subjectNameToCheck::equals)
                .findFirst()
                .orElse(null);

        return check != null;
    }
}


