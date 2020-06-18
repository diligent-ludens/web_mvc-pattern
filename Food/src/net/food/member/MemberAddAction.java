package net.food.member;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.member.db.MemberBean;
import net.food.member.db.MemberDAO;

public class MemberAddAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");	
		
		MemberBean membean = new MemberBean();
		MemberDAO memdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		  	
		boolean result = false;
		
		try{
		
		membean.setMEMBER_NAME(request.getParameter("MEMBER_NAME"));
		membean.setMEMBER_ID(request.getParameter("MEMBER_ID"));
		membean.setMEMBER_PW(request.getParameter("MEMBER_PW"));
		membean.setMEMBER_PWCK(request.getParameter("MEMBER_PWCK"));
		membean.setMEMBER_EMAIL(request.getParameter("MEMBER_EMAIL"));
		membean.setMEMBER_TEL(request.getParameter("MEMBER_TEL"));
			
   		result = memdao.memberInsert(membean);
   		
   		if(result==false){
   			System.out.println("게시판 등록 실패");
   			return null;
   		}
   		System.out.println("게시판 등록 완료");
   		
   		forward.setRedirect(true);
   		forward.setPath("./MemberJoin.me");
   		return forward;
   		
		}catch(Exception ex){
			System.out.println("파일 문제?");
			ex.printStackTrace();

		}
		return null;
	}

}
