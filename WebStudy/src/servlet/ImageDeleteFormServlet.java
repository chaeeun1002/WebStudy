package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.ImageWriting;

/**
 * Servlet implementation class ImageDeleteServlet
 */
@WebServlet("/ImageDeleteFormServlet")
public class ImageDeleteFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDeleteFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writing_id = request.getParameter("id");
		CRUDprocess crud = new CRUDprocess();
		ImageWriting image = crud.selectImageWritingById(Integer.parseInt(writing_id));
		request.setAttribute("IMAGE", image);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=imageDeleteForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writing_id = request.getParameter("id");
		CRUDprocess crud = new CRUDprocess();
		ImageWriting image = crud.selectImageWritingById(Integer.parseInt(writing_id));
		request.setAttribute("IMAGE", image);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=imageDeleteForm.jsp");
		rd.forward(request, response);
	}

}
