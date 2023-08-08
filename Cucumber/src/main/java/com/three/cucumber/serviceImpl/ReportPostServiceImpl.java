package com.three.cucumber.serviceImpl;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.three.cucumber.service.MemberService;
import com.three.cucumber.service.PostService;
import com.three.cucumber.service.ReportPostService;
import com.three.cucumber.service.dao.ReportPostDAO;
import com.three.cucumber.vo.ReportPostVO;

@Service("reportPostService")
public class ReportPostServiceImpl implements ReportPostService {
	
	@Autowired
	private ReportPostDAO rpdao;
	
	@Resource(name="memberService")
	private MemberService mSer;
	
	@Resource(name="PostService")
	private PostService pSer;

	@Override
	public void reportInsertatPost(ReportPostVO rpvo) {
		// TODO Auto-generated method stub
		rpdao.reportInsertatPost(rpvo);
	}

	@Override
	public ArrayList<ReportPostVO> allReportPost(int postId) {
		// TODO Auto-generated method stub
		return rpdao.allReportPost(postId);
	}

	// 전체 신고된 게시물 리스트를 가져가되, 신고 게시글의 제목과 신고한 사람의 닉네임을 가져가고자 함
	@Override
	public ArrayList<ReportPostVO> getEveryReportPost() {
		// TODO Auto-generated method stub
		
		ArrayList<ReportPostVO> rparray = rpdao.getEveryReportPost();
		
		for(int i=0; i<rparray.size(); i++) {
			String postTitle = pSer.findTitle(rparray.get(i).getPostId());
			String reporterNick = mSer.findNick(rparray.get(i).getPostReportMem());
			
			rparray.get(i).setPostTitle(postTitle);
			rparray.get(i).setReporterNick(reporterNick);
		}
		
		return rparray;
	}

	@Override
	public void AdDelPost(int postId) throws SQLException {
		pSer.deletePost(postId);
		rpdao.delRepPostByPost(postId);
	}

	@Override
	public void delRepPost(int postReportId) {
		rpdao.delRepPost(postReportId);
		
	}

	

}
