package net.detail.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailDAO;
import net.detail.db.DetailBean;
public class DetailModifyForm implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward=new ActionForward();		
		
		DetailDAO agoodsdao=new DetailDAO();
		DetailBean agb=new DetailBean();		
		
		int num=Integer.parseInt(request.getParameter("num"));	
		agb=agoodsdao.getDetail(num);		
		
		if(agb==null){
	   		System.out.println("(수정)상세보기 실패");
	   		return null;
	   	}
		
		request.setAttribute("agb", agb);		
		forward.setPath("./Detail/detail_modify.jsp");
		return forward;
	}
}
