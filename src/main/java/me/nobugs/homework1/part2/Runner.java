package me.nobugs.homework1.part2;

import me.nobugs.homework1.part2.booktask.Book;
import me.nobugs.homework1.part2.booktask.BookCollection;
import me.nobugs.homework1.part2.musictracktask.MusicGenre;
import me.nobugs.homework1.part2.musictracktask.MusicLibrary;
import me.nobugs.homework1.part2.musictracktask.MusicTrack;
import me.nobugs.homework1.part2.producttask.PriceList;
import me.nobugs.homework1.part2.producttask.Product;
import me.nobugs.homework1.part2.studenttask.Student;
import me.nobugs.homework1.part2.studenttask.StudentManager;
import me.nobugs.homework1.part2.taskmanagetask.Priority;
import me.nobugs.homework1.part2.taskmanagetask.Task;
import me.nobugs.homework1.part2.taskmanagetask.TaskManager;

public class Runner {
    public static void main(String[] args) {
        testStudentManageTask();
        testBookCollectionTask();
        testTaskManageTask();
        testMusicLibraryTask();
        testProductTask();
    }

    /**
     * Управление списком студентов:
     * Создайте класс Student с полями для хранения имени и ID студента.
     * В классе StudentManager используйте ArrayList<Student> для хранения списка студентов.
     * Реализуйте методы для добавления нового студента в список, удаления студента по ID и получения списка всех студентов.
     */
    public static void testStudentManageTask() {
        Student student = new Student();
        student.setStudentId(180140);
        student.setStudentName("Candice Pool");

        StudentManager studentManager = new StudentManager();
        studentManager.add(student);
        studentManager.add(new Student("James Backstore", 333));
        studentManager.add(new Student("John Doe", 11));
        System.out.println("The list is: ");
        studentManager.getAll();
        studentManager.deleteById(333);
        System.out.println("The list after deleting: ");
        studentManager.getAll();
    }

    /**
     * Универсальный набор книг:
     * Создайте класс Book с полями для названия и автора.
     * В классе BookCollection используйте HashSet<Book> для хранения коллекции книг без дубликатов.
     * Реализуйте методы для добавления книги в коллекцию, удаления книги из коллекции и проверки, содержится ли книга в коллекции.
     */
    public static void testBookCollectionTask() {
        BookCollection bookCollection = new BookCollection();

        Book book1 = new Book("Человек, который смеется", "Гюго");
        Book book2 = new Book("Алые паруса", "Грин");

        bookCollection.addBook(new Book("Мастер и Маргарита", "Булгаков"));
        bookCollection.addBook(new Book("Похороните меня за плинтусом", "Санаев"));
        bookCollection.addBook(book1);

        bookCollection.printBooks();
        System.out.println(bookCollection.isPresentInCollection(book1));
        System.out.println(bookCollection.isPresentInCollection(book2));

        bookCollection.deleteBook(book1);

        bookCollection.printBooks();
    }

    /**
     * Список дел с приоритетами:
     * Создайте класс Task с полями для описания задачи и её приоритета.
     * В классе TaskManager используйте ArrayList<Task> для хранения списка задач.
     * Реализуйте методы для добавления задачи в список, удаления задачи из списка и сортировки списка задач по приоритету перед выводом.
     */
    public static void testTaskManageTask() {
        TaskManager manager = new TaskManager();

        Task task = new Task("Помыть руки", Priority.HIGH);
        manager.addTask(task);
        manager.addTask(new Task("Помыть кота", Priority.MEDIUM));
        manager.addTask(new Task("Выучить китайский", Priority.LOW));
        manager.addTask(new Task("Работать работу", Priority.MEDIUM));
        manager.addTask(new Task("Сделать маникюр", Priority.HIGH));

        manager.displayTasksByPriority();

        manager.deleteTask(task);

        manager.displayTasksByPriority();
    }

    /**
     * Каталог музыкальных треков:
     * Создайте класс MusicTrack с полями для названия трека, исполнителя и жанра.
     * В классе MusicLibrary используйте HashMap<String, List<MusicTrack>> для организации музыкальных треков по жанрам,
     * где ключом является жанр, а значением – набор треков этого жанра.
     * Реализуйте методы для добавления трека в библиотеку, удаления трека из библиотеки и получения всех треков заданного жанра.
     */
    public static void testMusicLibraryTask() {
        MusicLibrary library = new MusicLibrary();

        MusicTrack track = new MusicTrack("Bloody Party", "INSTASAMKA", MusicGenre.RAP);
        library.addTrack(new MusicTrack("Coco Jamboo", "Mr.President", MusicGenre.REGGAE));
        library.addTrack(new MusicTrack("Bad Romance", "Lady Gaga", MusicGenre.POP));
        library.addTrack(new MusicTrack("GO GO", "INSTASAMKA", MusicGenre.POP));
        library.addTrack(track);

        library.printLibrary();
        System.out.println(library.getTracksByGenre(MusicGenre.POP));
        library.removeTrack(track);
        library.printLibrary();
    }

    /**
     * Отображение товаров и их цен:
     * Создайте класс Product с полями для наименования и цены товара.
     * В классе PriceList используйте HashMap<String, Double> для хранения списка товаров,
     * где ключом является название товара, а значением – его цена.
     * Реализуйте методы для добавления нового товара в список с его ценой,
     * изменения цены товара и получения цены товара по его названию.
     */
    public static void testProductTask() {
        PriceList priceList = new PriceList();

        Product bibka = new Product("Big bipka", 120.0);
        priceList.addProduct(new Product("Bibka", 12.0));
        priceList.addProduct(bibka);
        priceList.printPriceList();
        priceList.updatePrice(bibka.getProductName(), 300.0);
        priceList.printPriceList();
    }
}
