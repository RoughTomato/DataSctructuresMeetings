package Lists.LinkedList;

public class Node<T> {

    private Node<T> next = null;
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public Node() {

    }

    public T get() {
        return this.data;
    }

    public void set(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        boolean status = false;
        if(this.next != null) {
            status = true;
        }
        return status;
    }
}
