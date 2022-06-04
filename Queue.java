
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

    public Node<E> head;
    public Node<E> tail;
    public int max_size;
    public int cur_size;

    public ArrayQueue(int max_size) throws NegativeCapacityException
    {
        if (max_size <= 0) throw new NegativeCapacityException();
        this.max_size = max_size;
        this.cur_size = 0;
        this.head = null;
        this.tail = null;
    }

    public
    public void enqueue(E element)
    {
        if (this.cur_size == this.max_size) throw new QueueOverflowException();
        this.cur_size++;
        if (this.head == null) this.head = new Node(element , null , null);
        else this.tail = new Node(element , this.tail , null);
    }

    public E dequeue()
    {
        if (this.cur_size == 0) throw new EmptyQueueException();
        Node<E> ret = this.head;
        this.head = ret.Node_After_Current;
        cur_size--;
        return ret.value;
    }

    public E peek()
    {
        if (this.cur_size == 0) throw new EmptyQueueException();
        return this.head.value;
    }


    public int size() {
        return this.cur_size;
    }

    public boolean isEmpty()
    {
        return(cur_size == 0) ? true:false;

    }

    public Queue clone()
    {
        ArrayQueue new_que = new
        new_que.head =
    }

}