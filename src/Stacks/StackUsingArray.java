package Stacks;

public class StackUsingArray {
    int Max = 10;
    int[] st = new int[Max];
   int top = -1;

    public void push(int data){

        if(top >= (Max -1)){
            System.out.println("Overflow!");
        }else{
            top += 1;
            st[top] = data;
        }

    }

    public void pop(){
        if(top < 0){
            System.out.println("Underflow");
        }else{
            int popped = st[top] ;
            top -=1;
            System.out.println(popped+ " popped");
        }
    }

    public int peek(){
        return st[top];
    }

    public int search(int element){

        for(int i=0;i<=top;i++){
            if(st[i] == element){
                return i+1;
            }
        }
        return -1;
    }

    public int midOfStack(){
        int mid = top/2;
        return mid +1;
    }

    public void rotate(){
        int i = st[0];
        int j = st[top];

        while(i<j){
            swap(i,j);
            i++;
            j--;
        }
    }
    private void swap(int a,int b){
        a = a+b;
        b = a-b;
        a = a-b;
    }
    public void display(){
        System.out.println("\nStack : ");
        for(int i = top;i>=0;i--){
            System.out.println(st[i]);
        }
    }

    public static void main(String[] args) {

        StackUsingArray ob = new StackUsingArray();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the size of the stack");
//        int Max = sc.nextInt();
//        System.out.println("Enter Stack elements");
//        for(int i = 0;i<Max;i++){
//            int data = sc.nextInt();
//            ob.push(s,data);
//        }

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

        ob.display();

        //------------------------------------------------------------------------------
        //pop

//        ob.pop();
//        ob.pop();
//        ob.pop();
//        ob.pop();
//        ob.pop();
//        ob.pop();
        ob.display();

        //------------------------------------------------------------------------------
        //peek

        System.out.println("\nPeek : "+ob.peek());

        //------------------------------------------------------------------------------
        //search

//        int element = 60;
//        System.out.println("\nElement " +element+ " present at pos : " + ob.search(element));

        //-------------------------------------------------------------------------------
        //mid of stack

        System.out.println("\nMid of Stack : "+ob.midOfStack());
        //-------------------------------------------------------------------------------
        //rotate

        ob.rotate();
        ob.display();
        //--------------------------------------------------------------------------------
    }
}
