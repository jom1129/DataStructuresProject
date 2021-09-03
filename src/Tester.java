import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    static void generateDataSet() {
        Data.generateBestCase(10000, "res/10KBestCase.csv");
        // Data.generateWorstCase(10000, "res/10KWorstCase.csv");
        // Data.generateAverageCase(10000, "res/10KAverageCase.csv");
        // Do the same for the 200K, 500K and 1M datasets
    }

    public static void main(String[] args) {
        // generateDataSet();

        /*
            Sample Code for testing n = 10, 000
         */

        List<Integer> temp;
        int[] bestCase10k;
        int[] sortedBestCase10k;

        // Convert List<Integer> to int[]
        temp = Data.parse("res/10KBestCase.csv");
        bestCase10k = temp
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();

        // Bubble Sort
        Timer timer = new Timer();  // START THE TIMER
        Sort.bubble(sortedBestCase10k);
        System.out.println("Bubble Sort");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();

        // Selection Sort
        timer = new Timer();    // CREATE A NEW TIMER TO RESET THE TIME
        Sort.selection(sortedBestCase10k);
        System.out.println("Selection Sort");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();

        // Insertion Sort
        timer = new Timer();    // CREATE A NEW TIMER TO RESET THE TIME
        Sort.insertion(sortedBestCase10k);
        System.out.println("Insertion Sort");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());

    }
}
