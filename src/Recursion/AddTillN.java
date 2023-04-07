package Recursion;

public class AddTillN {

    public static int add(int n){
        if(n == 1){
            return 1;
        }
        return n + add(n-1);
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(add(10));
    }
}
