package design.pattern.templatePattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class TemplatePatternDemo {
    public static void main(String args[]){
        Template template1=new TemplateClient1();
        Template template2=new TemplateClient2();

        template1.doAllTasks();
        template2.doAllTasks();
    }
}
