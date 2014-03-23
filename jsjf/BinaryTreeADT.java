/** * BinaryTreeADT.java *  * Copyright (c) Addison Wesley Publishing */package jsjf;import java.util.Iterator;/** * Defines the interface to a binary tree data structure. *  * @author Lewis/Chase */public interface BinaryTreeADT<T> {   /**    * Removes the left subtree of the root of this binary tree.    */   public void removeLeftSubtree();   /**     * Removes the right subtree of the root of this binary tree.    */   public void removeRightSubtree();   /**    * Removes all elements from this binary tree.    */   public void removeAllElements();   /**    * Checks if this binary tree is empty.    *     * @return true if the binary tree is empty, false otherwise    */   public boolean isEmpty();   /**    * Gets the size of this binary tree.    *     * @return the number of elements in the binary tree    */   public int size();   /**    * Checks this binary tree for an element that matches the    * specified element.    *     * @param targetElement the search element    * @return true if the binary tree contains an element that     * matches the search element, false otherwise    */   public boolean contains (T targetElement);   /**    * Returns a reference to the specified element if it is     * found in this binary tree.    *     * @param targetElement the search element    * @return the element in the tree that matches the search    * element    * @throws an exception if the specified element is not found    */   public T find (T targetElement);   /**    * Gets this binary tree as a string.    *     * @return a string representation of the binary tree    */   public String toString();   /**    * Performs an inorder traversal on this binary tree by calling an     * overloaded, recursive inorder method that starts with the root.    *     * @return an iterator over the tree    */   public Iterator<T> iteratorInOrder();   /**    * Performs a preorder traversal on this binary tree by calling an     * overloaded, recursive preorder method that starts with the root.    *     * @return an iterator over the tree    */   public Iterator<T> iteratorPreOrder();   /**    * Performs a postorder traversal on this binary tree by calling an     * overloaded, recursive postorder method that starts with the root.    *     * @return an iterator over the tree    */   public Iterator<T> iteratorPostOrder();   /**    * Performs a levelorder traversal on the binary tree, using a list.    *     * @return an iterator over the tree    */   public Iterator<T> iteratorLevelOrder();}