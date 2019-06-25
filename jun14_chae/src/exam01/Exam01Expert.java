package exam01;

import java.util.ArrayList;
import java.util.List;

public class Exam01Expert {
	public List getList(String dong) {
		List list = new ArrayList();
		if(dong.equals("seokchon")) {
			list.add("비와별닭갈비");
			list.add("오모리찌개");
			list.add("코메또히또");
		}else if(dong.equals("songpa")) {
			list.add("만푸쿠");
			list.add("멘야하나비");
			list.add("단디");
		}else if(dong.equals("samjeon")) {
			list.add("군산오징어");
			list.add("주은감자탕");
			list.add("아시안테이블");
		}else if(dong.equals("sincheon")) {
			list.add("빌즈");
			list.add("갓덴스시");
			list.add("테이스팅룸");
		}
		return list;
	}
}
