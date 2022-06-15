import java.util.ArrayList;
import java.util.Date;

public class ToDoList implements Cloneable, Iterable<Task>, TaskIterable
{
    private ArrayList<Task> toDoList;
    private Date scanningDueDate;
    private int numOfElements;

    /**
     * constructor for to do list.
     */
    public ToDoList()
    {
        toDoList = new ArrayList();
        numOfElements = 0;
        scanningDueDate = null;
    }

    /**
     * returns the scanning due date of this todolist
     * @return scanning due date of this todolist
     */
    public Date getScanningDueDate() {
        return scanningDueDate;
    }

    /**
     * returns this todolist's arrayList of tasks
     * @return arrayList of tasks in this this todolist
     */
    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    /**
     * returns number of tasks in this todolist
     * @return number of elements in this todolist
     */
    public int getNumOfElements() {
        return numOfElements;
    }

    /**
     * adds given task to the end of arraylist
     * @param task task that to add to arraylist
     * @throws TaskAlreadyExistsException a task with the same description is already in arraylist
     */
    public void addTask(Task task) throws TaskAlreadyExistsException
    {
        for(int i = 0; i < numOfElements; i++){
            if((this.toDoList.get(i).description).equals(task.description)){
                throw new TaskAlreadyExistsException();
            }
        }
        this.toDoList.add(task);
        numOfElements++;
    }

    /**
     * sets the latest date that will be iterated to
     * @param date scanning due date
     */
    public void setScanningDueDate(Date date)
    {
        this.scanningDueDate = date;
    }

    /**
     * creates iterator for this todolist
     * @return iterator created for this todolist
     */
    public ToDoListIterator iterator()
    {
        return new ToDoListIterator(this);
    }

    /**
     * max sort for arraylist of tasks
     */
    public void smileSort()
    {
        for(int i = 0; i < numOfElements; i++) {
            int min_i = i;
            Task min = this.toDoList.get(min_i);
            for(int j = i + 1; j < numOfElements; j++) {
                if(this.toDoList.get(j).compare(min) < 0){
                    min = this.toDoList.get(j);
                    min_i = j;
                }
            }
            Task tmp = this.toDoList.get(i);
            this.toDoList.set(i, min);
            this.toDoList.set(min_i, tmp);
        }
    }

    /**
     * check's whether this todolist tasks are the same as another
     * @param T todolist that will be compared to this todolist
     * @return whether this todolist and another are the same
     */
    @Override
    public boolean equals(Object T){
        ToDoList t = (ToDoList) T;
        if(t == null) {
            return (this == t);
        }
        if(t.getNumOfElements() != this.numOfElements){
            return false;
        }
        t = (ToDoList)T;
        ToDoList tClone = t.clone();
        tClone.smileSort();
        ToDoList clone = this.clone();
        clone.smileSort();
        for(int i = 0; i < this.numOfElements; i++){
            if(!(clone.toDoList.get(i).equals(tClone.getToDoList().get(i)))){
                return false;
            }
        }
        return true;
    }

    /**
     * hashcode for this todolist
     * @return hashcode
     */
    @Override
    public int hashCode()
    {
        int sum = 0;
        for(int i = 0; i < numOfElements; i++){
            sum += this.toDoList.get(i).hashCode();
        }
        return sum;
    }

    /**
     * creates a string representing this todolist tasks
     * @return string representing the tasks in this todolist
     */
    @Override
    public String toString()
    {
        String ret_str = "[";
        for(int i = 0; i < this.numOfElements - 1; i++)
        {
            ret_str += "(" + this.toDoList.get(i).toString() + ")" +  ", ";
        }
        ret_str += "(" + this.toDoList.get(this.numOfElements - 1).toString() + ")" + "]";
        return ret_str;
    }

    /**
     * deep clone for this todolist
     * @return another todolist with the same values as this one
     */
    @Override
    public ToDoList clone() {
        try {
            ToDoList copy = new ToDoList();
            copy.setScanningDueDate(this.scanningDueDate);
            for (int i = 0; i < this.numOfElements; i++) {
                copy.addTask(this.toDoList.get(i).clone());
            }
            return copy;
        } catch (Exception e) {
            return null;
        }
    }
}
