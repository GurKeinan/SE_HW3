import java.util.ArrayList;
import java.util.Date;

public class ToDoList implements Cloneable, Iterable<Task>, TaskIterable
{
    private ArrayList<Task> toDoList;
    private Date scanningDueDate;
    public int numOfElements;

    public ToDoList()
    {
        toDoList = new ArrayList();
        numOfElements = 0;
        scanningDueDate = null;
    }

    public Date getScanningDueDate() {
        return scanningDueDate;
    }

    public ArrayList<Task> getToDoList() {
        return toDoList;
    }

    public int getNumOfElements() {
        return numOfElements;
    }

    public void setNumOfElements(int numOfElements) {
        this.numOfElements = numOfElements;
    }

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

    public void setScanningDueDate(Date date)
    {
        this.scanningDueDate = date;
        /*if(date == null){
            for(Task t: this.toDoList){
                System.out.println(t);
            }
        }
        else{
            int i = 0;
            smileSort();
            while(this.toDoList.get(i).getDueDate().compareTo(date) <= 0)
            {
                System.out.println(this.toDoList.get(i).toString());
            }

        }*/

    }
    public ToDoListIterator iterator()
    {
        return new ToDoListIterator(this);
    }

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

    //TODO
    @Override
    public int hashCode()
    {
        return 0;
    }

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
