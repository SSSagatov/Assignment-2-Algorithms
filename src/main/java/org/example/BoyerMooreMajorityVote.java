package org.example;

public class BoyerMooreMajorityVote {

    // function to find majority element using Boyer-Moore algorithm
    public static Integer findMajorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        // find a candidate
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        // verify candidate (optional but recommended)
        count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return null; // majority element not found
        }
    }

    // Test the algorithm
    public static void main(String[] args) {
        int[] arr1 = {2, 2, 1, 1, 1, 2, 2};
        int[] arr2 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        int[] arr3 = {1, 2, 3, 4};

        System.out.println("Majority element in arr1: " + findMajorityElement(arr1));
        System.out.println("Majority element in arr2: " + findMajorityElement(arr2));
        System.out.println("Majority element in arr3: " + findMajorityElement(arr3));
    }
}
