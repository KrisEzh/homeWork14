package com.company;


import java.util.Arrays;
import java.util.Iterator;



public class MyArrayList <E> implements MyArrayListInterface<E> {
    private E[] values;
    private int size;
    private int index;

    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.values = (E[]) new Object[DEFAULT_CAPACITY];
    }

    private void growArray(){
        E[] newArray = (E[]) new Object[values.length*2];
        System.arraycopy(values, 0, newArray, 0, index - 1);
        values = newArray;
    }
    @Override
    public void add(E e) {
       if(index == values.length)
           growArray();
       values[index]=e;
       index++;
       size++;
    }

    @Override
    public boolean addByIndex(int index, E e) {
        try{
            if(index == values.length)
                growArray();
            System.arraycopy(values, index, values, index+1, this.index - index);
            values[index] = e;
            this.index++;
            size++;
            return true;
        } catch (IllegalArgumentException ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
            return values[index] = e;
    }

    @Override
    public void remove(E e) {
        int index = -1;
        for (int i = 0; i < values.length; i++) {
            if(e.equals(values[i])) {
                index = i;
                break;
            }
        }
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public void remove(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementsAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementsAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public int indexOf( E e) {
        int result = -1;
        for(int i = 0; i < values.length; i++){
            if(values[i] == e ) {
                result = i;
                break;
            }
        } return result;
    }

    @Override
    public int lastIndexOf(E e){
        for(int i = size - 1; i >=0; i--){
            if(e.equals(values[i])){
                return i;
            }
        }
        return -1;
    }



    private void checkIndex(int index) {
        if (index < 0 || index >= this.index)
            throw new IllegalArgumentException();
    }
    @Override
    public E get(int index) {
        checkIndex(index);
            return values[index];
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if(otherList == null){
            return false;
        }
        if(size!= otherList.size()){
            return false;
        }
        for(int i = 0;  i< size; i++){
            if(!get(i).equals(otherList.get(i))){
                return  false;
            }
        }
        return true;

    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }

    public E[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public Iterator<E> iterator() {
       return new Iterator<E>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return 0< values.length && values[currentIndex] != null;
            }

            @Override
            public E next() {
                return values[currentIndex++];
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };

    }

}