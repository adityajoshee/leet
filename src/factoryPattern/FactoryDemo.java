package factoryPattern;

/**
 * Created by aditya.joshee on 20/07/15.
 */
public class FactoryDemo {
    public static void main(String args[]){
        ShapeFactory shapeFactory=new ShapeFactory();
        Shape someShape=shapeFactory.getShape("circle");
        someShape.draw();

    }
}
