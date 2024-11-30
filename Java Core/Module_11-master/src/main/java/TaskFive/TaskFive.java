package TaskFive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskFive {
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> mixedList = new ArrayList<>();

        Iterator<T> firstIter = first.iterator();
        Iterator<T> secondIter = second.iterator();

        while (firstIter.hasNext() && secondIter.hasNext()){
                mixedList.add(firstIter.next());
                mixedList.add(secondIter.next());
        }

    return mixedList.stream();

    }

    public static void main(String[] args) {
        Stream<String> firstStream = Stream.of("one", "two", "three");
        Stream<String> secondStream = Stream.of("1","2","3","4");
        Stream<String> mixed = zip(firstStream, secondStream);
        System.out.println(mixed.collect(Collectors.toList()));
    }
}
