package Arrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TwoD {

    static void display(int array[][], int l, int b) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }

    static void reverseArray(int array[][], int l, int b) {

        int copy[] = new int[l * b];
        int k = 0;//copy.length/2+1; //i+j;
        //int k =0;
        for (int i = l - 1; i >= 0; i--) {
            for (int j = b - 1; j >= 0; j--) {

                copy[k] = array[i][j];
                //   System.out.print(copy[k] + "\t");
                k++;
            }
        }

        k = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j] = copy[k];
                System.out.print(array[i][j] + "\t");
                k++;
            }
            System.out.print("\n");
        }

    }

    static void remove(int array[][], int l, int b, int ith, int jth) {

        for(int i=ith;i<l;i++){
            for(int j=jth;j<b;j++) {

                if(j<l-1){
                    array[i][j] = array[i][j+1];
                }else if(j==l-1 && i+1<l){
                    array[i][j] = array[i+1][0];
                }
                jth=0;
            }

        }
        array[l-1][b-1] = -1;
    }
    static void leftRotate(int array[][],int l,int b){

        int temp[][] = new int[l][b] ;

        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                temp[i][j] = array[i][j];
            }
        }

        for (int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                temp[i][j] = array[j][l-1-i];
            }
        }

        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                array[i][j] = temp[i][j];
                System.out.print(array[i][j] +"\t");
            }
            System.out.print("\n");
        }
    }

    static void rightRotate(int array[][],int l,int b){

        int temp[][] = new int[l][b];
        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                temp[i][j] = array[i][j];
            }
        }
        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                temp[i][j] = array[b-1-j][i];
                //System.out.println("["+i+","+j+"] -- ["+(b-1-j)+ ","+i+"]");
            }
        }

        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                array[i][j] = temp[i][j];
                System.out.print(temp[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    static void checkIfArrayIsSortedThenSearch(int array[][],int l,int b){

        int p = 0,q=0;
        Boolean sorted = true;
        //--checking if array is unsorted or sorted
        for(int i=0;i<l;i++){
            for(int j=0;j<b;j++){
                if(j==b-1){
                    p = i+1;
                    q = 0;
                    //System.out.println("["+i+","+j+"] --> ["+p+","+q+"]");

                }else{
                    p = i;
                    q = j+1;
                   // System.out.println("["+i+","+j+"] --> ["+p+","+q+"]");
                }

                if(p<l && q<b && array[i][j]>array[p][q]){
                    sorted = false;
                    System.out.println("Array is UnSorted");
                    int element = 3;
                    System.out.println("Element to be Searched : "+element);
                    linearSearch(array,element,l,b);
                    return;
                }

            }
        }
        if(sorted){
            System.out.println("Array is Sorted");
            //binarySearch();
        }

    }

    static void linearSearch(int array[][],int element,int l, int b){

        for(int i = 0;i<l;i++){
            for(int j=0;j<b;j++){
                if(array[i][j] == element){
                    System.out.println("Element present at pos : ["+i+","+j+"]");
                }
            }
        }
    }
    public static void main (String[]args){
          Scanner sc = new Scanner(System.in);
//        System.out.println("Reading and Displaying a Matrix");
//        System.out.println("Enter the length and breadth of the matrix");
//        int l = sc.nextInt();
//        int b = sc.nextInt();
//        int array[][] = new int[l][b];
//
//        System.out.println("Enter array elements");
//        for (int i = 0; i < l; i++) {
//            for (int j = 0; j < b; j++) {
//                array[i][j] = sc.nextInt();
//            }
//        }
       // int l=3,b=3;
        int array[][] = {{7,6,5},{9,2,1},{3,4,8}};
        //int array[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("Displaying 2D array : ");

        display(array, 3, 3);
        //-------------------------------------------------------------------------------------
//        System.out.println("Reverse Array");
//        reverseArray(array, l, b);
        //-------------------------------------------------------------------------------------
//        System.out.println("Removing array element");
//        System.out.println("Enter the value pos(i,j) at which element has to be removed from :");
//        System.out.println("Enter value of i : ");
//        int ith = sc.nextInt();
//        System.out.println("Enter value of j : ");
//        int jth = sc.nextInt();
//        remove(array, l, b, ith, jth);
//        display(array,l,b);
        //--------------------------------------------------------------------------------------
//       System.out.println("Left Rotate");
//       leftRotate(array,l,b);
        //--------------------------------------------------------------------------------------
//       System.out.println("Right Rotate");
//       rightRotate(array,l,b);
        //--------------------------------------------------------------------------------------
        System.out.println("Checking if Array is Sorted...");

        checkIfArrayIsSortedThenSearch(array,3,3);
    }
}
