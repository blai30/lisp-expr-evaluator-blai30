/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ2;

/**
 *
 * @author Brian Lai
 */
public class StackClass<T> implements StackInterface {
    
    private T[] items;
    private int numItems;
    private int currentCap;
    private static int INITIAL_CAP = 25;
    
    public StackClass() {
        this(INITIAL_CAP);
    }
    
    public StackClass(int cap) {
        this.items = (T []) new Object[StackClass.INITIAL_CAP];
        this.numItems = 0;
        this.currentCap = cap;
    }

    @Override
    public void push(Object newEntry) {
        if (this.numItems == this.currentCap) {
            this.expand();
        }
        this.items[this.numItems] = (T) newEntry;
        this.numItems++;
    }
    
    private void expand() {
        T[] expansion = (T[]) new Object[this.currentCap+25];
        System.arraycopy(this.items, 0, expansion, 0, this.numItems);
        this.items = expansion;
    }
    
    @Override
    public T pop() {
        if (this.empty()) {
            return null;
        }
        T removing = this.items[this.numItems-1];
        this.items[this.numItems-1] = null;
        this.numItems--;
        return removing;
    }

    @Override
    public T peek() {
        if (!this.empty()) {
            return this.items[this.numItems-1];
        }
        return null;
    }

    @Override
    public boolean empty() {
        return this.numItems == 0;
    }

//    @Override
//    public int search(Object entry) {
//        for (int i = this.numItems-1; i > -1; i--) {
//            if (this.items[i].equals(entry)) {
//                return this.numItems - i;
//            }
//        }
//        return -1;
//    }

    @Override
    public void clear() {
        while (!this.empty()) {
            this.pop();
        }
    }

    @Override
    public int size() {
        return this.numItems;
    }
    
}
