package LinkedList;
public class MyLinkedList{
    public static void main(String[] args) {
        MyLinkedList ml = new MyLinkedList();
        ml.mergeAll();
        System.out.println(ml);
        ml.insertFirst(1);
        ml.mergeAll();
        ml.insertFirst(2);
        ml.mergeAll();
        System.out.println(ml);
        
        ml.insertFirst(3);
        ml.insertLast(5);
        System.out.println(ml);
        ml.mergeAll();
        System.out.println(ml);
        
        System.out.println(ml);
        ml.removeFirst();
        System.out.println(ml);
        
    }
    Node first, last;
    int size = 0;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Node removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = first;
        first = first.next;
        size--;
        return tmp;
    }
    
    public void mergeAll(){
    }

  
   
    public void insertFirst(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    public void insertAfter(Node p, int x) {
        Node newNode = new Node(x);
        if (p == null || size == 0) {
            
            return;
        }
        if (p==last){
            insertLast(x);
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
        size++;
    }

   

    public void insertLast(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
    
   

    public String toString() {
        if (isEmpty())
            return "List empty";                    
        Node tmp = first;
        String str = "List with " + size + " elements: ";
        
        while (tmp != null) {
            str += tmp.data + "->";
            tmp = tmp.next;
        }

        return str;
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
