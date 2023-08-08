package com.three.cucumber.service;

import com.three.cucumber.vo.LikeyVO;

public interface LikeyService {
	
	int checkLike(LikeyVO vo);
	int doLike(LikeyVO vo);
}
