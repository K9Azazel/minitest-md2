package manager;

import java.util.Arrays;

public class MaterialManager<E> {
    int size = 0;
    static final int  DEFAULT_CAPACITY = 10;
    E materials[];
    public MaterialManager(){
        materials = (E[]) new Object[DEFAULT_CAPACITY];
    }
    public MaterialManager(int size) {
        materials = (E[]) new Object[size];
    }
    public void add(E e) {
        size += 1;
        ensureCapa();
        materials[size - 1] = e;
    }
    private void ensureCapa() {
        if (size > materials.length) {
            int biggerSize = size * 2 + 1;
            materials = Arrays.copyOf(materials, biggerSize);
        }
    }
    public boolean add(E e, int index) {
        if (index >= 0 && index <= size) {
            size += 1;
            ensureCapa();
            for (int i = size - 2; i >= index; i--) {
                materials[i + 1] = materials[i];
            }
            materials[index] = e;
            return true;
        }
        return false;
    }
    public int size(){
        return materials.length;
    }
    public E get(int index) {
        if (index >= 0 && index < size) {
            return materials[index];
        }
        return null;
    }
    public boolean contains(E e) {
        for (E x : materials) {
            if (e.equals(x)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        int index = -1;
        for (int i = 0; i < materials.length ; i++) {
            if (materials[i] == o){
                index = i;
                break;}
        }
        return index;
    }
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                materials[i] = materials[i + 1];
            }
            size -= 1;
            return true;
        }
        return false;
    }
    public void set(int index,E e){
        materials[index] = e;
    }
}