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
		//������ ������ ȣ���� ������ �Ϲ������� doGet�޼��带 ȣ���Ѵ�.
		CRUDprocess crud = new CRUDprocess();
		
		int bbsCount = crud.selectBbsCount();//���ǰ���
		int pageCount = bbsCount;//������ ������ ���� ����
		pageCount = (pageCount + 4)/5;//�� �������� �� 5��
		
		List<BBS> list = crud.selectBBS();
//		request.setAttribute("BBS", list);//������ ó�� �� ����� ����ֱ� ���� �Ӽ�
		
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
					break;//�ݺ� ����
				}
			}//end of for
			
			if(!it.hasNext()) {//�Խñ��� 5�� �̻� �ִ�.
				//���� ������ ��ũ�� Ȱ��ȭ �Ѵ�.
				blist.setLastPage(true);//������ �������̴�.
			}
			blist.setFirstPage(true);//ù��° �������̴�.

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
