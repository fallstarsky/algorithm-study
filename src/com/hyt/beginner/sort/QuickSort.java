package com.hyt.beginner.sort;

/**
 * @author houyutao
 * @date 2021-02-05
 */
public class QuickSort {


    public static void quickSort(int[] data, int low, int high) {
        if (low <= high) {
            int left = low;
            int right = high;
            int temp = data[left];

            while (left < right) {
                while (data[right] >= temp && right > left) {
                    right --;
                }
                if(left < right) {
                    data[left] = data[right];

                }

                while (data[left] < temp && left < right) {
                    left ++;
                }
                if (left < right) {
                    data[right] = data[left];

                }
            }

            data[right] = temp;

            quickSort(data, low, right - 1);
            quickSort(data, right + 1, high);
        }
    }

    public static void main(String[] args) {
        int size= 100;
        int[] data = new int[size];
        for (int i = 0 ; i < size ; i ++) {
            data[i] = (int) (Math.random() * size);
            System.out.print(data[i] + ",");
            if (i % 10 == 0 && i != 0) {
                System.out.println("\n");
            }
        }
        System.out.println("\n");

        quickSort(data, 0, size - 1);

        for (int i = 0 ; i < size ; i ++) {
            System.out.print(data[i] + ",");
            if (i % 10 == 0) {
                System.out.println("\n");
            }
        }



    }
}
