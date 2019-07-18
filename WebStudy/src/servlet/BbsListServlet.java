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
import model.BBS;
import model.BBSList;

/**
 * Servlet implementation class BbsServletList
 */
@WebServlet("/BbsListServlet")
public class BbsListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    private BBSList readDB() {
    	CRUDprocess crud = new CRUDprocess();
		List<BBS> bbsList = crud.selectBBS();
		BBSList bList = new BBSList();
		Iterator it = bbsList.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				BBS bbs = (BBS)it.next();
				bList.setSeqnoList(i, bbs.getSeqno());
				bList.setTitleList(i, bbs.getTitle());
				bList.setIdList(i, bbs.getId());
				bList.setBbs_dateList(i, bbs.getBbs_date());
			}else {
				break;
			}
		}
		if(! it.hasNext()) {
			bList.setLastPage(true);
		}else {
			bList.setFirstPage(true);
		}
		return bList;
    }
    
    private BBSList readPrev(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<BBS> bbsList = crud.selectBBSPrevPage(no);
		BBSList bList = new BBSList();
		Iterator it = bbsList.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				BBS bbs = (BBS)it.next();
				bList.setSeqnoList(i, bbs.getSeqno());
				bList.setTitleList(i, bbs.getTitle());
				bList.setIdList(i, bbs.getId());
				bList.setBbs_dateList(i, bbs.getBbs_date());
			}else {
				break;
			}
		}
		if((crud.selectCountPrevPageOfBBS(no)-5) < 5) {
			bList.setFirstPage(true);
		}else {
			bList.setFirstPage(false);
		}
		return bList;
    }
    
    private BBSList readNext(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<BBS> bbsList = crud.selectBBSNextPage(no);
		BBSList bList = new BBSList();
		Iterator it = bbsList.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				BBS bbs = (BBS)it.next();
				bList.setSeqnoList(i, bbs.getSeqno());
				bList.setTitleList(i, bbs.getTitle());
				bList.setIdList(i, bbs.getId());
				bList.setBbs_dateList(i, bbs.getBbs_date());
			}else {
				break;
			}
		}
		if(! it.hasNext()) {
			bList.setLastPage(true);
		}
		return bList;
    }
    
    private BBSList readPage(Integer no) {
    	CRUDprocess crud = new CRUDprocess();
		List<BBS> bbsList = crud.selectBBSPageNum(no);
		BBSList bList = new BBSList();
		Iterator it = bbsList.iterator();
		for(int i = 0; i < 5; i++) {
			if(it.hasNext()) {
				BBS bbs = (BBS)it.next();
				bList.setSeqnoList(i, bbs.getSeqno());
				bList.setTitleList(i, bbs.getTitle());
				bList.setIdList(i, bbs.getId());
				bList.setBbs_dateList(i, bbs.getBbs_date());
			}else {
				break;
			}
		}
		if(no == 1) {
			bList.setFirstPage(true);
		}
		if(crud.selectCountNextPageOfBBS(no) < 6) {
			bList.setLastPage(true);
		}
		return bList;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDprocess crud = new CRUDprocess();
		List<BBS> bbsList = crud.selectBBS();
		BBSList bList = null;
		
		int bbsCount = crud.selectCountOfBBS();
		int pageCount = bbsCount;
		pageCount = (pageCount+4)/5;
		
		String firstPage = request.getParameter("FIRST_PAGE");
		String lastPage = request.getParameter("LAST_PAGE");
		String pageNum = request.getParameter("PAGE");
		
		if(firstPage != null) {
			bList = readPrev(Integer.parseInt(firstPage));
		}else if(lastPage != null) {
			bList = readNext(Integer.parseInt(lastPage));
		}else if(pageNum != null) {
			bList = readPage(Integer.parseInt(pageNum));
		}else {
			bList = readDB();
		}
		
		request.setAttribute("BBSLIST", bList);
		request.setAttribute("PAGE", pageCount);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=bbsList.jsp");
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
