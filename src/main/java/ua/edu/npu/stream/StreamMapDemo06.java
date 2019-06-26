package ua.edu.npu.stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapDemo06 {
    public static void main(String[] args) {
        Stream<String> collection = Stream.of("a1", "a2", "a3", "a4");
        collection.map((s) -> s + "_1").collect(Collectors.toList()).forEach(System.out::println);

        collection = Stream.of("a1", "a2", "a3", "a4");
        Arrays.stream(collection.mapToInt((s) -> Integer.parseInt(s.substring(1))).toArray()).forEach(System.out::println);

        collection = Arrays.asList("1,2,0", "4,5").stream();
        final String[] strings = collection.flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new);
        Arrays.stream(strings).forEach(System.out::print);
        System.out.println();
    }
}
