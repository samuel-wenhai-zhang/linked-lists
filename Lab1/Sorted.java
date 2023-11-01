import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class Sorted {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("sorted.dat"));
        while (in.hasNextLine()) {
            SortedLinkedList list = new SortedLinkedList();

            String line = in.nextLine();
            Scanner reader = new Scanner(line);            
            while (reader.hasNextInt()) {
                list.add(reader.nextInt());
            }

            String result = "";
            for (int i = 0; i < 5; i++) {
                result += list.removeFront() + " ";
            }
            for (int i = 0; i < 5; i++) {
                result += list.removeBack() + " ";
            }
            System.out.println(result);
        }
        in.close();
    }    
}
