package ua.edu.npu.stream;

import ua.edu.npu.stream.entity.Sex;
import ua.edu.npu.stream.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSortedDemo04 {

    static List<User> users = new ArrayList<>();
    static List<String> strings = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
    static List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);

    static {
        users.add(new User("Peter", 23, Sex.MALE));
        users.add(new User("Poul", 30, Sex.MALE));
        users.add(new User("Olga", 17, Sex.FEMALE));
        users.add(new User("Semen", 20, Sex.MALE));
        users.add(new User("Orest", 61, Sex.MALE));
    }

    public static void main(String[] args) {

        strings.stream().sorted().collect(Collectors.toList())
                .forEach(System.out::println);
        
        strings.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList())
                .forEach(System.out::println);

        strings.stream().sorted().distinct().collect(Collectors.toList())
                .forEach(System.out::println);

        strings.stream().sorted((o1, o2) -> -o1.compareTo(o2)).distinct().collect(Collectors.toList())
                .forEach(System.out::println);

        users.stream().sorted((o1,o2) -> -o1.getName().compareTo(o2.getName())).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nDouble sorted");
        users.stream().sorted((o1, o2) -> o1.getSex() != o2.getSex()? o1.getSex().
                compareTo(o2.getSex()): o1.getAge().compareTo(o2.getAge())).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println(strings.stream().max(String::compareTo).get());

        System.out.println(strings.stream().min(String::compareTo).get());

        System.out.println(users.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get());

        System.out.println(integers.stream().reduce((s1, s2) -> s1 + s2).orElse(0));

        System.out.println(integers.stream().reduce(Integer::max).orElse(-1));

        System.out.println(integers.stream()
                .filter(o -> o % 2 != 0)
                .reduce((s1, s2) -> s1 + s2)
                .orElse(0));
    }

}
