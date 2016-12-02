package adityajoshee.design.pattern.factoryDesign;

/**
 * Created by aditya.joshee on 04/12/14.
 */
public class Maths extends Book {

    public static final Type type = Type.MATHS;

    public Maths() {

    }

    public Maths(String name) {
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
