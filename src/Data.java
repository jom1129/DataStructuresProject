import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Data {

    /*
        NOTICE: Do not generate a CSV if one already exists!
                Generating a new CSV overwrites the old one.
                For every case, create a separate CSV file!
                e.g. 10KWorstCase.csv and 10KBestCase.csv
                Store files in /res
     */

    private static class CSVUtils {
        /*
        static String[] checkCSV(String filename){
            File source = new File ("CSV");
            String[] fList = source.list();
            int f = 0;
            if (fList == null){
                System.out.println("No file found");
            }
            else {
                for (int i = 0; i < fList.length; i++) {
                    String n = fList[i];
                    if (n.equalsIgnoreCase(filename)){
                        System.out.println("File found");
                        f = 1;
                    }
                }
            }
            if (f == 0 ){
                System.out.println("File not Found");
            }
            return fList;
        }

         */

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
            try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
                data = br.lines()
                        .map(Integer::valueOf)
                        .collect(Collectors.toList());
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            return data;
        }

        static void generateCSV(int[] arr, String fileName){

            if(checkCSV(fileName)) {
                System.out.println(fileName + " exists! Aborting.");
                return;
            }

            List<Integer> dataList = Arrays
                    .stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
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

}
