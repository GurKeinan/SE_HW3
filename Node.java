public class Node<E>
{

    //after- node which was added after the current
    //before- node which was added before the current
    public E value;
    public Node Node_Before_Current;
    public Node Node_After_Current;

    public Node(E value , Node p_Node_Before_Current , Node p_Node_After_Current)
    {
        this.value = value;
        this.Node_Before_Current = p_Node_Before_Current;
        this.Node_After_Current = null;
        p_Node_After_Current.Node_After_Current = this;

    }


    public boolean has_next()
    {
        return (this.Node_After_Current == null) ? false : true;
    }


}
