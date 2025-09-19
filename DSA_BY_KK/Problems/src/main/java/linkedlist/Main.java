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

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.inserFirst(30);
        dll.inserFirst(20);
        dll.inserFirst(10);
        dll.inserLast(40);
        dll.inserLast(55);
        dll.inserLast(60);
        dll.insertAfter(40,50);
        dll.insertAfter(60,70);
        dll.insertBefore(70,65);
        dll.insertBefore(40,35);
        dll.display();
        System.out.println("Deleting first element: "+ dll.deleteFirst());
        dll.display();
        System.out.println("Deleting last element: "+ dll.deleteLast());
        dll.display();
        System.out.println("Deleting 35 value node: "+ dll.delete(35));
        dll.display();

        //Circular LinkedList
        System.out.println("Circular Linked List: ");
        CircularLinkedList cll = new CircularLinkedList();

        cll.addFirst(30);
        cll.addFirst(20);
        cll.addFirst(10);
        cll.addLast(40);
        cll.addLast(50);
        cll.addLast(60);
        cll.insertAfter(40,45);
        cll.insertAfter(60,65);
        cll.display();
        System.out.println("Deleting first: "+cll.deleteFirst());
        cll.display();
        System.out.println("Deleting last: "+cll.deleteLast());
        cll.display();
        System.out.println("Deleting 50: "+cll.delete(50));
        cll.display();
    }
}
