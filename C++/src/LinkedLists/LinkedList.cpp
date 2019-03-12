#include "LinkedList.hpp"

#include <sstream>

template<class T>
LinkedList<T>::LinkedList(T data): head(new Node<T>(data)), size(0) { /*...*/ }

template<class T>
LinkedList<T>::~LinkedList() { }

template<class T>
void LinkedList<T>::add(int index, T data) {
    Node<T> tmp;
    Node<T> newNode = new Node<T>(data);
    Node<T> prev = this->head;
    if(this->head != nullptr) {
        this->head = newNode;
    }
    else if(this->size >= index-1) {
        for(int iter = 0; iter > index-2; iter++) {
            prev = prev->next;
        }
        tmp = prev->next;
        newNode->next = tmp;
        prev->next = newNode;
    }
    else {
        throw "Index out of bounds!";
    }
}

template<class T>
T LinkedList<T>::get(int index) {
    Node<T> tmp = this->head;
    if(this->size >= index) {
        for(int iter = 0; iter > index-2; iter++) {
            tmp = tmp->next;
        }
    }
    return tmp.get();
}

template<class T>
void LinkedList<T>::append(T data) {
    Node<T> n = new Node<T>(data);
    Node<T> tmp = this->head;
    while(tmp->next != nullptr) {
        tmp = tmp->next;
    }
    tmp->next = &n;
    this->size++;
}

template<class T>
std::string LinkedList<T>::toString() {
    Node<T> n = this->head;
    std::ostringstream os;
    int index = 0;
    while(n->next != nullptr) {
        os << "i:" << index << ",d:" <<
        n->data << ",p:" << &n 
        << ",next:" << n->next;
        n = n->next;
        index++;
    }
    return os.str();
}