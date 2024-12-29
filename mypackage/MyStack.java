package mypackage;
public class MyStack<T> 
{
    private static class Node<T>
    {
        private T data;
        private Node<T> prev;

        public Node(T data, Node<T> prev)
        {
            this.data = data;
            this.prev = prev;
        }
    }

    // Stack attributes
    private Node<T> top;
    private int size;

    // Stack constructor
    public MyStack()
    {
        top = null;
        size = 0;
    }

    // Push method
    public void push(T val)
    {
        top = new Node<>(val, top);
        size++;
    }

    // Pop method
    public T pop()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        T to_return = top.data;
        top = top.prev;
        size--;
        return to_return;
    }

    public T peek()
    {
        if (size == 0)
        {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data; 
    }

    // To check if the stack is empty
    public boolean isEmpty()
    {
        if (size == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getSize()
    {
        return size;
    }

    public void clear()
    {
        while (size != 0)
        {
            pop();
        }
    }

}
