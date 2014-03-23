/**
 * ArrayIterator.java
 * 
 * Copyright (c) Addison Wesley Publishing
 */

package jsjf;

import java.util.*;

/*
 * Represents an iterator over the elements of an array.
 * 
 * @author Lewis/Chase
 */
public class ArrayIterator<T> implements Iterator<T>
{
  private int count;    // the number of elements in the collection
  private int current;  // the current position in the iteration
  private T[] items;
  
  /*
   * Sets up this iterator using the specified items.
   * 
   * @param collection the collection to iterate
   * @param size size of the specified collection
   */
  public ArrayIterator (T[] collection, int size)
  {
    items = collection;
    count = size;
    current = 0;
  }
  
  /*
   * Returns true if this iterator has at least one more element
   * to deliver in the iteration.
   * 
   * @return true if at least one more element exists
   */
  public boolean hasNext()
  {
    return (current < count);
  }
  
  /*
   * Returns the next element in the iteration.
   * 
   * @return the next element in the iteration
   * @throws NoSuchElementException if there are no more 
   * elements in this iteration
   */
  public T next() throws NoSuchElementException
  {
    if (! hasNext())
      throw new NoSuchElementException();
    
    current++;
    
    return items[current - 1];
  }
  
  /*
   * The remove operation is not supported in this collection.
   * 
   * @throws UnsupportedOperationException if called
   */
  public void remove() throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException();
  }
}
