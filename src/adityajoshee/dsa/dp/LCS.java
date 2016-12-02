package adityajoshee.dsa.dp;

import java.util.Arrays;

public class LCS {
	static int[][] arr;
	static int result=0;
	public static void main(String args[]){
		
		String s1 = "asdfkkkkkkkaaaaaaaassssssjkl";
		String s2 = "aaaaaaaaaaaaaaakkkkkkkkkkkkkkaaaaaaaassssssssssssllllllllll";
		arr=new int[s1.length()][s2.length()];
		for(int i=0;i<s1.length();i++){
			Arrays.fill(arr[i],-1);
		}
		System.out.println(findLCS(s1.toCharArray(),0,s2.toCharArray(),0));
	}
	private static int findLCS(char[] s1,int i,char[] s2,int j){
		if(i==s1.length || j==s2.length)
			return 0;
		if(arr[i][j]!=-1)
			return arr[i][j];
		if(s1[i]==s2[j])
			result =1+findLCS(s1,i+1,s2,j+1);
		else
			result= Math.max(findLCS(s1,i,s2,j+1),findLCS(s1,i+1,s2,j));
		arr[i][j]=result;
		return result;
	}


}
