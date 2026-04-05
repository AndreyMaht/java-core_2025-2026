package lr10.task_2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CreateXMLFILE {

    static class Book {
        String title;
        String author;
        String year;

        Book(String title, String author, String year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }


    }

    private static List<Book> books = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);
    private static final String FILE_PATH = "src/lr10/task_2/example.xml";

    public static void main(String[] args) {

        books.add(new Book("Война и мир", "Лев Толстой", "1869"));
        books.add(new Book("Мастер и Маргарита", "Михаил Булгаков", "1967"));
        books.add(new Book("Преступление и наказание", "Фёдор Достоевский", "1866"));

        boolean running = true;
        while (running) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Добавить новую книгу");
            System.out.println("2. Поиск книг по автору");
            System.out.println("3. Поиск книг по году издания");
            System.out.println("4. Удалить книгу по названию");
            System.out.println("5. Сохранить в XML и выйти");
            System.out.print("Выберите действие: ");

            int choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1:
                    addNewBook();
                    break;
                case 2:
                    searchByAuthor();
                    break;
                case 3:
                    searchByYear();
                    break;
                case 4:
                    saveToXmlAndExit();
                    running = false;
                    break;
                case 5:
                    deleteBookByTitle();
                    break;
                default:
                    System.out.println("Неверный пункт. Введите 1, 2, 3 или 4.");
            }
        }
        in.close();

    }

    private static void addNewBook() {
        System.out.print("Название: ");
        String title = in.nextLine();
        System.out.print("Автор: ");
        String author = in.nextLine();
        System.out.print("Год издания: ");
        String year = in.nextLine();
        books.add(new Book(title, author, year));
        System.out.println("Книга добавлена!");
    }

    private static void searchByAuthor() {
        System.out.print("Введите автора (полностью или частично): ");
        String query = in.nextLine().toLowerCase();

        List<Book> found = books.stream()
                .filter(book -> book.author.toLowerCase().contains(query))
                .collect(Collectors.toList());

        printResult(found, "автору \"" + query + "\"");
    }

    private static void searchByYear() {
        System.out.print("Введите год издания: ");
        String query = in.nextLine();

        List<Book> found = books.stream()
                .filter(book -> book.year.equals(query))
                .collect(Collectors.toList());

        printResult(found, "году " + query);
    }

    private static void printResult(List<Book> found, String criteria) {
        if (found.isEmpty()) {
            System.out.println("Книги по " + criteria + " не найдены.");
        } else {
            System.out.println("\nНайдено книг: " + found.size());
            for (Book book : found) {
                System.out.println("  • " + book);
            }
        }
    }

    private static void deleteBookByTitle() {
        System.out.print("Введите название: ");
        String title = in.nextLine();
        boolean removed = books.removeIf(book -> book.title.equalsIgnoreCase(title));
        if (removed) {
            System.out.println("Книга удалена.");
        } else {
            System.out.println("Не найдено.");
        }
    }

    private static void saveToXmlAndExit() {
        createXMLWithBooks(books, FILE_PATH);
        System.out.println("XML-файл сохранён. Всего книг: " + books.size());
        System.out.println("До свидания!");
    }

    public static void createXMLWithBooks (List<Book> books, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("library");
            doc.appendChild(rootElement);

            for (Book book : books) {
                Element bookElement = doc.createElement("book");
                rootElement.appendChild(bookElement);

                // title
                Element titleElement = doc.createElement("title");
                titleElement.appendChild(doc.createTextNode(book.title));
                bookElement.appendChild(titleElement);

                // author
                Element authorElement = doc.createElement("author");
                authorElement.appendChild(doc.createTextNode(book.author));
                bookElement.appendChild(authorElement);

                // year
                Element yearElement = doc.createElement("year");
                yearElement.appendChild(doc.createTextNode(book.year));
                bookElement.appendChild(yearElement);
            }

            File outputFile = new File(filePath);
            File parentDir = outputFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                boolean created = parentDir.mkdirs();
                if (!created) {
                    throw new RuntimeException("Не удалось создать директорию: " + parentDir.getAbsolutePath());
                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);

        } catch (Exception pce) {
            pce.printStackTrace();
        }
    }

}