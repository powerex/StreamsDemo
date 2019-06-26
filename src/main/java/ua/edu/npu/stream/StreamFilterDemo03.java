package ua.edu.npu.stream;

import ua.edu.npu.stream.entity.Sex;
import ua.edu.npu.stream.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterDemo03 {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Peter", 23, Sex.MALE));
        users.add(new User("Poul", 30, Sex.MALE));
        users.add(new User("Olga", 17, Sex.FEMALE));
        users.add(new User("Semen", 20, Sex.MALE));
        users.add(new User("Orest", 61, Sex.MALE));
    }

    public static void main(String[] args) {


        users.stream().filter((p) -> p.getAge() >= 18 && p.getAge() < 27
                && p.getSex() == Sex.MALE).forEach(System.out::println);


        final double average = users.stream().filter((p) -> p.getSex() == Sex.MALE).
                mapToInt(User::getAge).average().getAsDouble();
        System.out.println("Average male age: " + average);

        final long count = users.stream().filter((p) -> p.getAge() >= 18).filter(
                (p) -> (p.getSex() == Sex.FEMALE && p.getAge() < 55) || (p.getSex() == Sex.MALE && p.getAge() < 60)).count();
        System.out.println("Count of potential workers: " + count);

    }

}
