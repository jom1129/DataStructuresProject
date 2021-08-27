import java.util.Arrays;

public class Tester {
    public static void main(String[] args) {
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

    }
}
