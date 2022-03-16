package Problem3;

import Problem3.Model.Address;
import Problem3.Model.Student;
import Problem3.Repository.StudentRepository;
import Problem3.Utils.JSONManager;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class App {
    private final static String filepath = System.getProperty("user.dir") + "\\src\\main\\java\\Problem3\\JSON\\Students.json";

    public static void main(String[] args) {
        StudentRepository students = new StudentRepository();

        try {
            extractStudents(students, Objects.requireNonNull(JSONManager.extractStudents(filepath)));
            students.deleteById(776040234863577674L);
            extractStudents(students, generateRandomListOfStudents(5));
            System.out.println(students);
            updateStudents((List<Student>) students.findAll());
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

    public static void updateStudents(List<Student> students) {
        JSONManager.updateStudents(filepath, students);
    }

    public static void extractStudents(StudentRepository students, List<Student> studentsFromJSON) {
        for (Student student : studentsFromJSON) {
            students.save(student);
        }
    }

    public static List<Student> generateRandomListOfStudents(int size) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            students.add(generateRandomStudent());
        }
        return students;
    }

    public static Student generateRandomStudent() {
        Random random = new Random();
        long id = Math.abs(random.nextLong());
        String firstName = getAlphaNumericString(10);
        String lastName = getAlphaNumericString(10);
        Date dateOfBirth = Date.valueOf(LocalDate.now());
        boolean graduated = random.nextBoolean();
        Address address = generateRandomAddress();
        return new Student(id, firstName, lastName, dateOfBirth, graduated, address);

    }

    public static Address generateRandomAddress() {
        String city = getAlphaNumericString(10);
        String zipcode = getAlphaNumericString(10);
        String address = getAlphaNumericString(10);
        return new Address(city, zipcode, address);
    }

    public static String getAlphaNumericString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }


}
