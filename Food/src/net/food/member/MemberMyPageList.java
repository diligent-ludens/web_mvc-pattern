package net.food.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.food.member.db.MemberDAO;


 public class MemberMyPageList implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 
		 HttpSession session=request.getSession();
		MemberDAO memberdao = new MemberDAO();
		List memberlist = new ArrayList();
		
		String id = (String) session.getAttribute("id");
		System.out.println(id);
		memberlist = memberdao.getMemberList(id); //리스트를 받아옴
		
		
		request.setAttribute("memberlist", memberlist);
		
		ActionForward forward= new ActionForward();
	 	forward.setRedirect(false);
 		forward.setPath("./memberpage/MemberMyPage.jsp");
 		return forward;
	 }
 }