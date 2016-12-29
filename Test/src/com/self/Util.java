package com.self;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

	public static double G=6.67*Math.pow(10, -11);
	
	public static  void getJiaSuDu(Meteor mt1,Meteor mt2){
		Map<String,Map<String,Integer>> reMap = new HashMap<>();
		long juliSqure=(long) Math.pow(mt1.getX()-mt2.getX(),2)+
				(long) Math.pow(mt1.getY()-mt2.getY(),2)+
				(long) Math.pow(mt1.getZ()-mt2.getZ(),2);
		
		long heli=(long) (Util.G*mt1.getZhiliang()*mt2.getZhiliang()/juliSqure);
		
		long heliX=(long) heli*(long) (Math.sqrt(Math.pow(mt1.getX()-mt2.getX(),2))/(Math.sqrt((long) Math.pow(mt1.getX()-mt2.getX(),2)+
				(long) Math.pow(mt1.getY()-mt2.getY(),2)+
				(long) Math.pow(mt1.getZ()-mt2.getZ(),2))));
		
		long heliY=(long) Math.sqrt(heli*(long) (Math.pow(mt1.getY()-mt2.getY(),2)/((long) Math.pow(mt1.getX()-mt2.getX(),2)+
				(long) Math.pow(mt1.getY()-mt2.getY(),2)+
				(long) Math.pow(mt1.getZ()-mt2.getZ(),2))));
		
		long heliZ=(long) Math.sqrt(heli*(long) (Math.pow(mt1.getZ()-mt2.getZ(),2)/((long) Math.pow(mt1.getX()-mt2.getX(),2)+
				(long) Math.pow(mt1.getY()-mt2.getY(),2)+
				(long) Math.pow(mt1.getZ()-mt2.getZ(),2))));
		
		long mt1Xjsd = heliX/mt1.getZhiliang();
		long mt2Xjsd=heliX/mt2.getZhiliang();
		if(mt1.getX()>mt2.getX()){
			mt1Xjsd=0-mt1Xjsd;
		}else{
			mt2Xjsd=0-mt2Xjsd;
		}
		
		long mt1Yjsd=heliY/mt1.getZhiliang();
		long mt2Yjsd=heliY/mt2.getZhiliang();
		if(mt1.getY()>mt2.getY()){
			mt1Yjsd=0-mt1Yjsd;
		}else{
			mt2Yjsd=0-mt2Yjsd;
		}
		
		long mt1Zjsd = heliZ/mt1.getZhiliang();
		long mt2Zjsd = heliZ/mt2.getZhiliang();
		if(mt1.getZ()>mt2.getZ()){
			mt1Zjsd=0-mt1Zjsd;
		}else{
			mt2Zjsd=0-mt2Zjsd;
		}
		
		mt1.getLsx().add(mt1Xjsd);
		mt1.getLsy().add(mt1Yjsd);
		mt1.getLsz().add(mt1Zjsd);
		
		mt2.getLsx().add(mt2Xjsd);
		mt2.getLsy().add(mt2Yjsd);
		mt2.getLsz().add(mt2Zjsd);
	}
	
}
