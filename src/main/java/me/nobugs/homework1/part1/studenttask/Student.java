package me.nobugs.homework1.part1.studenttask;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Printable {
    private String name;
    private int studentNumber;
    private double gpa;

    @Override
    public void print() {
        System.out.println("Student{" +
                "name='" + getName() + '\'' +
                ", studentNumber=" + getStudentNumber() +
                ", gpa=" + getGpa() +
                '}');
    }
}
