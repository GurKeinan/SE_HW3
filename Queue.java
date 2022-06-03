
public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    void enqueue(E element);
    E dequeue();
    E peek();
    int size();
    boolean isEmpty();
    Queue<E> clone();
}


public class ArrayQueue<E extends Cloneable> implements Queue<E> ,Iterable, Cloneable
{
    public Node[] Node_array;

    public void enqueue(E element)
    {

    }

    public E dequeue()
    {

    }

    public E peek()
    {

    }


    public int size() {
        return 0;
    }

    public boolean isEmpty()
    {

    }

    public Queue clone()
    {

    }

}