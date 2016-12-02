package adityajoshee.java8;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by aditya on 11/30/16.
 */
public class Box<T> {
    Set<T> elements;

    public boolean add(T t){
        if (elements==null){
            elements = new HashSet<>();
        }
        return elements.add(t);
    }
    public static void main(String args[]){
        Box<Integer> integerBox = new Box<>();
        //integerBox.add("sd");
    }
}

     class MyBox{
         Set<Object> elements;
         public boolean add(Object t){
             if (elements==null){
                 elements = new HashSet<>();
             }
             return elements.add(t);
         }
         public static void main(String args[]){
             MyBox integerBox = new MyBox();
             integerBox.add("sd");
             integerBox.add(1);

         }
     }
