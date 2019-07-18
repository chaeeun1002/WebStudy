package servlet;

import java.io.IOException;

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
 * Servlet implementation class ImageModifyServlet
 */
@WebServlet("/ImageModifyServlet")
public class ImageModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageModifyServlet() {
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
		String savePath = "upload";//이미지 업로드 경로
		int maxLimit = 5 * 1024 * 1024;//최대 업로드 크기
		String encType="euc-kr";//언어 코드
		ServletContext context = this.getServletContext();
		String realPath = context.getRealPath(savePath);
		String fileName = "";
		String writing_id = "";
		String url = "";
		try {
			MultipartRequest multipart = 
					new MultipartRequest(request,realPath,maxLimit,encType,new DefaultFileRenamePolicy());
			String title = multipart.getParameter("TITLE");
			String name = multipart.getParameter("WRITERNAME");
			String email = multipart.getParameter("EMAIL");
			String content = multipart.getParameter("CONTENT");
			String pwd = multipart.getParameter("PASSWORD");
			String image_n = multipart.getParameter("imageName");
			writing_id = multipart.getParameter("id");//글번호
			CRUDprocess crud = new CRUDprocess();
			ImageWriting image  = crud.selectImageWritingById(Integer.parseInt(writing_id));
			if(image.getPassword().equals(pwd)) {
				//암호일치
				image.setTitle(title);
				image.setWriter_name(name);
				image.setEmail(email);
				image.setContent(content);
				image.setWriting_id(Integer.parseInt(writing_id));
				fileName = multipart.getFilesystemName("IMAGENAME");
				if(fileName.equals("")) {//이미지가 변경된 경우
					image.setImage_name(fileName);
				}
				//DB에서 update 실행
				int result = crud.updateImageWritingById(image);
				url = "main.jsp?BODY=imageModifyResult.jsp";
				url = url+"&seqno="+image.getWriting_id();
				//seqno라는 파라미터가 생성됨
			}else {
				//암호불일치
				url = "main.jsp?BODY=imageModifyResule.jsp";
				url = url+"&id="+image.getWriting_id();
				//id라는 파라미터가 생성됨
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}

}
