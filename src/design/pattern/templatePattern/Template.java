package design.pattern.templatePattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public abstract class Template {

    // template method - final - can't be overridden by clients of this design.pattern.templatePattern.Template
    public final void doAllTasks(){
        doPrimaryTask();
        doSecondaryTask();
    }

    protected void doPrimaryTask(){
        // to be impl by clients
    }
    protected void doSecondaryTask(){
        // to be impl by clients
    }
}
