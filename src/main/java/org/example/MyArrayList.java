package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T>{
    private Object[] array;
    private int size;
    private int capacity;

    public MyArrayList() {
        this.size = 0;
        this.capacity = 2;
        array = new Object[capacity];
    }

    public boolean add(T element) {
        //resize
        if (array.length == size) {
            //용량증가
            extractCapacity();
            //복사
            copyArr();
        }

        //data insert
        array[size] = element;
        size++;
        return true;
    }

    private void extractCapacity() {
        capacity = capacity * 2;
    }

    private void copyArr() {
        Object[] tmpArray = new Object[capacity];
        for (int i = 0; i < size; i++)
            tmpArray[i] = array[i];

        array = new Object[tmpArray.length];
        for (int i=0; i < size; i++) {
            array[i] = (T) tmpArray[i];
        }
    }

    public T get(int index){
        if(array[index] != null){
            return (T) array[index];
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean contains(T element){
        for(int i=0; i<size; i++){
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T element){
        for(int i=0; i<size; i++){
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    public void clear() {
        this.capacity = 10;
        this.size = 0;
        array = new Object[capacity];
    }

    public T remove(int index) {
        if(index >= size)
            throw new IndexOutOfBoundsException();

        T result = (T)array[index];
        for(int i=index; i < size - 1; i++){
            array[i] = array[i+1];
        }
        size--;

        if(size == capacity / 2){
            reduceCapacity();
            copyArr();
        }

        return result;
    }

    private void reduceCapacity() {
        capacity = capacity / 2;
    }

    public boolean removeIf(T element) {
        for(int i=0; i<size; i++) {
            if (array[i].equals(element)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
}
