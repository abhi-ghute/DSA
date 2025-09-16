package linkedlist;

public class SinglyLinkedList {

    private Node head;
    private Node tail;

    private static class Node{
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null){
            tail = node;
        }
    }

    public void addLast(int value){

        if (tail == null) {
            addFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
    }

    public void display(){
        Node temp = head;

        while (temp !=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("END");

    }

}
