import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
public class Data {
    {
    try
          {
    try
        {
        Random r = new Random();
      File file1 = new File("10kAverageCase.csv");
     
      FileWriter writer1 = new FileWriter(file1);
    
        for(int i=1;i<=10000;i++)
        {
            for(int j=1;j<=10000;j++)
            {
                int value;
                value = r.nextInt(10000);
                writer1.append(Integer.toString(value));
                writer1.append('\n');
            }
        }
      
       File file2 = new File("50kAverageCase.csv");
    
       FileWriter writer2 = new FileWriter(file2);
    
        for(int i=1;i<=10000;i++)
        {
            for(int j=1;j<=50000;j++)
            {
                int value;
                value = r.nextInt(50000);
                writer2.append(Integer.toString(value));
                writer2.append('\n');
            }
        }
        
        File file3 = new File("200kAverageCase.csv");
    
       FileWriter writer3 = new FileWriter(file3);
    
        for(int i=1;i<=200000;i++)
        {
            for(int j=1;j<=200000;j++)
            {
                int value;
                value = r.nextInt(20000);
                writer3.append(Integer.toString(value));
                writer3.append('\n');
            }
        }

        File file4 = new File("500kAverageCase.csv");
    
       FileWriter writer4 = new FileWriter(file2);
    
        for(int i=1;i<=500000;i++)
        {
            for(int j=1;j<=10000;j++)
            {
                int value;
                value = r.nextInt(500000);
                writer4.append(Integer.toString(value));
                writer4.append('\n');
            }
        }

        File file5 = new File("1MAverageCase.csv");
    
       FileWriter writer5 = new FileWriter(file2);
    
        for(int i=1;i<=10000;i++)
        {
            for(int j=1;j<=10000;j++)
            {
                int value;
                value = r.nextInt(10000);
                writer5.append(Integer.toString(value));
                writer5.append('\n');
            }
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  

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
        static int[] parseCSV(String fileName) {
            List<Integer> data = new ArrayList<>();
            if (checkCSV(fileName)) {
                System.out.println(fileName + " exists! Aborting.");
                return null;
            }

        }
        static void generateCSV(int[] arr, String filename){
            List<Integer> dataList = Arrays
                    .stream(arr)
                    .boxed()
                    .collect(Collectors.toList());
            try {
                PrintWriter pW = new PrintWriter(new FileWriter(filename,true));
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
