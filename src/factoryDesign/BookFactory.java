package factoryDesign;

/**
 * Created by aditya.joshee on 04/12/14.
 */
public class BookFactory {


// Factory Method
    public static Book getBook(String bookType){
        if("Science".equals(bookType)){
            return new Science();
        }
        if("Maths".equals(bookType)){
            return new Maths();
        }
        return null;
    }
}
