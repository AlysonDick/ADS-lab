import java.util.ArrayList;
import java.util.NoSuchElementException;
public class BST {
    private Node root; // root of BST
    private static class Node {
        private int key; // sorted by key
        private Node left, right, p;
        private int size; // number of nodes

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
        }
    }
        public BST() {
            root = null;
        }

        public void Insert(Node node){
            Node x = root;
            Node y = null;
            while(x!=null){
                y=x;
                if(node.key<x.key){
                    x = x.left;
                }else{
                    x=x.right;
                }
            }
            node.p = y;
            if(y==null){
                root = node;
            }else if(node.key<y.key){
                y.left = node;
            }else{
                y.right=node;
            }
        }

    public ArrayList<Node> toArray(){
        ArrayList<Node> array = new ArrayList<>();
        BST.Node node = root;
        while(node!=null){
            array.add(node);
            node = node.next;
        }
        return array;
    }

    public static void main(String[] args) {
        BST bst = new BST();
        Node node = new Node(1,1);
        bst.Insert(node);


        }
}