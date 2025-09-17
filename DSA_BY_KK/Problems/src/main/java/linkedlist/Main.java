package linkedlist;

public class Main {
    public static void main(String[] args) {

        //Singly Linked List
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        singlyLinkedList.addFirst(10);
        singlyLinkedList.addFirst(20);

        singlyLinkedList.addLast(30);
        singlyLinkedList.addLast(40);
        singlyLinkedList.addLast(50);
        singlyLinkedList.addLast(60);

        singlyLinkedList.add(25,2);

        singlyLinkedList.display();
        System.out.println("Deleting first node: "+singlyLinkedList.deleteFirst());
        singlyLinkedList.display();
        System.out.println("Deleting last node: "+singlyLinkedList.deleteLast());
        singlyLinkedList.display();
        System.out.println("Deleting 3rd index node: "+singlyLinkedList.delete(3));
        singlyLinkedList.display();
    }
}
