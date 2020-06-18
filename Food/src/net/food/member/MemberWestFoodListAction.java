package net.food.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailDAO;

public class MemberWestFoodListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		DetailDAO detailDAO = new DetailDAO();
		List foodlist = new ArrayList();
		
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount = detailDAO.getWestListCount();
		foodlist = detailDAO.getWestFoodList(page, limit);
		
		int maxpage = (int)((double)listcount / limit + 0.95);
		int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1;
		int endpage = maxpage;
		if(endpage > startpage + 10 -1) endpage = startpage + 10 - 1;
		
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("listcount", listcount);
		request.setAttribute("foodlist", foodlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./memberpage/MemberWestFood.jsp");
		
		return forward;
	}
	
}
