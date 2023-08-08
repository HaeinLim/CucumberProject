package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.Criteria;
import com.three.cucumber.vo.PostVO;

public interface HomeDAO {

	// 메인에서 이루어지는 것
	// 1. 전체 포스트 조회
	// 2. 검색해서 찾고자하는 포스트 찾기
	// 3. 카테고리 조회
	// 4. 페이징

	// 전체 카테고리
	ArrayList<CateVO> getAllCate();
	
	// 전체 포스트 조회
	ArrayList<PostVO> getAllPostMain(int pageNum);
	
	// 인기순 전체 포스트 조회
	ArrayList<PostVO> getAllHotPost(int pageNum);
	
	// 카테고리, 검색어, 인기순o 포스트 조회
	ArrayList<PostVO> getPostWithCateSearchHot(Criteria cri);
	
	// 카테고리, 검색어, 최신순 포스트 조회
	ArrayList<PostVO> getPostWithCateSearchNew(Criteria cri);
	
	// 카테고리와 최신순 포스트 조회
	ArrayList<PostVO> getPostWithCate(Criteria cri);
	
	// 카테고리와 인기순 포스트 조회
	ArrayList<PostVO> getPostWithCateHot(Criteria cri);
	
	// 검색어와 인기순으로 포스트 조회
	ArrayList<PostVO> getPostWithKeywordHot(Criteria cri);
	
	// 검색어로만 포스트 조회
	ArrayList<PostVO> getPostWithKeyword(Criteria cri);
	
	// 포스트 총 개수
	int getTotal();
	
	// 카테고리, 검색어, 인기순 포스트 총 개수
	int getCateSearchHotCnt(Criteria cri);
	
	// 카테고리, 검색어, 최신순 포스트 총 개수
	int getCateSearchNewCnt(Criteria cri);
	
	// 카테고리 포스트 총 개수
	int getCateCnt(int cateId);
	
	// 검색어, 인기순 포스트 총 개수
	int getSearchHotCnt(Criteria cri);
	
	// 검색어로만 포스트 조회
	int getSearchCnt(String keyword);
	
	// 거래글 조회수
	void viewCount(int postId);
	
	// 거래글 상세내용
	PostVO detail(int postId);
}