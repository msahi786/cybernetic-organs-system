package com.cybernetic;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static final int[] SIZES = {100, 500, 1000, 10000, 100000};
    private static final int RUNS = 10;

    public static void main(String[] args) {

        runAndAnalyzeSorts();


        runAndAnalyzeSearches();
    }

    private static void runAndAnalyzeSorts() {
        System.out.println("Sorting Algorithms Performance:\n");

        for (int size : SIZES) {
            System.out.println("Array size: " + size);
            int[] originalArray = generateRandomArray(size);

            // Run each sorting algorithm 10 times and record the times
            analyzeAlgorithm("Bubble Sort", originalArray, AlgorithmAnalysis::bubbleSort);
            analyzeAlgorithm("Insertion Sort", originalArray, AlgorithmAnalysis::insertionSort);
            analyzeAlgorithm("Selection Sort", originalArray, AlgorithmAnalysis::selectionSort);
            analyzeAlgorithm("Merge Sort", originalArray, (arr) -> AlgorithmAnalysis.mergeSort(arr, 0, arr.length - 1));

            System.out.println();
        }
    }

    private static void runAndAnalyzeSearches() {
        System.out.println("Searching Algorithms Performance:\n");

        for (int size : SIZES) {
            System.out.println("Array size: " + size);
            int[] sortedArray = generateRandomArray(size);
            AlgorithmAnalysis.mergeSort(sortedArray, 0, sortedArray.length - 1);  // Ensure the array is sorted for binary search

            // Random search key
            int key = sortedArray[new Random().nextInt(size)];

            // Run Linear Search 10 times
            analyzeSearchAlgorithm("Linear Search", sortedArray, key, AlgorithmAnalysis::linearSearch);

            // Run Binary Search 10 times
            analyzeSearchAlgorithm("Binary Search", sortedArray, key, AlgorithmAnalysis::binarySearch);

            System.out.println();
        }
    }

    private static void analyzeAlgorithm(String algorithmName, int[] originalArray, SortingAlgorithm algorithm) {
        long fastestTime = Long.MAX_VALUE;
        long slowestTime = Long.MIN_VALUE;
        long totalTime = 0;

        for (int i = 0; i < RUNS; i++) {
            int[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);

            long startTime = System.nanoTime();
            algorithm.sort(arrayCopy);
            long endTime = System.nanoTime();

            long timeTaken = endTime - startTime;
            fastestTime = Math.min(fastestTime, timeTaken);
            slowestTime = Math.max(slowestTime, timeTaken);
            totalTime += timeTaken;
        }

        long averageTime = totalTime / RUNS;

        System.out.println(algorithmName + " -> Fastest: " + fastestTime + " ns, Slowest: " + slowestTime + " ns, Average: " + averageTime + " ns");
    }

    private static void analyzeSearchAlgorithm(String algorithmName, int[] array, int key, SearchingAlgorithm algorithm) {
        long fastestTime = Long.MAX_VALUE;
        long slowestTime = Long.MIN_VALUE;
        long totalTime = 0;

        for (int i = 0; i < RUNS; i++) {
            long startTime = System.nanoTime();
            algorithm.search(array, key);
            long endTime = System.nanoTime();

            long timeTaken = endTime - startTime;
            fastestTime = Math.min(fastestTime, timeTaken);
            slowestTime = Math.max(slowestTime, timeTaken);
            totalTime += timeTaken;
        }

        long averageTime = totalTime / RUNS;

        System.out.println(algorithmName + " -> Fastest: " + fastestTime + " ns, Slowest: " + slowestTime + " ns, Average: " + averageTime + " ns");
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }


    private interface SortingAlgorithm {
        void sort(int[] array);
    }


    private interface SearchingAlgorithm {
        int search(int[] array, int key);
    }
}
