#ifndef HPP_LINKEDLIST
#define HPP_LINKEDLIST

#include<string>

template<class T>
//Node.hpp
class Node {
  public:
    T get();
    void set(T);
  protected:
    T data;
    Node * next;
};

template<class T>
//LinkedList.hpp
class LinkedList {

  protected:
    Node<T> head;
    int size;

  public:
    explicit LinkedList();
    explicit LinkedList(T);
    explicit LinkedList(const LinkedList<T> &);
    ~LinkedList();
    void add(int, T);
    void append(T);
    T get(int);
    void remove(int);
    std::string toString();
};
#endif
