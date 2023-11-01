import java.util.NoSuchElementException;

public class SortedLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public SortedLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int n) {
        if (size == 0) {
            Node node = new Node(n, null, null);     
            head = node;
            tail = node;
        }
        else if (n <= head.data) {
            Node node = new Node(n, null, head);
            head.prev = node;
            head = node;
        }
        else if (n >= tail.data) {
            Node node = new Node(n, tail, null);
            tail.next = node;
            tail = node;
        }
        else {
            Node nextNode = head;
            while (n > nextNode.data) {
                nextNode = nextNode.next;
            }
            Node prevNode = nextNode.prev;
            Node node = new Node(n, prevNode, nextNode);
            prevNode.next = node;
            nextNode.prev = node;
        }
        size++;
    }

    public void addAll(int[] ns) {
        for (int n : ns) {
            add(n);
        }        
    }

    public int removeFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node oldNode = head;
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            head = oldNode.next;
            head.prev = null;
        }
        size--;
        return oldNode.data;
    }

    public int peekFront() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.data;
    }

    public int removeBack() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node oldNode = tail;
        if (size == 1) {
            head = null;
            tail = null;
        }
        else {
            tail = oldNode.prev;
            tail.next = null;
        }
        size--;
        return oldNode.data;
    }

    public int peekBack() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String result = "[";
        result += head.data;

        Node nextNode = head.next;
        while (nextNode != null) {
            result += ", " + nextNode.data;
            nextNode = nextNode.next;
        }
        result += "]";
        return result;
    }

    private static class Node {
        private int data;
        private Node prev;
        private Node next;

        private Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

}
