import java.lang.reflect.*;
import java.util.Iterator;

public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    void enqueue(E element);
    E dequeue();
    E peek();
    int size();
    boolean isEmpty();
    Queue<E> clone();
}


class ArrayQueue<E extends Cloneable> implements Queue<E>, Iterable<E>, Cloneable
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
            this.head = 0;
            this.tail = 0;

        }
    }

    @Override
    public void enqueue(E element)
    {
        if (this.num_of_elements == this.size) throw new QueueOverflowException();
        else if(num_of_elements == 0)
        {
            this.num_of_elements += 1;
            this.elements[this.tail] = element;
        }
        else
        {
            this.tail = (this.tail+1)%this.size;
            this.num_of_elements += 1;
            this.elements[this.tail] = element;

        }

    }
    public E dequeue()
    {
        if (this.num_of_elements == 0) throw new EmptyQueueException();
        else if(this.num_of_elements == 1)
        {
            this.num_of_elements -= 1;
            E temp = ((E)this.elements[this.head]);
            this.elements[head] = null;
            return temp;
        }
        else
        {

            this.num_of_elements -= 1;
            E temp = ((E)this.elements[this.head]);
            this.elements[head] = null;
            this.head = (this.head+1)%this.size;
            return temp;
        }
    }

    public E peek()
    {
        if (this.num_of_elements == 0) throw new EmptyQueueException();
        else
        {
            return ((E)this.elements[this.head]);
        }
    }
    public int size()
    {
        return this.num_of_elements;
    }


    public boolean isEmpty()
    {
        return (num_of_elements == 0);
    }

    public ArrayQueue<E> clone()
    {
        ArrayQueue<E> temp = new ArrayQueue<E>(this.size);
        temp.num_of_elements = this.num_of_elements;
        temp.head = 0;
        temp.tail = 0;
        Method myclone = null;
        try {

            temp.elements = this.elements.clone();
            for (int i = this.head; i < num_of_elements; i++) {
                E item = (E) this.elements[i % size];
                if (item != null) {
                    myclone = item.getClass().getMethod("clone");
                    temp.elements[temp.tail] = (Cloneable) myclone.invoke(item);

                }
                else {temp.elements[temp.tail] = null;}
                temp.tail++;
            }
        }
        catch(Exception e){  return null;}
        return temp;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<E>(this);
    }
}
