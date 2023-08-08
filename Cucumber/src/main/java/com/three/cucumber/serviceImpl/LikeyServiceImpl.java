package com.three.cucumber.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.LikeyService;
import com.three.cucumber.service.dao.LikeyDAO;
import com.three.cucumber.vo.LikeyVO;

@Service("likeyService")
public class LikeyServiceImpl implements LikeyService {

	@Autowired
	private LikeyDAO ldao;

	@Override
	public int checkLike(LikeyVO vo) {
		return ldao.checkLike(vo);
	}

	@Override
	public int doLike(LikeyVO vo) {
		int re = ldao.checkLike(vo);
		if(re == 0) {
			ldao.insertLike(vo);
			ldao.plLike(vo.getLikeyPost());
			return 1;
		}
		else {
			ldao.deleteLike(vo);
			ldao.miLike(vo.getLikeyPost());
			return 0;
		}
		
	}

}
