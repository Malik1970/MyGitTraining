package com.mycompany;

public class TvRemote extends AbstractTv{

	public int switchchannel(int c){
		System.out.println("Tv Channel is changed");
		c=1;
		
		System.out.println("Tv Channel is changed"+c);
		return c;
	}
}
