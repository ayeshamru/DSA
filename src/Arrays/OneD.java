package Arrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class OneD {

    static int arrSize = 0;

    static void Display(int[] arr){
        for(int i = 0;i<arrSize;i++){
            System.out.print(arr[i] + "\t");
        }
        System.out.println("\n");
    }

    static void Remove(int pos,int arr[]){
        pos -= 1;
        for(int i = pos;i<arrSize-1;i++){
            arr[i] = arr[i+1];
        }
        arrSize -= 1;
    }

    static void lRotate(int arr[],int degree){
    int copy[] = new int [degree];
    for(int i=0;i<degree;i++){
        copy[i] = arr[i];
    }
    for(int i=0;i<arrSize-degree;i++){
        arr[i] = arr[i+degree];
    }
    for(int i=0;i<copy.length;i++){
            arr[arrSize-degree+i] = copy[i];
    }
    }
    static void rRotate(int arr[],int degree){
    int copy[] = new int[degree];
    for(int i=arrSize-degree;i<arrSize;i++){
        copy[i-arrSize+degree] = arr[i];
    }
    for(int i = arrSize-1;i >= degree;i--){
        arr[i] = arr[i-degree];
    }
    for(int i = 0;i<copy.length;i++)
        arr[i]=copy[i];
    }

    static void reverseArray(int arr[]){
        for(int i = 0;i<arrSize/2;i++){
            swap(i,arrSize-i-1,arr);
        }
    }

    static void swap(int a, int b,int arr[]){
        arr[a] = arr[a]+arr[b];
        arr[b] = arr[a]-arr[b];
        arr[a] = arr[a]-arr[b];
    }
   // static void

    static void Lsearch (int arr[],int element){
        for(int i=0;i<arrSize;i++){
            if(arr[i] == element){
                System.out.println("Element present at pos :" +(i+1));
            }
        }
    }
    static void generateSubarrays(int array[],int n){
//        for(int i=0;i<=array.length-1;i++){
//            for(int j=i;j<=array.length-1;j++){
//
//                if(i==j){
//                    System.out.println("[" + array[i] + "]");
//                }else{
//                    System.out.println("[" +array[i]+ "," +array[j]+"]");
//                }
//
//            }
            for(int i=0;i<array.length;i++){
                String res = "";
                for(int j=i;j<array.length;j++){
                    res +=array[j] + " ";
                    System.out.println("["+res+"]");
                }

        }
    }

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int [] arr;
//        System.out.println("Enter size of array");
//        int n = sc.nextInt();
//        arr = new int[n];
//
//        System.out.println("Enter array elements");
//        for(int i = 0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
        int arr[]= {9,2,5,3,6,4,1,8,6,1};
        arrSize = arr.length;

//        System.out.println("Removing Element");
//        int removePos = 10;
//        Remove(removePos,arr);
//        System.out.println("Display");
//        Display(arr);

        System.out.println("Rotate Left");
        int degree = 4;
        lRotate(arr,degree);
        Display(arr);

        System.out.println("Rotate Right");
        degree = 3;
        rRotate(arr,degree);
        Display(arr);

        System.out.println("Reverse Array");
        reverseArray(arr);
        Display(arr);

        System.out.println("Searching for position of element");
        int element = 2;
        Lsearch(arr,element);

        int array[] = {1,2,3};
        int n= array.length;
        System.out.println("Generating subarrays");
        generateSubarrays(array,n);
        //Display(array);
    }
}

