package net.food.guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.gu")
public class FoodMainController extends HttpServlet{
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
		
		if(command.contentEquals("/mainPage.gu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./page/mainpage.jsp");
			
		}else if(command.contentEquals("/loginpage.gu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./page/loginPage.jsp");
		}else if(command.contentEquals("/newmemberpage.gu")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./page/newMemberPage.jsp");
		}else if(command.contentEquals("/koreafood.gu")) {
			action = new KoreaFoodListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.contentEquals("/chinafood.gu")) {
			action = new ChinaFoodListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.contentEquals("/westfood.gu")) {
			action = new WestFoodListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.contentEquals("/snackfood.gu")) {
			action = new SnackFoodListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/MemberFind.gu")) {
			forward = new ActionForward();
			forward.setPath("./page/member_find.jsp");
		}else if(command.contentEquals("/MemberFindAction.gu")) {
			action = new MemberFindAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
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
