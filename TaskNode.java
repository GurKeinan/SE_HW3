public class TaskNode {
    private Task task;
    private TaskNode next;

    public TaskNode(){
        this.task = null;
        this.next = null;
    }

    public TaskNode(Task t){
        this.task = t;
        this.next = null;
    }

    public TaskNode(Task t, TaskNode next){
        this.task = t;
        this.next = next;
    }

    public Task getTask() {
        return task;
    }

    public TaskNode getNext() {
        return next;
    }

    public void setNext(TaskNode next) {
        this.next = next;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public boolean hasNext(){
        if(this.next == null) return false;
        return true;
    }
}
