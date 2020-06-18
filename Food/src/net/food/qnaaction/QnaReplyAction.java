package net.food.qnaaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.qna.db.QnaDAO;
import net.food.qna.db.QnaDTO;

public class QnaReplyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 	request.setCharacterEncoding("utf-8");
		 	ActionForward forward = new ActionForward();
		 	
			QnaDAO qnadao = new QnaDAO();
	   		QnaDTO qnadata = new QnaDTO();
	   		int result = 0;
	   		
	   		qnadata.setQNA_NUM(Integer.parseInt(request.getParameter("QNA_NUM")));
	   		qnadata.setQNA_NAME(request.getParameter("QNA_NAME"));
	   		qnadata.setQNA_PASS(request.getParameter("QNA_PASS"));
	   		qnadata.setQNA_SUBJECT(request.getParameter("QNA_SUBJECT"));
	   		qnadata.setQNA_CONTENT(request.getParameter("QNA_CONTENT"));
	   		qnadata.setQNA_RE_REF(Integer.parseInt(request.getParameter("QNA_RE_REF")));
	   		qnadata.setQNA_RE_LEV(Integer.parseInt(request.getParameter("QNA_RE_LEV")));
	   		qnadata.setQNA_RE_SEQ(Integer.parseInt(request.getParameter("QNA_RE_SEQ")));
	   		
	   		result=qnadao.qnaReply(qnadata);
	   		
	   		if(result==0){
	   			System.out.println("답장 실패");
	   			return null;
	   		}
	   		System.out.println("답장 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./QnaDetailAction.qn?num="+result);
	   		return forward;
	}  	
}