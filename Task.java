import java.util.Calendar;
import java.util.Date;

public class Task implements Cloneable
{
    public String description;
    public Date dueDate;
    public Task next_task;

    public Task(String description , Date dueDate)
    {
        this.description = description;
        this.dueDate = dueDate;
        next_task = null;
    }

    @Override
    public String toString()
    {
        return ("(" + this.description +", " + this.dueDate+")");
    }

    @Override
    public Task clone()
    {
        return new Task(this.description , this.dueDate);
    }

    public boolean has_next()
    {
        return (this.next_task != null);
    }



}