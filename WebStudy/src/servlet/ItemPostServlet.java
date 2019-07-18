package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import crud.CRUDprocess;
import model.ItemInfo;

/**
 * Servlet implementation class ItemPostServlet
 */
@WebServlet("/ItemPostServlet")
public class ItemPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemPostServlet() {
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
//		if(loginId != null) {
			CRUDprocess crud = new CRUDprocess();
			String name = request.getParameter("NAME");
			int price = Integer.parseInt(request.getParameter("PRICE"));
			String origin = request.getParameter("ORIGIN");
			String info = request.getParameter("INFO");
			int max = crud.selectMaxCode();
			int code = max + 1;
			ItemInfo item = new ItemInfo();
			item.setCode(code);
			item.setName(name);
			item.setPrice(price);
			item.setOrigin(origin);
			item.setInfo(info);
			int result = crud.insertItemInfo(item);
//			if(result > 0) {
//				System.out.println("»ğÀÔ ¼º°ø");
//			}else {
//				System.out.println("»ğÀÔ ½ÇÆĞ");
//			}
			response.sendRedirect("ItemListServlet");
//		}else {
//			response.sendRedirect("main.jsp?BODY=noLogin.jsp");
//		}
		
	}

}
