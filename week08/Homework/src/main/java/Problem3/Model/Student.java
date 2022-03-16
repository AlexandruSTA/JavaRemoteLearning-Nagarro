package Problem3.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Student {

    @JsonProperty("id")
    private long id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("dateOfBirth")
    private Date dateOfBirth;
    @JsonProperty("graduated")
    private boolean graduated;
    @JsonProperty("address")
    private Address address;

    public Student() {
    }

    public Student(long id, String firstName, String lastName, Date dateOfBirth, boolean graduated, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.graduated = graduated;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String studentData = "==========STUDENT DATA==========\n";
        studentData += "Id: " + id +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nDate of birth: " + dateOfBirth +
                "\nGraduated: " + graduated +
                "\nAddress: " + address;
        studentData += "==============================";
        return studentData;
    }
}
