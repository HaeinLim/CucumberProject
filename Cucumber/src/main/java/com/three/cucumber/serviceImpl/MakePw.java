package com.three.cucumber.serviceImpl;

import java.util.Random;

public class MakePw {

	public MakePw() {}
	
	public String random() {
		Random rnd =new Random();

		StringBuffer buf =new StringBuffer();

		for(int i=0;i<8;i++){
		    if(rnd.nextBoolean()){
		    	if(rnd.nextBoolean()) {
		    		buf.append((char)((int)(rnd.nextInt(26))+97));
		    	}else {
		    		buf.append((char)((int)(rnd.nextInt(26))+65));
		    	}
		    }else{
		    	if(rnd.nextBoolean()) {
		    		buf.append((rnd.nextInt(10))); 
		    	}
		    	else {
		    		buf.append((char)((int)(rnd.nextInt(4))+35)); 
		    	}
		    }
		}
	return buf.toString();
	}
}
