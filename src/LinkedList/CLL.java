package LinkedList;

import java.util.Scanner;

public class CLL {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
        }
    }
    static void insertAtHead(CLL ll,int data){
        Node newNode = new Node(data);
        if(ll.head != null){
            Node temp = ll.head;
            while (temp.next != ll.head) {
                temp = temp.next;
            }
            newNode.next = ll.head;
            temp.next = newNode;
            ll.head = newNode;
        }else{
            ll.head = newNode;
            newNode.next = ll.head;
        }
    }
    static void display(CLL ll){
        Node temp = ll.head;
        if(temp!=null) {
            while (temp.next != ll.head) {
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.print(temp.data + "-->");
        }
        System.out.println();
    }

    static void insertAtTail(CLL ll, int data) {
        Node newNode = new Node(data);
        if (ll.head != null) {
            Node temp = ll.head;
            while (temp.next != ll.head) {
                temp = temp.next;
            }
            newNode.next = ll.head;
            temp.next = newNode;
        }
        else {
            ll.head = newNode;
            newNode.next = ll.head;
        }
    }
    static void insertAtPos(CLL ll,int data,int pos) {
        Node newNode = new Node(data);
        if(pos>1){
        Node temp = ll.head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }else{
            insertAtHead(ll,data);
        }
    }


    static void search(CLL ll,int element){
        Node temp = ll.head;
        int count= 1;
        if(temp.data == element){
            System.out.println("Element found at pos : " + count);
        }else {
            while (temp.next != ll.head) {
                temp = temp.next;
                count++;
                if (temp.data == element) {
                    System.out.println("Element found at pos : " + count);
                }
            }
        }
    }
    static void deleteAtHead(CLL ll){
        Node temp = ll.head;
        if(temp.next == temp){
            ll.head = null;
        }else{
            while(temp.next != ll.head){
                temp = temp.next;
            }
            temp.next = ll.head.next;
            ll.head = temp.next;
        }

    }
    static void deleteAtTail(CLL ll){

        Node temp = ll.head;
        if(temp.next == temp){
            ll.head = null;
        }else {
            while (temp.next.next != ll.head) {
                temp = temp.next;
            }
            temp.next = ll.head;
        }
    }
    static void deleteAtPos(CLL ll,int pos){
        Node temp = ll.head;
        if(pos >1) {
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }else{
            while(temp.next != ll.head){
                temp = temp.next;
            }
            temp.next = ll.head.next;
            ll.head = ll.head.next;

        }
    }
    static void reverse(CLL ll){
        Node temp = ll.head;
        Node prev = null;

        while(temp.next != null){
            temp = temp.next;
            ll.head.next = prev;
            prev = ll.head;
            ll.head = temp;
        }
        temp.next = prev;
       ll.head = prev;
        }

        static void lRotate(CLL ll,int degree){
            for (int i = 0; i < degree; i++) {
                ll.head = ll.head.next;
            }
        }

        static void rRotate(CLL ll,int degree){
            //find length of ll
            Node temp = ll.head;
            int count = 1;
            while(temp.next != ll.head){
                count++;
                temp = temp.next;
            }
            degree = count - degree;
            for(int i=0;i<degree;i++){
                ll.head = ll.head.next;
            }

        }

    public static void main(String[] args) {
        CLL ob = new CLL();
//       Scanner sc = new Scanner(System.in);
//       System.out.println("Enter number of nodes to be inserted");
//       int n = sc.nextInt();
//       System.out.println("Enter data of each node");
//       for(int i =0;i<n;i++){
//           int d = sc.nextInt();
//           insertAtHead(ob,d);
//       }
        //-----------------------------------------------------------------------------------
        //Insert at Head
//        insertAtHead(ob,5);
//        insertAtHead(ob,10);
//        insertAtHead(ob,20);
//        display(ob);
        //-------------------------------------------------------------------------------------
        //Insertion at Tail
        insertAtTail(ob,30);
        insertAtTail(ob,40);
        insertAtTail(ob,50);
        insertAtTail(ob,60);
        insertAtTail(ob,70);
        insertAtTail(ob,80);

        display(ob);
        //--------------------------------------------------------------------------------------
        //Insert at Pos
//        insertAtPos(ob,90,6);
//        display(ob);
        //--------------------------------------------------------------------------------------
        //search
        //search(ob,60);
        //--------------------------------------------------------------------------------------
        //Delete at Head
//        deleteAtHead(ob);
//        deleteAtHead(ob);
//        display(ob);
        //--------------------------------------------------------------------------------------
        //Delete at Tail
//        deleteAtTail(ob);
//        display(ob);
        //--------------------------------------------------------------------------------------
        //Delete at Pos
//        deleteAtPos(ob,4);
//        display(ob);
        //--------------------------------------------------------------------------------------
        //Reverse
//        reverse(ob);
//        display(ob);
        //--------------------------------------------------------------------------------------
        //Left Rotate
        lRotate(ob,3);
        display(ob);
        //--------------------------------------------------------------------------------------
        //Right Rotate
//        rRotate(ob,2);
//        display(ob);
        //--------------------------------------------------------------------------------------



    }
}
