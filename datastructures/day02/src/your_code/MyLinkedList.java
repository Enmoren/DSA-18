package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }

        private Node(Chicken d) {
            this.val = d;
            prev = null;
            next = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
        if (this.size==0){
            this.head = new Node (c, null, null);
            this.tail = this.head;
        }else{
            Node node = this.tail;
            node.next = new Node(c, node, null);
            this.tail = node.next;
        }
        this.size++;
    }

    public void addFirst(Chicken c) {
        if (this.size==0){
            this.head = new Node (c, null, null);
            this.tail = this.head;
        }else{
            Node node = this.head;
            node.prev = new Node(c, null, node);
            this.head = node.prev;
        }
        this.size++;
    }

    public Chicken get(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("out of bounds");
        }
        Node node = this.head;
        for (int i=0; i<index; i++){
            node = node.next;
        }
        return node.val;
    }

    public Chicken remove(int index) {
        Chicken element = get(index);
        Node node = this.head;
        if (index == 0){
            this.head = this.head.next;
            this.head.prev = null;
        }else if(index == size-1){
            this.tail = this.tail.prev;
//            this.head.next = null;
        }else{
            for (int i=0; i<index; i++){
                if(i==index-1){
                    node.next = node.next.next;
                    node.next.prev = node;
                }
                node = node.next;
            }
        }
        this.size--;
        return element;
    }

    public Chicken removeFirst() {
        Node node = this.head;
        if (this.size==0) {
            throw new IndexOutOfBoundsException();
        }else if(this.size==1){
            this.head = null;
            this.tail = null;
        }else{
            node.next.prev = null;
            this.head = node.next;
        }
        size--;
        return node.val;
    }

    public Chicken removeLast() {
        Node node = this.tail;
        if (this.size==0) {
            throw new IndexOutOfBoundsException();
        }else if(this.size==1){
            this.head = null;
            this.tail = null;
        }else{
            node.prev.next = null;
            this.tail = node.prev;
        }
        size--;
        return node.val;
    }
}