package lr9.task_5;

//Создание однонаправленного списка с головы

public class unidirectionalList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addHead(10);
        list.addHead(20);
        list.addHead(30);
        list.printList();
    }

}
