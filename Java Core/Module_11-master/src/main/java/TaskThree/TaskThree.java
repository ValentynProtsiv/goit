package TaskThree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskThree {
    public static void main(String[] args) {
        String[] unSortedNumbers = new String[]{"1, 2, 0", "4, 5"};
        List<Integer> integerList = new ArrayList<>();
        for (String text: unSortedNumbers) {
            for (String number: text.split(", ")) {
                integerList.add(Integer.parseInt(number));
            }
        }
        System.out.print(integerList.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
