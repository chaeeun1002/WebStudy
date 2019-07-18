package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ID");
		String pwd = request.getParameter("PWD");
		CRUDprocess crud = new CRUDprocess();
		Member member = crud.selectIdAndPwd(id);
		String result = null;
		if(member != null) {
			if(id.equals(member.getMem_id())&&pwd.equals(member.getMem_pwd())) {
				System.out.println("로그인 성공");
				result = "OK";
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", id);
			}else if(!pwd.equals(member.getMem_pwd())) {
				result = "NOKPWD";
			}
		}else {
			System.out.println("로그인 실패");
			result = "NOK";
		}
		response.sendRedirect("main.jsp?BODY=loginResult.jsp&RESULT="+result);
	}

}
