import java.util.ArrayList;
import java.util.Scanner;

public class Question1 {
    public static int findIndex(ArrayList<Integer> arr) {
        
        int i = 0;

        // Find the index of the first -1
        while (i < arr.size() && arr.get(i) != -1) {
            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int num;

        // Taking input until -1 is entered
        while (true) {
            num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            arr.add(num);
        }

        // Finding the index
        int index = findIndex(arr);
        System.out.println(index);
    }
}