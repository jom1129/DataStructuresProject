import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    static void generateDataSet() {
        Data.generateBestCase(10000, "res/10KBestCase.csv");
        Data.generateWorstCase(10000, "res/10KWorstCase.csv");
        Data.generateAverageCase(10000, "res/10KAverageCase.csv");
        Data.generateBestCase(200000, "res/200KBestCase.csv");
        Data.generateWorstCase(200000, "res/200KWorstCase.csv");
        Data.generateAverageCase(200000, "res/200KAverageCase.csv");
        Data.generateBestCase(500000, "res/500KBestCase.csv");
        Data.generateWorstCase(500000, "res/500KWorstCase.csv");
        Data.generateAverageCase(500000, "res/500KAverageCase.csv");
        Data.generateBestCase(1000000, "res/1MBestCase.csv");
        Data.generateWorstCase(1000000, "res/1MWorstCase.csv");
        Data.generateAverageCase(1000000, "res/1MAverageCase.csv");
    }

    public static void main(String[] args) {
        // generateDataSet();

        List<Integer> temp;
        int[] bestCase10k;
        int[] worstCase10k;
        int[] averageCase10k;
        int[] sortedBestCase10k;
        int[] sortedWorstCase10k;
        int[] sortedAverageCase10k;

        // Convert List<Integer> to int[]
        temp = Data.parse("res/10KBestCase.csv");
        bestCase10k = temp
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        temp = Data.parse("res/10KWorstCase.csv");
        worstCase10k = temp
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        temp = Data.parse("res/10KAverageCase.csv");
        averageCase10k = temp
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();
        sortedWorstCase10k = worstCase10k.clone();
        sortedAverageCase10k = averageCase10k.clone();

        // Bubble Sort
        Timer timer = new Timer();  // START THE TIMER
        Sort.bubble(sortedBestCase10k);
        System.out.println("Bubble Sort");
        System.out.println();
        System.out.println("Best Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();
        
        timer = new Timer();   
        Sort.bubble(sortedWorstCase10k);
        System.out.println("Worst Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();
        
        timer = new Timer();
        Sort.bubble(sortedAverageCase10k);
        System.out.println("Average Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();
        System.out.println();

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();
        sortedWorstCase10k = worstCase10k.clone();
        sortedAverageCase10k = averageCase10k.clone();

        // Selection Sort
        timer = new Timer();    // CREATE A NEW TIMER TO RESET THE TIME
        Sort.selection(sortedBestCase10k);
        System.out.println("Selection Sort");
        System.out.println();
        System.out.println("Best Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();
        
        timer = new Timer();
        Sort.selection(sortedWorstCase10k);
        System.out.println("Worst Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();

        timer = new Timer();
        Sort.selection(sortedAverageCase10k);
        System.out.println("Average Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();
        System.out.println();

        // Clone the original unsorted array
        // work with the clone
        sortedBestCase10k = bestCase10k.clone();
        sortedWorstCase10k = worstCase10k.clone();
        sortedAverageCase10k = averageCase10k.clone();

        // Insertion Sort
        timer = new Timer();    // CREATE A NEW TIMER TO RESET THE TIME
        Sort.insertion(sortedBestCase10k);
        System.out.println("Insertion Sort");
        System.out.println();
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();

        timer = new Timer();
        Sort.insertion(sortedWorstCase10k);
        System.out.println("Worst Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();

        timer = new Timer();
        Sort.insertion(sortedAverageCase10k);
        System.out.println("Average Case 10K");
        System.out.println("Time:" + timer.timeElapsed());
        System.out.print("Instructions: ");
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
        System.out.println();

    }
}
