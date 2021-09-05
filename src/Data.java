import java.io.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Data {
    /*
        NOTICE: Do not generate a CSV if one already exists!
                Generating a new CSV overwrites the old one.
                For every case, create a separate CSV file!
                e.g. 10KWorstCase.csv and 10KBestCase.csv
                Store files in /res
     */

    private static class CSVUtils {

        static boolean checkCSV(String fileName) {
            File file = new File(fileName);
            return file.isFile();
        }

        // static parseCSV()
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

    /*
        These methods invoke checkCSV and generateCSV from CSVUtils
        to store data:
                static generateBestCase();
                static generateWorstCase()
                static generateAverageCase()
     */

    static void generateBestCase(int n, String fileName) {
        List<Integer> dataList = IntStream.iterate(0, i -> i + 1)
                .limit(n)
                .boxed()
                .toList();
        CSVUtils.generateCSV(dataList, fileName);
    }
    
    static void generateWorstCase(int n, String fileName) {
        List<Integer> dataList = IntStream.iterate(n, i -> i - 1)
                .limit(n)
                .boxed()
                .toList();
        CSVUtils.generateCSV(dataList, fileName);
    }
    
    static void generateAverageCase(int n, String fileName) {
        List<Integer> dataList = new SecureRandom().ints(n)
                        .boxed()
                        .toList();
        CSVUtils.generateCSV(dataList, fileName);


    }

    
    static List<Integer> parse(String fileName) {
        return CSVUtils.parseCSV(fileName);
    }
}
