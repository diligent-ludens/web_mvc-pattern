package net.food.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("*.me")
public class MemberController extends javax.servlet.http.HttpServlet{
	private static final long serialVersionUID=1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
		
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("/MemberAddAction.me")) {//회원가입 내용 저장
			action = new MemberAddAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		
		}else if(command.equals("/MemberLogin.me")) {//로그인후 메인화면 이동
			forward = new ActionForward();
			forward.setPath("./memberpage/MemberMainPage.jsp");	
		
		
		}else if(command.equals("/MemberLoginAction.me")) {//로그인 동작 실행
			action = new MemberLoginAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
			}
		
		}else if(command.equals("/MemberJoin.me")) {//회원가입후 로그인화면 이동
			forward = new ActionForward();
			forward.setPath("./page/loginPage.jsp");	
		
		}else if(command.equals("/MemberQnaList.me")) {//회원가입후 로그인화면 이동
			forward = new ActionForward();
			forward.setPath("./memberqna/qna_list.jsp");	
			
		}else if(command.equals("/MemberIDCheckAction.me")){
			action = new MemberIDCheckAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {				
				e.printStackTrace();
			}
	//=====================로그인 후 qna 화면 구현=====================================	
		
		}else if(command.equals("/MemberQnaLoginList.me")){//로그인 시 qna화면 이동
			action = new QnaListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.contentEquals("/MemberQnaWrite.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./memberqna/qna_write.jsp");
			
		}else if(command.contentEquals("/MemberQnaAddAction.me")) {
			action  = new QnaAddAction();
			try {
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/MemberQnaDetailAction.me")){
				action = new QnaDetailAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/MemberQnaReplyView.me")){
				action = new QnaReplyView();
				try{
					forward=action.execute(request, response);
				}catch(Exception e){
					e.printStackTrace();
				}
		}else if(command.equals("/MemberQnaReplyAction.me")){
			action = new QnaReplyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/MemberQnaDelete.me")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./memberqna/qna_delete.jsp");
		}else if(command.equals("/MemberQnaDeleteAction.me")){
			action = new QnaDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/MemberQnaModify.me")){
			action = new QnaModifyView();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		
		//===================로그인후 헤더영역=======================
		}else if(command.contentEquals("/MemberMainPage.me")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./memberpage/MemberMainPage.jsp");
			
		}else if(command.contentEquals("/MemberKoreaFood.me")) {
			action = new MemberKoreaFoodListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.contentEquals("/MemberChinaFood.me")) {
			action = new MemberChinaFoodListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.contentEquals("/MemberWestFood.me")) {
			action = new MemberWestFoodListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.contentEquals("/MemberSnackFood.me")) {
			action = new MemberSnackFoodListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			forward.setPath("./memberpage/MemberSnackFood.jsp");
		}else if(command.contentEquals("/MemberMyPageList.me")) {
			action = new MemberMyPageList();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}
