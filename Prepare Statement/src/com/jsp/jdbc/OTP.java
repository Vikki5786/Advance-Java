package com.jsp.jdbc;

import java.util.Random;

public class OTP {
	public static void main(String[] args) {
		
		Random r= new Random();
		int otp = r.nextInt();
//		int otp1 = r.nextInt(100000);
		System.out.println(otp);
		
		if(otp < 100000) {
			otp = otp + 100000;
		}
		System.out.println(otp);
	}
}
