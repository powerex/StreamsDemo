package ua.edu.npu.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class LocalUser {
    private String name;
    private int age;
    private String location;

    public LocalUser(String name, int age, String location) {
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
        System.out.println("Hello from isFrom()");
        return this.location.equals(location);
    }
}

public class StreamDemo01 {

    public static List<LocalUser> users = new ArrayList<>();

    static {
        users.add(new LocalUser("Peter", 23, "Kyiv"));
        users.add(new LocalUser("Semen", 22, "Lviv"));
        users.add(new LocalUser("Olga", 23, "Kyiv"));
        users.add(new LocalUser("Anna", 23, "Odesa"));
        users.add(new LocalUser("Oleg", 23, "Kyiv"));
    }

    public static void main(String[] args) {
        System.out.println(getCountNewVersion());
    }

    public static long getCountOldVersion() {
        long count = 0;
        Iterator<LocalUser> iterator = users.iterator();
        while (iterator.hasNext()) {
            LocalUser user = iterator.next();
            if (user.isFrom("Kyiv"))
                count++;
        }
        return count;
    }

    public static long getCountNewVersion() {
        long result = 0;
        result = users.stream().filter(user -> user.isFrom("Kyiv")).count();
//        users.stream().filter(user -> user.isFrom("Kyiv"));
        return result;
    }
}
