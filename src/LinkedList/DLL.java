package LinkedList;

public class DLL {
    Node head;
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(int d){
            this.data = d;
        }
    }

    static void insertAtHead(DLL ll,int data){
        Node newNode = new Node(data);
        if(ll.head != null){
            ll.head.prev = newNode;
            newNode.next = ll.head;
            ll.head=newNode;
        }else {
            ll.head = newNode;
        }
    }
    static void insertAtTail(DLL ll,int data){
        Node newNode = new Node(data);
        if(ll.head != null) {
            Node temp = ll.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = null;
        }else{
            ll.head = newNode;
        }
    }
    static void insertAtPos(DLL ll,int data,int pos){
        Node newNode = new Node(data);
        Node temp = ll.head;
        if (pos > 1) {
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
            newNode.prev = temp;
        }else{
            newNode.next = temp;
            temp.prev = newNode;
            ll.head = newNode;
        }
    }

    static int search(DLL ll,int key){
        Node temp = ll.head;
        int pos = 0;
        while(temp != null){
            pos += 1;
            if(temp.data == key){
                return pos;
            }
            temp = temp.next;
        }
        return -1;
    }

    static void deleteAtHead(DLL ll){
        Node temp = ll.head;
        ll.head = ll.head.next;
        temp.next = null;
        ll.head.prev = null;
    }
    static void deleteAtPos(DLL ll,int pos){
        Node temp = ll.head;

        if(pos>1) {
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            if (temp.next.next != null) {
                temp.next = temp.next.next;
                temp.next.prev = temp;
            }else{
                temp.next = null;
            }
        }else {
            ll.head = ll.head.next;
            ll.head.prev = null;
        }
    }
    static void deleteAtTail(DLL ll){
        Node temp = ll.head;
        if(temp != null && temp.next != null) {
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }else{
            ll.head = null;
        }
    }

    static void reverse(DLL ll){
        Node temp = ll.head;
       while(temp.next!=null) {
           temp=temp.next;
       }
        ll.head = temp;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.prev;
        }

    }

    static void lRotate(DLL ll,int degree){
        if(degree > 0) {
            Node temp = ll.head;
            Node lastNode = ll.head;

            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            //exit loop when last node is found
            for (int i = 1; i < degree; i++) {
                temp = temp.next;
            }
            lastNode.next = ll.head;
            ll.head = temp.next;
            temp.next = null;
        }
    }
    static void rRotate(DLL ll,int degree){

        if(degree>0) {
            Node lastNode = ll.head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = ll.head;
            ll.head.prev = lastNode;

            for (int i = 1; i < degree; i++) {
                lastNode = lastNode.prev;
            }
            lastNode.prev.next = null;
            ll.head = lastNode;
            ll.head.prev = null;
        }
    }
    static void floydsAlgo(DLL ll){
        Node hare = ll.head;
        int count = 0;
        Node tortoise = ll.head;

            while (hare != null) {

                if(hare.next!= null) {
                    hare = hare.next.next;

                }else{
                    hare = null;
                    count++;
                    break;
                }
                if(hare != null) {
                    tortoise = tortoise.next;

                }
                count++;
            }

        System.out.println("Node present at : "+count);
            System.out.println(tortoise.data);

    }
    static void display(DLL ll){
        Node temp = ll.head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("\n");
    }
    public static void main(String args[]){
        DLL ob = new DLL();

        //---------------------------------------------------------------------------------
        //Insert at head
        insertAtHead(ob,70);
        insertAtHead(ob,60);
        insertAtHead(ob,50);
        insertAtHead(ob,40);
        insertAtHead(ob,30);
        insertAtHead(ob,20);
        insertAtHead(ob,10);
        //insertAtHead(ob,5);
        display(ob);
        //---------------------------------------------------------------------------------
        //Insert at tail
//        insertAtTail(ob,1);
//        insertAtTail(ob,2);
        //display(ob);
        //---------------------------------------------------------------------------------
        //Insert at Pos
//        insertAtPos(ob,100,1);
//        display(ob);
        //---------------------------------------------------------------------------------
        //Search
       // System.out.println(search(ob,0));
        //---------------------------------------------------------------------------------
        //Delete at Head
//        deleteAtHead(ob);
//        deleteAtHead(ob);
//        deleteAtHead(ob);
//
//        display(ob);
        //---------------------------------------------------------------------------------
        //Delete at Tail
//          deleteAtTail(ob);
//         deleteAtTail(ob);

 //         display(ob);
        //---------------------------------------------------------------------------------
        //Delete at Pos
//        deleteAtPos(ob,6);
//        display(ob);
        //---------------------------------------------------------------------------------
        //Reverse
        //reverse(ob);
        //display(ob);
        //---------------------------------------------------------------------------------
        //left Rotate
        //lRotate(ob,0);
        //display(ob);
        //---------------------------------------------------------------------------------
        //right Rotate
//        rRotate(ob,5);
//        display(ob);
        //---------------------------------------------------------------------------------
        //Tortoise and Hare problem --> to find mid of ll
        floydsAlgo(ob);

    }
}
