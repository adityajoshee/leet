package algorithms.dp;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		System.out.println("Enter n:");
		int n =s.nextInt();
		s.close();
		fib(n);
	}
	
	static int fib(int n){
		int a=0;
		int b=1;

		int sum=a+b;
		for(int i=0;i<n;i++){
			if(i==0 || i==1){
				System.out.print(i+",");
				continue;
			}
			sum=a+b;
			System.out.print(sum+",");
			a=b;
			b=sum;
		}
		return sum;
		
	}
}
