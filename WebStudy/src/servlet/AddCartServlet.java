package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.Cart;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("LOGIN");
		CRUDprocess crud = new CRUDprocess();
//		if (loginId == null) {
//			response.sendRedirect("noLogin.jsp");
//		} else {
			String code = (String) request.getParameter("CODE");
			int code_num = Integer.parseInt(code);
			System.out.println(code);
			Cart cart_num = new Cart();
			cart_num.setCode(code_num);
			cart_num.setId(loginId);
			Integer num = crud.selectNumByIdAndCode(cart_num);
			if (num == 0) {
				String add_result = null;
				int seqno = crud.selectMaxCartSeqno() + 1;
				Cart cart = new Cart();
				cart.setCode(code_num);
				cart.setId(loginId);
				cart.setNum(num+1);
				cart.setSeqno(seqno);
				int result = crud.insertIntoCart(cart);
				if (result > 0) {
					add_result = "NULLOK";
					response.sendRedirect("addCartResult.jsp?RESULT=" + add_result + "&NUM=" + 1);
				} else {
					add_result = "NULLNOK";
					response.sendRedirect("addCartResult.jsp?RESULT=" + add_result);
				}
			} else {
				Cart cart_up = new Cart();
				cart_up.setCode(code_num);
				cart_up.setId(loginId);
				cart_up.setNum(num+1);
				int result = crud.updateNumByIdAndCode(cart_up);
				String up_result = null;
				if(result > 0) {
					up_result = "OK";
					response.sendRedirect("addCartResult.jsp?RESULT=" + up_result + "&NUM=" + 1);
				}else {
					up_result = "NOK";
					response.sendRedirect("addCartResult.jsp?RESULT=" + up_result);
				}
			}
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
