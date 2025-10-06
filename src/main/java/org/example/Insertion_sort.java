package org.example;

import java.util.Arrays;

public class Insertion_sort {

    // Optimized insertion sort
    public static void insertionSortOptimized(int[] arr) {
        int n = arr.length;
        boolean sorted; // флаг для раннего выхода

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int left = 0;
            int right = i - 1;

            // binary search optimization
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > key)
                    right = mid - 1;
                else
                    left = mid + 1;
            }

            // if element already in correct place
            if (left == i) continue;

            // insertion method
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            arr[left] = key;

            // optimization early termination
            sorted = true;
            for (int k = 1; k < n; k++) {
                if (arr[k - 1] > arr[k]) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) break;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 7}; //

        insertionSortOptimized(arr);
        System.out.println("Sorted:  " + Arrays.toString(arr));
    }
}
