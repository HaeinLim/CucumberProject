package com.three.cucumber.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.three.cucumber.service.HomeService;
import com.three.cucumber.service.dao.HomeDAO;
import com.three.cucumber.vo.CateVO;
import com.three.cucumber.vo.Criteria;
import com.three.cucumber.vo.PageMake;
import com.three.cucumber.vo.PostVO;

@Service("homeService")
public class HomeServiceImpl implements HomeService {

	@Autowired
	private HomeDAO mhdao;

	@Transactional
	
	public Criteria allSearch(Criteria cri) {
		if (cri.getPageNum() == 0)
			cri.setPageNum(1);
		if(cri.getOrder() == null)
			cri.setOrder("new");
		
		PageMake pm = new PageMake();

		if (cri.getCateId() != 0) { // 카테고리 선택o
			if (cri.getKeyword() != null) {
				if (cri.getOrder().equals("hot")) { // 카테고리, 검색어, 인기순 포스트 조회
					System.out.println("here1");
					int total = mhdao.getCateSearchHotCnt(cri);
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithCateSearchHot(cri));
					cri.setEndpage(total / 10 + 1);
					
				} else { // 카테고리, 검색어, 최신순 포스트 조회
					System.out.println("here2");
					int total = mhdao.getCateSearchNewCnt(cri);
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithCateSearchNew(cri));
					cri.setEndpage(total / 10 + 1);
					
				}
			} else { 
				if(cri.getOrder().equals("hot")) {
					int total = mhdao.getCateCnt(cri.getCateId());
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithCateHot(cri));
					cri.setEndpage(total / 10 + 1);
					
				}else {
				
				// 카테고리로만 조회(기본 최신순)
				System.out.println("here3");
				int total = mhdao.getCateCnt(cri.getCateId());
				cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
				cri.setPlist(mhdao.getPostWithCate(cri));
				cri.setEndpage(total / 10 + 1);

			}
				}
		} else { // 카테고리 선택x
			if (cri.getKeyword() != null) {
				if (cri.getOrder().equals("hot")) { // 검색어, 인기순 조회
					System.out.println("here4");
					int total = mhdao.getSearchHotCnt(cri);
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithKeywordHot(cri));
					cri.setEndpage(total / 10 + 1);

				}
				
				else { // 검색어로만 조회
					System.out.println("here5");
					int total = mhdao.getSearchCnt(cri.getKeyword());
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithKeyword(cri));
					cri.setEndpage(total / 10 + 1);

				}

			} else {
				if (cri.getOrder().equals("hot")) { // 게시글 인기순 전체 조회 
					System.out.println("here6");
					int total =
					mhdao.getTotal();
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getAllHotPost(cri.getPageNum()));
					cri.setEndpage(total / 10 + 1);


				} 
				else {
					System.out.println("here8");
					// 게시글 최신순 전체 조회
					int total = mhdao.getTotal();

					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getAllPostMain(cri.getPageNum()));
					cri.setEndpage(total / 10 + 1);

				}
			}
		}
		return cri;
	}

	public ArrayList<CateVO> getAllCate() throws Exception {
		return mhdao.getAllCate();
	} // 카테고리 전체조회

	// 거래글 조회수
	@Override
	public void viewCount(int postId) throws Exception { // 거래글 > 거래글 상세로 갈때 postId를 가진 리스트 호출문과 함께 컨트롤러에 작성
		mhdao.viewCount(postId); // ex) hSer.viewCount(PostVO.getPostId()); ArrayList<PostVO> pdetail = hSer.디테일
									// 보는메소드(PostVO.getPostId())

	}

	// 거래글 상세조회
	@Override
	public PostVO detail(int postId) {
		// TODO Auto-generated method stub
		return mhdao.detail(postId);
	}


}
