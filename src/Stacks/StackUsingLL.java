package Stacks;

public class StackUsingLL {
    Node top;
    class Node{
        int data;
        Node next;
        Node(int d){
            this.data = d;
        }
    }
    public void push(int data){
        //Insert at top (head)
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;

    }
    public void pop(){
        //Delete from top (head)
        Node temp = top.next;
        top.next = null;
        top = temp;

    }
    public int peek(){
        return top.data;
    }

    public int search(int element){
        int pos = 0;
        Node temp = top;
        while(temp != null){
            pos += 1;
            if(temp.data == element){
                return pos;
            }
            temp = temp.next;
        }
        return 0;
    }
    public int midOfStack(){
        int mid = 0;
        return mid;
    }
    public void rotate(){

    }
    public void display() {
        Node temp = top;
        while (temp != null){
            System.out.println(temp.data+"\n"+"---");
            temp = temp.next;
         }
    }

    public static void main(String[] args) {
        StackUsingLL ob = new StackUsingLL();
        //------------------------------------------------------------------------------
        //push
        ob.push(10);
        ob.push(20);
        ob.push(30);
        ob.push(40);
        ob.push(50);
        ob.push(60);
        ob.push(70);
        ob.push(80);

       // ob.display();

        //------------------------------------------------------------------------------
        //pop

        ob.pop();
        ob.pop();

        ob.display();

        //------------------------------------------------------------------------------
        //peek

        //System.out.println("\nPeek : "+ob.peek());

        //------------------------------------------------------------------------------
        //search

        int element = 20;
        System.out.println("\nElement " +element+ " is present at pos : " + ob.search(element)+ " from TOP");

        //-------------------------------------------------------------------------------
        //mid of stack

        //System.out.println("\nMid of Stack : "+ob.midOfStack());
        //-------------------------------------------------------------------------------
        //rotate

//        ob.rotate();
//        ob.display();
        //--------------------------------------------------------------------------------
    }
}
