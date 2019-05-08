package com.zyl.usertest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mian2 {
    static class Dish{
        private String type;
        private String name;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"Hello", "World"};
        List<String[]> collect = Arrays.stream(words).map(word -> word.split("")).collect(Collectors.toList());
        collect.forEach(s -> {
            for (String s1 : s) {
                System.out.println(s1);
            }
        });
        List<String> collect1 = Arrays.stream(words).map(word -> word.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collect1);

        List<Integer> nums1 = Arrays.asList(1, 2 ,3);
        List<Integer> nums2 = Arrays.asList(4, 5);
        List<int[]> collect2 = nums1.stream().flatMap(n1 -> {
            return nums2.stream().map(n2 -> new int[]{n1, n2});
        }).collect(Collectors.toList());
        System.out.println(collect2);
    }
}
