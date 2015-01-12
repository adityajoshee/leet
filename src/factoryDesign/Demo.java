package factoryDesign;

import java.util.Scanner;

/**
 * Created by aditya.joshee on 04/12/14.
 */
public class Demo {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String input =in.nextLine();
        Book requestedBook;
        requestedBook=BookFactory.getBook(input);
        System.out.println("You requested : "+requestedBook.toString());
    }
}
