package jsjf;

import jsjf.exceptions.*;
import java.util.ArrayList;

/**
 * An array list implementation of a stack.
 *
 * Solution to Programming Project 6.2.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class ArrayListStack<T> implements StackADT<T>
{
    ArrayList<T> stack;

    /**
     * Creates an empty stack.
     */
    public ArrayListStack()
    {
        stack = new ArrayList<T>();
    }

    /**
     * Adds the specified element to the top of this stack.
     * @param element generic element to be pushed onto stack
     */
    public void push(T element)
    {
        stack.add(element);
    }

    /**
     * Removes the element at the top of this stack and returns a
     * reference to it. 
     * @return element removed from top of stack
     * @throws EmptyCollectionException if stack is empty 
     */
    public T pop() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack.remove(stack.size()-1);
    }
   
    /**
     * Returns a reference to the element at the top of this stack.
     * The element is not removed from the stack.  
     * @return element on top of stack
     * @throws EmptyCollectionException if stack is empty
     */
    public T peek() throws EmptyCollectionException
    {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return stack.get(stack.size()-1);
    }

    /**
     * Returns true if this stack is empty and false otherwise. 
     * @return true if this stack is empty
     */
    public boolean isEmpty()
    {
        return (stack.size() == 0);
    }
 
    /**
     * Returns the number of elements in this stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return stack.size();
    }

    /**
     * Returns a string representation of this stack. 
     * @return a string representation of the stack
     */
    public String toString()
    {
        String result = "";

        for (T elem : stack)
             result = result + elem + "\n";

        return result;
    }
}

