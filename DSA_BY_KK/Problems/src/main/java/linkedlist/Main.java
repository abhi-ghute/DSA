package linkedlist;

public class Main {
    public static void main(String[] args) {

        //Singly Linked List
        System.out.println("Singly Linked List");
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

        System.out.println("==================================================================");
        System.out.println("Doubly Linked List");

        DoublyLinkedList ddl = new DoublyLinkedList();

        ddl.inserFirst(30);
        ddl.inserFirst(20);
        ddl.inserFirst(10);
        ddl.inserLast(40);
        ddl.inserLast(55);
        ddl.inserLast(60);
        ddl.insertAfter(40,50);
        ddl.insertAfter(60,70);
        ddl.insertBefore(70,65);
        ddl.insertBefore(40,35);
        ddl.display();

    }
}
