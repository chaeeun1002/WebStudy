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
				//�α��μ���
				result = "OK";
				//���¸� �����ϴ� ��ü : HttpSession
				HttpSession session = request.getSession();
				session.setAttribute("LOGIN", id);
			}else {
				//�α��ν���(�н����� ��ġX)
				result = "NOK";
			}
		}else {
			//�α��ν���(���� ���� X)
			result = "NULL";
		}
		//ȭ����ȯ(�α��� ��� ������ --> loginResult.jsp)
		response.sendRedirect("login.jsp?BODY=loginResult.jsp&RESULT="+result);
	}

}
