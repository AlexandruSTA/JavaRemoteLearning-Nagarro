package Problem3.Utils;

import Problem3.Model.Address;
import Problem3.Model.Student;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONManager {
    public static List<Student> extractStudents(String filePath) throws IOException {
        List<Student> extractedStudents = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(filePath)) {
            Object studentsRaw = jsonParser.parse(reader);
            JSONArray students = (JSONArray) studentsRaw;
            students.forEach(s -> {
                try {
                    extractedStudents.add(parseStudent((JSONObject) s));

                } catch (java.text.ParseException e) {
                    System.out.println(e.getMessage());
                }
            });
            return extractedStudents;
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Student parseStudent(JSONObject studentRaw) throws java.text.ParseException {
        Long id = (Long) studentRaw.get("id");
        String firstName = (String) studentRaw.get("firstName");
        String lastName = (String) studentRaw.get("lastName");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = formatter.parse((String) studentRaw.get("dateOfBirth"));
        Boolean graduated = (Boolean) studentRaw.get("graduated");
        JSONObject address = (JSONObject) studentRaw.get("address");

        var parsedStudent = new Student();
        parsedStudent.setId(id);
        parsedStudent.setFirstName(firstName);
        parsedStudent.setLastName(lastName);
        parsedStudent.setDateOfBirth(dateOfBirth);
        parsedStudent.setGraduated(graduated);
        parsedStudent.setAddress(parseAddress(address));

        return parsedStudent;
    }

    public static Address parseAddress(JSONObject addressRaw) {
        String addressName = (String) addressRaw.get("address");
        String city = (String) addressRaw.get("city");
        String zipcode = (String) addressRaw.get("zipcode");

        Address address = new Address();
        address.setAddressLine(addressName);
        address.setCity(city);
        address.setZipcode(zipcode);
        return address;
    }

    public static void updateStudents(String filePath, List<Student> students) {
        JSONArray updatedStudents = new JSONArray();
        students.forEach(student -> updatedStudents.add(createStudentJSON(student)));

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(updatedStudents.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject createStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put("id", student.getId());
        studentDetails.put("firstName", student.getFirstName());
        studentDetails.put("lastName", student.getLastName());
        studentDetails.put("dateOfBirth", new SimpleDateFormat("dd-MM-yyyy").format(student.getDateOfBirth()));
        studentDetails.put("graduated", student.isGraduated());
        studentDetails.put("address", createAddressJSON(student.getAddress()));
        return studentDetails;
    }

    public static JSONObject createAddressJSON(Address address) {
        JSONObject addressDetails = new JSONObject();
        addressDetails.put("city", address.getCity());
        addressDetails.put("zipcode", address.getZipcode());
        addressDetails.put("address", address.getAddressLine());
        return addressDetails;
    }
}
