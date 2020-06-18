package net.food.qnaaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import net.food.qna.db.QnaDAO;
import net.food.qna.db.QnaDTO;


 public class QnaDetailAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		 
		request.setCharacterEncoding("utf-8");
   		
		QnaDAO qnadao=new QnaDAO();
	    QnaDTO qnadata=new QnaDTO();
	   	
		int num=Integer.parseInt(request.getParameter("num"));//getparameter로 오는 것은 string , parseInt를통해 int형으로 바꾼다.
		qnadao.setReadCountUpdate(num);// 조회수 증가
		qnadata=qnadao.getDetail(num);
	   	
	   	if(qnadata==null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("qnadata", qnadata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./qna/qna_view.jsp");
   		return forward;

	 }
}