package practice;

/**
 * Created by aditya on 8/16/16.
 */
public class PassBy {
    public static void main(String args[]){
        Integer[] list = new Integer[]{-1};
        addItem(list,3);
        System.out.println(list[0]);
        changeArray(list);
        System.out.println(list[0]);

    }
    // assuming you allocated the list
    public static void addItem(Integer[] list, int item) {
        list[0] = item;
    }
    //You will see the changes to the list from the calling code.
    // However you can't change the reference itself, since it's passed by value:

    // assuming you allocated the list
    public static void changeArray(Integer[] list) {
        list = null;
    }
}
