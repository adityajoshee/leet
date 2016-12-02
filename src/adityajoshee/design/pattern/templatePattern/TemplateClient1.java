package adityajoshee.design.pattern.templatePattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class TemplateClient1 extends Template {

    public void doPrimaryTask(){
        System.out.println("Client 1 : primary task done.");
    }

    public void doSecondaryTask(){
        System.out.println("Client 1 : sec task done.");
    }


}
