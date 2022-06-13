import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    ArrayQueue<E> arrayQueue;
    int cur_index;
    int counted = 0;

    public ArrayQueueIterator(ArrayQueue<E> arr)
    {
        this.arrayQueue = arr;
        this.cur_index = this.arrayQueue.head;
    }
    public boolean hasNext()
    {
        if (arrayQueue.elements[(cur_index)%arrayQueue.size] == null) return false;
        if(counted >= arrayQueue.num_of_elements) return false;

                 
        else return true;
    }



    public E next()
    {
        E temp = (E)(arrayQueue.elements[(cur_index)%arrayQueue.size]);
        cur_index++;
        counted++;
        return temp;
    }

    public void remove()
    {
        arrayQueue.elements[cur_index] = null;
    }






















}
