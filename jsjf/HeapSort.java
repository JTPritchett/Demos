/**
 * HeapSort.java
 * 
 * Copyright (c) Addison Wesley Publishing
 */

package jsjf;

import hw_9_10_280.Athlete;

/**
 * Sorts a given array of Comparable objects using a heap.
 * 
 * @author Lewis/Chase
 */
public class HeapSort<T>
{
   /**
    * Sorts this array with the given data.
    * 
    * @param data the array to be sorted
    * @param min the minimum index value
    * @param max the maximum index value
    */
   public static  <T extends Comparable<T>> void HeapSort(T[] data, int min, int max) 
   {
      Heap<T> temp = new Heap<T>();

      /** copy the array into a heap */
      for (int ct = min; ct <= max; ct++)
         temp.addElement(data[ct]);

      /** place the sorted elements back into the array */
      int count = min;
      while (!(temp.isEmpty()))
      {
         data[count] = temp.removeMin();
         count++;
      }
   }
}
