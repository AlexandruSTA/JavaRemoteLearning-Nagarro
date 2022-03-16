package Problem3.Repository;

import Problem3.Model.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository implements StudentCrudRepository {
    private final List<Student> students = new ArrayList<>();

    @Override
    @NotNull
    public Student save(@NotNull Student student) throws IllegalArgumentException {
        if (student == null) {
            throw new IllegalArgumentException("Reference of student is null!");
        }
        if (findById(student.getId()).isPresent()) {
            students.set(students.indexOf(student), student);
        } else {
            students.add(student);
        }

        return student;
    }

    @Override
    public Optional<Student> findById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findAll() {
        return students;
    }

    @Override
    public void deleteById(long id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return;
            }
        }
    }

    @Override
    public String toString() {
        String studentsInfo = "";
        for (Student student : students) {
            studentsInfo += student + "\n";
        }
        return studentsInfo;
    }
}
