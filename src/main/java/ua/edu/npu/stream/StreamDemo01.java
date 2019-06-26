package ua.edu.npu.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class User {
    private String name;
    private int age;
    private String location;

    public User(String name, int age, String location) {
        this.name = name;
        this.age = age;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public boolean isFrom(String location) {
        return this.location.equals(location);
    }
}

public class StreamDemo01 {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Peter", 23, "Kyiv"));
        users.add(new User("Semen", 22, "Lviv"));
        users.add(new User("Olga", 23, "Kyiv"));
        users.add(new User("Anna", 23, "Odesa"));
        users.add(new User("Oleg", 23, "Kyiv"));
    }

    public static void main(String[] args) {
        System.out.println(getCountOldVersion());
    }

    public static long getCountOldVersion() {
        long count = 0;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.isFrom("Kyiv"))
                count++;
        }
        return count;
    }

    public static long getCountNewVersion() {
        return users.stream().filter(user -> user.isFrom("Kyiv")).count();
    }
}
