package com.mimusyun.algorithm.book.examples;

import com.mimusyun.algorithm.book.stdlib.*;

public class Chapter1_1_Basic_Programming {
	
	public static void run() {
		
		_1_1_1_a();
		_1_1_1_b();
		_1_1_1_c();
		
		_1_1_2_a();
		_1_1_2_b();
		_1_1_2_c();
		_1_1_2_d();
		
		_1_1_3(null);
		
		_1_1_4_a();
		_1_1_4_b();
		_1_1_4_c();
		_1_1_4_d();
		
		_1_1_5(0.25, 0.5);
		
		_1_1_6();
		
		_1_1_7_a();
		_1_1_7_b();
		_1_1_7_c();
		
		_1_1_8_a();
		_1_1_8_b();
		_1_1_8_c();
		
		_1_1_9(1000);
		
		_1_1_10();
		
		StdOut.println(_1_1_20(20));
		
	}
	
	/* One Fundamentals - Exercises */
	
	public static void _1_1_1_a() {
		StdOut.println( "### 1.1.1.a ###" );
		StdOut.println( "( 0 + 15 ) / 2 ");
		StdOut.println( "ans : " + ( 0 + 15 ) / 2);
		StdOut.println();
	}
	
	public static void _1_1_1_b() {
		StdOut.println( "### 1.1.1.b ###" );
		StdOut.println( "2.0e-6 * 100000000.1 = " + 2.0e-6 * 100000000.1 );
		StdOut.println( "ans : " + 2.0e-6 * 100000000.1 );
		StdOut.println();
	}
	
	public static void _1_1_1_c() {
		StdOut.println( "### 1.1.1.c ###" );
		StdOut.println( "true && false || true && true = " + (true && false || true && true) );
		StdOut.println( "ans : " + (true && false || true && true) );
		StdOut.println();
	}
	
	public static void _1_1_2_a() {
		StdOut.println( "### 1.1.2.a ###" );
		StdOut.println( "(1 + 2.236)/2 = " + (1 + 2.236)/2 );
		StdOut.println( "ans : " + (1 + 2.236)/2 );
		StdOut.println();
	}
	
	public static void _1_1_2_b() {
		StdOut.println( "### 1.1.2.b ###" );
		StdOut.println( "1 + 2 + 3 + 4.0 " + 1 + 2 + 3 + 4.0 );
		StdOut.println( "ans : " + + 1 + 2 + 3 + 4.0 );
		StdOut.println();
	}
	
	public static void _1_1_2_c() {
		StdOut.println( "### 1.1.2.c ###" );
		StdOut.println( "4.1 >= 4 " + (4.1 >= 4) );
		StdOut.println( "ans : " + (4.1 >= 4) );
		StdOut.println();
	}
	
	public static void _1_1_2_d() {
		StdOut.println( "### 1.1.2.d ###" );
		StdOut.println( "1 + 2 + \"3\" " );
		StdOut.println( "ans : " + 1 + 2 + "3" );
		StdOut.println();
	}
	
	public static void _1_1_3(String[] args) {
		StdOut.println( "### 1.1.3 ###" );
		if(args!=null && args.length>0) {	
			if((args[0] == args[1]) == (args[1] == args[2])) StdOut.println("equal");
			else StdOut.println("unequal");
		} else {
			StdOut.println("Error : Need three args");
		}
	}
	
	public static void _1_1_4_a() {
		StdOut.println( "### 1.1.4.a ###" );
		StdOut.println( "if(a > b) then c = 0;");
		StdOut.println( "ans : then cannot be used. "  );
		StdOut.println();
	}
	
	public static void _1_1_4_b() {
		StdOut.println( "### 1.1.4.b ###" );
		StdOut.println( "if(a > b) { c = 0; }");
		StdOut.println( "ans : "  );
		StdOut.println();
	}
	
	public static void _1_1_4_c() {
		StdOut.println( "### 1.1.4.c ###" );
		StdOut.println( "if(a > b) c = 0; ");
		StdOut.println( "ans : "  );
		StdOut.println();
	}
	
	public static void _1_1_4_d() {
		StdOut.println( "### 1.1.4.c ###" );
		StdOut.println( "if(a > b) c = 0 else b = 0; ");
		StdOut.println( "ans : if(a > b) c = 0; else b = 0;"  );
		StdOut.println();
	}
	
	public static void _1_1_5(double x, double y) {
		
		StdOut.println( "### 1.1.5 ###" );
		if((0<=x && x<=1) && (0<=y && y<=1))
			StdOut.println("true");
		else
			StdOut.println("false");
		StdOut.println();
	}
	
	public static void _1_1_6() {
		
		StdOut.println( "### 1.1.6 ###" );
		int f = 0;
		int g = 1;
		for(int i = 0; i<= 15; i++ )
		{
			StdOut.println(f);
			f = f + g;
			g = f - g;
		}
		StdOut.println();
	}
	
	public static void _1_1_7_a() {
		
		StdOut.println( "### 1.1.7.a ###" );
		double t = 9.0;
		while(Math.abs(t - 9.0/t) > .001)
			t = (9.0/t + t) /2.0;
		StdOut.printf("%.5f\n", t);
		StdOut.println();
	}
	
	public static void _1_1_7_b() {
		
		StdOut.println( "### 1.1.7.b ###" );
		int sum = 0;
		for(int i=1; i<1000; i++)
			for(int j=0; j<i; j++)
				sum++;
		StdOut.println(sum);
		StdOut.println();
		
	}
	
	public static void _1_1_7_c() {
		
		StdOut.println( "### 1.1.7.c ###" );
		int sum = 0;
		for(int i=1; i<1000; i*=2)
			for(int j=0; j<i; j++)
				sum++;
		StdOut.println(sum);
		StdOut.println();
		
	}
	
	public static void _1_1_8_a() {
		
		StdOut.println( "### 1.1.8.a ###" );
		StdOut.println('b');
		StdOut.println();
		
	}
	
	public static void _1_1_8_b() {
		
		StdOut.println( "### 1.1.8.b ###" );
		StdOut.println('b' + 'c');
		StdOut.println();
		
	}
	
	public static void _1_1_8_c() {
		
		StdOut.println( "### 1.1.8.b ###" );
		StdOut.println((char)('a' + 4));
		StdOut.println();
		
	}
	
	public static void _1_1_9(int N) {
		
		StdOut.println( "### 1.1.9 ###" );
		String s = "";
		for(int n = N; n > 0; n /= 2)
			s = (n % 2) + s;
		StdOut.println(s);
		StdOut.println();
		
	}
	
	@SuppressWarnings("null")
	public static void _1_1_10() {
		
		StdOut.println( "### 1.1.10 ###" );
		int a[] = null;
		try {
			for(int i=0; i<10; i++)
				a[i] = i * i;
		} catch(Exception e) {
			StdOut.println(e);
		}
		StdOut.println();
		
	}
	
	public static long _1_1_20(int N) {
		//StdOut.print(N);
		if(N==0) return 1;
		else return N * _1_1_20(N-1);
	}
	
	
}
