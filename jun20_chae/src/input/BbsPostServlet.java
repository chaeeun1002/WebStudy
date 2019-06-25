package input;

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
		//method�� get�� ����� �ѱ� ó�� : server ������ server.xml���Ͽ��� connector������Ʈ�� �Ӽ� �߰� (URIEncoding="euc-kr") 
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		System.out.println("�� ���� : "+title);
		System.out.println("�� ���� : "+content);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//method�� post�� ����� �ѱ� ó��
		req.setCharacterEncoding("euc-kr");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		HttpSession session = req.getSession();
		String loginId = (String)session.getAttribute("LOGIN");
		
		if(loginId == null) {
			resp.sendRedirect("login.jsp?BODY=nologin.jsp");
		}else {
			CRUDprocess crud = new CRUDprocess();
			int seqno = crud.selectMaxSeqno()+1;
			Calendar today = new GregorianCalendar();
			int year = today.get(Calendar.YEAR);
			int mon = today.get(Calendar.MONTH)+1;
			int date = today.get(Calendar.DATE);
			int hour = today.get(Calendar.HOUR_OF_DAY);
			int min = today.get(Calendar.MINUTE);
			int sec = today.get(Calendar.SECOND);
			String bbs_date = year+"/"+mon+"/"+date+" "+hour+":"+min+":"+sec;
			BBS bbs = new BBS();//�� ��ü ����
			bbs.setTitle(title);
			bbs.setContent(content);
			bbs.setSeqno(seqno);
			bbs.setBbs_date(bbs_date);
			bbs.setId(loginId);
			int result = crud.insertIntoBbs(bbs);
			//BbsListServlet ���� ȣ��
			resp.sendRedirect("BbsListServlet");
		}
		
		//result�� ����� ������ ����, �ƴϸ� ����
//		if(result > 0) {
//			resp.sendRedirect("bbsInputResult.jsp?RESULT=OK");
//		}else {
//			resp.sendRedirect("bbsInputResult.jsp?RESULT=NOK");
//		}
		
//		RequestDispatcher rd = req.getRequestDispatcher("bbsInputResult.jsp");
//		rd.forward(req, resp);
	}
	
}
