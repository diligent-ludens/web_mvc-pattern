package net.detail.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailDAO;
import net.detail.db.DetailBean;

public class DetailListAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		System.out.println("listAction");
		DetailDAO agoodsdao=new DetailDAO();
		ActionForward forward=new ActionForward();
	
		List list=(List)agoodsdao.getDetailList();
		System.out.println("list 추가 실행");
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("./Detail/detail_list.jsp");
		
		return forward;
	}
}
