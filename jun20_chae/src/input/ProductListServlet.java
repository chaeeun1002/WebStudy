package input;

import java.io.IOException;
import java.util.ArrayList;
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
    
    private ProductList readDB() {
    	CRUDprocess crud = new CRUDprocess();
    	ProductList plist = new ProductList();
    	List<Product> list = crud.selectItemInfo();
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
		if(!it.hasNext()) {
			plist.setLastPage(true);
		}
		plist.setFirstPage(true);
		return plist;
    }
    
    private ProductList readPrevPage(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
    	List<Product> list = new ArrayList<Product>();
    	list = crud.selectItemPrevPage(no);
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
    	int num = crud.selectItemPrevCount(no);
    	if((num-5) < 5) {
    		plist.setFirstPage(true);
    	}else {
    		plist.setFirstPage(false);
    	}
    	return plist;	
    }
    
    private ProductList readNextPage(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
    	List<Product> list = new ArrayList<Product>();
    	list = crud.selectItemNextPage(no);
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
    	if(!it.hasNext()) {
    		plist.setLastPage(true);
    	}
    	return plist;
    }
    
    private ProductList readPageNo(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
    	List<Product> list = crud.selectItemByPageNum(no);
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
    	if(no == 1) {
    		plist.setFirstPage(true);
    	}
    	int num = crud.selectItemNextCount(no);
    	if(num < 6) {
    		plist.setLastPage(true);
    	}
    	return plist;	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstPage = request.getParameter("FIRST_PAGE");
		String lastPage = request.getParameter("LAST_PAGE");
		String pageNo = request.getParameter("PAGE_NO");
		ProductList pList = null;
		if(firstPage != null) {//이전 페이지를 누른 경우
			pList = readPrevPage(Integer.parseInt(firstPage));
		}else if(lastPage != null) {//다음 페이지를 누른 경우
			pList = readNextPage(Integer.parseInt(lastPage));
		}else if(pageNo != null) {//페이지 번호를 누른 경우
			pList = readPageNo(Integer.parseInt(pageNo));
		}else {//메뉴에서 자유게시판 읽기를 누른 경우
			pList = readDB();
		}
		
		CRUDprocess crud = new CRUDprocess();
		int itemCount = crud.selectItemInfoCount();
		int pageCount = itemCount;
		pageCount = (pageCount + 4)/5;
		
		request.setAttribute("PLIST", pList);
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
