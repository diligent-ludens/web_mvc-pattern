package net.food.qnaaction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.qna.db.QnaDAO;
import net.food.qna.db.QnaDTO;


 public class QnaModifyAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 request.setCharacterEncoding("utf-8");
		 
		 boolean result = false;
		 
		 int num = Integer.parseInt(request.getParameter("QNA_NUM"));
		 
		 QnaDAO qnadao = new QnaDAO();
		 QnaDTO qnadata = new QnaDTO();
		 
		 boolean usercheck=qnadao.isQnaWriter(num, request.getParameter("QNA_PASS"));
		 if(usercheck == false){
		   		response.setContentType("text/html;charset=utf-8");
		   		PrintWriter out = response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('수정할 권한이 없습니다.');");
		   		out.println("location.href='./qnalist.qn';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		 }
		 
		 try{
			 qnadata.setQNA_NUM(num);
			 qnadata.setQNA_SUBJECT(request.getParameter("QNA_SUBJECT"));
			 qnadata.setQNA_CONTENT(request.getParameter("QNA_CONTENT"));
			 
			 result = qnadao.qnaModify(qnadata);
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
		   		return null;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 ActionForward forward = new ActionForward();
		   	 forward.setRedirect(true);
		   	 forward.setPath("./QnaDetailAction.qn?num="+qnadata.getQNA_NUM());
		   	 return forward;
	   	 }catch(Exception ex){
	   		 ex.printStackTrace();	 
		 }
		 
		 return null;
	 }
}