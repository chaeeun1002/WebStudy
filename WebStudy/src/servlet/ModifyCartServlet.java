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
 * Servlet implementation class ModifyCartServlet
 */
@WebServlet("/ModifyCartServlet")
public class ModifyCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCartServlet() {
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
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("LOGIN");
		String num = request.getParameter("NUM");
		String code = request.getParameter("CODE");
		
		String btn = request.getParameter("BTN");

		CRUDprocess crud = new CRUDprocess();
		
		String modify = "";
		if(btn.equals("수정")) {//수정 버튼을 누른 경우
			Cart cart_update = new Cart();
			cart_update.setId(loginId);
			cart_update.setCode(Integer.parseInt(code));
			cart_update.setNum(Integer.parseInt(num));
			crud.updateCartToNum(cart_update);
			modify = "update";
		}else {//삭제 버튼을 누른 경우
			 Cart cart_delete = new Cart();
			 cart_delete.setId(loginId);
			 cart_delete.setCode(Integer.parseInt(code));
			 crud.deleteCartByIdAndCode(cart_delete);
			 modify = "delete";
		}
		response.sendRedirect("cartModifyResult.jsp?MODIFY="+modify);
	}

}
