import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LinkedList<Item extends Comparable<Item>> {

    private Node<Item> head;

    private static class Node<Item>{
        private Item key;
        private Node<Item> next;
    }

    public LinkedList(){
        head = null;
    }

    public static <Item extends Comparable<Item>> int size(Node<Item> node){
        if(node == null) return 0;
        else{
            return size(node.next)+1;
        }
    }

    public static <Item extends Comparable<Item>>Node MERGE(Node<Item> a, Node<Item> b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }
        Node x = null;
        if (a.key.compareTo(b.key)<=0){
            x = a;
            x.next = MERGE(a.next, b);
        } else {
            x = b;
            x.next = MERGE(a, b.next);
        }
        return x;
    }

    public void Insert(Item item){
        Node<Item> node = new Node<>();
        node.key = item;
        node.next = head;
        head = node;
    }

    public ArrayList<Item> toArray(){
        ArrayList<Item> array = new ArrayList<>();
        Node<Item> node = head;
        while(node!=null){
            array.add(node.key);
            node = node.next;
        }
        return array;
    }

    public void Delete(){
        if(head != null){
            head = head.next;
        }

    }

//    public Node<Item> Search(){
//
//    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.Insert(7);
        ll.Insert(5);
        LinkedList<Integer> ll2 = new LinkedList<>();
        ll2.Insert(10);
        ll2.Insert(3);
        Node<Integer> result = MERGE(ll.head, ll2.head);
        LinkedList<Integer> ll3 = new LinkedList<Integer>();
        ll3.head = result;
        System.out.println(ll3.toArray());
        ll3.Delete();
        System.out.println(ll3.toArray());

    }
}