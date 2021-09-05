import java.io.*;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Utility class for reading and generating CSV datasets.
 * Cannot be instantiated.
 */
public class Data {

    /**
     * Helpers class containing implementations of
     * CSV I/O.
     */
    private static class CSVUtils {

        /**
         * Check if a file exists.
         * @param fileName file to be checked
         * @return does it exist?
         */
        static boolean checkCSV(String fileName) {
            File file = new File(fileName);
            return file.isFile();
        }


        /**
         * Read from a CSV file
         * @param fileName filename to be read
         * @return values inside the csv file
         */
        static List<Integer> parseCSV(String fileName) {
            List<Integer> data = new ArrayList<>();
            if (!checkCSV(fileName)) {
                System.out.println(fileName + " does not exist! Aborting.");
                return null;
            }
            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while (br.ready()) data.add(Integer.parseInt(br.readLine()));
            } catch (Exception ignored) {

            }
            return data;
        }

        /**
         * Generate a CSV from the provided parameters.
         * @param dataList read from the List
         * @param fileName filename to write to
         */
        static void generateCSV(List<Integer> dataList, String fileName){
            if(checkCSV(fileName)) {
                System.out.println(fileName + " exists! Aborting.");
                return;
            }

            try {
                PrintWriter pW = new PrintWriter(new FileWriter(fileName, true));
                dataList.forEach(pW::println);
                pW.println();
                pW.close();
            } catch (FileNotFoundException missingFileException) {
                System.out.println("Missing File.");
            } catch (IOException inputAndOutputException) {
                System.out.println("Input and Output error: " + inputAndOutputException);
            }
        }
    }


    /**
     * Generate an already-sorted list
     * Then create a CSV for it
     * @param n Dataset size
     * @param fileName filename to write to
     */
    static void generateBestCase(int n, String fileName) {
        List<Integer> dataList = IntStream.iterate(0, i -> i + 1)
                .limit(n)
                .boxed()
                .toList();
        CSVUtils.generateCSV(dataList, fileName);
    }

    /**
     * Generate a list arranged in descending order
     * Then create a CSV for it
     * @param n Dataset size
     * @param fileName filename to write to
     */
    static void generateWorstCase(int n, String fileName) {
        List<Integer> dataList = IntStream.iterate(n, i -> i - 1)
                .limit(n)
                .boxed()
                .toList();
        CSVUtils.generateCSV(dataList, fileName);
    }

    /**
     * A uniformly distributed, random dataset
     * Then create a CSV for it.
     * @param n Dataset size.
     * @param fileName filename to write to.
     */
    static void generateAverageCase(int n, String fileName) {
        List<Integer> dataList = new SecureRandom().ints(n)
                        .boxed()
                        .toList();
        CSVUtils.generateCSV(dataList, fileName);


    }

    /**
     * Read from a CSV
     * @param fileName file name to read from
     * @return a list containing CSV contents
     */
    static List<Integer> parse(String fileName) {
        return CSVUtils.parseCSV(fileName);
    }
}
