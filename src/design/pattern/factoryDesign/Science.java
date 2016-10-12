package design.pattern.factoryDesign;

/**
 * Created by aditya.joshee on 04/12/14.
 */
public class Science extends Book {

    public static final Type type= Type.SCIENCE;


    public Science(){

    }

    public Science(String name){
        super(name);
    }

    @Override
    public void read() {

    }

    @Override
    public String toString() {
        return "Book Type: "+type;
    }


}
