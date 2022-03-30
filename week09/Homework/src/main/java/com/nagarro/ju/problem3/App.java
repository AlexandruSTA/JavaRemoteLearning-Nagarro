package com.nagarro.ju.problem3;

import com.nagarro.ju.problem3.models.GenericPriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        GenericPriorityQueue<Integer> genericPriorityQueue = new GenericPriorityQueue<>();
        genericPriorityQueue.insert(30);
        genericPriorityQueue.insert(50);
        genericPriorityQueue.insert(10);
        genericPriorityQueue.printQueue();
        genericPriorityQueue.remove();
        genericPriorityQueue.printQueue();
        System.out.println("Is priorityQueue empty? " + genericPriorityQueue.isEmpty());
        genericPriorityQueue.clear();
        System.out.println("Is priorityQueue empty? " + genericPriorityQueue.isEmpty());
        List<Integer> numbers = new ArrayList<>(List.of(20, 30, 100, 42, 52, 5, 0, 10));
        System.out.println("Numbers list:");
        for (Integer number : numbers) {
            System.out.print(number + ";");
        }
        List<Integer> sortedNumbers = genericPriorityQueue.sort(numbers);
        System.out.println("\nSorted numbers:");
        for (Integer number : sortedNumbers) {
            System.out.print(number + ";");
        }
        System.out.println();
    }
}
