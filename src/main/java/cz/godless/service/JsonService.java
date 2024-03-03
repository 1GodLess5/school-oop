package cz.godless.service;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import cz.godless.constant.Constant;

import java.io.FileReader;
import java.io.IOException;

public class JsonService {
    public static void processJsonFile() {
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

    private static void processClazz(JsonReader reader) throws IOException {
        reader.beginObject(); // Start reading the Clazz object
        while (reader.hasNext()) {
            String name = reader.nextName(); // Get the name of the next JSON element
            if ("name".equals(name)) {
                System.out.println("Class Name: " + reader.nextString());
            } else if ("mainTeacher".equals(name)) {
                processMainTeacher(reader);
            } else if ("students".equals(name)) {
                processStudents(reader);
            } else {
                reader.skipValue(); // Skip values of other elements
            }
        }
        reader.endObject(); // End of Clazz object
    }

    private static void processMainTeacher(JsonReader reader) throws IOException {
        reader.beginObject(); // Start reading the mainTeacher object
        while (reader.hasNext()) {
            String name = reader.nextName(); // Get the name of the next JSON element
            if ("name".equals(name)) {
                System.out.println("Main Teacher: " + reader.nextString());
            } else if ("teachingSubjects".equals(name)) {
                processTeachingSubjects(reader);
            } else {
                reader.skipValue(); // Skip values of other elements
            }
        }
        reader.endObject(); // End of mainTeacher object
    }

    private static void processTeachingSubjects(JsonReader reader) throws IOException {
        reader.beginArray(); // Start reading the teachingSubjects array
        while (reader.hasNext()) {
            reader.beginObject(); // Start reading a teachingSubject object
            while (reader.hasNext()) {
                String name = reader.nextName(); // Get the name of the next JSON element
                if ("subjectName".equals(name)) {
                    System.out.println("Subject Name: " + reader.nextString());
                } else if ("studentGrades".equals(name)) {
                    processStudentGrades(reader);
                } else {
                    reader.skipValue(); // Skip values of other elements
                }
            }
            reader.endObject(); // End of teachingSubject object
        }
        reader.endArray(); // End of teachingSubjects array
    }

    private static void processStudentGrades(JsonReader reader) throws IOException {
        reader.beginObject(); // Start reading the studentGrades object
        while (reader.hasNext()) {
            String studentName = reader.nextName(); // Get the student name
            System.out.println("\tStudent Name: " + studentName);
            reader.beginArray(); // Start reading the grades array
            while (reader.hasNext()) {
                reader.beginObject(); // Start reading a grade object
                while (reader.hasNext()) {
                    String gradeType = reader.nextName(); // Get the grade type
                    if ("grade".equals(gradeType)) {
                        System.out.println("\t\tGrade: " + reader.nextDouble());
                    } else if ("description".equals(gradeType)) {
                        System.out.println("\t\tDescription: " + reader.nextString());
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

    public static void main(String[] args) {
        String filePath = "path/to/your/json/file.json";
        processJsonFile(filePath);
    }
}
