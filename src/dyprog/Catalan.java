package dyprog;

import java.util.Scanner;

 // Finding number of BSTs which can be
// formed out of 1....n nodes.

public class Catalan {
	public static void main(String args[]){
		System.out.println("Enter N:");
		int n=(new Scanner(System.in)).nextInt();
		System.out.println(catalan(n));
	}
	private static int catalan(int n){
		if(n==0) return 0;
		int dp[]=new int[n+1];
		dp[1]=1;
		dp[0]=1;
		int left=0,right=0,sum=0;
		for(int i=2;i<=n;i++){
			sum=0;
			for(int j=1;j<=i;j++){          // j can be considered as the root element among 1,2...->n elements.
//				left=0;right=0;
//				for(int k=1;k<=i;k++){
//					if(k<j)
//						left++;
//					if(k>j)
//						right++;
//				}
				sum=sum+dp[j-1]*dp[i-j];         // sum + (no. of ways in left subtree) * (no. of ways in right subtree)
			}
			dp[i]=sum;
		}
		return dp[n];
	}

}
