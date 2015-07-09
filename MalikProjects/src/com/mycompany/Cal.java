package com.mycompany;

public class Cal {
	public static void main(String[] args) {
		
		/*int sumValue = 0;
		sumValue = add(10,5);
		System.out.println("Sum of 10, 5 is "+sumValue);
		*/
		int n1 = 10;
		int n5; 
		int n2 = 5;
		// n1+n2 = sum
		System.out.println(n1+"+"+n2+"="+add(n1,n2));
		System.out.println(n1+"-"+n2+"="+sub(n1,n2));
		System.out.println(n1+"*"+n2+"="+mul(n1,n2));
		System.out.println(n1+"/"+n2+"="+div(n1,n2));
		System.out.println(n1+"%"+n2+"="+mod(n1,n2));
		
		int n3 = n1++; // n3=10 , n1=?  increment by 1 n1=11
		int n4 = ++n1; // n4=12, n1=12
		System.out.println("n3="+n3+","+n4);
		n1 = 1;
		System.out.println("++n1="+(++n1)+",n1++="+(n1++) +", n1="+n1); //++n1=2, n1++=2, n1=3 
		

	}
	
	public static int add(int n1, int n2){
		int sum = n1 + n2;
		return sum;
	}
	public static int sub(int n1, int n2){
		return n1-n2;
	}
	public static int mul(int n1, int n2){
		return n1*n2;
	}
	
	public static float div(int n1, int n2){
		return n1/n2;
	}
	
	public static int mod(int n1, int n2){
		return n1%n2;
	}
	
	

}
