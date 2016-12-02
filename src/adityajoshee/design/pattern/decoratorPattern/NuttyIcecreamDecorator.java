package adityajoshee.design.pattern.decoratorPattern;

/**
 * Created by aditya on 11/27/16.
 */
public class NuttyIcecreamDecorator {
    IcecreamFactory icecreamFactory;

    public NuttyIcecreamDecorator(IcecreamFactory icecreamFactory){
        this.icecreamFactory = icecreamFactory;

    }

    public void addNuts(){

    }
}
