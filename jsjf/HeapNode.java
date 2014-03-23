/**
 * HeapNode.java
 * 
 * Copyright (c) Addison Wesley Publishing
 */

package jsjf;

/**
 * Creates a binary tree node with a parent pointer for use 
 * in heaps.
 * 
 * @author Lewis/Chase
 */
public class HeapNode<T> extends BinaryTreeNode<T>
{
   protected HeapNode<T> parent;

   /**
    * Creates a new heap node with the specified data.
    * 
    * @param obj the object to be stored in node
    */
   HeapNode (T obj) 
   {
      super(obj);
      parent = null;
   }
}
