package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crud.CRUDprocess;
import model.Condition;
import model.ImageWriting;

/**
 * Servlet implementation class ImageListServlet
 */
@WebServlet("/ImageListServlet")
public class ImageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CRUDprocess crud = new CRUDprocess();
		String pageNum = request.getParameter("page");
		if(pageNum == null) {
			pageNum = "1";
		}
		int count = crud.selectCountImageWriting();
		int totalPageCount = 0;//전체 페이지 갯수
		int startRow = 0; int endRow = 0;
		int currentPage = Integer.parseInt(pageNum);
		if(count > 0) {//게시글이 존재하는 경우
			totalPageCount = count / 5;
			if(count % 5 > 0) {
				totalPageCount++;
			}
			startRow = (currentPage-1)*5+1;
			endRow = currentPage * 5;
			if(endRow > count) {
				endRow = count;
			}
		}
		Condition cond = new Condition();
		cond.setStartRow(startRow);cond.setEndRow(endRow);
		List<ImageWriting> list = crud.selectImageWritingByCondition(cond);
		request.setAttribute("IMAGELIST", list);
		request.setAttribute("startRow", startRow);
		request.setAttribute("endRow", endRow);
		request.setAttribute("count", count);
		request.setAttribute("pageCount", totalPageCount);
		request.setAttribute("currentPage", currentPage);
		//페이지 전환
		//행우선
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=imageList.jsp");
		rd.forward(request, response);
//		//열우선
//		RequestDispatcher rd = request.getRequestDispatcher("main.jsp?BODY=imageList_col.jsp");
//		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
