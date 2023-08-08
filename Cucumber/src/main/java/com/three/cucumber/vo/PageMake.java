package com.three.cucumber.vo;

import java.util.ArrayList;

public class PageMake {

	public ArrayList<Integer> makeNum(int pageNum, int total) {
		
		ArrayList<Integer> pagelist = new ArrayList<Integer>();
		int max = total/10+1;
		if(pageNum == 1) {			
			if(max >= 3) {
				pagelist.add(1);
				pagelist.add(2);
				pagelist.add(3);
			}
			else {
				for (int i=1; i<=max; i++) {
					pagelist.add(i);
				}
			}
		}else {
			if(pageNum==max) {
				if(max<3) {
					pagelist.add(pageNum-1);
					pagelist.add(pageNum);
				}
				else {
				pagelist.add(pageNum-2);
				pagelist.add(pageNum-1);
				pagelist.add(pageNum);
				}
			}else {
				pagelist.add(pageNum-1);
				pagelist.add(pageNum);
				pagelist.add(pageNum+1);
			}
		
		
		
	}
		return pagelist;

}
}