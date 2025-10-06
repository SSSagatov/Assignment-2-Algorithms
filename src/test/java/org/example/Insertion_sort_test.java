package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class Insertion_sort_test {

    @Test
    void testRandomArray() {
        int[] arr = {23, 7, 8, 5, 4, 8, 9};
        int[] expected = {4, 5, 7, 8, 8, 9, 23};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testReverseSorted() {
        int[] arr = {9, 8, 7, 6, 5};
        int[] expected = {5, 6, 7, 8, 9};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testWithDuplicates() {
        int[] arr = {3, 1, 2, 2, 3, 1};
        int[] expected = {1, 1, 2, 2, 3, 3};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {42};
        int[] expected = {42};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @Test
    void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }

    @org.testng.annotations.Test
    void testNearlySorted() {
        int[] arr = {1, 2, 4, 3, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6};

        Insertion_sort.insertionSortOptimized(arr);

        assertArrayEquals(expected, arr);
    }
}
