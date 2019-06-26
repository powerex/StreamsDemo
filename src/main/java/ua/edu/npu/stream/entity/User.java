package ua.edu.npu.stream.entity;

import java.util.Objects;

public class User {
    private String name;
    private Integer age;
    private Sex sex;

    public User(String name, Integer age, Sex sex) {
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

    public Sex getSex() {
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