package lr9;

//код класс Node, который используется в линейном однонаправленном списке,
// который хранит значение и ссылку на следующий элемент.

class Node { // КЛАСС - СТРУКТУРА ЭЛЕМЕНТА СПИСКА

    public int value; // значение

    public Node next; // поле - ссылка (указатель) на след узел

    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}
