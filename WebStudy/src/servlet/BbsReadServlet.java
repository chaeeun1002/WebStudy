package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.BBS;

/**
 * Servlet implementation class BbsReadServlet
 */
@WebServlet("/BbsReadServlet")
public class BbsReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsReadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDprocess crud = new CRUDprocess();
		String s_seqno = (String)request.getParameter("SEQNO");
		int seqno = Integer.parseInt(s_seqno);
		BBS bbs = crud.selectBBSBySeqno(seqno);
		request.setAttribute("BBS", bbs);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=bbsRead.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
