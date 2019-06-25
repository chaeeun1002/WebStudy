package input;

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
		String id = request.getParameter("id");
		String pw = request.getParameter("pwd");
		CRUDprocess crud = new CRUDprocess();
		Member mem = crud.selectMemberIdandPw(id);
		String result = "";
		if(mem != null) {
			if(pw.equals(mem.getMem_pw())) {
				//로그인성공
				result = "OK";
				//상태를 유지하는 객체 : HttpSession
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", id);
			}else {
				//로그인실패(패스워드 일치X)
				result = "NOK";
			}
		}else {
			//로그인실패(계정 정보 X)
			result = "NULL";
		}
		//화면전환(로그인 결과 페이지 --> loginResult.jsp)
		response.sendRedirect("login.jsp?BODY=loginResult.jsp&RESULT="+result);
	}

}
