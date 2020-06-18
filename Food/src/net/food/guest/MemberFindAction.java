package net.food.guest;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.member.db.MemberBean;
import net.food.member.db.MemberDAO;

public class MemberFindAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");		
		ActionForward forward=new ActionForward();
		MemberDAO memberdao=new MemberDAO();
		MemberBean member=new MemberBean();		
		String name=request.getParameter("MEMBER_NAME");
		String tel=request.getParameter("MEMBER_TEL");
				
		
		member= memberdao.findId(name, tel);		
		if(member!=null){
			request.setAttribute("id", member.getMEMBER_ID());
			request.setAttribute("password", member.getMEMBER_PW());			
			forward.setRedirect(false);
			forward.setPath("./page/member_find_ok.jsp"); 			
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('입력한 정보가 일치하지 않습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			forward=null;
		}		 
		return forward;
	}
}
