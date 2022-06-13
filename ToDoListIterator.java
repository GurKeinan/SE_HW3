import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task>
{
    Task cur_task;
    public ToDoListIterator(ToDoList mylist)
    {
        this.cur_task = mylist.tail;
    }
    @Override
    public boolean hasNext() {
        return (cur_task != null);
    }

    public Task next()
    {
        Task temp=cur_task;
        cur_task = cur_task.next_task;
        return temp;
    }

}
