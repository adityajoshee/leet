package dyprog;

import java.util.Scanner;

public class Factorial {
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		System.out.println("Enter n:");
		int n =s.nextInt();
		s.close();
		fact(n);
	}
	static int fact(int n){
		int lastmultiple=1;
		for(int i=0;i<=n;i++){
			if(i==0){
				System.out.print(1+",");
				continue;
			}
				lastmultiple=lastmultiple*i;
				System.out.print(lastmultiple+",");
		}
		return lastmultiple;
	}
}
