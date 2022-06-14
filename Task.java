import java.util.Calendar;
import java.util.Date;

public class Task implements Cloneable
{
    public String description;
    public Date dueDate;

    public Task(String description , Date date)
    {
        this.description = description;
        this.dueDate = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = (Date)dueDate.clone();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object T)
    {
        if(T == null) return (this == null);
        return (this.toString().equals(((Task)T).toString()));
    }


    //TODO
    @Override
    public int hashCode(){
        return 0;
    }

    @Override
    public String toString() {
        String day = String.valueOf(this.dueDate.getDate());
        String month = String.valueOf(this.dueDate.getMonth() + 1);
        String year = String.valueOf(this.dueDate.getYear() + 1900);
        if(month.length() == 1){
            month = "0" + month;
        }

        return (this.description +", " + day + "." +
                month +  "." + year);
    }

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


    public int compare(Task T)
    {
        int temp = this.dueDate.compareTo(T.dueDate);
        if (temp != 0) return temp;
        else return this.description.compareToIgnoreCase(T.description);
    }
}