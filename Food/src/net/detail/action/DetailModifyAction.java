package net.detail.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailDAO;
import net.detail.action.ActionForward;
import net.detail.db.DetailBean;

public class DetailModifyAction implements Action {
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		boolean result = false;
	    int num = Integer.parseInt(request.getParameter("DETAIL_NUM"));
	
		DetailDAO detailDAO = new DetailDAO();
		DetailBean detailBean = new DetailBean();		
		
		try{
			 detailBean.setDETAIL_NUM(num);
			 detailBean.setDETAIL_CONTENT(request.getParameter("DETAIL_CONTENT"));
			 detailBean.setDETAIL_ADDTER(request.getParameter("DETAIL_ADDTER"));

			 result = detailDAO.modifyDetail(detailBean);
			 if(result == false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 ActionForward forward = new ActionForward();
		   	 forward.setRedirect(true);
		   	 forward.setPath("./DetailView.ag?num="+detailBean.getDETAIL_NUM());
		   	 
		   	 return forward;
	   	 }catch(Exception ex){
	   		 ex.printStackTrace();	 
		 }
		 
		 return null;
	 }
}
