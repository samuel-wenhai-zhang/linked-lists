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
        Node curr = head;
        head = head.next;
        return curr.data;
    }

    public void clear() {
        head = null;
    }

    public int get(int index) {
        return getNode(index).data;
    }

    public int set(int index, int newVal) {
        Node node = getNode(index);
        int oldData = node.data;
        node.data = newVal;
        return oldData;
    }

    public void add(int index, int val) {
        if (index == 0) { 
            head = new Node(val, head);
        }
        else {
            Node before = getNode(index - 1);
            before.next = new Node(val, before.next);
        }
    }

    public boolean addAll(int[] vals) {
        if (vals.length == 0) {
            return false;
        }
        for (int val : vals) {
            add(val);
        }
        return true;
    }
    
    public int indexOf(int value) {
        if (head == null) {
            return -1;
        }
        Node nextNode = head;
        int index = 0;
        while (nextNode != null) {
            if (nextNode.data == value) {
                return index;
            }
            nextNode = nextNode.next;
            index++;
        }
        return -1;
    }

    public int remove(int index) {
        if (index == 0) {
            return remove();
        }
        Node prev = getNode(index - 1);
        if (prev.next == null) {
            throw new IndexOutOfBoundsException();
        }
        int toReturn = prev.next.data;
        prev.next = prev.next.next;
        return toReturn;

    }


    private Node getNode(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node nextNode = head;
        while (index > 0 && nextNode != null) {
            nextNode = nextNode.next;
            index--;
        }
        if (nextNode == null) {
            throw new IndexOutOfBoundsException();
        }
        return nextNode;
    }


    public boolean equals(IntLinkedList otherList) {
        if (head == null) {
            return otherList.head == null;
        }
        return head.equals(otherList.head);
    }

    @Override
    public String toString() {
        if (head == null) {
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
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public boolean equals(Node other) {
            if (other == null) {
                return false;
            }
            if (this.next == null && other.next == null) {
                return true;
            }
            return data == other.data && next.equals(other.next);
        }
    } 
}