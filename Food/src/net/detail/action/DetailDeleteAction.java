package net.detail.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailDAO;

public class DetailDeleteAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {	
		
		boolean result = false;
		
		ActionForward forward=new ActionForward();
		DetailDAO detailDAO=new DetailDAO();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		result = detailDAO.deleteDetail(num);
		
		if(result == false){
			System.out.println("게시판 삭제 실패");
			 return null;
		}		
		
		forward.setRedirect(true);
		forward.setPath("./MemberMainPage.me");
		return forward;
	}
}
