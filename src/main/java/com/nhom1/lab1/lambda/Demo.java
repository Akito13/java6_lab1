package com.nhom1.lab1.lambda;

import com.nhom1.lab1.model.Student;

import java.util.*;

public class Demo {
    public static List<Student> stu = Arrays.asList(
            new Student("Nguyen Van B", true, 7.5),
            new Student("Nguyen Thanh A", true, 9.5),
            new Student("Nguyen Van C", false, 8.0),
            new Student("Nguyen Hong D", true, 7.0)
    );

    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
//        demo4();
    }

    public static void demo1(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        integers.forEach(System.out::println);
    }

    public static void demo2() {
        stu.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Gender: " + sv.getMale());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println("================================");
        });
    }

    public static void demo3(){
        Collections.sort(stu, (o1, o2) -> o1.getMarks().compareTo(o2.getMarks()));
        stu.forEach(sv -> {
            System.out.println(">> Name: " + sv.getName());
            System.out.println(">> Gender: " + sv.getMale());
            System.out.println(">> Marks: " + sv.getMarks());
            System.out.println("================================");
        });
    }

    public static void demo4() {
         Number num = (a, b) -> {
             return a + b;
         };
         int c = num.sum(4, 5);
        System.out.println(c);
    }

}