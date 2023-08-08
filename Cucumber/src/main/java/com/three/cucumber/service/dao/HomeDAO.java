package com.three.cucumber.service.dao;

import java.util.ArrayList;

import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.Criteria;
import com.three.cucumber.vo.PostVO;

public interface HomeDAO {

	// ���ο��� �̷������ ��
	// 1. ��ü ����Ʈ ��ȸ
	// 2. �˻��ؼ� ã�����ϴ� ����Ʈ ã��
	// 3. ī�װ� ��ȸ
	// 4. ����¡

	// ��ü ī�װ�
	ArrayList<CateVO> getAllCate();
	
	// ��ü ����Ʈ ��ȸ
	ArrayList<PostVO> getAllPostMain(int pageNum);
	
	// �α�� ��ü ����Ʈ ��ȸ
	ArrayList<PostVO> getAllHotPost(int pageNum);
	
	// ī�װ�, �˻���, �α��o ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithCateSearchHot(Criteria cri);
	
	// ī�װ�, �˻���, �ֽż� ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithCateSearchNew(Criteria cri);
	
	// ī�װ��� �ֽż� ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithCate(Criteria cri);
	
	// ī�װ��� �α�� ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithCateHot(Criteria cri);
	
	// �˻���� �α������ ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithKeywordHot(Criteria cri);
	
	// �˻���θ� ����Ʈ ��ȸ
	ArrayList<PostVO> getPostWithKeyword(Criteria cri);
	
	// ����Ʈ �� ����
	int getTotal();
	
	// ī�װ�, �˻���, �α�� ����Ʈ �� ����
	int getCateSearchHotCnt(Criteria cri);
	
	// ī�װ�, �˻���, �ֽż� ����Ʈ �� ����
	int getCateSearchNewCnt(Criteria cri);
	
	// ī�װ� ����Ʈ �� ����
	int getCateCnt(int cateId);
	
	// �˻���, �α�� ����Ʈ �� ����
	int getSearchHotCnt(Criteria cri);
	
	// �˻���θ� ����Ʈ ��ȸ
	int getSearchCnt(String keyword);
	
	// �ŷ��� ��ȸ��
	void viewCount(int postId);
	
	// �ŷ��� �󼼳���
	PostVO detail(int postId);
}