package org.example;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K, V>{

    private Object[] keys;
    private Object[] values;
    private int size;
    private int capacity;

    public MyHashMap() {
        size = 0;
        capacity = 2;
        keys = new Object[capacity];
        values = new Object[capacity];
    }

    public V put(K key, V value) {
        for(int i=0; i<size; i++){
            if(keys[i].equals(key)) {
                values[i] = value;
                return (V) values[i];
            }
        }

        //용량 증가
        if (keys.length == size) {
            extractCapacity();
            copyArr();
        }

        keys[size] = key;
        values[size] = value;
        size++;
        return null;
    }
    private void extractCapacity() {
        capacity = capacity * 2;
    }
    private void copyArr() {
        Object[] tmpkeys = new Object[capacity];
        Object[] tmpvalues = new Object[capacity];
        for (int i = 0; i < size; i++) {
            tmpkeys[i] = keys[i];
            tmpvalues[i] = values[i];
        }

        keys = new Object[capacity];
        values = new Object[capacity];
        for (int i=0; i < size; i++) {
            keys[i] = (K) tmpkeys[i];
            values[i] = (V) tmpvalues[i];
        }
    }

    public int size() {
        return size;
    }

    public V get(K key1) {
        for(int i=0; i<size; i++){
            if(keys[i].equals(key1))
                return (V) values[i];
        }
        return null;
    }


    public V remove(K key) {
        for(int i=0; i<size; i++){
            if(keys[i].equals(key)){
                V result = (V) values[i];
                for(int j=i; j<size-1; j++){
                    keys[j] = keys[j+1];
                    values[j] = values[j+1];
                }
                size--;
                if(size == capacity / 2){
                    reduceCapacity();
                    copyArr();
                }
                return result;
            }
        }

        return null;
    }

    private void reduceCapacity() {
        capacity = capacity / 2;
    }

    public boolean containsKey(K key) {
        for(int i=0; i<size; i++){
            if(keys[i].equals(key))
                return true;
        }
        return false;
    }

    public boolean containsValue(V value) {
        for (Object v : values) {
            if(value.equals((V) v))
                return true;
        }
        return false;
    }

    public void clear() {
        size = 0;
        capacity = 2;
        keys = new Object[capacity];
        values = new Object[capacity];
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }
}
