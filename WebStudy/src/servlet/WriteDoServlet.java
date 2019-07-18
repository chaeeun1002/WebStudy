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
		String savePath = "upload";//업로드용 폴더 이름
		int maxLimit = 5 * 1024 * 1024;//업로드 사이즈 설정(최대 5mb)
		String langType = "euc-kr";
		ServletContext context = this.getServletContext();
		//ServletContext?
		//프로젝트의 환경설정 정보를 가지고 있는 객체.
		String realPath = context.getRealPath(savePath);
		System.out.println("업로드 폴더 : "+realPath);
		//upload 라는 폴더의 실제 윈도우 시스템 상의 경로를 ServletContext가 찾아서 realPath에 넣어줌.
		String fileName = "";//업로드된 파일명용 변수
		int seqno = 0;
		try {
			MultipartRequest multipart = 
					new MultipartRequest(request,realPath,maxLimit,langType,new DefaultFileRenamePolicy());
			//MultipartRequest?
			//form에서 선택한 이미지를 폴더에 업로드해주는 객체
			//(파라미터를 가지고 있는 request객체, upload폴더의 실제 경로, 최대 업로드용 사이즈,   
			//한글처리, 똑같은 파일을 다시 업로드 할 경우의 설정(기존 파일 이름뒤에 넘버링을 해서 같이 저장)) 
			fileName = multipart.getFilesystemName("IMAGENAME");
			//getFilesystemName?--> 실제로 업로드 해주는 메서드
			//업로드 된 경우, fileName에 파일이름이 저장됨
			if(fileName.equals("")) {//업로드 실패
				System.out.println("업로드 실패");
			}else {//업로드 성공
				CRUDprocess crud = new CRUDprocess();
				ImageWriting iw = new ImageWriting();
				
				int writing_id = crud.selectMaxWritingId()+1;//글번호
				int group_id = crud.selectMaxGroupId()+1;//그룹번호
				
				//답글에 대한 파라미터 처리 시작
				String parentId = multipart.getParameter("parentid");
				String groupId = multipart.getParameter("groupid");
				String orderNo = multipart.getParameter("orderno");
				//답글에 대한 파라미터 처리 끝
				
				if(parentId == null || parentId.equals("")) {//원글인 경우
					iw.setParent_id(0);
					iw.setOrder_no(0);
					iw.setGroup_id(group_id);
				}else {//답글인 경우
					iw.setGroup_id(Integer.parseInt(groupId));
					iw.setParent_id(Integer.parseInt(parentId));
					iw.setOrder_no(Integer.parseInt(orderNo));
					//순서번호 변경
					crud.updateOrderNo(iw);
				}
				
				//DB삽입
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
				
				//업로드폼의 경우에는 MultipartRequest객체를 통해서 파라미터를 가져와야 한다.
			
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
			System.out.println("문제발생");
			e.printStackTrace();
		}
	}

}
