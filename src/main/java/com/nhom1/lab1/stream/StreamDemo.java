package com.nhom1.lab1.stream;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    @Setter
    public static class Student {
        private String name;
        private int age;
        public Student(String name, int age) {
            this.name=name;
            this.age=age;
        }
    }

    public static void main(String[] args) {
        String[] bingos = new String[] {
                "B1", "A2",
                "C5", "A12",
                "B40", "B26",
                "A8", "C10",
                "C32", "D14",
                "A30", "D20",
                "D10", "B16"
        };

        List<Student> studentList = Arrays.asList(
                new Student("Nhan", 23),
                new Student("Minh", 20),
                new Student("Hung", 20),
                new Student("Dung", 21)
        );
//        demo1(bingos);
//        demo2();
//        demo3(studentList);
        demo4(studentList);
    }

    public static void demo4(List<Student> list){
        double averageAge = list.stream()
                .mapToDouble(student -> student.age)
                .average()
                .getAsDouble();
        System.out.println("Average age: " + averageAge);
        int sumAge = list.stream()
                .mapToInt(s -> s.age)
                .sum();
        System.out.println("Sum age: " + sumAge);
        
        int minAge = list.stream()
                .mapToInt(s -> s.age)
                .min()
                .getAsInt();
        System.out.println("Min age: " + minAge);     
        
        boolean all_over18 = list.stream()
                .allMatch(s -> s.age > 20);
        System.out.println("All over 20: " + all_over18);

        boolean any_over20 = list.stream().anyMatch(s -> s.age > 20);
        System.out.println("Any over 20: " + any_over20);

        boolean none_over20 = list.stream().noneMatch(s -> s.age > 20);
        System.out.println("None over 20: " + none_over20);

        Student student = list.stream()
                .reduce(list.get(0), (min, currentStudent) -> min.age < currentStudent.age ? min : currentStudent);
        System.out.println("Min age student: " + student.name);
    }

    public static void demo3(List<Student> list) {
        List<Student> newList = list.stream()
                .sorted((o1, o2) -> o1.name.compareTo(o2.name))
                .filter(student -> student.age > 20)
                .peek(student -> {
                    student.setName(student.name + " FPT");
                })
                .toList();
        newList.forEach(student -> System.out.println(student.name));
        System.out.println("============================================");
        list.forEach(student -> System.out.println(student.name));
    }

    public static void demo1(String[] bingos){
        Stream<String> bingoStream = Stream.of(bingos);
        bingoStream.forEach(s -> System.out.print(s + " "));
        System.out.println("\n==================================");
        List<String> bingoPool = Arrays.asList(bingos);
        bingoPool.stream()
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    public static void demo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 9, 4, 5, 6);
        List<Double> doubleList = list.stream()
                .filter(integer -> integer % 2 == 0)
                .map(integer -> Math.sqrt(integer))
                .peek(aDouble -> System.out.println(aDouble))
                .collect(Collectors.toList());
    }
}
