import java.util.NoSuchElementException;

public class IntLinkedList {

    private Node head;

    public IntLinkedList() {
        head = null;
    }

    public boolean add(int value) {
        if (head == null) {
            head = new Node(value, null);
        } else {
            Node nextNode = head;
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = new Node(value, null);
        }
        return true;
    }

    public int size() {
        int size = 0;
        Node nextNode = head;
        while (nextNode != null) {
            size++;
            nextNode = nextNode.next;
        }
        return size;
    }

    public int remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        else {
            Node curr = head;
            head = head.next;
            return curr.data;
        }
    }

    public void clear() {
        head = null;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        else {
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

    }








    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    } 
}