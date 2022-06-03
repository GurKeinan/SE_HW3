public class Node<E>
{
    public E value;
    public int index_Node_Before_Current;
    //public int num_Node_After_Current; - probably not necessary

    public Node(E value)
    {
        this.value = value;
    }

    public void set_index_Node_Before_Current(int index_Node_Before_Current)
    {
        this.index_Node_Before_Current = index_Node_Before_Current;
    }


}
