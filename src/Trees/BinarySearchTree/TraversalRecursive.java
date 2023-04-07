package Trees.BinarySearchTree;

public class TraversalRecursive {

    Node root;

    class Node {
        int data;
        Node left;
        Node right;
        Node(int d){
            this.data = d;
        }
    }

    void displayPreorder(Node root){

        if(root == null){
            return;
        }
        System.out.print(root.data+ " | ");
        displayPreorder(root.left);
        displayPreorder(root.right);
    }
    void displayPostorder(Node root){

        if(root == null){
            return;
        }
        displayPostorder(root.left);
        displayPostorder(root.right);
        System.out.print(root.data+ " | ");
    }
    void displayInorder(Node root){

        if(root == null){
            return;
        }
        displayInorder(root.left);
        System.out.print(root.data+ " | ");
        displayInorder(root.right);
    }

    void displayLevelorder(Node root){
        int h = height(root);
        for(int i = 1;i<=h;i++){
            currentLevel(root,i);
        }
    }

    int height(Node root){

        if(root == null){
            return 0;
        }
        int lheight = height(root.left);
        int rheight = height(root.right);
        if(lheight> rheight){
            return(lheight+1);
        }else{
            return(rheight +1);
        }
    }

    void currentLevel(Node root,int level){
        if(root == null){
            return;
        }
        if (level == 1) {
            System.out.print(root.data+" | ");
        }else if(level >1){
            currentLevel(root.left,level-1);
            currentLevel(root.right, level-1);
        }
    }

    void createTree(){
        root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
    }

    public static void main(String[] args) {
        TraversalRecursive tree = new TraversalRecursive();
        tree.createTree();
        tree.displayPreorder(tree.root);
        System.out.println();
        tree.displayInorder(tree.root);
        System.out.println();
        tree.displayPostorder(tree.root);
        System.out.println();
        tree.displayLevelorder(tree.root);
    }
}
