public class IntLinkedListRunner {
    public static void main(String[] args) {
        IntLinkedList myList = new IntLinkedList();
        int[] vals = {1, 3, 10, -3, 18, 27};
        myList.addAll(vals);
        System.out.println(myList.indexOf(0));
        System.out.println(myList.indexOf(3));

    }
}
