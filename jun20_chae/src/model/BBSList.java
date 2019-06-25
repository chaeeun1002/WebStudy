package model;

import java.util.ArrayList;

public class BBSList {//���� : List<BBS> list�� ��� ������ 5���� �Ѱܹ޴� Ŭ����
	private ArrayList<Integer> seqnoList = new ArrayList<Integer>();//�۹�ȣ 5���� ����
	public void setSeqnoList(int index,Integer seqno) {
		seqnoList.add(index,seqno);
	}
	public Integer[] getSeqnoList() {
		//�÷��������ӿ�ũ�� �迭�� �ٲ��ش�. -- > toArray()�޼��� ���
		return seqnoList.toArray(new Integer[seqnoList.size()]);//�迭�� ũ�� ���� : seqnoList.size
	}
	
	private ArrayList<String> titleList = new ArrayList<String>();//������ 5���� ����
	public void setTitleList(int index,String title) {
		titleList.add(index,title);
	}
	public String[] getTitleList(){
		return titleList.toArray(new String[titleList.size()]);
	}
	
	private ArrayList<String> writerList = new ArrayList<String>();//�ۼ��� 5���� ����
	public void setWriterList(int index,String writer) {
		writerList.add(index,writer);
	}
	public String[] getWriterList(){
		return writerList.toArray(new String[writerList.size()]);
	}
	
	private ArrayList<String> dateList = new ArrayList<String>();//�ۼ��� 5���� ����
	public void setDateList(int index,String date) {
		dateList.add(index,date);
	}
	public String[] getDateList() {
		return dateList.toArray(new String[dateList.size()]);
	}
	
	private boolean lastPage = false;
	private boolean firstPage = false;
	
	public int getListSize() {
		return seqnoList.size();//�˻��� ���� ���� ����
	}
	
	public boolean isLastPage() {
		return lastPage;
	}
	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}
	public boolean isFirstPage() {
		return firstPage;
	}
	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}
}
