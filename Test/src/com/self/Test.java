package com.self;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<String> ls = new ArrayList<>(3000);
		Test tt = new Test();
	    writeList obj=tt.getW1();
		obj.setLs(ls);
		writeList2 obj2 = tt.getW2();
		obj2.setLs(ls);
		Thread t1=new Thread(obj);
		Thread t2 = new Thread(obj2);
		t1.start();
		t2.start();
		Test.Ws w = new Test.Ws();
		
	}
	
	public static int num=0;
	
	public static synchronized void addNum(){
		Test.num++;
	}

	public static synchronized int getNum(){
		return Test.num;
	}
	
	public static void pLs(List<String> ls){
		System.out.println("ls size is :"+ls.size());
		for(String s:ls){
			System.out.print(s+",");
		}
	}
	
	public class writeList implements Runnable {

		private List<String> ls;

		public List<String> getLs() {
			return this.ls;
		}

		public void setLs(List<String> ls) {
			this.ls = ls;
		}

		public void run() {
           for(int i=0;i<1000;i++){
        	   ls.add("a"+i);
           }
           Test.addNum();
			if(2==Test.getNum()){
				Test.pLs(ls);
			}
		}
	}

	public class writeList2 implements Runnable {

		private List<String> ls;

		public List<String> getLs() {
			return this.ls;
		}

		public void setLs(List<String> ls) {
			this.ls = ls;
		}

		public void run() {
			for(int i=0;i<1000;i++){
	        	   ls.add("b"+i);
	           }
			Test.addNum();
			if(2==Test.getNum()){
				Test.pLs(ls);
			}
		}
	}
	
	public static class Ws implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public writeList getW1(){
		return new writeList();
	}
	
	public writeList2 getW2(){
		return new writeList2();
	}
	
}
