package study02;

import java.util.ArrayList;
import java.util.List;

public class Study02Expert {
	public List getBrands(String color) {
		List brands = new ArrayList();
		if(color.equals("light")) {
			brands.add("ũ���");
			brands.add("���� ���");
		}else if(color.equals("darker")) {
			brands.add("��Ÿ��Ʈ");
			brands.add("KGB");
		}else if(color.equals("brown")) {
			brands.add("CASS");
			brands.add("���������");
			brands.add("ĪŸ��");
		}else if(color.equals("black")) {
			brands.add("���̱�");
		}
		return brands;
	}
}
