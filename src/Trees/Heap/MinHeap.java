package Trees.Heap;

import java.util.ArrayList;

public class MinHeap {

    ArrayList<Integer> a = new ArrayList<>();

    void display(){
        System.out.println(a);
    }

    void insertElement(int element){
        a.add(element);
        int indexOfElement = a.size() -1;
        int indexOfParent = indexOfElement/2;

        while(a.get(indexOfParent) > a.get(indexOfElement) && indexOfParent > 0) {
            swap(indexOfElement, indexOfParent);
            indexOfElement = indexOfParent;
            indexOfParent = indexOfElement / 2;
        }
    }

    void deleteElement(){
        int indexOfLastElement = a.size() -1;
        int lastElement = a.get(indexOfLastElement);

        a.set(1,lastElement);
        a.remove(indexOfLastElement);

        //heapify

        int rootIndex = 1;

        while(rootIndex * 2 < a.size()) {
            int indexOfLeftChild = 2 * rootIndex;
            int indexOfRightChild = 2 * rootIndex + 1;
            if (a.get(indexOfLeftChild) < a.get(indexOfRightChild)) {
                swap(indexOfLeftChild, rootIndex);
                rootIndex = indexOfLeftChild;
            } else {
                swap(indexOfRightChild, rootIndex);
                rootIndex = indexOfRightChild;
            }
        }
    }

    void swap(int p , int q){
        int temp = a.get(p);
        a.set(p,a.get(q));
        a.set(q,temp);



    }
    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insertElement(-1);
        heap.insertElement(1);
        heap.insertElement(3);
        heap.insertElement(6);
        heap.insertElement(5);
        heap.insertElement(9);
        heap.insertElement(8);
        heap.display();

        //Insertion
        heap.insertElement(7);
        heap.display();

        //deletion

        heap.deleteElement();
        heap.display();

    }
}
