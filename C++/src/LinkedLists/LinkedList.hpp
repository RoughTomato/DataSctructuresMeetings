#ifndef HPP_LINKEDLIST
#define HPP_LINKEDLIST

#include<string>

template<class T>
//Node.hpp
class Node {
public:
        T data;
        Node * next;
};

template<class T>
//LinkedList.hpp
class LinkedList {

  private:
    Node<T> * head;
    int size;

  public:
    LinkedList();
    LinkedList(T);
    ~LinkedList();
    void add(int, T);
    void append(T);
    Node<T> get(int);
    void remove(int);
    std::string toString();

  protected:

};
#endif