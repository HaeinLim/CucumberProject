package com.three.cucumber.serviceImpl;

import java.util.Random;

public class Makenum {

	public Makenum() {}
	public String random() {
	 	Random random = new Random();		//���� �Լ� ����
			int createNum = 0;  			//1�ڸ� ����
			String ranNum = ""; 			//1�ڸ� ���� ����ȯ ����
		    	int letter    = 6;			//���� �ڸ���:6
			String content = "";  		//��� ����
			
			for (int i=0; i<letter; i++) { 
		        		
				createNum = random.nextInt(9);		//0���� 9���� �� �� �ִ� 1�ڸ� ���� ����
				ranNum =  Integer.toString(createNum);  //1�ڸ� ������ String���� ����ȯ
				content += ranNum;			//������ ����(���ڿ�)�� ���ϴ� ��(letter)��ŭ ���ϸ� ����
			}
		return content;
	}
	

}
