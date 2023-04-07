package Queues;

import java.sql.SQLOutput;

public class QueueUsingLL {
    int MAX = 10;
    int count  =1;
    QNode head;
    QNode tail;

    class QNode{
        int data;

        QNode next;
        QNode(int d){
            this.data = d;
        }
    }

    void enqueue(int data){
        //Insert at Tail
        QNode newNode = new QNode(data);
        if(count > MAX){
            System.out.println("Overflow");
        }else {
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            count++;
        }
    }
    void dequeue(){
        //Delete from Head
        if(head == null){
            System.out.println("Underflow");
        }else{
            QNode temp = head;
            System.out.println("Element Dequeued : "+temp.data);
            head = head.next;
            temp.next = null;
        }
    }
    int peek(){
        return head.data;
    }

    int rear(){
        return tail.data;
    }

    void isNull(){
        if(head == null){
            System.out.println("Queue is Null");
        }else{
            System.out.println("Queue is not Null");
        }
    }
    void isFull(){
        if(count > MAX){
            System.out.println("Queue is Full");
        }else{
            System.out.println("Queue is not Full");
        }
    }
    void display(){
        QNode temp = head;
        while(temp != null){
            System.out.print(temp.data+"-->");
            temp = temp.next;

        }
        System.out.println();
    }
    public static void main(String[] args) {
        QueueUsingLL ob = new QueueUsingLL();

        //---------------------------------------------------------------------------------------
        //Enqueue
        ob.enqueue(10);
        ob.enqueue(20);
        ob.enqueue(30);
        ob.enqueue(40);
        ob.enqueue(50);
        ob.enqueue(60);
        ob.enqueue(70);
        ob.enqueue(80);
        ob.enqueue(90);
        ob.enqueue(100);
//       ob.enqueue(110);
        ob.display();
        //---------------------------------------------------------------------------------------
        //Dequeue
        ob.dequeue();
       ob.dequeue();
        ob.dequeue();
        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();
//        ob.dequeue();

        ob.display();
        //---------------------------------------------------------------------------------------
        //Front
        System.out.println("\nFront : "+ob.peek());
        //---------------------------------------------------------------------------------------
        //Rear
        System.out.println("Rear : "+ob.rear());
        //---------------------------------------------------------------------------------------
        //IsFull
        ob.isFull();
        //---------------------------------------------------------------------------------------
        //IsNull
        ob.isNull();
        //---------------------------------------------------------------------------------------
    }
}
