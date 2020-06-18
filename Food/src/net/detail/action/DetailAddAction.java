package net.detail.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.detail.db.DetailDAO;
import net.detail.db.DetailBean;

public class DetailAddAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DetailDAO detailDAO = new DetailDAO();
		DetailBean detailBean = new DetailBean();
		ActionForward forward = new ActionForward();
	
		boolean result = false;
		
		detailBean.setDETAIL_NUM(Integer.parseInt(request.getParameter("DETAIL_NUM")));
		detailBean.setDETAIL_NAME(request.getParameter("DETAIL_NAME"));
		detailBean.setDETAIL_CATEGORY(request.getParameter("DETAIL_CATEGORY"));
		detailBean.setDETAIL_CONTENT(request.getParameter("DETAIL_CONTENT"));
		detailBean.setDETAIL_ADDTER(request.getParameter("DETAIL_ADDTER"));
		
		result = detailDAO.insertDetail(detailBean);
		
		if(result==false){
   			System.out.println("게시판 등록 실패");
   			return null;
   		}
   		System.out.println("게시판 등록 완료");
   		
		forward.setRedirect(true);
		forward.setPath("./DetailView.ag");
		
		if(true)
			return forward;
		else {
			return null;
		}
		
	}
}