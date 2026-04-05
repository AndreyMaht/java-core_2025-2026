package lr10.task_3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class JSONcreator {

    private static final String FILE_PATH = "src/lr10/task_3/library.json";
    private static JSONObject library;
    private static JSONArray booksArray;

    public static void main(String[] args) {
        loadOrCreateLibrary();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Поиск книг по автору");
            System.out.println("2. Добавить новую книгу");
            System.out.println("3. Удалить книгу по названию");
            System.out.println("4. Сохранить и выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    searchByAuthor(scanner);
                    break;
                case 2:
                    addNewBook(scanner);
                    break;
                case 3:
                    deleteBookByTitle(scanner);
                    break;
                case 4:
                    saveLibraryToFile();
                    System.out.println("Изменения сохранены.");
                    running = false;
                    break;
                default:
                    System.out.println("Неверный пункт. Введите 1, 2, 3 или 4.");
            }
        }
        scanner.close();
    }

    private static void loadOrCreateLibrary() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                JSONParser parser = new JSONParser();
                library = (JSONObject) parser.parse(reader);
                booksArray = (JSONArray) library.get("books");
                System.out.println("Загружено книг: " + booksArray.size());
            } catch (Exception e) {
                System.err.println("Ошибка загрузки: " + e.getMessage());
                createDefaultLibrary();
            }
        } else {
            createDefaultLibrary();
        }
    }

    private static void createDefaultLibrary() {
        library = new JSONObject();
        booksArray = new JSONArray();

        JSONObject book1 = new JSONObject();
        book1.put("title", "Война и мир");
        book1.put("author", "Лев Толстой");
        book1.put("year", 1869);

        JSONObject book2 = new JSONObject();
        book2.put("title", "Мастер и Маргарита");
        book2.put("author", "Михаил Булгаков");
        book2.put("year", 1967);

        JSONObject book3 = new JSONObject();
        book3.put("title", "Преступление и наказание");
        book3.put("author", "Фёдор Достоевский");
        book3.put("year", 1866);

        booksArray.add(book1);
        booksArray.add(book2);
        booksArray.add(book3);
        library.put("books", booksArray);

        saveLibraryToFile();
        System.out.println("Создан новый файл библиотеки с 3 книгами.");
    }

    private static void saveLibraryToFile() {
        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(library.toJSONString());
        } catch (Exception e) {
            System.err.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    private static void searchByAuthor(Scanner scanner) {
        System.out.print("Введите автора: ");
        String query = scanner.nextLine().toLowerCase();

        for (Object obj : booksArray) {
            JSONObject book = (JSONObject) obj;
            String author = (String) book.get("author");
            if (author.toLowerCase().contains(query)) {
                System.out.println("Название: " + book.get("title"));
                System.out.println("Автор: " + author);
                System.out.println("Год: " + book.get("year"));
                System.out.println("---");
            }
        }

    }

    private static void addNewBook(Scanner scanner) {
        System.out.print("Название: ");
        String title = scanner.nextLine();
        System.out.print("Автор: ");
        String author = scanner.nextLine();
        System.out.print("Год издания: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        JSONObject newBook = new JSONObject();
        newBook.put("title", title);
        newBook.put("author", author);
        newBook.put("year", year);
        booksArray.add(newBook);

        saveLibraryToFile();
        System.out.println("Книга добавлена и сохранена.");
    }

    private static void deleteBookByTitle(Scanner scanner) {
        System.out.print("Введите точное название книги: ");
        String title = scanner.nextLine();

        Iterator<?> iterator = booksArray.iterator();
        boolean removed = false;
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj instanceof JSONObject) {
                JSONObject book = (JSONObject) obj;
                if (book.get("title").equals(title)) {
                    iterator.remove();
                    removed = true;
                    break;
                }
            }
        }

        if (removed) {
            saveLibraryToFile();
            System.out.println("Книга \"" + title + "\" удалена.");
        } else {
            System.out.println("Книга с названием \"" + title + "\" не найдена.");
        }
    }

}
