package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellSort {

    // Shell's Original Gap Sequence
    public static void shellSort_Shell(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            gapInsertionSort(arr, n, gap);
        }
    }

    // Knuth's Gap Sequence
    public static void shellSort_Knuth(int[] arr) {
        int n = arr.length;
        int gap = 1;
        while (gap < n / 3) {
            gap = 3 * gap + 1;
        }

        while (gap > 0) {
            gapInsertionSort(arr, n, gap);
            gap /= 3;
        }
    }

    // Sedgewick's Gap Sequence
    public static void shellSort_Sedgewick(int[] arr) {
        int n = arr.length;
        List<Integer> gaps = generateSedgewickGaps(n);
        Collections.reverse(gaps); // sort gaps from largest to smallest

        for (int gap : gaps) {
            gapInsertionSort(arr, n, gap);
        }
    }

    // helper insertion sort with a specific gap
    private static void gapInsertionSort(int[] arr, int n, int gap) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }

    // generate Sedgewick's gap sequence
    private static List<Integer> generateSedgewickGaps(int n) {
        List<Integer> gaps = new ArrayList<>();
        int k = 0;
        int gap;

        while (true) {
            // 2 interleaved sequences
            int pow2 = (int) Math.pow(2, k);
            int pow4 = (int) Math.pow(4, k);
            gap = 9 * pow4 - 9 * pow2 + 1;
            if (gap > n) break;
            gaps.add(gap);
            k++;
        }

        if (!gaps.contains(1)) gaps.add(1);
        return gaps;
    }

    // print array
    private static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    // test all three versions
    public static void main(String[] args) {
        int[] arr1 = {45, 23, 53, 12, 9, 30, 72, 61};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();

        System.out.println("Original Array:");
        printArray(arr1);

        shellSort_Shell(arr1);
        System.out.println("\nAfter Shell's Sequence:");
        printArray(arr1);

        shellSort_Knuth(arr2);
        System.out.println("\nAfter Knuth's Sequence:");
        printArray(arr2);

        shellSort_Sedgewick(arr3);
        System.out.println("\nAfter Sedgewick's Sequence:");
        printArray(arr3);
    }
}
