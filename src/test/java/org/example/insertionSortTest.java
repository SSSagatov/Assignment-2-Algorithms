package org.example;

import org.junit.jupiter.api.Test;
import java.util.Random;

public class insertionSortTest {

    // Вспомогательный метод для генерации случайного массива
    private int[] generateRandomArray(int size) {
        Random random = new Random(42); // фиксируем seed для воспроизводимости
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
        return arr;
    }

    // Метод для измерения времени выполнения сортировки
    private long measureSortTime(int size) {
        int[] arr = generateRandomArray(size);
        long start = System.nanoTime();
        Insertion_sort.insertionSortOptimized(arr);
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // переводим в миллисекунды
    }

    @Test
    public void testInsertionSortTimeGrowth() {
        System.out.println("\n--- Insertion Sort Time Complexity Tests ---");
        int[] sizes = {
                100, 200, 400, 800,
                1_000, 2_000, 4_000, 8_000,
                10_000, 20_000, 40_000, 60_000,
                80_000, 100_000, 200_000, 400_000,
                600_000, 800_000, 1_000_000, 2_000_000
        };

        for (int size : sizes) {
            long time = measureSortTime(size);
            System.out.printf("Array size: %,10d -> Time: %,6d ms%n", size, time);
        }

        System.out.println("-------------------------------------------");
    }
}
