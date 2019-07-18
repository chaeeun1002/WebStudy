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

import crud.CRUDprocess;
import model.ItemInfo;
import model.ItemList;

/**
 * Servlet implementation class ItemListServlet
 */
@WebServlet("/ItemListServlet")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    private ItemList readDB() {
    	CRUDprocess crud = new CRUDprocess();
		List<ItemInfo> list = crud.selectItemInfo();
		ItemList iList = new ItemList();
		Iterator it = list.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				ItemInfo info = (ItemInfo)it.next();
				iList.setCodeList(i, info.getCode());
				iList.setNameList(i, info.getName());
				iList.setPriceList(i, info.getPrice());
				iList.setOriginList(i, info.getOrigin());
			}else {
				break;
			}
		}
		if(! it.hasNext()) {
			iList.setLastPage(true);
		}else {
			iList.setFirstPage(true);
		}
		return iList;
    }
    
    private ItemList readPrev(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<ItemInfo> list = crud.selectItemInfoPrevPage(no);
		ItemList iList = new ItemList();
		Iterator it = list.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				ItemInfo item = (ItemInfo)it.next();
				iList.setCodeList(i, item.getCode());
				iList.setNameList(i, item.getName());
				iList.setPriceList(i, item.getPrice());
				iList.setOriginList(i, item.getOrigin());
			}
		}
		if(!it.hasNext()) {
			iList.setFirstPage(true);
		}
		if((crud.selectCountPrevPageOfItemInfo(no)-5) < 5){
			iList.setFirstPage(true);
		}else {
			iList.setFirstPage(false);
		}
		return iList  ;
    }
    
    private ItemList readNext(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<ItemInfo> list = crud.selectItemInfoNextPage(no);
		ItemList iList = new ItemList();
		Iterator it = list.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				ItemInfo item = (ItemInfo)it.next();
				iList.setCodeList(i, item.getCode());
				iList.setNameList(i, item.getName());
				iList.setPriceList(i, item.getPrice());
				iList.setOriginList(i, item.getOrigin());
			}
		}
		if(! it.hasNext()) {
			iList.setLastPage(true);
		}
		return iList;
    }
    
    private ItemList readPage(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<ItemInfo> list = crud.selectItemInfoPageNum(no);
		ItemList iList = new ItemList();
		Iterator it = list.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				ItemInfo item = (ItemInfo)it.next();
				iList.setCodeList(i, item.getCode());
				iList.setNameList(i, item.getName());
				iList.setPriceList(i, item.getPrice());
				iList.setOriginList(i, item.getOrigin());
			}
		}
		if(no == 1) {
			iList.setFirstPage(true);
		}
		if(crud.selectCountNextPageOfItemInfo(no) < 6) {
			iList.setLastPage(true);
		}
		return iList;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDprocess crud = new CRUDprocess();
		
		int itemCount = crud.selectCountOfItemInfo();
		int pageCount = itemCount;
		pageCount = (pageCount+4)/5;

		String firstPage = request.getParameter("FIRST_PAGE");
		String lastPage = request.getParameter("LAST_PAGE");
		String pageNo = request.getParameter("PAGE");

		ItemList iList = null;
		
		if(firstPage != null) {
			iList = readPrev(Integer.parseInt(firstPage));
		}else if(lastPage != null) {
			iList = readNext(Integer.parseInt(lastPage));
		}else if(pageNo != null) {
			iList = readPage(Integer.parseInt(pageNo));
		}else {
			iList = readDB();
		}
		
		request.setAttribute("ITEMLIST", iList);
		request.setAttribute("PAGE", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=itemList.jsp");
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
