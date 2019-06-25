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
import model.BBS;
import model.BBSList;

/**
 * Servlet implementation class BbsListServlet
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//서블릿이 서블릿을 호출할 때에는 일반적으로 doGet메서드를 호출한다.
		CRUDprocess crud = new CRUDprocess();
		
		int bbsCount = crud.selectBbsCount();//글의갯수
		int pageCount = bbsCount;//페이지 갯수를 위한 변수
		pageCount = (pageCount + 4)/5;//한 페이지에 글 5개
		
		List<BBS> list = crud.selectBBS();
//		request.setAttribute("BBS", list);//페이지 처리 전 목록을 띄어주기 위한 속성
		
		BBSList blist = new BBSList();
			Iterator it = list.iterator();
			for(int i = 0; i < 5; i++) {
				if(it.hasNext()) {
					BBS bbs = (BBS)it.next();
					blist.setSeqnoList(i, bbs.getSeqno());
					blist.setTitleList(i, bbs.getTitle());
					blist.setWriterList(i, bbs.getId());
					blist.setDateList(i, bbs.getBbs_date());
				}else {
					break;//반복 종료
				}
			}//end of for
			
			if(!it.hasNext()) {//게시글이 5개 이상 있다.
				//다음 페이지 링크를 활성화 한다.
				blist.setLastPage(true);//마지막 페이지이다.
			}
			blist.setFirstPage(true);//첫번째 페이지이다.

		request.setAttribute("PAGE", pageCount);
		request.setAttribute("BLIST", blist);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp?BODY=bbsList.jsp");
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
