package factoryPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class ShapeFactory {

    public static Shape getShape(String shape){
        if(shape.equalsIgnoreCase("circle")){
            return new Circle();

        }
        if(shape.equalsIgnoreCase("square")){
            return new Square();

        }
        return null;
    }
}
