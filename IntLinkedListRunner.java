public class IntLinkedListRunner {
    public static void main(String[] args) {
        IntLinkedList myList = new IntLinkedList();
        System.out.println(myList); // []
        System.out.println(myList.size());

        myList.add(5);
        System.out.println(myList); // [5]
        System.out.println(myList.size());


        myList.add(10);
        System.out.println(myList); // [5, 10]
        System.out.println(myList.size());


        myList.add(15);
        System.out.println(myList); // [5, 10, 15]
        System.out.println(myList.size());

        while (myList.size() >= 0) {
            System.out.println(myList.remove());
            System.err.println(myList);
        }
    }
}
