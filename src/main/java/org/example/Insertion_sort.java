package org.example;

import java.util.Arrays;

public class Insertion_sort {

    public static void insertionSort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int temp = arr[i]; //current value that we will compare for
            int j = i - 1; //the value before this comparable number

            while (j >=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {23,7,8,5,4,8,9};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}