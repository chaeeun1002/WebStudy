package exam01;

import java.util.ArrayList;
import java.util.List;

public class Exam01Expert {
	public List getList(String dong) {
		List list = new ArrayList();
		if(dong.equals("seokchon")) {
			list.add("��ͺ��߰���");
			list.add("�����");
			list.add("�ڸ޶�����");
		}else if(dong.equals("songpa")) {
			list.add("��Ǫ��");
			list.add("����ϳ���");
			list.add("�ܵ�");
		}else if(dong.equals("samjeon")) {
			list.add("�����¡��");
			list.add("����������");
			list.add("�ƽþ����̺�");
		}else if(dong.equals("sincheon")) {
			list.add("����");
			list.add("��������");
			list.add("���̽��÷�");
		}
		return list;
	}
}
