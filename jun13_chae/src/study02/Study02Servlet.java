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
@WebServlet("/Study02Servlet") // -> html�� form action�Ӽ� ���� �־���� ��. 
public class Study02Servlet extends HttpServlet {
	//HttpServlet : �� Ŭ������ ����� ����Ŭ������ �����ؾ� �� �����̳ʿ��� ��Ŭ�������� ������ ������ �����ϰ� �ȴ�.
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
    //���� �����Ͱ� ������ ���۵Ǵ� ��Ŀ� ���̰� ����.
    //doGet : form�� ������ �ִ� �����Ͱ� �� �������� url ��ũ�� ��ð� �Ǿ� ���۵�.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Study02Expert expert = new Study02Expert();
		//request : form�� ������ �ִ� �����͸� �޴� ��ü.
		//response : 
		String c = request.getParameter("color");
		System.out.println("������ �� : "+c);
		List result = expert.getBrands(c);
		
		//result(���)�� HttpServletRequest ��ü�� �����Ѵ�. --> �� ��ü�� jsp�� ���۵ǹǷ�.
		request.setAttribute("brands", result);
		request.setAttribute("cnt", 5);
		
		//������ JSP ȣ��
		//1.Redirect : URL�ּҸ� ������ ȭ���� �ּҷ� ��������.
		//2.Forward : URL�ּҴ� �״������, ȭ���� ������ �ٲ�.
		//-->(������ ȭ�鿡�� ������ ȣ���ؼ� DB������ �� ���, ���ΰ�ħ�� �ϸ� ��� ������ ȣ����(������))
		
		//����� JSP�� ������. Forward�� ������.
		//�� ��ü �̸��� RequestDispatcher
		RequestDispatcher rd = request.getRequestDispatcher("study02.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//doPost : ������ ���� ���ų� �����Ǽ��� �ȵǴ� �����͸� �����ϰ��� �� �� ���.(url ��ũ�� ��ð� �ȵ�.)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost�� ����.");
	}
	//html�� action method���� ȣ���� �޼��常 ����ȴ�.(doGet(�⺻) or doPost)-->�� �� ���ÿ� ��������� ����.
	//method�� ������� ������ �⺻���� doGet �޼��尡 ����ȴ�.
}
