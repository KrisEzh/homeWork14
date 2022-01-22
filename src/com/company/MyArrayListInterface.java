package com.company;

public interface MyArrayListInterface<E> extends Iterable<E>{
    void add(E e);

    boolean addByIndex(int index, E e);


    E set(int index, E e);

    void remove(E e);

    void remove(int index);

    boolean contains(E e);

    int indexOf(E e);

    int lastIndexOf(E e);

    E get(int index);

   boolean equals(MyArrayList otherList);

    int size();

    boolean isEmpty();

    void clear();

    E[] toArray();
}
