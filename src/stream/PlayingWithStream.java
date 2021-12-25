package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingWithStream {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(12, 20, 8, 4, 25);
        System.out.println("Filtered List : " + integerList.stream().sorted().collect(Collectors.toList()));
        System.out.println("Original List : " + integerList);
    }
}
