package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.BBS;

public class BbsPostServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("euc-kr");
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("LOGIN");
//		if(loginId == null) {
//			resp.sendRedirect("main.jsp?BODY=noLogin.jsp");
//		}else {
			CRUDprocess crud = new CRUDprocess();
			
			String title = req.getParameter("TITLE");
			String content = req.getParameter("CONTENT");
			String id = (String)session.getAttribute("LOGIN");
			int seqno = crud.selectMaxSeqno()+1;
			Calendar today = new GregorianCalendar();
			int year=today.get(Calendar.YEAR);
			int mon = today.get(Calendar.MONTH) + 1;
			int date = today.get(Calendar.DATE);
			int hour = today.get(Calendar.HOUR_OF_DAY);
			int min = today.get(Calendar.MINUTE);
			int sec = today.get(Calendar.SECOND);
			String bbs_date = year+"/"+mon+"/"+date+" "+hour+":"+min+":"+sec;
			
			BBS bbs = new BBS();
			bbs.setSeqno(seqno);
			bbs.setTitle(title);
			bbs.setContent(content);
			bbs.setId(id);
			bbs.setBbs_date(bbs_date);
			
			String inputResult = null;
			
			int result = crud.insertIntoBbs(bbs);
//			if(result > 0) {
//				System.out.println("»ğÀÔ ¼º°ø");
//				inputResult = "OK";
//				resp.sendRedirect("BbsListServlet");
//			}else {
//				System.out.println("»ğÀÔ ½ÇÆĞ");
//				inputResult = "NOK";
//			}
			resp.sendRedirect("BbsListServlet");
//		}
		
		
	}

}
