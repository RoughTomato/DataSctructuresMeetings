package Lists.LinkedList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Simple generic LinkedList implementation - NOT THREAD SAFE
 * @param <T>
 */
public class LinkedList<T> {

    private Node<T> head;

    public int size;

    /**
     * Default constructor, creating empty list without @head.
     */
    public LinkedList() { /* Do nothing */ }

    /**
     * Iterates over the list and returns element at @index.
     * @param index
     * @return
     */
    private Node<T> iterateOverList(int index) {
        Node<T> ret = this.head;
        for(int iter = 0; iter <= index-1; iter++) {
            ret = ret.getNext();
        }
        return ret;
    }

    /**
     * Constructor initializing list with head.
     * @param data
     */
    public LinkedList(T data){
        this.head = new Node<>(data);
        this.size = 0;
    }

    /**
     * Copy constructor
     * @param list
     */
    public LinkedList(LinkedList<T> list) {
        Node<T> node = list.getHead();
        while(node.getNext() != null) {
            this.append(node.get());
            node = node.getNext();
        }
    }

    /**
     * Checks whether list is empty by checking if head exists.
     * @return boolean
     */
    public boolean isEmpty() {
        return this.head == null ? true : false;
    }

    /**
     * Appends new element (@Node<T>) to the end of the list.
     * @param data
     */
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if(this.isEmpty()){
            this.head = new Node<>(data);
            this.size = 0;
        }
        else if(this.size == 0) {
            this.head.setNext(newNode);
            this.size++;
        }
        else {
            iterateOverList(this.size).setNext(newNode);
            this.size++;
        }
    }

    /**
     * Adds new element at @index by replacing previous @next node to new node holding new @data and pointing
     * to previous next node.
     * @param index
     * @param data
     * @throws LinkedListException
     */
    public void add(int index, T data) throws LinkedListException {
        Node<T> newNode = new Node<>(data);
        Node<T> prev;
        if(this.isEmpty()) {
            this.head = newNode;
        }
        else if (this.size > index) {
            prev = iterateOverList(index-1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        }
        else {
            throw new LinkedListException("Index out of bound " + index + "/" + this.size);
        }
    }

    /**
     * Replaces node at @index by assuming it's identity
     * @param index
     * @param data
     * @throws LinkedListException
     */
    public void replace(int index, T data) throws LinkedListException {
        Node<T> newNode = new Node<>(data);
        Node<T> prev;
        if(!this.isEmpty() && this.size > index) {
            prev = iterateOverList(index-1);
            newNode.setNext(prev.getNext().getNext());
            prev.setNext(newNode);
        }
        else {
            throw new LinkedListException("Index out of bound " + index + "/" + this.size);
        }
    }

    /**
     * Removes element at @index by changing link (@next) of previous element
     * @param index
     * @return status
     */
    public boolean remove(int index) {
        Node<T> prev = null;
        Node<T> next = null;
        boolean status = false;
        if(!this.isEmpty() && this.size >= index) {
            if(index == 0) {
                this.removeHead();
                status = true;
            }
            else {
                prev = iterateOverList(index-1);
                Node<T> curr = prev.getNext();
                next = curr.getNext();
                prev.setNext(next);
                this.size--;
                status = true;
            }
        }
        return status;
    }

    /**
     * Replaces head with the next element, therefore deletes the original head.
     */
    private void removeHead() {
        this.head = this.head.getNext();
        this.size--;
    }

    /**
     * Remove all elements that exist within both lists.
     * @param list
     */
    public void removeAll(LinkedList<T> list) {
        throw new NotImplementedException();
    }

    /**
     * Overrides information at stored in the @Node<T> at @index with @data.
     * @param index
     * @param data
     * @throws LinkedListException
     */
    public void set(int index, T data) throws LinkedListException {
        if(!this.isEmpty() && !(index > this.size)) {
            this.iterateOverList(index).set(data);
        }
        else {
            throw new LinkedListException("Index out of bound! "+ index + "/"+ this.size);
        }
    }

    /**
     * Method fetches @T at the position of the @index, provided
     * that list ins't empty (has head) and @index isn't larger than total size.
     * @param index
     * @return T at the index position in the list
     */
    public T get(int index) throws LinkedListException {
        T ret = null;
        Node<T> tmp = null;
        if(!this.isEmpty() && !(index > this.size)) {
            tmp = this.iterateOverList(index);
        }
        else {
            throw new LinkedListException("Index out of bound! "+ index + "/"+ this.size);
        }
        return tmp.get();
    }

    /**
     * Returns current list of the size
     * @return current list size (not thread safe!)
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Returns current head of the list.
     * @return Node<T> that is the head of the list. (Not thread safe!)
     */
    public Node<T> getHead() {
        return this.head;
    }
}
