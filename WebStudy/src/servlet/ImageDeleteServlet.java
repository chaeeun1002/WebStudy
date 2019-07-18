package servlet;

import java.io.IOException;

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
@WebServlet("/ImageDeleteServlet")
public class ImageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageDeleteServlet() {
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
		String pwd = request.getParameter("PWD");
		String writing_id = request.getParameter("id");
		CRUDprocess crud = new CRUDprocess();
		ImageWriting image = crud.selectImageWritingById(Integer.parseInt(writing_id));
		String url = "main.jsp?BODY=imageDeleteResult.jsp";
		if(image.getPassword().equals(pwd)) {
			//암호 일치
			int result = crud.deleteImageWritingById(Integer.parseInt(writing_id));
		}else {
			//암호 불일치
			url = url+"&id="+writing_id;
		}
		response.sendRedirect(url);
	}

}
