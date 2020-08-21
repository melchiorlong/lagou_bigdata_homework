package com.homework.Stage1.Section3.Topic4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSys {

    /**
     * 使用 List 集合实现简易的学生信息管理系统，
     * 要求打印字符界面提示用户选择相应的功能，
     * 根据用户输入的选择去实现 增加、删除、修改、查找以及遍历所有学生信息的功能。
     * 其中学生的信息有：学号、姓名、年龄。
     * 要求： 尽量将功能拆分为多个.java 文件。
     * <p>
     * 解题思路
     * 按照题目要求简历Student类
     * 创建声明List<Student>类
     * 根据要求实现增删改查的功能
     */

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("张三", 1001, 20));
        list.add(new Student("李四", 1002, 21));
        list.add(new Student("王五", 1003, 22));
        list.add(new Student("王五", 1004, 23));
        list.add(new Student("小六", 1005, 20));
        String input = "";

        while (!input.equals("6")) {
            System.out.println("你要做什么？1:增加 2:删除 3:修改 4:查找 5:显示所有 6:退出。");
            Scanner sc = new Scanner(System.in);
            input = sc.next();


            switch (input) {
//          增加
                case "1":
                    System.out.println("请输入要增加的学生信息，如：学号 姓名 年龄。");
                    Scanner sc_add = new Scanner(System.in);
                    String input_id = sc_add.next();
                    String input_name = sc_add.next();
                    String input_age = sc_add.next();
                    Student student_add = new Student(input_name, Integer.parseInt(input_id), Integer.parseInt(input_age));
                    ListOps.add(list, student_add);
                    break;

//          删除
                case "2":
                    System.out.println("请输入要删除的学生学号");
                    Scanner sc_delete = new Scanner(System.in);
                    String delete_id = sc_delete.next();
                    ListOps.delete(list, delete_id);
                    break;

//          修改
                case "3":

                    System.out.println("请输入要修改的学生学号");
                    Scanner sc_change_old = new Scanner(System.in);
                    String change_old = sc_change_old.next();
                    ListOps.delete(list, change_old);

                    System.out.println("请输入修改后的学生信息，如：学号 姓名 年龄。");
                    Scanner sc_change_new = new Scanner(System.in);
                    String id_new = sc_change_new.next();
                    String name_new = sc_change_new.next();
                    String age_new = sc_change_new.next();
                    Student student_change = new Student(name_new, Integer.parseInt(id_new), Integer.parseInt(age_new));
                    ListOps.add(list, student_change);
                    break;

//          查找
                case "4":
                    System.out.println("请输入需要查找的条件如，1：学号 2：姓名 3：年龄");
                    Scanner sc_find = new Scanner(System.in);
                    String find_num = sc_find.next();
                    if (find_num.equals("1")) {
                        System.out.println("请输入学号");
                        Scanner sc_find_id = new Scanner(System.in);
                        String find_id = sc_find_id.next();
                        Student result_stu = ListOps.findId(list, find_id);
                        System.out.println("result_id = " + result_stu);
                    } else if (find_num.equals("2")) {
                        System.out.println("请输入姓名");
                        Scanner sc_find_name = new Scanner(System.in);
                        String find_name = sc_find_name.next();
                        List<Student> resultList = ListOps.findName(list, find_name);
                        System.out.println("result_id = " + resultList);
                    } else if (find_num.equals("3")) {
                        System.out.println("请输入年龄");
                        Scanner sc_find_age = new Scanner(System.in);
                        String find_age = sc_find_age.next();
                        List<Student> resultList = ListOps.findAge(list, find_age);
                        System.out.println("result_id = " + resultList);
                    } else {
                        System.out.println("输入错误");
                    }
                    break;

//          遍历当前
                case "5":
                    for (Student stu : list) {
                        System.out.println(stu);
                    }
                    break;
                case "6":
                    System.out.println("谢谢使用！");
                    break;
                default:
                    System.out.println("输入错误。");
            }
        }
    }
}
