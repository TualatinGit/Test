package com.self;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Synchronized {

	public static void main(String[] args){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<String> ls=new ArrayList<>();
		long t=Calendar.getInstance().getTimeInMillis();
		for(long i=0;i<100000000;i++){
			ls.add("1");
		}
		System.out.println(Calendar.getInstance().getTimeInMillis()-t);
		System.out.println();
	}
	
}
