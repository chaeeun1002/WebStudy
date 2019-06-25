package study01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Fruit;
import model.Movie;
import model.Student;

/**
 * Servlet implementation class DataSendServlet
 */
@WebServlet("/DataSendServlet")
public class DataSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] drinks = {"�Ƹ޸�ī��","ī���","īǪġ��","�׸�Ƽ��","ī���ī"};
		
		List list = new ArrayList();
		list.add("���ѹα�"); list.add("�Ϻ�"); list.add("�߱�"); list.add("�븸");
		
		Student std1 = new Student();
		std1.setName("ȫ�浿");
		std1.setAddr("����");
		std1.setMajor("�濵");
		std1.setGender("����");
		std1.setScore("A");
		
		Student std2 = new Student();
		std2.setName("�ϱ浿");
		std2.setAddr("��õ");
		std2.setMajor("�����");
		std2.setGender("����");
		std2.setScore("B");
		
		Student std3 = new Student();
		std3.setName("��ä��");
		std3.setAddr("���");
		std3.setMajor("��ǻ��");
		std3.setGender("����");
		std3.setScore("B");
		
		List<Student> students = new ArrayList<Student>();
		students.add(std1); students.add(std2); students.add(std3);
		
		Fruit f1 = new Fruit();
		f1.setName("����");
		f1.setOrigin("ĥ��");
		f1.setInfo("�����Դϴ�.");
		f1.setImage("grape.jpg");
		f1.setPrice("5,000");
		
		Fruit f2 = new Fruit();
		f2.setName("Ű��");
		f2.setOrigin("�ʸ���");
		f2.setInfo("Ű���Դϴ�.");
		f2.setImage("kiwi.jpg");
		f2.setPrice("3,000");
		
		Fruit f3 = new Fruit();
		f3.setName("����");
		f3.setOrigin("�̱�");
		f3.setInfo("�����Դϴ�.");
		f3.setImage("lemon.jpg");
		f3.setPrice("4,000");
		
		Fruit f4 = new Fruit();
		f4.setName("����");
		f4.setOrigin("�ѱ�");
		f4.setInfo("�����Դϴ�.");
		f4.setImage("strawberry.jpg");
		f4.setPrice("6,000");
		
		Fruit f5 = new Fruit();
		f5.setName("������");
		f5.setOrigin("ȣ��");
		f5.setInfo("�������Դϴ�.");
		f5.setImage("orange.jpg");
		f5.setPrice("3,500");
		
		Fruit f6 = new Fruit();
		f6.setName("��");
		f6.setOrigin("�ѱ�");
		f6.setInfo("���Դϴ�.");
		f6.setImage("tangerine.jpg");
		f6.setPrice("7,000");
		
		List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(f1);fruits.add(f2);fruits.add(f3);
		fruits.add(f4);fruits.add(f5);fruits.add(f6);
		
		Movie mv1 = new Movie();
		mv1.setTitle("13�ð�");
		mv1.setRelease("2016�� 3�� 3��");
		mv1.setInfo("��ΰ� ���׿��� �׳� ����� ���� �������� 13�ð��� ���������� ���۵ȴ�!");
		mv1.setAge("15�� ������");
		mv1.setImage("13hours.jpg");
		
		Movie mv2 = new Movie();
		mv2.setTitle("7������ ����");
		mv2.setRelease("2013�� 1�� 23��");
		mv2.setInfo("����ŷ ���·�! ���󿡼� ���� ��������� '���ٺ�'�� ���ƿ���! �־��� ��ǹ����� ���� ������ 7���濡 �̻��� ���� ���Դ�!");
		mv2.setAge("15�� ������");
		mv2.setImage("7present.jpg");
		
		Movie mv3 = new Movie();
		mv3.setTitle("33");
		mv3.setRelease("2016�� 4�� 7��");
		mv3.setInfo("2010�� 8�� 5�� ĥ�� ��ȣ�� ���� �ر�,���� 32��, ���� 95%�� 700m ���Ͽ� 33�� ���� �Ÿ�");
		mv3.setAge("12�� ������");
		mv3.setImage("33.jpg");
		
		Movie mv4 = new Movie();
		mv4.setTitle("7�� ������");
		mv4.setRelease("2009�� 4�� 22��");
		mv4.setInfo("���̴� �� �ӹ�, ���ߴ°� ������ (7�� ������) | �׳ฦ �ǽ��϶�! �׸� �ǽ��϶�!");
		mv4.setAge("12�� ������");
		mv4.setImage("7.jpg");
		
		Movie mv5 = new Movie();
		mv5.setTitle("6��° ������");
		mv5.setRelease("2008�� 2�� 5��");
		mv5.setInfo("ª�� �غ� �͵��� �𸣴� (6��° ������) ");
		mv5.setAge("15�� ������");
		mv5.setImage("6year.jpg");
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(mv1);movies.add(mv2);movies.add(mv3);
		movies.add(mv4);movies.add(mv5);
		
		request.setAttribute("MOVIES", movies);
		request.setAttribute("FRUITS", fruits);
		request.setAttribute("STUDENTS", students);
		request.setAttribute("ASIA", list);
		request.setAttribute("MENUS", drinks);
		
		RequestDispatcher rd = request.getRequestDispatcher("table.jsp");
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
