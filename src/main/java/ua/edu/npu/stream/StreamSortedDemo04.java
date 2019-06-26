package ua.edu.npu.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSortedDemo04 {

    enum Sex {MALE, FEMALE}

    static class User {
        private String name;
        private Integer age;
        private StreamSortedDemo04.Sex sex;

        public User(String name, Integer age, StreamSortedDemo04.Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public StreamSortedDemo04.Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User User = (User) o;
            return Objects.equals(name, User.name) &&
                    Objects.equals(age, User.age) &&
                    Objects.equals(sex, User.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }

    static List<StreamSortedDemo04.User> users = new ArrayList<>();
    static List<String> strings = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");
    static List<Integer> integers = Arrays.asList(1, 2, 3, 4, 2);

    static {
        users.add(new StreamSortedDemo04.User("Peter", 23, StreamSortedDemo04.Sex.MALE));
        users.add(new StreamSortedDemo04.User("Poul", 30, StreamSortedDemo04.Sex.MALE));
        users.add(new StreamSortedDemo04.User("Olga", 17, StreamSortedDemo04.Sex.FEMALE));
        users.add(new StreamSortedDemo04.User("Semen", 20, StreamSortedDemo04.Sex.MALE));
        users.add(new StreamSortedDemo04.User("Orest", 61, StreamSortedDemo04.Sex.MALE));
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

        System.out.println(integers.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0));
    }

}
