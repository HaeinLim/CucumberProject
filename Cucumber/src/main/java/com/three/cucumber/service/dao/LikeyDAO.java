package com.three.cucumber.service.dao;

import com.three.cucumber.vo.LikeyVO;

public interface LikeyDAO {

	int checkLike(LikeyVO lvo);
	
	int insertLike(LikeyVO vo);
	
	void deleteLike(LikeyVO vo);

	void plLike(int likeyPost);

	void miLike(int likeyPost);
}
