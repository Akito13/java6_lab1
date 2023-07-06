package com.nhom1.lab1.lambda;

@FunctionalInterface
public interface Number {
    int sum(int a, int b);

    static void sumStatic(int a, int b){

    }
    default void sumDefault(int a, int b) {

    }
}
