package me.nobugs.homework1.part1;

import me.nobugs.homework1.part1.booktask.Book;
import me.nobugs.homework1.part1.cartask.Car;
import me.nobugs.homework1.part1.clocktask.Clock;
import me.nobugs.homework1.part1.pointtask.Point;
import me.nobugs.homework1.part1.studenttask.Student;

public class Runner {

    public static void main(String[] args) {
        testBookTask();
        testStudentTask();
        testPointTask();
        testClockTask();
        testCarTask();
    }

    /**
     * Задача "Книга":
     * Создайте класс Book с полями для хранения названия, автора и года издания. Реализуйте методы
     * для получения и установки этих полей. Создайте интерфейс Displayable с
     * методом display(), который реализуется в классе Book для отображения информации о книге.
     */
    public static void testBookTask() {
        Book book = new Book("Мастер и Маргарита", "Булгаков", 1966);
        book.display();

        Book book2 = new Book();
        book2.setBookTitle("Война и Мир");
        book2.setAuthor("Толстой");
        book2.setPubYear(1869);
        book2.display();
    }

    /**
     * Задача "Студент":
     * Создайте класс Student с полями для хранения имени, номера зачётной книжки и среднего балла.
     * Реализуйте методы для получения и установки этих полей.
     * Создайте интерфейс Printable с методом print(), аналогично задаче "Банковский счёт", для вывода информации о студенте.
     */
    public static void testStudentTask() {
        Student student = new Student("Ivan Ivanov", 169890, 4.9);
        student.print();

        Student student2 = new Student();
        student2.setName("Vasya Pupkin");
        student2.setStudentNumber(123789);
        student2.setGpa(3.0);
        student2.print();
    }

    /**
     * Задача "Точка на плоскости":
     * Создайте класс Point с приватными полями x и y для координат точки на плоскости.
     * Реализуйте методы для получения (get) и установки (set) этих полей.
     * Создайте интерфейс Movable с методами moveUp(), moveDown(), moveLeft() и moveRight() для изменения положения точки.
     */
    public static void testPointTask() {
        Point point = new Point(5.0, 5.0);
        point.moveDown();
        point.moveRight();
        point.moveDown();
        System.out.println("X is " + point.getX());
        System.out.println("Y is " + point.getY());

        Point point2 = new Point();
        point2.setX(23.0);
        point2.setY(-3.0);
        point2.moveLeft();
        System.out.println("X is " + point2.getX());
        System.out.println("Y is " + point2.getY());
    }

    /**
     * Задача "Часы":
     * Создайте класс Clock с полями для хранения часов, минут и секунд.
     * Реализуйте методы для установки времени и получения текущего времени, а также метод tick()
     * для увеличения времени на одну секунду. Создайте интерфейс Readable с методом readTime(),
     * который возвращает текущее время.
     */
    public static void testClockTask() {
        Clock clock = new Clock();
        clock.setHour(15);
        clock.setMinutes(30);
        clock.setSeconds(29);

        clock.readTime();
        clock.tick();
        clock.readTime();
    }

    /**
     * Задача "Автомобиль":
     * Создайте класс Car с полями для марки, модели и года выпуска.
     * Реализуйте методы для получения и установки этих полей.
     * Создайте интерфейс Drivable с методами start(), stop() и drive(distance),
     * которые реализует класс Car для имитации движения автомобиля.
     */
    public static void testCarTask() {
        Car car = new Car();
        car.setBrand("Mercedes");
        car.setModel("Maybach");
        car.setManufactureYear(2020);

        car.start();
        car.drive(1.5);
        car.stop();
    }
}
