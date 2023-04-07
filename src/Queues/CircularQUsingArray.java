package Queues;

public class CircularQUsingArray {
        int MAX = 10;
        int[] q = new int[MAX];
        int head = -1;
        int tail = -1;

        void enqueue(int data){
            if((tail+1) % MAX == head){
                System.out.println("Overflow");
            }else if(head == -1 && tail == -1){
                head = (head+1) % MAX;
                tail = (tail+1) % MAX;
                q[tail] = data;
            }else {
                tail = (tail+1) % MAX;
                q[tail] = data;
            }
        }

        void dequeue(){
            if((head+1) % MAX == tail){
                System.out.println("\nUnderflow");
            }else{
                int element = q[head];
                System.out.println("\nElement Dequeued : "+element);
                q[head] = 0;
                head = (head + 1)% MAX;
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

            if((tail+1)%MAX == head){
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
            CircularQUsingArray ob = new CircularQUsingArray() ;

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
        //    ob.enqueue(110);
            ob.display();
            //---------------------------------------------------------------------------------------
            //Dequeue
            ob.dequeue();
            ob.dequeue();
            ob.dequeue();
            ob.dequeue();
            ob.enqueue(120);
            ob.enqueue(130);
            ob.enqueue(140);
            ob.enqueue(150);
//            ob.enqueue(160);
//            ob.dequeue();
//            ob.dequeue();
//            ob.dequeue();
//            ob.dequeue();
//            ob.dequeue();
//            ob.dequeue();
//            ob.dequeue();

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


