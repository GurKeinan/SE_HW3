import java.util.Iterator;

public class ArrayQueueIterator<E extends Cloneable> implements Iterator<E> {
    private ArrayQueue<E> arrayQueue;
    private int cur_index; // current checked item in the queue
    private int counted = 0; // number of items counted

    /**
     * constructor for new ArrayQueueIterator
     * @param arr- the ArrayQueue we want to iterate through
     */
    public ArrayQueueIterator(ArrayQueue<E> arr)
    {
        this.arrayQueue = arr;
        this.cur_index = this.arrayQueue.getHead();
    }

    /**
     *
     * @return if this element is legal (not empty or already checked)
     */
    public boolean hasNext()
    {
        if (arrayQueue.getElements()[(cur_index)%arrayQueue.getSize()] == null) return false; // if we reached null object
        if(counted >= arrayQueue.getSize()) return false;
        // if we reached the number of existing items we know we're done

                 
        else return true;
    }


    /**
     * return the current item casted to the wanted type and increases cur with consideration to the array size
     * (option to module)
     * @return this item
     */
    public E next()
    {
        E temp = (E)(arrayQueue.getElements()[(cur_index)%arrayQueue.getSize()]);
        cur_index++;
        counted++;
        return temp;
    }

    public void remove()
    {
        arrayQueue.getElements()[cur_index] = null;
    }






















}
