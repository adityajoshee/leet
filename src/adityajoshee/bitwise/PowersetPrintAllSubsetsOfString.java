package adityajoshee.bitwise;

/**
 * Created by aditya on 11/18/16.
 */
public class PowersetPrintAllSubsetsOfString {
    public static void main(String args[]){
        String s = "abc";
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            stringBuffer.append('1');
        }
        // max number in decimal (made from 11...1)
        int decimalValue = Integer.parseInt(stringBuffer.toString(), 2);

        // iterating from 0 to max-num in decimal
        for (int i = 0; i <= decimalValue; i++) {
            char[] mask = Integer.toBinaryString(i).toCharArray();
            for (int j = 0; j < mask.length; j++) {
                if (mask[j]=='1'){
                    System.out.print(chars[j+(chars.length-mask.length)]);
                }
            }
            System.out.println();
        }
    }
}
