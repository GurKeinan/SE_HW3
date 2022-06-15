import java.lang.reflect.*;
import java.util.Iterator;

public interface Queue<E extends Cloneable> extends Iterable<E>, Cloneable {
    /**
     * adding new item to the queue
     * @param element- the added item
     */
    void enqueue(E element);

    /**
     * removing the first added item from the queue and returning it
     * @return the first added item (in the beginning of the queue)
     * @throws QueueOverflowException if the max_num_of items has been reached
     */
    E dequeue();

    /**
     * @return the first added item (in the beginning of the queue)
     * @throws EmptyQueueException if the queue is empty
     */
    E peek();

    /**
     * @return the number of items currently in the queue
     * @throws EmptyQueueException if the queue is empty
     */
    int size();

    /**
     * @return true if the queue is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * deep clone of this queue
     * @return clone of this queue
     * @throws Exception if something went wrong

     */
    Queue<E> clone();
}


class ArrayQueue<E extends Cloneable> implements Queue<E>, Iterable<E>, Cloneable
{


    private Cloneable[] elements; //array of cloneable objects (will be casted later), contains our queue
    private int max_num_of_items; //max number of items this ArrayQueue will contain
    private int size; //current number of items in this ArrayQueue
    private int head; //the first added (and first removed) item
    private int tail; //the last added (and last removed) item

    /**
     * constructor for new ArrayQueue
     * @param max_num_of_items- max number of items this ArrayQueue will contain
     * @throws NegativeCapacityException if the given max_num_of_items is negative
     */
    public ArrayQueue(int max_num_of_items)
    {
        if (max_num_of_items <= 0) throw new NegativeCapacityException();
        else
        {
            this.max_num_of_items = max_num_of_items;
            elements = new Cloneable[max_num_of_items];
            this.head = 0;
            this.tail = 0;

        }
    }


    /**
     * get method for this' elements array
     */
    public Cloneable[] getElements() {
        return this.elements;
    }

    /**
     * get method for this' size
     */
    public int getSize() {
        return this.size;
    }

    /**
     *get method for this' head item
     */
    public int getHead() {
        return this.head;
    }

    /**
     * adds new item to the queue, the tail will go back to zero if exceeds the max_num_of_items
     * @param element- the added item
     */
    @Override
    public void enqueue(E element)
    {
        if (this.size == this.max_num_of_items) throw new QueueOverflowException();
        else if(size == 0)
        {
            this.size += 1;
            this.elements[this.tail] = element;
        }
        else
        {
            this.tail = (this.tail+1)%this.max_num_of_items;
            this.size += 1;
            this.elements[this.tail] = element;

        }

    }

    /**
     * remove item from the queue, the head will go back to zero if exceeds the max_num_of_items
     * @return the first added item
     */
    public E dequeue()
    {
        if (this.size == 0) throw new EmptyQueueException();
        else if(this.size == 1)
        {
            this.size -= 1;
            E temp = ((E)this.elements[this.head]);
            this.elements[head] = null;
            return temp;
        }
        else
        {

            this.size -= 1;
            E temp = ((E)this.elements[this.head]);
            this.elements[head] = null;
            this.head = (this.head+1)%this.max_num_of_items;
            return temp;
        }
    }

    public E peek()
    {
        if (this.size == 0) throw new EmptyQueueException();
        else
        {
            return ((E)this.elements[this.head]);
        }
    }
    public int size()
    {
        return this.size;
    }


    public boolean isEmpty()
    {
        return (size == 0);
    }

    public ArrayQueue<E> clone()
    {
        ArrayQueue<E> temp = new ArrayQueue<E>(this.max_num_of_items);
        temp.size = this.size;
        temp.head = 0;
        temp.tail = 0;
        Method myclone = null;
        try {

            temp.elements = this.elements.clone();
            for (int i = this.head; i < size; i++) {
                E item = (E) this.elements[i % max_num_of_items];
                if (item != null) {
                    myclone = item.getClass().getMethod("clone"); //using invoke to get E's clone method
                    temp.elements[temp.tail] = (Cloneable) myclone.invoke(item); //cloning each item

                }
                else {temp.elements[temp.tail] = null;}
                temp.tail++;
            }
        }
        catch(Exception e){  return null;}
        return temp;
    }

    /**
     *
     * @return new ArrayQueueIterator with this ArrayQueue as an argument
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayQueueIterator<E>(this);
    }
}
