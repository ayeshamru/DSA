package LinkedList;

import java.util.Scanner;

public class SLL {

    Node head;
    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
            this.next = null;
        }
    }

    static SLL insertAtTail(SLL ll,int data){
        Node newNode = new Node(data);
        if(ll.head == null) {
            ll.head = newNode;
        }else{
            Node temp = ll.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next=newNode;
        }
        return ll;
    }

    static SLL insertAtHead(SLL ll,int data){

        Node newNode = new Node(data);
        newNode.next = ll.head;
        ll.head = newNode;
        return ll;
    }

    static SLL insertAtPos(SLL ll,int data, int pos){

        if(ll.head == null){
            insertAtHead(ll,data);
        }else {
            Node temp = ll.head;
            Node newNode = new Node(data);

            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;

        }
        return ll;
    }
    static void display(SLL ll){
        Node temp = ll.head;
        while(temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }

    static int search(SLL ll,int element){

        int pos = 0;
        Node temp = ll.head;
        while(temp != null){
            pos +=1;
            if(temp.data == element){
                return pos;
            }
            temp = temp.next;
        }
        return 0;
    }

    static void deleteAtHead(SLL ll){

        Node temp = ll.head;
        if(temp != null){
            ll.head = ll.head.next;
            temp.next = null;
        }
    }

    static void deleteAtTail(SLL ll){

        Node temp = ll.head;

        if(temp != null ) {
            if(temp.next == null)
                ll.head = null;
            else {
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            }
        }
    }
    static void deleteAtPos(SLL ll,int pos){
        if(pos == 1){
            ll.head = ll.head.next;
            return;
        }
        Node temp = ll.head;
        for(int i=1;i<pos-1;i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
    }
    static void lRotate(SLL ll,int degree){

        if(degree >0) {
            Node temp = ll.head;

            for (int i = 1; i < degree; i++) {
                temp = temp.next;
            }

            Node last = temp;

            while (last.next != null) {
                last = last.next;
            }

            last.next = ll.head;
            ll.head = temp.next;
            temp.next = null;
        }
    }
    static void rRotate(SLL ll,int degree){
        Node temp = ll.head;
        int count = 0;
        while(temp != null){
            count += 1;
            temp = temp.next;
        }
        degree = count - degree;
        lRotate(ll,degree);
    }

    static void reverse(SLL ll){
        Node temp = ll.head;
        Node prev = null;
        while(temp!= null){
            temp = temp.next;
            ll.head.next = prev;
            prev = ll.head;
            ll.head = temp;

        }
        ll.head = prev;
    }
    static void mergeLists(SLL ob,SLL ob1){
        Node t = ob.head;
        Node t1 = ob1.head;
        Node temp = ob.head;

        while(t != null && t1 != null ){
            if (t.data > t1.data) {
                temp= t1;
                t1 = t1.next;
            } else {
                temp= t;
                t = t.next;
            }
        System.out.print(temp.data+"-->");
        }

        if(t == null){
            System.out.print(t1.data+"-->");
            t1 = t1.next;
        }else if(t1 == null){
            System.out.println(t.data+"-->");
        }

    }

    private int findLength(SLL ll){
        Node temp = ll.head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }
    static void intersect(SLL ll,SLL ll1){

        Node temp1 = ll.head;
        Node temp2 = ll1.head;

        int l1 = ll.findLength(ll);
        System.out.println("\n" + l1);
        int l2 = ll.findLength(ll1);
        System.out.println("\n" + l2);

        if(l1<l2) {
            while (l1 < l2) {
                temp2 = temp2.next;
                l2--;
            }
        }else {
            while (l2 < l1) {
                temp1 = temp1.next;
                l1--;
            }
        }

        while(temp1.next != temp2.next){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        System.out.println(temp1.data);
    }
    public static void main(String[] args) {

        SLL ob = new SLL();
        SLL ob1 = new SLL();


//        Node temp1 = ob.head;
//        Node temp2 = ob.head;
//
//        while(temp1 != null && temp2 != null){
//
//            if(temp1.data>temp2.data) {
//                temp1 = temp1.next;
//            }else {
//                temp2 = temp2.next;
//            }
//        }



        //insertion-----------------------------------------------------------------------
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of nodes to be inserted");
//        int n = sc.nextInt();
//
//        for(int i=0;i<n;i++){
//            System.out.println("Enter data for node");
//            int d = sc.nextInt();
//            insertAtTail(ob,d);
//            //insertAtHead(ob,d);
//           // insertAtPos(ob,d,0);
//        }
//        insertAtPos(ob,5678,1);
//        display(ob);
        //--------------------------------------------------------------------------------
        //Searching
        insertAtTail(ob,10);
        insertAtTail(ob,20);
        insertAtTail(ob,30);
        insertAtTail(ob,40);
        insertAtTail(ob,50);
        insertAtTail(ob,60);

        //insertAtPos(ob,5678,1);
        System.out.println("Linked List 1 : ");
        display(ob);
        //System.out.println(search(ob,15));
        //---------------------------------------------------------------------------------
        //Deletion
        //deleteAtHead(ob);
        //---------------------------------------------------------------------------------
//        deleteAtTail(ob);
//        System.out.println("\n");
//        display(ob);
        //---------------------------------------------------------------------------------
//        deleteAtPos(ob,1);
//        System.out.println("\n");
//        display(ob);

        //----------------------------------------------------------------------------------
//        System.out.println("\nleft Rotation");
//        lRotate(ob,2);
//        display(ob);
        //----------------------------------------------------------------------------------
//        System.out.println("\nRight Rotation");
//        rRotate(ob,6);
//        display(ob);
        //----------------------------------------------------------------------------------
//        System.out.println("\nReverse");
//        reverse(ob);
//        display(ob);
        //----------------------------------------------------------------------------------
//        System.out.println("\nMerge 2 Lists");

        insertAtTail(ob1,5);
        insertAtTail(ob1,15);
        insertAtTail(ob1,17);
        insertAtTail(ob1,25);
        insertAtTail(ob1,29);
        insertAtTail(ob1,35);
        insertAtTail(ob1,36);
        insertAtTail(ob1,45);
        insertAtTail(ob1,49);
        insertAtTail(ob1,55);


        System.out.println("\nLinked List 2 : ");
        display(ob1);
        System.out.println("\nMerged List : ");
        mergeLists(ob,ob1);
        //display(ob2);
        //----------------------------------------------------------------------------------
        //Intersection --> Find node at which 2 ll are intersecting
//        insertAtTail(ob1,100);
//        insertAtTail(ob1,90);
//        insertAtTail(ob1,70);
//        insertAtTail(ob1,80);
//        insertAtTail(ob1,10);
//        insertAtTail(ob1,60);
//        insertAtTail(ob1,20);
//        insertAtTail(ob1,5);
//        insertAtTail(ob1,50);
//        insertAtTail(ob1,60);
//
//
//        System.out.println("\nLinked List 2 : ");
//        display(ob1);
//
//        System.out.println("\nIntersection");
//        intersect(ob,ob1);
    }
}
