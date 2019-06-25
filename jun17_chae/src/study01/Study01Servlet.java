package study01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Study01Servlet
 */
@WebServlet("/Study01Servlet")
public class Study01Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Study01Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("NUM1"));
		int num2 = Integer.parseInt(request.getParameter("NUM2"));
		//µ¡¼ÀÀÇ °á°ú¸¦ ÀúÀå
		int sum = num1 + num2;
		request.setAttribute("sum",sum);
		//»¬¼ÀÀÇ °á°ú¸¦ ÀúÀå
		int sub = num1 - num2;
		request.setAttribute("sub",sub);
		//°ö¼ÀÀÇ °á°ú¸¦ ÀúÀå
		int mul = num1 * num2;
		request.setAttribute("mul",mul);
		//³ª´°¼ÀÀÇ °á°ú¸¦ ÀúÀå
		int div = num1 / num2;
		request.setAttribute("dv",div);
		//result.jsp·Î È­¸éÀüÈ¯(forward ¹æ½Ä)
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		//result.jsp·Î È­¸éÀüÈ¯(redirect ¹æ½Ä)
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
