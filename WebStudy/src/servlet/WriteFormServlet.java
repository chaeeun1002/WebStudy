package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.ImageWriting;

/**
 * Servlet implementation class WriteFormServlet
 */
@WebServlet("/WriteFormServlet")
public class WriteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("LOGIN");
		//ȭ����ȯ(-->writeFormView.jsp)
		//������ �۾��� ��
		//����� �۾��� ��(������ ������ �˻��ؼ� [RE]������ ������ �������.)
		String parentId = request.getParameter("parentid");
		String groupId = request.getParameter("groupid");
		String title = "";//����� ������ ���� ����
		ImageWriting image = null;//������ �� ������ ���� ����
		if(parentId != null) {//����� ���
			CRUDprocess crud = new CRUDprocess();
			image = crud.selectImageWritingById(Integer.parseInt(parentId)); 
			if(image != null) {
				title = "RE]"+image.getTitle(); 
				System.out.println(title);
			}
		}
			request.setAttribute("IMAGE", image);
			request.setAttribute("TITLE", title);
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=writeFormView.jsp");
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
