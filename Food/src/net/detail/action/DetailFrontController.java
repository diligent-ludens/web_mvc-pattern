package net.detail.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.member.MemberAddAction;


@WebServlet("*.ag")
public class DetailFrontController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		Action action = null;
		
		
		if(command.equals("/DetailAddAction.ag")) {
			action = new DetailAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}else if(command.equals("/DetailList.ag")){
			action=new DetailListAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DetailAdd.ag")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Detail/detail_write.jsp");
		}else if(command.equals("/DetailDelete.ag")){
			action=new DetailDeleteAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DetailModify.ag")){
			action=new DetailModifyForm();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DetailModifyAction.ag")){
			action=new DetailModifyAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DetailView.ag")) {
			action = new DetailViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/DetailWrite.ag")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./Detail/detail_write.jsp");
		}
		
		if(forward != null){
			if(forward.isRedirect()){			
				response.sendRedirect(forward.getPath());			
			}else{			
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);			
			}
		}
		
	}
	
	
}

