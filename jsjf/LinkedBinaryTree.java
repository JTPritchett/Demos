/**
 * LinkedBinaryTree.java
 * 
 * Copyright (c) Addison Wesley Publishing
 */

package jsjf;



import java.util.Iterator;

import jsjf.exceptions.*;

/**
 * Implements the BinaryTreeADT interface.
 * 
 * @author Lewis/Chase
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>
{
   protected int count;
   protected BinaryTreeNode<T> root; 

   /**
    * Creates an empty binary tree.
    */
   public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }

   /**
    * Creates a binary tree with the specified element as its root.
    * 
    * @param element the root element
    */
   public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }

   /**
    * Constructs a binary tree from the two specified binary trees.
    * 
    * @param element the root element
    * @param leftSubtree the tree to be used as left child
    * @param rightSubtree the tree to be used as right child
    */
   public LinkedBinaryTree (T element, LinkedBinaryTree<T> leftSubtree,
                            LinkedBinaryTree<T> rightSubtree) 
   {
      root = new BinaryTreeNode<T> (element);
      count = 1;
      
      if (leftSubtree != null)
      {
         count = count + leftSubtree.size();
         root.left = leftSubtree.root;
      }
      else
         root.left = null;
      
      if (rightSubtree !=null)
      {
         count = count + rightSubtree.size();
         root.right = rightSubtree.root;
      }
      else
         root.right = null;
   }
   
   /**
    * Removes the left subtree of this binary tree.
    */
   public void removeLeftSubtree() 
   {
      if (root.left != null)
         count = count - root.left.numChildren() - 1;
      root.left = null;
   }
   
   /**
    * Removes the right subtree of this binary tree.
    */
   public void removeRightSubtree() 
   {
      if (root.right != null)
         count = count - root.right.numChildren() - 1;
      
      root.right = null;
   }
   
   /**
    * Deletes all nodes from this binary tree.
    */
   public void removeAllElements() 
   {
      count = 0;
      root = null;
   }
   
   /**
    * Checks to see if this binary tree is empty.
    * 
    * @return true if the tree is empty, false otherwise
    */
   public boolean isEmpty() 
   {
      return (count == 0);
   }

   /**
    * Gets the size of this binary tree.
    * 
    * @return true if the binary tree is empty, false otherwise
    */
   public int size() 
   {
      return count;
   }
   
   /**
    * Searches this tree for an element that matches the specified
    * target element.
    * 
    * @param targetElement the search element
    * @return true if tree contains search element, false
    * otherwise
    */
   public boolean contains (T targetElement) 
   {
      T temp;
      boolean found = false;
      
      try 
      {
         temp = find (targetElement);
         found = true;
      }
      catch (Exception ElementNotFoundException) 
      {
         found = false;
      }
      
      return found;
   }
   
   /**
    * Returns a reference to the specified target element if it is
    * found in this binary tree.
    * 
    * @targetElement the search element
    * @return element in tree that matches the search element
    * @throws NoSuchElementException if the specified target 
    * element is not found in the binary tree
    * 
    */
   
   public T getRootElement()
   {
	   
       BinaryTreeNode<T> current = root;
       return current.element;
   }
   public LinkedBinaryTree<T> getLeft()
   {
	   
	  LinkedBinaryTree<T> left = null;
	  if (root.left !=null)
			  left= new LinkedBinaryTree<T> (root.left.element);
	  
	  return left;
   }
   
   /**
    * Returns the right subtree of the root of this tree.
    *
    * @return a link to the right subtree of the tree
    */
   public LinkedBinaryTree<T> getRight()
   {
	   LinkedBinaryTree<T> right = null;
	   if (root.right !=null)
			   new LinkedBinaryTree<T> (root.right.element);
		  return right;
   }
   
   
   public T find(T targetElement)
   {
      BinaryTreeNode<T> current = findAgain( targetElement, root );
      
    
      return (current.element);
   }

   /**
    * Returns a reference to the node that preceeds the specified 
    * target element if it is found in this binary tree.
    * 
    * @param targetElement the search element
    * @param next the current node
    * @return the node that preceeds node containing search
    * element
    */ 
   private BinaryTreeNode<T> findAgain(T targetElement, 
                                       BinaryTreeNode<T> next)
   {
      if (next == null)
         return null;
      
      if (next.element.equals(targetElement))
         return next;
      
      BinaryTreeNode<T> temp = findAgain(targetElement, next.left);
      
      if (temp == null)
         temp = findAgain(targetElement, next.right);
      
      return temp;
   }
   
   /**
    * Gets this binary tree as a string.
    * 
    * @return a string representation of the binary tree
    */
   public String toString() 
   {
      LinkedBinaryTree<T> tempList = new   LinkedBinaryTree<T>();
     
      
      return tempList.toString();
   }

   /**
    * Performs an inorder traversal on this binary tree by calling
    * an overloaded, recursive inorder method that starts with
    * the root.
    * 
    * @return an iterator over the tree
    */
   public Iterator<T> iteratorInOrder()
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      inorder (root, tempList);
      
      return tempList.iterator();
   }

   /**
    * Performs a recursive inorder traversal.
    * 
    * @param node the current node
    * @param tempList the current list
    */
   protected void inorder (BinaryTreeNode<T> node, 
                           ArrayUnorderedList<T> tempList) 
   {
      if (node != null)
      {
         inorder (node.left, tempList);
         tempList.addToRear(node.element);  //visit  
         inorder (node.right, tempList);
      }
   }

   /**
    * Performs an preorder traversal on this binary tree by calling
    * an overloaded, recursive preorder method that starts with
    * the root.
    * 
    * @return an iterator over the tree
    */
   public Iterator<T> iteratorPreOrder() 
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      preorder (root, tempList);
      
      return tempList.iterator();
   }

   /**
    * Performs a recursive preorder traversal.
    * 
    * @param node the current node
    * @param tempList the current list
    */
   protected void preorder (BinaryTreeNode<T> node, 
                            ArrayUnorderedList<T> tempList) 
   {
      if (node != null)
      {
         tempList.addToRear(node.element);
         preorder (node.left, tempList);
         preorder (node.right, tempList);
      }
   }

   /**
    * Performs an postorder traversal on this binary tree by 
    * calling an overloaded, recursive postorder method that 
    * starts with the root.
    * 
    * @return an iterator over the tree
    */
   public Iterator<T> iteratorPostOrder() 
   {
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      postorder (root, tempList);
      
      return tempList.iterator();
   }

   /**
    * Performs a recursive postorder traversal.
    * 
    * @param node the current node
    * @param tempList the current list
    */
   protected void postorder (BinaryTreeNode<T> node, 
                             ArrayUnorderedList<T> tempList) 
   {
      if (node != null)
      {
         postorder (node.left, tempList);  //Left
         postorder (node.right, tempList);   // Right
         tempList.addToRear(node.element); //Vist
      }
   }

   /**
    * Performs a levelorder traversal on this binary tree, using
    * a templist.
    * 
    * @return an iterator over the tree
    */
   public Iterator<T> iteratorLevelOrder() 
   {
      ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                       new ArrayUnorderedList<BinaryTreeNode<T>>();
      ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;

      nodes.addToRear (root);
      
      while (! nodes.isEmpty()) 
      {
         current = (BinaryTreeNode<T>)(nodes.removeFirst());
         
         if (current != null)
         {
            tempList.addToRear(current.element);
            if (current.left!=null)
               nodes.addToRear (current.left);
            if (current.right!=null)
               nodes.addToRear (current.right);
         }
         else
            tempList.addToRear(null);
      }
      
      return tempList.iterator();
   }
 
   
}
