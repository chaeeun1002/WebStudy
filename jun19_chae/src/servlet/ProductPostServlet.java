package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.Product;

/**
 * Servlet implementation class ProductPostServlet
 */
@WebServlet("/ProductPostServlet")
public class ProductPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPostServlet() {
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
		request.setCharacterEncoding("euc-kr");
		String code = request.getParameter("NO");
		String name = request.getParameter("NAME");
		String price = request.getParameter("PRICE");
		String info = request.getParameter("INFO");
		String origin = request.getParameter("ORIGIN");
		Product pro = new Product();
		pro.setCode(code);
		pro.setName(name);
		pro.setPrice(Integer.parseInt(price));
		pro.setInfo(info);
		pro.setOrigin(origin);
		CRUDprocess crud = new CRUDprocess();
		int result = crud.insertIntoItemInfo(pro);
//		if(result > 0) {
//			response.sendRedirect("itemResult.jsp?RESULT=OK");
//		}else {
//			response.sendRedirect("itemResult.jsp?RESULT=NOK");
//		}
		response.sendRedirect("ProductListServlet");
	}

}
