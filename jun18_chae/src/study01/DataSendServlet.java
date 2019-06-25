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
		String[] drinks = {"아메리카노","카페라떼","카푸치노","그린티라떼","카페모카"};
		
		List list = new ArrayList();
		list.add("대한민국"); list.add("일본"); list.add("중국"); list.add("대만");
		
		Student std1 = new Student();
		std1.setName("홍길동");
		std1.setAddr("서울");
		std1.setMajor("경영");
		std1.setGender("남자");
		std1.setScore("A");
		
		Student std2 = new Student();
		std2.setName("하길동");
		std2.setAddr("인천");
		std2.setMajor("국어국문");
		std2.setGender("남자");
		std2.setScore("B");
		
		Student std3 = new Student();
		std3.setName("박채은");
		std3.setAddr("경기");
		std3.setMajor("컴퓨터");
		std3.setGender("여자");
		std3.setScore("B");
		
		List<Student> students = new ArrayList<Student>();
		students.add(std1); students.add(std2); students.add(std3);
		
		Fruit f1 = new Fruit();
		f1.setName("포도");
		f1.setOrigin("칠레");
		f1.setInfo("포도입니다.");
		f1.setImage("grape.jpg");
		f1.setPrice("5,000");
		
		Fruit f2 = new Fruit();
		f2.setName("키위");
		f2.setOrigin("필리핀");
		f2.setInfo("키위입니다.");
		f2.setImage("kiwi.jpg");
		f2.setPrice("3,000");
		
		Fruit f3 = new Fruit();
		f3.setName("레몬");
		f3.setOrigin("미국");
		f3.setInfo("레몬입니다.");
		f3.setImage("lemon.jpg");
		f3.setPrice("4,000");
		
		Fruit f4 = new Fruit();
		f4.setName("딸기");
		f4.setOrigin("한국");
		f4.setInfo("딸기입니다.");
		f4.setImage("strawberry.jpg");
		f4.setPrice("6,000");
		
		Fruit f5 = new Fruit();
		f5.setName("오렌지");
		f5.setOrigin("호주");
		f5.setInfo("오렌지입니다.");
		f5.setImage("orange.jpg");
		f5.setPrice("3,500");
		
		Fruit f6 = new Fruit();
		f6.setName("귤");
		f6.setOrigin("한국");
		f6.setInfo("귤입니다.");
		f6.setImage("tangerine.jpg");
		f6.setPrice("7,000");
		
		List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(f1);fruits.add(f2);fruits.add(f3);
		fruits.add(f4);fruits.add(f5);fruits.add(f6);
		
		Movie mv1 = new Movie();
		mv1.setTitle("13시간");
		mv1.setRelease("2016년 3월 3일");
		mv1.setInfo("모두가 숨죽였던 그날 역사상 가장 숨막히는 13시간의 구출작전이 시작된다!");
		mv1.setAge("15세 관람가");
		mv1.setImage("13hours.jpg");
		
		Movie mv2 = new Movie();
		mv2.setTitle("7번방의 선물");
		mv2.setRelease("2013년 1월 23일");
		mv2.setInfo("흥행킹 류승룡! 세상에서 가장 사랑스러운 '딸바보'로 돌아오다! 최악의 흉악범들이 모인 교도소 7번방에 이상한 놈이 들어왔다!");
		mv2.setAge("15세 관람가");
		mv2.setImage("7present.jpg");
		
		Movie mv3 = new Movie();
		mv3.setTitle("33");
		mv3.setRelease("2016년 4월 7일");
		mv3.setInfo("2010년 8월 5일 칠레 산호세 광산 붕괴,섭씨 32도, 습도 95%의 700m 지하에 33인 광부 매몰");
		mv3.setAge("12세 관람가");
		mv3.setImage("33.jpg");
		
		Movie mv4 = new Movie();
		mv4.setTitle("7급 공무원");
		mv4.setRelease("2009년 4월 22일");
		mv4.setInfo("속이는 게 임무, 감추는게 직업인 (7급 공무원) | 그녀를 의심하라! 그를 의심하라!");
		mv4.setAge("12세 관람가");
		mv4.setImage("7.jpg");
		
		Movie mv5 = new Movie();
		mv5.setTitle("6년째 연애중");
		mv5.setRelease("2008년 2월 5일");
		mv5.setInfo("짧게 해본 것들은 모르는 (6년째 연애중) ");
		mv5.setAge("15세 관람가");
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
