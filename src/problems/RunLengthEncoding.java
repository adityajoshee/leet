package problems;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RunLengthEncoding {
	public static void main(String[] args){
		System.out.println(encode("aabraacadaabraa"));
	}
	
    public static String encode(String source) {
        StringBuffer dest = new StringBuffer();
        for (int i = 0; i < source.length(); i++) {
            int runLength = 1;
            while (i+1 < source.length() && source.charAt(i) == source.charAt(i+1)) {
                runLength++;
                i++;
            }
            dest.append(runLength);
            dest.append(source.charAt(i));
        }
        return dest.toString();
    }
}