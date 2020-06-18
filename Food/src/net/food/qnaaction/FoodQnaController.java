package net.food.qnaaction;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.food.qnaaction.QnaListAction;



@WebServlet("*.qn")
public class FoodQnaController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForward forward = null;
		
		if(command.equals("/qnalist.qn")){
			action = new QnaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.contentEquals("/qnawrite.qn")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./qna/qna_write.jsp");
			
		}else if(command.contentEquals("/qnaaddaction.qn")) {
			action  = new QnaAddAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/QnaDetailAction.qn")){
				action = new QnaDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/QnaReplyView.qn")){
				action = new QnaReplyView();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/QnaReplyAction.qn")){
			action = new QnaReplyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/QnaDelete.qn")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./qna/qna_delete.jsp");
		}else if(command.equals("/QnaDeleteAction.qn")){
			action = new QnaDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/QnaModify.qn")){
			action = new QnaModifyView();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/QnaModifyAction.qn")){
			action = new QnaModifyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		
		
		
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	
}
