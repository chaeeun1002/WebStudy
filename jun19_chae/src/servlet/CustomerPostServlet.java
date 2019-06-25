package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.Customer;

/**
 * Servlet implementation class CustomerPostServlet
 */
@WebServlet("/CustomerPostServlet")
public class CustomerPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerPostServlet() {
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
		String cus_id = request.getParameter("ID");
		String cus_name = request.getParameter("NAME");
		String cus_addr = request.getParameter("ADDR");
		String cus_reg_date = request.getParameter("REG");
		Customer cus = new Customer();
		cus.setCust_id(cus_id);
		cus.setCust_name(cus_name);
		cus.setCust_addr(cus_addr);
		cus.setCust_reg_date(cus_reg_date);
		CRUDprocess crud = new CRUDprocess();
		int result = crud.insertIntoCustomerInfo(cus);
//		if(result > 0) {
//			response.sendRedirect("customerResult.jsp?RESULT=OK");
//		}else {
//			response.sendRedirect("customerResult.jsp?RESULT=NOK");
//		}
		response.sendRedirect("CustomerListServlet");
	}

}
