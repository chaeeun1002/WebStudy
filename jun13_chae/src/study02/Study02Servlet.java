package study02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Study02Servlet
 */
@WebServlet("/Study02Servlet") // -> html의 form action속성 값에 넣어줘야 함. 
public class Study02Servlet extends HttpServlet {
	//HttpServlet : 이 클래스를 상속한 서블릿클래스를 생성해야 웹 컨테이너에서 이클립스에서 생성한 서블릿이 동작하게 된다.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Study02Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //웹의 데이터가 서버로 전송되는 방식에 차이가 있음.
    //doGet : form이 가지고 있는 데이터가 웹 브라우저의 url 링크에 명시가 되어 전송됨.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Study02Expert expert = new Study02Expert();
		//request : form이 가지고 있는 데이터를 받는 객체.
		//response : 
		String c = request.getParameter("color");
		System.out.println("선택한 색 : "+c);
		List result = expert.getBrands(c);
		
		//result(결과)를 HttpServletRequest 객체에 저장한다. --> 이 객체가 jsp로 전송되므로.
		request.setAttribute("brands", result);
		request.setAttribute("cnt", 5);
		
		//서블릿이 JSP 호출
		//1.Redirect : URL주소를 변경할 화면의 주소로 변경해줌.
		//2.Forward : URL주소는 그대로지만, 화면의 내용이 바뀜.
		//-->(원래의 화면에서 서블릿을 호출해서 DB연동을 할 경우, 새로고침을 하면 계속 서블릿을 호출함(문제점))
		
		//결과를 JSP로 보낸다. Forward로 보낸다.
		//이 객체 이름은 RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("study02.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//doPost : 데이터 양이 많거나 공개되서는 안되는 데이터를 전송하고자 할 때 사용.(url 링크에 명시가 안됨.)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost가 받음.");
	}
	//html의 action method에서 호출한 메서드만 실행된다.(doGet(기본) or doPost)-->둘 다 동시에 실행되지는 않음.
	//method를 명시하지 않으면 기본으로 doGet 메서드가 실행된다.
}
