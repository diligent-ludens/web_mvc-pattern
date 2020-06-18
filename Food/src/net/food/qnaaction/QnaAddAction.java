package net.food.qnaaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.food.qna.db.QnaDAO;
import net.food.qna.db.QnaDTO;



public class QnaAddAction implements Action {
	
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		request.setCharacterEncoding("utf-8"); 
		 
		QnaDAO qnadao=new QnaDAO();
	   	QnaDTO qnadata=new QnaDTO();
	   	ActionForward forward=new ActionForward();
	   			  		
   		boolean result = false;
   		
   		try{
   					
   			qnadata.setQNA_NAME(request.getParameter("QNA_NAME"));
   			qnadata.setQNA_PASS(request.getParameter("QNA_PASS"));
   			qnadata.setQNA_SUBJECT(request.getParameter("QNA_SUBJECT"));
   			qnadata.setQNA_CONTENT(request.getParameter("QNA_CONTENT"));
   			
	   		
	   		result = qnadao.qnaInsert(qnadata);
	   		
	   		if(result==false){
	   			System.out.println("게시판 등록 실패");
	   			return null;
	   		}
	   		System.out.println("게시판 등록 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./qnalist.qn");
	   		return forward;
	   		
  		}catch(Exception ex){
  			//System.out.println("파일 문제?");
  			ex.printStackTrace();
   			
   		}
  		return null;
	}  	
}