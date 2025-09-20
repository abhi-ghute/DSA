package linkedlist;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = node;
        }
        size++;
    }

    public void add(int value, int position){
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if(position == 0){
            addFirst(value);
            return;
        }else if(position == size){
            addLast(value);
            return;
        }

        Node temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        Node node = new Node(value,temp.next);
        temp.next = node;
        size++;
    }

    public void addLast(int value){

        if (tail == null) {
            addFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public int deleteFirst(){
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }

        int value = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }

    public int deleteLast(){
        if(size == 1){
            return deleteFirst();
        }

        Node secondLast = get(size-2);
        int value = tail.data;
        secondLast.next = null;
        tail = secondLast;
        size--;
        return value;
    }

    public int delete(int position){
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        if(size == 1){
            return deleteFirst();
        }

        if(position == size-1){
            return deleteLast();
        }

        Node previous = get(position-1);
        int value = previous.next.data;
        Node deleteNode = previous.next;
        previous.next = previous.next.next;
        deleteNode.next = null;
        size--;
        return value;
    }

    public Node get(int position){

        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }

        Node temp = head;

        for(int i=0;i<position;i++){
            temp = temp.next;
        }
        return temp;
    }

    public void display(){
        Node temp = head;

        while (temp !=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("END");

    }

    //------------------------Questions------------------------------
    public void insertRecursively(int value, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        head = insertRec(head, value, index);
    }

    private Node insertRec(Node current, int value, int index) {

        if(index == 0){
           Node node = new Node(value);
           node.next = current;
           size++;
           if (node.next == null) {
                tail = node;
           }
           return node;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        current.next = insertRec(current.next, value,index-1);
        return current;
    }

    public void removeDuplcatesFromSorted(){
        Node node = head;

        if(node == null){
            return;
        }

        while (node.next != null) {
            if (node.data == node.next.data) {
                // Skip the duplicate node
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
        tail = node;
    }
}
