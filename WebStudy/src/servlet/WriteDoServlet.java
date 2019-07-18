package servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import crud.CRUDprocess;
import model.ImageWriting;

/**
 * Servlet implementation class WriteDoServlet
 */
@WebServlet("/WriteDoServlet")
public class WriteDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteDoServlet() {
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
		String savePath = "upload";//���ε�� ���� �̸�
		int maxLimit = 5 * 1024 * 1024;//���ε� ������ ����(�ִ� 5mb)
		String langType = "euc-kr";
		ServletContext context = this.getServletContext();
		//ServletContext?
		//������Ʈ�� ȯ�漳�� ������ ������ �ִ� ��ü.
		String realPath = context.getRealPath(savePath);
		System.out.println("���ε� ���� : "+realPath);
		//upload ��� ������ ���� ������ �ý��� ���� ��θ� ServletContext�� ã�Ƽ� realPath�� �־���.
		String fileName = "";//���ε�� ���ϸ�� ����
		int seqno = 0;
		try {
			MultipartRequest multipart = 
					new MultipartRequest(request,realPath,maxLimit,langType,new DefaultFileRenamePolicy());
			//MultipartRequest?
			//form���� ������ �̹����� ������ ���ε����ִ� ��ü
			//(�Ķ���͸� ������ �ִ� request��ü, upload������ ���� ���, �ִ� ���ε�� ������,   
			//�ѱ�ó��, �Ȱ��� ������ �ٽ� ���ε� �� ����� ����(���� ���� �̸��ڿ� �ѹ����� �ؼ� ���� ����)) 
			fileName = multipart.getFilesystemName("IMAGENAME");
			//getFilesystemName?--> ������ ���ε� ���ִ� �޼���
			//���ε� �� ���, fileName�� �����̸��� �����
			if(fileName.equals("")) {//���ε� ����
				System.out.println("���ε� ����");
			}else {//���ε� ����
				CRUDprocess crud = new CRUDprocess();
				ImageWriting iw = new ImageWriting();
				
				int writing_id = crud.selectMaxWritingId()+1;//�۹�ȣ
				int group_id = crud.selectMaxGroupId()+1;//�׷��ȣ
				
				//��ۿ� ���� �Ķ���� ó�� ����
				String parentId = multipart.getParameter("parentid");
				String groupId = multipart.getParameter("groupid");
				String orderNo = multipart.getParameter("orderno");
				//��ۿ� ���� �Ķ���� ó�� ��
				
				if(parentId == null || parentId.equals("")) {//������ ���
					iw.setParent_id(0);
					iw.setOrder_no(0);
					iw.setGroup_id(group_id);
				}else {//����� ���
					iw.setGroup_id(Integer.parseInt(groupId));
					iw.setParent_id(Integer.parseInt(parentId));
					iw.setOrder_no(Integer.parseInt(orderNo));
					//������ȣ ����
					crud.updateOrderNo(iw);
				}
				
				//DB����
				String writerName = multipart.getParameter("WRITERNAME");
				String title = multipart.getParameter("TITLE");
				String pwd = multipart.getParameter("PASSWORD");
				String content = multipart.getParameter("CONTENT");
				String email = multipart.getParameter("EMAIL");
				Calendar today = Calendar.getInstance();
				int y = today.get(Calendar.YEAR);
				int m = today.get(Calendar.MONTH)+1;
				int d = today.get(Calendar.DATE);
				String rDate = y+"/"+m+"/"+d;
				
				//���ε����� ��쿡�� MultipartRequest��ü�� ���ؼ� �Ķ���͸� �����;� �Ѵ�.
			
				iw.setTitle(title);
				iw.setWriter_name(writerName);
				iw.setPassword(pwd);
				iw.setEmail(email);
				iw.setContent(content);
				iw.setRegister_date(rDate);
				iw.setImage_name(fileName);
				iw.setWriting_id(writing_id);
				int result = crud.insertIntoImageWriting(iw);
				response.sendRedirect("writeResult.jsp");
			}
		}catch(Exception e) {
			System.out.println("�����߻�");
			e.printStackTrace();
		}
	}

}
