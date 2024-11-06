package me.nobugs.homework1.part2.studenttask;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class StudentManager {
    ArrayList<Student> students = new ArrayList<>();

    public void add(Student student) {
        getStudents().add(student);
    }

    public void deleteById(int id) {
        getStudents().removeIf(studentId -> studentId.getStudentId() == id);
    }

    public void getAll() {
        if (getStudents().isEmpty()) {
            System.out.println("The list is empty");
        }

        getStudents().forEach(System.out::println);
    }
}
