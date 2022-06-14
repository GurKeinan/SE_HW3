import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task>
{
    private ToDoList toDoList;
    private ToDoList clone;
    private int index;
    public ToDoListIterator(ToDoList myList)
    {
        this.toDoList = myList;
        this.index = 0;
        this.clone = myList.clone();
        clone.smileSort();
    }
    @Override
    public boolean hasNext() {
        if(clone.getScanningDueDate() == null) {
            return (index < clone.getNumOfElements());
        }
        return ((index < clone.getNumOfElements())&&
                (clone.getToDoList().get(index).getDueDate().compareTo(clone.getScanningDueDate()) <= 0));
    }

    public Task next()
    {
        index++;
        return clone.getToDoList().get(index - 1);
    }

}
