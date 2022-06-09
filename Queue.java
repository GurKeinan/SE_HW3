import java.lang.reflect.*;

public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    void enqueue(E element);
    E dequeue();
    E peek();
    int size();
    boolean isEmpty();
    Queue<E> clone();
}


public class ArrayQueue<E extends Cloneable> implements Queue<E>, Iterable<E>, Cloneable
{

    Cloneable[] elements;
    int size;
    int num_of_elements;
    int head;
    int tail;

    public ArrayQueue(int size)
    {
        if (size <= 0) throw new NegativeCapacityException();
        else
        {
            this.size = size;
            elements = new Cloneable[size];
        }
    }

    @Override
    public void enqueue(E element)
    {
        if (this.num_of_elements == this.size) throw new QueueOverflowException();
        else
        {
            this.head = (this.head+1)%this.size;
            this.num_of_elements += 1;
            this.elements[this.head] = element;

        }

    }
    public E dequeue()
    {
        if (this.num_of_elements == 0) throw new EmptyQueueException();
        else
        {
            this.tail = (this.tail+1)%this.size;
            this.num_of_elements -= 1;
            return ((E)this.elements[this.tail]);
        }
    }

    public E peek()
    {
        if (this.num_of_elements == 0) throw new EmptyQueueException();
        else
        {
            return ((E)this.elements[this.tail]);
        }
    }
    public int size()
    {
        return this.size;
    }


    public boolean isEmpty()
    {
        return (num_of_elements == 0);
    }

    public Queue<E> clone()
    {
        Method clone = null;
        try {

            ArrayQueue<E> temp = (ArrayQueue<E>)super.clone();
            temp.elements = this.elements.clone();
            for (int i = this.head ; i < num_of_elements ; i++) {
                temp.elements[i % size] = (E) (elements[i % size].clone());
            }
        catch(Exception e){  return null;}
            }





    }

}
