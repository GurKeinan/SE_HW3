public class ToDoList implements Cloneable, Iterable<Task>
{
    public Task head;
    public Task tail;
    public int size;

    public ToDoList()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean check_description(Task cur_checked , Task task_to_add)
    {
        boolean result = cur_checked.description.equals(task_to_add.description);
        if (!cur_checked.has_next()) return result;
        else{
            if (!result) return false;
            return check_description(cur_checked.next_task , task_to_add);
        }
    }

    public void addTask(Task task_to_add) throws TaskAlreadyExistsException
    {
        if (size == 0)
        {
            this.head = task_to_add;
            this.tail = task_to_add;
            size++;
        }
        else
        {
            if (check_description(this.tail , task_to_add))
            {
                this.head.next_task = task_to_add;
                this.head = this.head.next_task;
                size++;
            }
            else throw new TaskAlreadyExistsException();
        }
    }

    public ToDoListIterator iterator()
    {
        return new ToDoListIterator(this);
    }

    public void smileSort()
    {
        ToDoList temp = new ToDoList();
        Task min = this.head;
        for(Task tmp1 : this){
            for(Task tmp2 : this)
            {
                if(tmp2.compare(tmp1) < 0){
                    less++;
                }
            }

            less = 0;
        }
    }

    @Override
    public boolean equals(Object T){

        for(int i = 0; i < size; i++)
        {

        }
    }

    @Override
    public String toString()
    {
        String ret_str = "[";
        Task cur_task = this.tail;
        while(cur_task.has_next())
        {
            ret_str += cur_task.toString() + ", ";
        }
        ret_str += cur_task.toString()+"]";
        return ret_str;
    }

    @Override
    public ToDoList clone()
    {
        ToDoList temp = new ToDoList();
        if (this.size == 0) return temp;
        try {
            temp.tail = this.tail.clone();
            temp.head = this.tail.clone();
            Task cur_cloned = this.tail;
            while (cur_cloned.has_next())
            {
                temp.addTask(cur_cloned.next_task.clone());
                cur_cloned = cur_cloned.next_task;
            }
        }
        catch(Exception e) {return null;};
        return temp;
    }




}
