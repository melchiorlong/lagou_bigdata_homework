package com.homework.Stage1.Section3.Topic4;

public class Student {

    /**
     * 学生的信息有：学号、姓名、年龄。
     */

    private String name;
    private int id;
    private int age;

    public Student() {
    }

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "姓名：'" + name + '\'' +
                ", 学号：" + id +
                ", 年龄：" + age +
                '}';
    }
}
