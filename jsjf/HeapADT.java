/**
 * HeapADT.java
 * 
 * Copyright (c) Addison Wesley Publishing
 */

package jsjf;

/**
 * Defines the interface to a Heap.
 * 
 * @author Lewis/Chase
 */
public interface HeapADT<T> extends BinaryTreeADT<T> 
{
   /** 
    * Adds the specified object to this heap.
    * 
    * @param obj the object to be added
    */
   public void addElement (T obj);
   
   /**
    * Removes element with the lowest value from this heap.
    * 
    * @return element with the lowest value removed from heap
    */
   public T removeMin();
   
   /**
    * Returns a reference to the element with the lowest value in 
    * this heap.
    * 
    * @return element with the lowest value currently in heap
    */
   public T findMin();
}
