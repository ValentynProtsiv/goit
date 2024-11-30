package TaskOne;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskOne {
    public static void printOddNumber(String filename){
        File file = new File(filename);
        try(FileReader fileReader = new FileReader(file)){
            Scanner scanner = new Scanner(fileReader);
            String text = "";
            Map<Integer, String> textMap = new HashMap<>();

            while (scanner.hasNextLine()){
                text = scanner.nextLine();
                scanner.nextLine();
                String[] textArr = text.split(" ");
                textMap.put(Integer.valueOf(textArr[0]), textArr[1]);
            }
            textMap.forEach((key, value) -> System.out.println(key + ". " + value));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        printOddNumber("src/main/java/TaskOne/file.txt");
    }

}
