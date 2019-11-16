package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int age = 2016; //Integer.parseInt(args[0]);
        int limit = 100; // Integer.parseInt(args[1]);
        int minAge = age, minBaseAge = 10;
        for (int i = 11; i < limit; i++) {
            var result = convertAgeFromBaseToBase(age, i);
            if (minAge > result) {
                minAge = result;
                minBaseAge = i;
            }
        }
        System.out.println(minBaseAge);
    }

    private static Integer convertAgeFromBaseToBase(int age, int base) {
        var index = age;
        var rest = 0;
        ArrayList<Integer> results = new ArrayList<>();
        var Continue = true;
        while (Continue) {
            rest = index % base;
            index = index / base;
            results.add(rest);
            Continue = index != 0;
        }
        Collections.reverse(results);
        return Integer.parseInt(results.stream().map(Object::toString).collect(Collectors.joining("")));
    }
}
