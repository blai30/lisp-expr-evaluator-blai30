/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PJ2;

/**
 *
 * @author Brian
 */
public class StackClass<T> implements StackInterface {
    
    private T[] items;
    private int numItems;
    private int currentCap;
    private static final int INITIAL_CAP = 25;
    
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
    public Object pop() {
        if (this.isEmpty()) {
            return null;
        }
        
    }

    @Override
    public Object peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return this.numItems == 0;
    }

    @Override
    public int search(Object entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
