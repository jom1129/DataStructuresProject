import java.util.Arrays;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        /*
        int[] arr = { 10, 8, 6, 5, 4, 3, 2, 0 };
        int[] sorted = arr.clone();

        Sort.bubble(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Sort.counter);

        sorted = arr.clone();

        Sort.insertion(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Sort.counter);

        sorted = arr.clone();

        Sort.selection(sorted);
        System.out.println(Arrays.toString(sorted));
        System.out.println(Sort.counter);

         */
        // Data.generateBestCase(100, "res/100BestCase.txt");
        List<Integer> data = Data.parse("res/100BestCase.txt");
        System.out.print(data.get(data.size() - 1));
    }
}
