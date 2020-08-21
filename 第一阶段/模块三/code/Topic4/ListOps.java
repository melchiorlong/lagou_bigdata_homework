package com.homework.Stage1.Section3.Topic4;

import java.util.ArrayList;
import java.util.List;

public class ListOps {

    public static void add(List<Student> list, Student s){
        list.add(s);
    }

    public static void delete(List<Student> list, String id){

        Student delete_s = new Student();
        for (Student s: list) {
            if (s.getId()==Integer.parseInt(id)){
                delete_s = s;
            }
        }
        list.remove(delete_s);
    }

    public static Student findId(List<Student> list, String find_id) {
        for (Student stu : list
        ) {
            if (stu.getId() == Integer.parseInt(find_id)) {
                return stu;
            }
        }
        return null;
    }

    public static List<Student> findName(List<Student> list, String find_name) {
        List<Student> resultList = new ArrayList<>();
        for (Student stu : list
        ) {
            if (stu.getName().equals(find_name)) {
                resultList.add(stu);
            }
        }
        return resultList;
    }
    public static List<Student> findAge(List<Student> list, String find_age) {
        List<Student> resultList = new ArrayList<>();
        for (Student stu : list
        ) {
            if (stu.getAge() == Integer.parseInt(find_age)) {
                resultList.add(stu);
            }
        }
        return resultList;
    }
}
