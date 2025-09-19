package linkedlist;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public void inserFirst(int value){
        Node node = new Node(value);
        if(head == null){
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    public void inserLast(int value){
        Node node = new Node(value);
        if(head == null){
            inserFirst(value);
            return;
        }

        tail.next = node;
        node.prev = tail;
        tail = node;
    }

    public void insertAfter(int after, int value){
        Node node = find(after);

        if(node == null){
            System.out.println("Element Node found");
            return;
        }

        Node newNode = new Node(value);
        newNode.next = node.next;
        newNode.prev = node;
        node.next = newNode;

        if(newNode.next == null){
            tail = newNode;
        }

    }

    public void insertBefore(int before, int value){
        Node node = find(before);

        if(node == null){
            System.out.println("Element Node found");
            return;
        }

        Node newNode = new Node(value);
        if(node.prev == null){
            inserFirst(value);
        }
        newNode.next = node;
        newNode.prev = node.prev;
        node.prev.next = newNode;  // Update the previous node's next reference
        node.prev = newNode;
    }

    public Integer deleteFirst(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return null;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        return  val;
    }

    public Integer deleteLast(){
        if(tail == null){
            System.out.println("LinkedList is empty");
            return null;
        }
        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        return  val;
    }

    public Integer delete(int value){
        Node node = find(value);

        if(node == null){
            System.out.print("Element Node found ");
            return value;
        }

        if(node.prev == null){
           return deleteFirst();
        }

        if(node.next == null){
            return deleteLast();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        return value;
    }

    private Node find(int value){
        Node node = head;

        while (node!=null){
            if(node.data == value){
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void display(){
        Node node = head;

        while(node != null){
            System.out.print(node.data+"->");
            node = node.next;
        }
        System.out.println("END");
    }

    private class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data, Node prev, Node next) {
            this.prev = prev;
            this.next = next;
            this.data = data;
        }

        public Node(int data) {
            this.data = data;
        }
    }
}
