package com.hyt.heap;

import java.util.PriorityQueue;

/**
 * @author houyutao
 * @date 2021-03-29
 */
public class Heap {

    private int[] heap;

    private int heapSize;

    public Heap(int size) {
        heap = new int[size];
    }


    public boolean push(int value) {
        if (heapSize == heap.length) {
            return false;
        }
        heap[heapSize] = value;
        heapInsert(value);
        return true;

    }
    
    public int pop() {
        if (heapSize == 0) {
            throw new RuntimeException("堆为空");
        }

        int t = heap[0];
        heap[0] = heap[--heapSize];
        heapify(0);
        return t;
    }

    private void heapify(int index) {
        int left =  index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 > heapSize ? left : (heap[left] > heap[left + 1] ? left : left + 1);
            if (heap[index] > heap[largest]) {
                break;
            }
            swap(index, largest);
            index = largest;
            left = largest * 2 + 1;
        }

    }

    private void heapInsert(int value) {
        int index = heapSize;
        while (heap[index] > heap[(index - 1) / 2]) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
        heapSize ++;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j]= temp;
    }

    private void printHeap() {
        for (int i = 0 ; i < heapSize ; i ++) {
            if ((i + 1 ) % 10 == 0) {
                System.out.println();
            }
            System.out.print(heap[i] + "  ");
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(9);
        for (int i = 1 ; i <= 9 ; i ++) {
            heap.push(i);
        }

        heap.printHeap();

        System.out.println(heap.pop());

        System.out.println("=============");
        heap.printHeap();
    }


}
