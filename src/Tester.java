import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Tester {

    static void generateDataSet() {
        Data.generateBestCase(10000, "res/10KBestCase.csv");
        // Data.generateWorstCase(10000, "res/10KBestCase");
        // Data.generateAverageCase(10000, "res/10KAverageCase");
        // Do the same for the 500K and 1M datasets
    }

    public static void main(String[] args) {
        // generateDataSet();
        List<Integer> temp;
        int[] bestCase10k;

        temp = Data.parse("res/10KBestCase.csv");
        bestCase10k = temp
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();

        Timer timer = new Timer();
        Sort.bubble(bestCase10k);
        System.out.println(timer.timeElapsed());
        System.out.println(new BigDecimal(Sort.counter).toPlainString());
    }
}
