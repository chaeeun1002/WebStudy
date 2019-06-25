package study02;

import java.util.ArrayList;
import java.util.List;

public class Study02Expert {
	public List getBrands(String color) {
		List brands = new ArrayList();
		if(color.equals("light")) {
			brands.add("크라운");
			brands.add("오비 라거");
		}else if(color.equals("darker")) {
			brands.add("스타우트");
			brands.add("KGB");
		}else if(color.equals("brown")) {
			brands.add("CASS");
			brands.add("버드와이저");
			brands.add("칭타오");
		}else if(color.equals("black")) {
			brands.add("블랙이글");
		}
		return brands;
	}
}
