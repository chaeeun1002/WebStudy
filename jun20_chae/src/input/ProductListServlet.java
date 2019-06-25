package input;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.Product;
import model.ProductList;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDprocess crud = new CRUDprocess();
		
		int itemCount = crud.selectItemInfoCount();
		int pageCount = itemCount;
		pageCount = (pageCount + 4)/5;
		
		List<Product> list = crud.selectItemInfo();
		
		ProductList plist = new ProductList();
		Iterator it = list.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				Product item = (Product)it.next();
				plist.setCodeList(i, item.getCode());
				plist.setNameList(i, item.getName());
				plist.setPriceList(i, item.getPrice());
				plist.setOriginList(i, item.getOrigin());
			}else {
				break;
			}
		}
		
		request.setAttribute("PLIST", plist);
		request.setAttribute("PAGE", pageCount);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp?BODY=itemList.jsp");
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
