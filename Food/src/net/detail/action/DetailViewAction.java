package net.detail.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.detail.db.DetailBean;
import net.detail.db.DetailDAO;

public class DetailViewAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		DetailDAO detailDAO = new DetailDAO();
		DetailBean detailBean = new DetailBean();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		detailBean = detailDAO.getDetail(num);
		
		if(detailBean == null) {
			System.out.println("상세 페이지 이동 실패");
			return null;
		}
		// System.out.println("상세 페이지 이동 성공");

		request.setAttribute("detailBean", detailBean);
		
		forward.setRedirect(false);
		forward.setPath("./Detail/detail_view.jsp");
		return forward;
	}
	
}
