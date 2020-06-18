package net.food.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.qna.db.QnaDAO;

 public class QnaListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 
		QnaDAO qnadao = new QnaDAO();
		List qnalist = new ArrayList();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page")!=null){
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = qnadao.getListCount(); //총 리스트 수를 받아옴
		qnalist = qnadao.getQnaList(page, limit); //리스트를 받아옴
		
		//총 페이지 수
 		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리
 		
 		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
 		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
 		
 		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)
		int endpage = startpage+10-1;

 		if (endpage> maxpage) endpage= maxpage;

 		request.setAttribute("page2", page); //현재 페이지 수
 		request.setAttribute("maxpage2", maxpage); //최대 페이지 수
 		request.setAttribute("startpage2", startpage); //현재 페이지에 표시할 첫 페이지 수
 		request.setAttribute("endpage2", endpage); //현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount2",listcount); //글 수
		request.setAttribute("qnalist2", qnalist);
		
		ActionForward forward= new ActionForward();
	 	forward.setRedirect(false);
 		forward.setPath("./memberqna/qna_list.jsp");
 		return forward;
	 }
 }