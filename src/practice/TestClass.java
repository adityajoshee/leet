package practice;

/**
 * Created by aditya on 8/12/16.
 */
class TestClass {
    public static void main(String args[] ) throws Exception {

        String s = "Hello World";
        int x = s.indexOf('o');
        int y = s.lastIndexOf('l');
        System.out.print(x + " " + y);

        String chars[] = {"a", "b", "c", "a", "c"};
        for (int i = 0; i < chars.length; ++i)
            for (int j = i + 1; j < chars.length; ++j)
                if(chars[i].compareTo(chars[j]) == 0)
                    System.out.print(chars[j]);

    }
}