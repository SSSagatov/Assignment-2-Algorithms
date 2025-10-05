package org.example;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    // constructor
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // return parent, left, right indices
    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i) { return 2 * i + 1; }
    private int right(int i) { return 2 * i + 2; }

    // get size of the heap
    public int size() { return heap.size(); }

    // check if heap is empty
    public boolean isEmpty() { return heap.isEmpty(); }

    // get the minimum element (root)
    public int peek() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    // insert a new element
    public void insert(int key) {
        heap.add(key);
        heapifyUp(heap.size() - 1);
    }

    // remove and return the minimum element
    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return min;
    }

    // decrease the value of a key at index i
    public void decreaseKey(int i, int newValue) {
        if (i < 0 || i >= heap.size()) throw new IndexOutOfBoundsException("Invalid index");
        if (newValue > heap.get(i)) throw new IllegalArgumentException("New value is greater than current value");

        heap.set(i, newValue);
        heapifyUp(i);
    }

    // merge two min-heaps
    public void merge(MinHeap other) {
        for (int key : other.heap) {
            this.insert(key);
        }
    }

    // Heapify Up
    private void heapifyUp(int i) {
        while (i > 0 && heap.get(parent(i)) > heap.get(i)) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Heapify Down
    private void heapifyDown(int i) {
        int smallest = i;
        int left = left(i);
        int right = right(i);

        if (left < heap.size() && heap.get(left) < heap.get(smallest))
            smallest = left;

        if (right < heap.size() && heap.get(right) < heap.get(smallest))
            smallest = right;

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    // swap helper
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // display heap elements
    public void printHeap() {
        System.out.println(heap);
    }

    // test
    public static void main(String[] args) {
        MinHeap heap1 = new MinHeap();
        heap1.insert(10);
        heap1.insert(5);
        heap1.insert(30);
        heap1.insert(2);
        heap1.insert(8);

        System.out.println("Heap 1:");
        heap1.printHeap();

        System.out.println("Extracted Min: " + heap1.extractMin());
        heap1.printHeap();

        // decrease key
        heap1.decreaseKey(2, 1);
        System.out.println("After decreaseKey:");
        heap1.printHeap();

        // second heap
        MinHeap heap2 = new MinHeap();
        heap2.insert(3);
        heap2.insert(7);
        heap2.insert(6);
        System.out.println("\nHeap 2:");
        heap2.printHeap();

        // merge two heaps
        heap1.merge(heap2);
        System.out.println("\nAfter Merging Heap 1 and Heap 2:");
        heap1.printHeap();
    }
}
