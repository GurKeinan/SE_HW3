import java.util.Iterator;

public class ToDoListIterator implements Iterator<Task>
{
    private ToDoList toDoList;
    private ToDoList clone;
    private int index;

    /**
     * constructor for todolisteiterator
     * @param myList the list this iterator will iterate on
     */
    public ToDoListIterator(ToDoList myList)
    {
        this.toDoList = myList;
        this.index = 0;
        this.clone = myList.clone();
        clone.smileSort();
    }

    /**
     * check's if there is another task that needs to be iterated on in todolist
     * @return whether there is another task that needs to be iterated on in todolist
     */
    @Override
    public boolean hasNext() {
        if(clone.getScanningDueDate() == null) {
            return (index < clone.getNumOfElements());
        }
        return ((index < clone.getNumOfElements())&&
                (clone.getToDoList().get(index).getDueDate().compareTo(clone.getScanningDueDate()) <= 0));
    }

    /**
     * moves iterator to the next task in todolist
     * @return the task in todolist pointed on by iterator
     */
    public Task next()
    {
        index++;
        return clone.getToDoList().get(index - 1);
    }

}
