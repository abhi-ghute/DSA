package linkedlist;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    private class Node{
        int data;
        Node next;

        private Node(int data){
            this.data = data;
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);

        if (head ==null){
            tail = node;
            head = node;
            tail.next = head;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;

    }

    public void addLast(int value){
        Node node = new Node(value);

        if (head ==null){
            addFirst(value);
            return;
        }

        node.next = tail.next;
        tail.next = node;
        tail = node;
    }

    public void insertAfter(int after, int value){
        Node node = find(after);
        if (node == null){
            System.out.println("No node present with value after");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = node.next;

        if (node.next == head){
            tail = newNode;
        }
        node.next = newNode;

    }

    public Integer deleteFirst(){
        if(head ==null){
            System.out.println("No Node in LinkedList..");
            return null;
        }
        int value = head.data;
        head = head.next;
        tail.next = head;
        return value;
    }

    public Integer deleteLast(){
        if (head == null) {
            System.out.println("List is empty.");
            return null;
        }

        int value = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
            return value;
        }

        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = head;
        tail = current;

        return value;
    }

    public Integer delete(int value) {
        if (head == null) {
            return null;
        }

        Node node = find(value);
        // Case 1: Only one node
        if (node == head) {
            return deleteFirst();
        }

        // Case 2: Delete head
        if (node == tail) {
            return deleteLast();
        }

        // Case 3: Delete non-head node
        Node current = head;
        Node prev = null;

        do {
            prev = current;
            current = current.next;

            if (current.data == value) {
                int deletedValue = current.data;
                prev.next = current.next;

                // Case 4: Deleting tail
                if (current == tail) {
                    tail = prev;
                }

                return deletedValue;
            }
        } while (current != head);

        return null;
    }

    private Node find(int value){

        if (head  == null){
            return null;
        }

        Node node = head;

        do{
            if (node.data == value){
                return node;
            }
            node = node.next;
        }while (node != head);

        return null;
    }

    public void display(){
        if (head==null){
            System.out.println("Linked List is empty");
            return;
        }

        Node node = head;
        do{
            System.out.print(node.data+"->");
            node = node.next;
        }while (node != head);
        System.out.println("HEAD");
    }
}
