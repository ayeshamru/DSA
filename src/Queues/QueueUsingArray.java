package Queues;

public class QueueUsingArray {
    int MAX = 10;
    int[] q = new int[MAX];
    int head = -1;
    int tail = -1;

    void enqueue(int data){
        if(tail == MAX-1){
            System.out.println("Overflow");
        }else if(head == -1 && tail == -1){
            head +=1;
            tail +=1;
            q[tail] = data;
        }else {
            tail += 1;
            q[tail] = data;
        }
    }

    void dequeue(){
      if(head > MAX-1){
          System.out.println("\nUnderflow");
      }else{
          int element = q[head];
          System.out.println("\nElement Dequeued : "+element);
          q[head] = 0;
          head++;
      }

    }
    int rear(){
        return q[tail];
    }
    int peek(){
       // System.out.println(head);
        return q[head];
    }

    void isFull(){

        if(tail == MAX-1){
            System.out.println("Queue is full");
        }else{
            System.out.println("Queue is not full");
        }
    }
    void isNull(){
        if(tail == -1 && head == -1){
            System.out.println("Queue is NULL/Empty");
        }else{
            System.out.println("Queue is  not NULL/Empty");
        }
    }
    void display(){

        //System.out.println(tail+" "+head);
        for(int i=0;i<MAX;i++){
            System.out.print(q[i]+" | ");
        }
    }
    public static void main(String[] args) {
        QueueUsingArray ob = new QueueUsingArray();

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
       ob.enqueue(110);
        ob.display();
        //---------------------------------------------------------------------------------------
        //Dequeue
       ob.dequeue();
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
