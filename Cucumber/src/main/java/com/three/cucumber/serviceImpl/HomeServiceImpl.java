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

		if (cri.getCateId() != 0) { // ī�װ� ����o
			if (cri.getKeyword() != null) {
				if (cri.getOrder().equals("hot")) { // ī�װ�, �˻���, �α�� ����Ʈ ��ȸ
					System.out.println("here1");
					int total = mhdao.getCateSearchHotCnt(cri);
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithCateSearchHot(cri));
					cri.setEndpage(total / 10 + 1);
					
				} else { // ī�װ�, �˻���, �ֽż� ����Ʈ ��ȸ
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
				
				// ī�װ��θ� ��ȸ(�⺻ �ֽż�)
				System.out.println("here3");
				int total = mhdao.getCateCnt(cri.getCateId());
				cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
				cri.setPlist(mhdao.getPostWithCate(cri));
				cri.setEndpage(total / 10 + 1);

			}
				}
		} else { // ī�װ� ����x
			if (cri.getKeyword() != null) {
				if (cri.getOrder().equals("hot")) { // �˻���, �α�� ��ȸ
					System.out.println("here4");
					int total = mhdao.getSearchHotCnt(cri);
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithKeywordHot(cri));
					cri.setEndpage(total / 10 + 1);

				}
				
				else { // �˻���θ� ��ȸ
					System.out.println("here5");
					int total = mhdao.getSearchCnt(cri.getKeyword());
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getPostWithKeyword(cri));
					cri.setEndpage(total / 10 + 1);

				}

			} else {
				if (cri.getOrder().equals("hot")) { // �Խñ� �α�� ��ü ��ȸ 
					System.out.println("here6");
					int total =
					mhdao.getTotal();
					cri.setPagelist(pm.makeNum(cri.getPageNum(), total));
					cri.setPlist(mhdao.getAllHotPost(cri.getPageNum()));
					cri.setEndpage(total / 10 + 1);


				} 
				else {
					System.out.println("here8");
					// �Խñ� �ֽż� ��ü ��ȸ
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
	} // ī�װ� ��ü��ȸ

	// �ŷ��� ��ȸ��
	@Override
	public void viewCount(int postId) throws Exception { // �ŷ��� > �ŷ��� �󼼷� ���� postId�� ���� ����Ʈ ȣ�⹮�� �Բ� ��Ʈ�ѷ��� �ۼ�
		mhdao.viewCount(postId); // ex) hSer.viewCount(PostVO.getPostId()); ArrayList<PostVO> pdetail = hSer.������
									// ���¸޼ҵ�(PostVO.getPostId())

	}

	// �ŷ��� ����ȸ
	@Override
	public PostVO detail(int postId) {
		// TODO Auto-generated method stub
		return mhdao.detail(postId);
	}


}
