package ua.edu.npu.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctDemo05 {
    static List<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

    public static void main(String[] args) {
        strings.stream().distinct().collect(Collectors.toList())
                .forEach(System.out::println);

        Arrays.stream(
                strings.stream()
                        .distinct()
                        .map(String::toUpperCase)
                        .toArray(String[]::new))
                .forEach(System.out::println);

        System.out.println(strings.stream()
                .collect(Collectors.joining(": ", "<b> ", " </b>")));

        System.out.println(strings.stream()
                .distinct()
                .collect(Collectors.toMap((p) -> p.substring(0, 1), (p) -> p.substring(1, 2))));

        System.out.println(strings.stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0, 1))));

        System.out.println(strings.stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0, 1),
                        Collectors.mapping((p) -> p.substring(1, 2),
                        Collectors.joining(":")))));
    }
}
