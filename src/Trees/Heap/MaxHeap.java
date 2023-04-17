package Trees.Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxHeap {

    ArrayList<Integer> arr = new ArrayList<Integer>();

    void insertElement(int element){

        arr.add(element);

        int indexofElement = arr.size() -1;
        int indexofParent = indexofElement / 2;

        while(element > arr.get(indexofParent) && indexofParent > 0) {
                swap(indexofElement, indexofParent);
                indexofElement = indexofParent;
                indexofParent = indexofElement / 2;
        }

    }

    void deleteElement(){
        int indexOfLastElement = arr.size() -1;
        int lastElement = arr.get(indexOfLastElement);

        arr.set(1,lastElement);
        arr.remove(indexOfLastElement);

        //heapify
        int rootIndex = 1;

        while(rootIndex * 2 < arr.size()) {
            int leftChildIndex = 2 * rootIndex;
            int rightChildIndex = 2 * rootIndex + 1;

            if (arr.get(leftChildIndex) > arr.get(rightChildIndex)) {
                swap(leftChildIndex, rootIndex);
                rootIndex = leftChildIndex;
            } else {
                swap(rightChildIndex, rootIndex);
                rootIndex = rightChildIndex;
            }
        }
    }

    void swap(int a, int b){

        int temp = arr.get(a);
        arr.set(a,arr.get(b));
        arr.set(b,temp);
    }
    void display(){
        System.out.println(arr);
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        heap.arr.add(-1);
//        heap.arr.add(100);
//        heap.arr.add(40);
//        heap.arr.add(50);
//        heap.arr.add(10);
//        heap.arr.add(15);
//        heap.arr.add(50);
//        heap.arr.add(40);

        //Insertion
        heap.insertElement(100);
        heap.insertElement(40);
        heap.insertElement(50);
        heap.insertElement(25);
        heap.insertElement(15);
        heap.insertElement(50);
        heap.insertElement(40);
        heap.display();

        heap.insertElement(17);
        heap.display();

        //Deletion
        heap.deleteElement();
        heap.display();

        
    }

}
