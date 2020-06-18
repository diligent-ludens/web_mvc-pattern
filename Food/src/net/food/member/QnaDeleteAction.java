package net.food.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.qna.db.QnaDAO;

public class QnaDeleteAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 request.setCharacterEncoding("utf-8");
		 
		 ActionForward forward = new ActionForward();
		
		
		 boolean result = false;
		 boolean usercheck = false;
		 int num = Integer.parseInt(request.getParameter("num"));
	   	
		 QnaDAO qnadao = new QnaDAO();
		 usercheck = qnadao.isQnaWriter(num, request.getParameter("QNA_PASS"));
	   	
		 if(usercheck == false){
			 response.setContentType("text/html;charset=utf-8");
			 PrintWriter out=response.getWriter();
			 out.println("<script>");
			 out.println("alert('삭제할 권한이 없습니다.');");
			 out.println("location.href='./qnalist.qn';");
			 out.println("</script>");
			 out.close();
			 return null;
		 }
	   	
		 result = qnadao.qnaDelete(num);
		 if(result == false){
			 System.out.println("게시판 삭제 실패");
			 return null;
		 }
	   	
		 System.out.println("게시판 삭제 성공");
		 forward.setRedirect(true);
		 forward.setPath("./qnalist.qn");
		 return forward;
	}
}