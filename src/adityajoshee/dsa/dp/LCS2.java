package adityajoshee.dsa.dp;

// Sample s1={a,b,p,c} ; s2={p,a,c,p,b,c}
// Find length of LCS and print the subsequence
public class LCS2 {
	public static void main(String args[]){
		char[] s1={'a','b','p','c','a'} ;
		char[] s2={'p','a','c','p','b','c','r','a'};
		System.out.println(findLCS(s1,s2));
	}
	
	private static int findLCS(char[]s1,char[]s2){
		int[][] dp=new int[s1.length+1][s2.length+1];
		
		// Known values
		for(int i=0;i<=s1.length;i++)
			dp[i][0]=0;
		for(int i=0;i<=s2.length;i++)
			dp[0][i]=0;
		
		// Actual Computation
		for(int i=0;i<s1.length;i++){
			for(int j=0;j<s2.length;j++){
				if(s1[i]==s2[j]){
					dp[i+1][j+1]=1+dp[i][j];	
				}
				else
					dp[i+1][j+1]=Math.max(dp[i][j+1], dp[i+1][j]);
			}
		}
		printLCS(s1,s2,dp);
		System.out.println();
		return dp[s1.length][s2.length];
	}
	
	private static void printLCS(char[]s1,char[]s2,int[][]dp){
		int i=s1.length;
		int j=s2.length;
		while(i>0 && j>0){
				if(s1[i-1]==s2[j-1]){
					System.out.print(s1[i-1]);
					i--;j--;
				}
				else if(dp[i-1][j]>dp[i][j-1])
					i--;
				else 
					j--;
			}
	}
	
/*[
  [0, 0, 0, 0, 0, 0, 0, 0, 0],
	[0, 0, 1, 1, 1, 1, 1, 1, 1], 
	[0, 0, 1, 1, 1, 2, 2, 2, 2],
	[0, 1, 1, 1, 2, 2, 2, 2, 2],
	[0, 1, 1, 2, 2, 2, 3, 3, 3], 
	[0, 1, 2, 2, 2, 2, 3, 3, 4]]*/

}
