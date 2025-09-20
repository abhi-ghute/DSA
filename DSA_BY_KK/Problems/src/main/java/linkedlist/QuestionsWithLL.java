package linkedlist;

public class QuestionsWithLL {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        sll.insertRecursively(10, 0);
        sll.insertRecursively(20, 1);
        sll.insertRecursively(20, 1);
        sll.insertRecursively(10, 0);
        sll.addLast(30);
        sll.addLast(30);
        sll.display();
        sll.removeDuplcatesFromSorted();
        sll.display();

    }
}
