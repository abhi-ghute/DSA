package linkedlist;

public class Main {
    public static void main(String[] args) {

        //Singly Linked List
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addFirst(10);
        singlyLinkedList.addFirst(20);

        singlyLinkedList.addLast(30);

        singlyLinkedList.display();
        singlyLinkedList.display();
    }
}
