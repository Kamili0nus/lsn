package io.lsn.task;

import io.lsn.task.graph.Graph;
import io.lsn.task.graph.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) {

        switch (args[0]) {
            case "task1":
                distinctInputSorter(args);
                break;
            case "task2":
                findPair(args);
                break;

            case "task3":
                graphsFinder(args);
                break;

            default:
                throw new IllegalArgumentException("Invalid task type");
        }
    }

    private static void distinctInputSorter(String[] args) {

        TreeSet<Integer> sortedSet = new TreeSet<>(readInput(args));

        System.out.println(sortedSet);
        System.out.printf("count: %d%n", args.length - 1);
        System.out.printf("distinct: %d%n", sortedSet.size());
        System.out.printf("min: %d%n", sortedSet.first());
        System.out.printf("max: %d%n", sortedSet.last());
    }

    private static void findPair(String[] args) {

        final int searchSum = 13;
        List<Integer> inputList = new ArrayList<>(readInput(args));
        Collections.sort(inputList);

        for (int i = 0; i < inputList.size() - 1; i++) {
            if (inputList.get(i) > searchSum) break;
            for (int j = i + 1; j < inputList.size(); j++) {
                if (inputList.get(i) + inputList.get(j) == searchSum) {
                    System.out.printf("%d %d%n", inputList.get(i), inputList.get(j));
                } else if (inputList.get(i) + inputList.get(j) > searchSum) break;
            }
        }
    }

    private static void graphsFinder(String[] args) {

        final int edgesCount = Integer.parseInt(args[1]);
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);

        if (edgesCount > 0) {
            for (int i = 0; i < edgesCount; i++) {
                graph.addEdge(Node.getInstance(scanner.nextInt()), Node.getInstance(scanner.nextInt()));
            }
        }
        System.out.printf("%d", graph.graphCounter());
    }

    private static List<Integer> readInput(String[] args) {

        List<Integer> inputList = new ArrayList<>();

        //skipping args[0] as it is used for task selection
        for (int i = 1; i < args.length; i++) {
            inputList.add(Integer.valueOf(args[i]));
        }

        return inputList;
    }
}