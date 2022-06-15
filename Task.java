import java.util.Calendar;
import java.util.Date;

public class Task implements Cloneable
{
    private String description;
    private Date dueDate;

    /**
     * constructor for task
     * @param description description of this task
     * @param date this task's due date
     */
    public Task(String description , Date date)
    {
        this.description = description;
        this.dueDate = date;
    }

    /**
     * get method for description
     * @return this task's description
     */
    public String getDescription()
    {
        return this.description;
    }
    /**
     * returns due date
     * @return this task's due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * sets this task's due date
     * @param dueDate this task's new due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = (Date)dueDate.clone();
    }

    /**
     * check's whether this task has the same description and due date as the given task
     * @param T task that will be compared to this task
     * @return whether this task has the same values as given task
     */
    @Override
    public boolean equals(Object T)
    {
        if(T == null) return (this == null);
        return (this.toString().equals(((Task)T).toString()));
    }

    /**
     * returns a semi-unique hashcode of this task
     *
     * @return hashcode of this task.
     */
    @Override
    public int hashCode(){

        return this.dueDate.getMonth() + this.description.charAt(0);
    }

    /**
     * creates string representing the task's values
     * @return string representing this task's values
     */
    @Override
    public String toString() {
        String day = String.valueOf(this.dueDate.getDate());
        String month = String.valueOf(this.dueDate.getMonth() + 1);
        String year = String.valueOf(this.dueDate.getYear() + 1900);
        if(month.length() == 1){
            month = "0" + month;
        }
        if(day.length() == 1){
            day = "0" + day;
        }
        return (this.description +", " + day + "." +
                month +  "." + year);
    }

    /**
     * creates a deep clone of this task
     * @return a new task with the same values as this one
     */
    @Override
    public Task clone()
    {
        try {
            Task copy = (Task) super.clone();
            copy.dueDate = (Date)this.dueDate.clone();
            copy.description = this.description;
            return copy;
        }
        catch(Exception e){
            return null;
        }
    }

    /**
     * compares this task with another
     * @param T task that needs to be compared
     * @return whether this task is less than, equal to, or more than given task
     */
    public int compare(Task T)
    {
        int temp = this.dueDate.compareTo(T.dueDate);
        if (temp != 0) return temp;
        else return this.description.compareToIgnoreCase(T.description);
    }
}