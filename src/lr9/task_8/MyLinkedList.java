package lr9.task_8;

import java.util.Scanner;

public class MyLinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public void createHead() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа (для окончания введите -1):");
        while (true) {
            int x = in.nextInt();
            if (x == -1) break;
            addFirst(x);
        }
    }

    public void createTail() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа (для окончания введите -1):");
        while (true) {
            int x = in.nextInt();
            if (x == -1) break;
            addLast(x);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    // Добавление в начало
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        if (tail == null) tail = head; // если список был пуст
    }

    // Добавление в конец
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Вставка по индексу (нумерация с 0)
    public void insert(int pos, int data) {
        if (pos < 0) throw new IllegalArgumentException("Индекс не может быть отрицательным");
        if (pos == 0) {
            addFirst(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
            current = current.next;
        }
        if (current == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        if (newNode.next == null) tail = newNode; // если вставили в конец
    }

    // Удаление первого элемента
    public void removeFirst() {
        if (head == null) throw new IllegalStateException("Список пуст");
        head = head.next;
        if (head == null) tail = null; // список стал пустым
    }

    // Удаление последнего элемента
    public void removeLast() {
        if (head == null) throw new IllegalStateException("Список пуст");
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    // Удаление элемента по индексу
    public void remove(int pos) {
        if (pos < 0) throw new IllegalArgumentException("Индекс не может быть отрицательным");
        if (pos == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            if (current == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
            current = current.next;
        }
        if (current == null || current.next == null) throw new IndexOutOfBoundsException("Индекс за пределами списка");
        current.next = current.next.next;
        if (current.next == null) tail = current; // если удалили последний
    }

    // Рекурсивный ввод с головы (добавление в начало)
    public void createHeadRec() {
        head = null;
        tail = null;
        createHeadRecHelper();
    }
    private void createHeadRecHelper() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == -1) return;
        // добавляем в начало
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        if (tail == null) tail = head;
        createHeadRecHelper();
    }

    // Рекурсивный ввод с хвоста (добавление в конец)
    public void createTailRec() {
        head = null;
        tail = null;
        createTailRecHelper();
    }
    private void createTailRecHelper() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == -1) return;
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        createTailRecHelper();
    }

    // Рекурсивный вывод в строку
    public String toStringRec() {
        return toStringRecHelper(head);
    }
    private String toStringRecHelper(Node current) {
        if (current == null) return "";
        String rest = toStringRecHelper(current.next);
        if (rest.isEmpty()) {
            return Integer.toString(current.data);
        } else {
            return current.data + " -> " + rest;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        System.out.println("Итеративное создание с головы:");
        list.createHead();
        System.out.println("Список: " + list.toString());

        list.addFirst(10);
        System.out.println("После addFirst(10): " + list);
        list.addLast(20);
        System.out.println("После addLast(20): " + list);
        list.insert(2, 99);
        System.out.println("После insert(2, 99): " + list);
        list.removeFirst();
        System.out.println("После removeFirst(): " + list);
        list.removeLast();
        System.out.println("После removeLast(): " + list);
        list.remove(1);
        System.out.println("После remove(1): " + list);


        System.out.println("\nРекурсивное создание с хвоста:");
        list.createTailRec();
        System.out.println("Список: " + list.toStringRec());
    }
}