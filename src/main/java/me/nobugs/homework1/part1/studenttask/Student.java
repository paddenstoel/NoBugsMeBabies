package me.nobugs.homework1.part1.studenttask;

public class Student implements Printable {
    private String name;
    private int studentNumber;
    private double gpa;

    public Student() {
    }

    public Student(String name, int studentNumber, double gpa) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void print() {
        System.out.println("Student{" +
                "name='" + getName() + '\'' +
                ", studentNumber=" + getStudentNumber() +
                ", gpa=" + getGpa() +
                '}');
    }
}
