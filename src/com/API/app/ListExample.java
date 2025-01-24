package com.API.app;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Adding elements
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println("List: " + list);

        // Accessing elements
        System.out.println("Element at index 1: " + list.get(1));

        // Modifying elements
        list.set(1, "D");
        System.out.println("Modified List: " + list);

        // Bulk operations
        list.addAll(Arrays.asList("E", "F"));
        System.out.println("After addAll: " + list);

        // Sorting
        list.sort(Comparator.reverseOrder());
        System.out.println("Sorted List: " + list);
//        list.stream().forEach(System.out::println);
//        System.out.println("III");
//        list.parallelStream().forEach(System.out::println);
        int size=list.indexOf("A");
        boolean hasA=list.contains("A");
        boolean e=list.isEmpty();
        System.out.println(size+" "+hasA+" "+e);
        
        
        // Iteration
//        for (String item : list) {
//            System.out.println("Item: " + item);
//        }
    }
}

