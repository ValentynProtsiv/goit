package TaskTwo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TasKTwo {
    public static void printOddNumber(String filename){
        File file = new File(filename);
        try(FileReader fileReader = new FileReader(file)){
            Scanner scanner = new Scanner(fileReader);
            String text = "";
            Map<Integer, String> textMap = new HashMap<>();

            while (scanner.hasNextLine()){
                text = scanner.nextLine();
                String[] textArr = text.split(" ");
                textMap.put(Integer.valueOf(textArr[0]), textArr[1]);
            }
            textMap.entrySet().stream().
                    sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                    forEach((entry) -> System.out.println(entry.getKey() + ". " +entry.getValue()));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        printOddNumber("src/main/java/TaskTwo/file.txt");
    }
}
