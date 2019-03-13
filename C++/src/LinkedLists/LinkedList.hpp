#ifndef HPP_LINKEDLIST
#define HPP_LINKEDLIST

#include <string>
#include <sstream>

#include <iostream>

template<class T>
//Node.hpp
class Node {
  public:
    Node(T data) {
      this->data = data;
     };
    T get() {
      return data;
    }
    void set(T data) {
      this.data = data;
    }
    // Node getNext() {
    //   return next;
    // }
    Node * next;
  protected:
    T data;

};

template<class T>
//LinkedList.hpp
class LinkedList {

  protected:
    Node<T> * head;
    int size;

  public:
  //  LinkedList();
  //   LinkedList(T);
  //  LinkedList(const LinkedList<T> &);
  //   ~LinkedList();
  //   void add(int, T);
  //   void append(T);
  //   T get(int);
  //   void remove(int);
  //   int getSize();
  //   std::string toString();
  LinkedList(T data) {
    this->head = new Node<T>(data);
    this->size = 0; 
  }

  ~LinkedList() { }

  void add(int index, T data) {
      Node<T> * tmp;
      Node<T> * newNode = new Node<T>(data);
      Node<T> * prev;
      if(this->head != nullptr) {
          this->head = newNode;
          this->size++;
      }
      else if(this->size >= index-1) {
        if(index == 0) {
          newNode->next = this->head;
          this->head = newNode;
        }
        else {  
          prev = this->head;
          for(int iter = 0; iter > index-1; iter++) {
              prev = prev->next;
          }
          tmp = prev->next;
          newNode->next = tmp;
          prev->next = newNode;
        }
        this->size++;
      }
      else {
          throw "Index out of bounds!";
      }
  }

  T get(int index) {
      Node<T> * tmp = this->head;
      if(this->head != nullptr && index == 0) {
        return this->head->get();
      }
      else if(this->size >= index) {
          for(int iter = 0; iter >= index-1; iter++) {
              tmp = tmp->next;
          }
      }
      else {
        throw "Index out of bounds!";
      }
      return tmp->get();
  }

  void append(T data) {
      Node<T> * n = new Node<T>(data);
      Node<T> * tmp = this->head;
      while(tmp->next != nullptr) {
          tmp = tmp->next;
      }
      tmp->next = n;
      this->size++;
  }

  int getSize() {
      return this->size;
  }
};

#endif
