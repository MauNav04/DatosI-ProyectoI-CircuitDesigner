package Estructuras;

public class ListaEnlazada {
    private Node head;
    private int size;

    public ListaEnlazada(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        return this.size;
    }

    public void insertFirst(Object data){
        Node newNode = new Node(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }
    public Node deleteFirst(){
        if (this.head != null){
            Node temp = this.head;
            this.head = this.head.getNext();
            this.size--;
            return temp;
        } else {
            return null;
        }
    }

}
