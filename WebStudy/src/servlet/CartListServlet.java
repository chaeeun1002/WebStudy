package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.CartList;

/**
 * Servlet implementation class CartListServlet
 */
@WebServlet("/CartListServlet")
public class CartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("LOGIN");
		CRUDprocess crud = new CRUDprocess();
		if(loginId == null) {
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=loginForm.jsp");
			rd.forward(request, response);
		}else {
			List<CartList> list = crud.selectCartById(loginId);
			Iterator it = list.iterator();
			int totalAmount = 0;
			for(int i = 0; i < list.size(); i++) {
				if(it.hasNext()) {
					CartList cart = (CartList)it.next();
					totalAmount = totalAmount + (cart.getPrice() * cart.getNum());
				}
			}
			request.setAttribute("TOTAL", totalAmount);
			request.setAttribute("CARTLIST", list);
			
		}
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=cartList.jsp");
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
